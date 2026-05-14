import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void ButtonTests() throws InterruptedException {

        // click and confirm title
        driver.findElement(By.id("j_idt88:j_idt90")).click();

        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Actual title is same as expected one");
        } else {
            System.out.println("Actual title is not same as expected one");
        }

        // go back
        driver.navigate().back();
        Thread.sleep(2000);

        // find position of button
        WebElement getPosition =
                driver.findElement(By.id("j_idt88:j_idt94"));

        Point xyPoint = getPosition.getLocation();

        int x = xyPoint.getX();
        int y = xyPoint.getY();

        System.out.println("X position is : " + x);
        System.out.println("Y position is : " + y);

        // find button colour
        WebElement buttonColour =
                driver.findElement(By.id("j_idt88:j_idt96"));

        String color =
                buttonColour.getCssValue("background-color");

        System.out.println("Button color is : " + color);

        // find height and width
        WebElement size =
                driver.findElement(By.id("j_idt88:j_idt98"));

        int height = size.getSize().getHeight();
        int width = size.getSize().getWidth();

        System.out.println("Height : " + height);
        System.out.println("Width : " + width);
    }

    @AfterMethod
    public void closeBrowser() {

        if (driver != null) {
            driver.quit();
        }
    }
}