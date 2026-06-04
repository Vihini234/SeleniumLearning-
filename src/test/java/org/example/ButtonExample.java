package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class ButtonExample {

    WebDriver driver;
    WebDriverWait wait;

    By clickBtn = By.id("j_idt88:j_idt90");
    By positionBtn = By.id("j_idt88:j_idt94");
    By colorBtn = By.id("j_idt88:j_idt96");
    By sizeBtn = By.id("j_idt88:j_idt98");

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void ButtonTests() {

        // Click button (with proper wait)
        wait.until(ExpectedConditions.elementToBeClickable(clickBtn)).click();

        // Validate title (safe approach)
        wait.until(ExpectedConditions.titleContains("Dashboard"));
        Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Title mismatch!");

        // Go back
        driver.navigate().back();

        // Position of button
        WebElement pos = driver.findElement(positionBtn);
        Point point = pos.getLocation();

        System.out.println("X position: " + point.getX());
        System.out.println("Y position: " + point.getY());

        // Button color
        WebElement color = driver.findElement(colorBtn);
        System.out.println("Button color: " + color.getCssValue("background-color"));

        // Button size
        WebElement size = driver.findElement(sizeBtn);

        System.out.println("Height: " + size.getSize().getHeight());
        System.out.println("Width: " + size.getSize().getWidth());
    }

    @AfterMethod
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}