package Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BrowserImagesSearch {

    public static void search(String name) throws MalformedURLException {
        // настройка браузера
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // поиск изображения
        driver.get("https://yandex.ru/images/");
        System.out.println(driver.getTitle());
        WebElement searchField = driver.findElement(By.xpath("//input[@class = 'input__control']"));
        searchField.sendKeys(name);
        WebElement findBtn = driver.findElement(By.xpath("//div[@class = 'websearch-button__text']"));
        findBtn.click();
        WebElement picture = driver.findElement(By.xpath("//div[@role = 'list']//div[1][@role = 'listitem']")); // цифра 1 означает, что это первое фото в списке => можно менять и подбирать несколько фоток
        picture.click();
        WebElement scaledPicture = driver.findElement(By.xpath("//img[@class = 'MMImage-Origin']"));
        URL url = new URL(scaledPicture.getAttribute("src"));
        System.out.println(url);
    }
}