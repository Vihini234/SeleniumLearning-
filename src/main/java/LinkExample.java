import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class LinkExample {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.leafground.com/link.xhtml");

        // 1. Go to Dashboard
        driver.findElement(By.linkText("Go to Dashboard")).click();
        driver.navigate().back();

        // IMPORTANT: re-locate elements after navigation
        driver.get("https://www.leafground.com/link.xhtml");

        // 2. Get link URL (no click needed)
        String url = driver.findElement(By.partialLinkText("Find"))
                .getAttribute("href");

        System.out.println("Destination: " + url);

        // 3. Broken link (safe handling)
        driver.findElement(By.linkText("Broken?")).click();

        driver.navigate().back();

        // 4. Count links (after fresh page load)
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links: " + links.size());

        driver.quit();
    }
}