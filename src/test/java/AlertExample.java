import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");
    }

    @Test(priority = 1)
    public void simpleAlertTest() throws InterruptedException {

        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertBox.click();

        Alert alert = driver.switchTo().alert();

        Thread.sleep(3000); // Wait 3 seconds

        alert.accept();

        System.out.println("Simple Alert Accepted");
    }

    @Test(priority = 2)
    public void confirmAlertTest() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement confirmBox = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("j_idt88:j_idt93")));

        confirmBox.click();

        Thread.sleep(3000); // Wait 3 seconds before clicking No

        WebElement noButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[normalize-space()='No']")));

        noButton.click();

        System.out.println("Confirm Dialog Closed");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(2000);

        driver.quit();
    }
}