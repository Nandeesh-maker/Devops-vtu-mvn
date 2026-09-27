package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebpageTest {

    WebDriver driver;

    @BeforeClass
    public void openBrowser() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
    }

    @Test
    public void testPageTitle() {

        driver.get("https://nandeesh-maker.github.io/devopsgradle/");

        String title = driver.getTitle();

        System.out.println("Page Title: " + title);

        assert title != null && !title.isEmpty();
    }

    @AfterClass
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
        }
    }
}