import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class windowExample {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    //New change
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void windowHandlingTest() {

        // Parent window
        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window: " + parentWindow);

        // ✅ Stable locator (NO dynamic ID)
        WebElement openButton =
                driver.findElement(By.linkText("Go to Dashboard"));

        openButton.click();

        // All window handles
        Set<String> handles = driver.getWindowHandles();
        System.out.println("Number of Windows: " + handles.size());

        // =========================
        // METHOD 1: Using Set
        // =========================
        for (String window : handles) {
            driver.switchTo().window(window);
            System.out.println("Window Title: " + driver.getTitle());
        }

        // =========================
        // METHOD 2: Using List
        // =========================
        List<String> list = new ArrayList<>(handles);

        String childWindow = null;

        if (list.size() > 1) {
            childWindow = list.get(1);
            driver.switchTo().window(childWindow);

            System.out.println("Child Title: " + driver.getTitle());

            driver.close(); // close child window
        }

        // Back to parent
        driver.switchTo().window(parentWindow);

        System.out.println("Back to Parent Title: " + driver.getTitle());

        // Verify element still visible
        WebElement openButtonAgain =
                driver.findElement(By.linkText("Go to Dashboard"));

        System.out.println("Button Visible: " + openButtonAgain.isDisplayed());

        // Count open tabs
        System.out.println("Open Tabs: " + driver.getWindowHandles().size());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}