package Actions;

import GUI.Interface;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.win32.W32APIOptions;

import javax.swing.*;
import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// выполнение действий
public class ButtonActions {

//    public static void button1Action() {
//        System.out.println("Выполнение действия кнопки 1");
//        User32.INSTANCE.SystemParametersInfo(0x0014, 0, "D:\\java\\MUIVProject\\src\\main\\resources\\Picture.jpg", 1);
//    }
//    public static interface User32 extends Library {
//        User32 INSTANCE = (User32) Native.loadLibrary("user32", User32.class, W32APIOptions.DEFAULT_OPTIONS);
//        boolean SystemParametersInfo(int one, int two, String s, int three);
//    }

    private static ArrayList<String> tagsList = new ArrayList<>();

    // После нажатия на кнопку "Добавить" происходит запись тегов в файл tags.txt
    public static void button1Action(String tags, Interface intr) throws IOException {
        System.out.println("Выполнение действия кнопки 1");
        System.out.println(tags);
        FileWriter fileWriter = new FileWriter("src\\main\\resources\\tags.txt", false); // второй параметр- файл будет перезаписываться
        fileWriter.write(tags);
        fileWriter.flush(); // запись происходит только после этого метода
        JOptionPane.showMessageDialog(null, "Теги: " + tags + " добавлены!");
    }

    // После нажатия на кнопку "Запуск" происходит проверка файла tags.txt
    public static void button2Action() throws IOException {
        System.out.println("Выполнение действия кнопки 2");
        // тут проверка наличия тегов, их запись в массив и тд
        String fileName = "src\\main\\resources\\tags.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);
        scanner.useDelimiter("\\s*, \\s*");
        while (scanner.hasNext()) {
            tagsList.add(scanner.next());
        }


        //запуск поиска изображений в браузере
        //BrowserImagesSearch.search("Котики");
    }
}
