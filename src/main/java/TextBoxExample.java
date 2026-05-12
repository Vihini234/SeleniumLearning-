// Import Selenium libraries
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TextBoxExample {

    public static void main(String[] args) throws InterruptedException {

        // Open Chrome browser
        WebDriver driver = new ChromeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Open LeafGround Input page
        driver.get("https://www.leafground.com/input.xhtml");

        // Wait 3 seconds
        Thread.sleep(3000);

        // =====================================================
        // Type your name
        // =====================================================

        // Find name textbox using id
        WebElement name =
                driver.findElement(By.id("j_idt88:name"));

        // Type name inside textbox
        name.sendKeys("Vihini Wathsiluni");

        // =====================================================
        // Append country to city field
        // =====================================================

        // Find append textbox
        WebElement appendText =
                driver.findElement(By.id("j_idt88:j_idt91"));

        // Type country name
        appendText.sendKeys(" India");

        // =====================================================
        // Check whether textbox is enabled or disabled
        // =====================================================

        // Find disabled textbox and check status
        boolean enabled =
                driver.findElement(By.name("j_idt88:j_idt93"))
                        .isEnabled();

        // Print result
        System.out.println("Is text box enabled? : " + enabled);

        // =====================================================
        // Clear typed text
        // =====================================================

        // Find clear textbox
        WebElement clearText =
                driver.findElement(By.id("j_idt88:j_idt95"));

        // Clear existing text
        clearText.clear();

        // =====================================================
        // Retrieve typed text
        // =====================================================

        // Find textbox
        WebElement textElement =
                driver.findElement(By.id("j_idt88:j_idt97"));

        // Get text value from textbox
        String text =
                textElement.getAttribute("value");

        // Print retrieved text
        System.out.println("Retrieved text : " + text);

        // =====================================================
        // Type email and press TAB key
        // =====================================================

        // Find email field
        driver.findElement(By.id("j_idt88:j_idt99"))
                .sendKeys(
                        "rvihini@gmail.com"
                                + Keys.TAB
                                + "Confirmed control moved to next element"
                );

        // Wait 3 seconds
        Thread.sleep(3000);

        // Close browser
        driver.quit();
    }
}