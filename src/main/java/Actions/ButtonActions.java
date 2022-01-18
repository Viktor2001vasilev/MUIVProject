package Actions;

import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


// выполнение действий
public class ButtonActions{

    private static Thread myThread = new Thread(new Runnable() {
        public void run(){
            while (!stop) {
                System.out.println("Запуск потока");
                try {
                    SetDesktopWallpaper.setWallpaper((int)(Math.random() * (srcList.size())-1));
                    Thread.sleep(interval * 20000);
                    System.out.println("1 треть ожидания прошла");
                    Thread.sleep(interval * 20000);
                    System.out.println("2 треть ожидания прошла");
                    Thread.sleep(interval * 20000);
                    System.out.println("3 треть ожидания прошла");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    private static ArrayList<String> tagsList = new ArrayList<>();
    private static ArrayList<String> srcList = new ArrayList<>();
    private static int interval = 2; // дефолтное значение - 2 минуты
    private static Boolean stop = false;

    private static void tagsIntroduce() throws IOException{
        // тут проверка наличия тегов, их запись в массив и тд
        String fileName = "src\\main\\resources\\tags.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter("\\s*, \\s*"); // отсеиваем запятую и пробел, оставляя теги
        tagsList.clear();
        while (scanner.hasNext()) {
            tagsList.add(scanner.next());
        }
    }

    // После нажатия на кнопку "Добавить" происходит запись тегов в файл tags.txt
    public static void button1Action(String tags) throws IOException {
        System.out.println("Выполнение действия кнопки 1");

        System.out.println(tags);
        FileWriter fileWriter = new FileWriter("src\\main\\resources\\tags.txt", false); // второй параметр- файл будет перезаписываться
        fileWriter.write(tags);
        fileWriter.flush(); // запись происходит только после этого метода
        tagsIntroduce();
        if(tagsList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Введите хотя-бы отдин тег.");
        }
        else JOptionPane.showMessageDialog(null, "Теги: " + tags + " добавлены!");
    }

    // После нажатия на кнопку "Запуск" происходит поиск, загрузка и установка обоев с таймаутом
    public static void button2Action() throws IOException, InterruptedException {
        System.out.println("Выполнение действия кнопки 2");
        ImageActions.deleteFolder();
        ImageActions imageActions = new ImageActions();
        tagsIntroduce();
        //запуск поиска изображений в браузере
        if(!tagsList.isEmpty()) {
            BrowserImagesSearch browserImagesSearch = new BrowserImagesSearch();
            if (tagsList.size() >= 7) {
                srcList = browserImagesSearch.search(tagsList, true);
            } else {
                srcList = browserImagesSearch.search(tagsList, false);
            }
            System.out.println(srcList);
        }
        else JOptionPane.showMessageDialog(null, "Необходимо ввести теги.");
        //загрузка найденных фотографий
        for(int i = 0; i < srcList.size(); i++) {
            imageActions.download(srcList.get(i), i);
        }
        //Изменение обоев рабочего стола с ожиданием
        myThread.start();
        if (stop) ImageActions.deleteFolder();
    }

    public static void button3Action(String time) throws IOException {
        try {
            interval = Integer.parseInt(time);
            System.out.println(interval);
            JOptionPane.showMessageDialog(null, "Интервал задан.");
        }
        catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Необходимо ввести целое число, иначе интервал будет равен 5 минутам.");
        }
    }

    public static void button4Action() throws IOException {
        System.out.println("Стоп");
        stop = true;
    }
}
