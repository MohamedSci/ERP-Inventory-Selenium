package com.mohamedsaidibrahim;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected static WebDriver driver;

    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mohamed.microtecdev.com:2050/inventory/masterdata/uom/add-uom");
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
