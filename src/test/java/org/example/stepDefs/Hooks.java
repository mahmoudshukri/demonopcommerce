package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver=null;
    @Before
    public static void openBrowser()
    {
        // 1-define bridge by System.setProperty() or WebDriverManager

        WebDriverManager.chromedriver().setup();


        // 2- Create new object from chrome driver
        driver=new ChromeDriver();

        // 3- Configurations
        // 3.1- Maximize window
        driver.manage().window().maximize();
        // 3.2 - Set Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // 4- navigate to url
        driver.navigate().to("https://demo.nopcommerce.com/");

    }
@After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();

}



}
