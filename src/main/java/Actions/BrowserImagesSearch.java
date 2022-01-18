package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrowserImagesSearch {

    private final ChromeDriver driver;

    public BrowserImagesSearch() {
        // настройка браузера
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://yandex.ru/images/");
        System.out.println(driver.getTitle());
    }

    public ArrayList<String> search(List<String> tags, Boolean enough ) {
        ArrayList<String> srcList = new ArrayList<>();
        if(enough) {
            try {
                while (srcList.size() < tags.size()) {
                    srcList.add(unstoppableSearch(tags.get(srcList.size()), 1));
                    if (srcList.size()< tags.size()) JOptionPane.showMessageDialog(null, "Фото по тегу " + "\"" + tags.get(srcList.size())+ "\"" + " найдено.");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }

        }
        else {
            try {
                while (srcList.size() < 7) {
                    for(int i = 0; i < tags.size(); i++) {
                        int count = 0;
                        int index = (srcList.size() == 0) ? 0 : srcList.size() - (srcList.size() - i);
                        if (index >= tags.size()) index = 0;
                        while (count < 2) {
                            srcList.add(unstoppableSearch(tags.get(index), 1+(int)(Math.random()*15)));
                            JOptionPane.showMessageDialog(null, "Фото по тегу " + "\"" + tags.get(index) + "\"" + " найдено.");
                            count++;
                        }
                        System.out.println(index);
                        if((tags.size() < 4 | index > tags.size()-2) & srcList.size() >= 7) break;
                    }
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        stopSearch();
        return srcList;
    }

    private String unstoppableSearch(String name, int index) throws MalformedURLException, InterruptedException {
        // поиск изображения
        WebElement searchField = driver.findElement(By.xpath("//input[@class = 'input__control']"));
        searchField.sendKeys(name);
        WebElement findBtn = driver.findElement(By.xpath("//div[@class = 'websearch-button__text']"));
        findBtn.click();
        WebElement picture = driver.findElement(By.xpath("//div[@role = 'list']//div[" + index + "][@role = 'listitem']")); // цифра 1 означает, что это первое фото в списке => можно менять и подбирать несколько фоток
        picture.click();
        WebElement scaledPicture = driver.findElement(By.xpath("//img[@class = 'MMImage-Origin']"));
        URL url = new URL(scaledPicture.getAttribute("src"));
        System.out.println(url);
        String windowName = driver.getWindowHandle();
        driver.get("https://yandex.ru/images/");
        driver.switchTo().window(windowName);
        return url.toString();
    }

    private void stopSearch() {
        driver.quit();
    }
}