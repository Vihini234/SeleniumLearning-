import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Radio_CehckBox_Example {

    WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void radioTests() {

        // Open the webpage
        driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");

        // Check which radio button is selected by default
        boolean chromeRadioOption = driver.findElement(By.id("j_idt87:console1:0")).isSelected();
        boolean firefoxRadioOption = driver.findElement(By.id("j_idt87:console1:1")).isSelected();
        boolean safariRadioOption = driver.findElement(By.id("j_idt87:console1:2")).isSelected();
        boolean edgeRadioOption = driver.findElement(By.id("j_idt87:console1:3")).isSelected();

        if (chromeRadioOption) {

            String chromeText = driver.findElement(
                            By.xpath("//label[@for='j_idt87:console1:0']"))
                    .getText();

            System.out.println("Default selected radio button is: " + chromeText);

        } else if (firefoxRadioOption) {

            String firefoxText = driver.findElement(
                            By.xpath("//label[@for='j_idt87:console1:1']"))
                    .getText();

            System.out.println("Default selected radio button is: " + firefoxText);

        } else if (safariRadioOption) {

            String safariText = driver.findElement(
                            By.xpath("//label[@for='j_idt87:console1:2']"))
                    .getText();

            System.out.println("Default selected radio button is: " + safariText);

        } else if (edgeRadioOption) {

            String edgeText = driver.findElement(
                            By.xpath("//label[@for='j_idt87:console1:3']"))
                    .getText();

            System.out.println("Default selected radio button is: " + edgeText);
        }

        // Select Firefox radio button if it is not already selected
        if (!firefoxRadioOption) {

            driver.findElement(By.id("j_idt87:console1:1")).click();

            System.out.println("Firefox radio button selected.");
        }

        driver.quit();
    }
}