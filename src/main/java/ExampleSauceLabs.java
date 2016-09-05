import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertEquals;


public class ExampleSauceLabs {

    static String USERNAME = "rudy92";
    static String ACCESS_KEY ="ed92329d-d2fe-49d9-b71c-db90ebe84621";
    public static final String MYURL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

    @Test
    public void findElement() throws MalformedURLException {
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("platform", "Linux");
        caps.setCapability("version", "30.0");
        caps.setCapability("screenResolution", "1024x768");
        caps.setCapability("passed","true");
        caps.setCapability("name","Mail test");
        WebDriver driver = new RemoteWebDriver(new URL(MYURL), caps);


        driver.get("https://mail.ru/");
        WebElement Login = driver.findElement(By.id("mailbox__login"));
        Login.sendKeys("strong.zubovich@bk.ru");

        WebElement password = driver.findElement(By.id("mailbox__password"));
        password.sendKeys("ZXCvbn123!");

        WebElement enterButton = driver.findElement(By.id("mailbox__auth__button"));
        enterButton.click();

        int numberOfLetters = driver.findElements(By.cssSelector("[data-bem=\"b-datalist__item\"]")).size();
        System.out.println("Количество писем = "+numberOfLetters);

//        assertEquals("Входящие - Почта Mail.Ru",driver.getTitle());

        driver.quit();


    }
}
