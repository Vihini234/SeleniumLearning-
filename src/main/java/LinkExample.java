import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class LinkExample {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // =====================================================
        // PART 1: LINKS PAGE
        // =====================================================

        driver.get("https://www.leafground.com/link.xhtml");
        Thread.sleep(3000);

        // Go to Dashboard
        driver.findElement(By.linkText("Go to Dashboard")).click();
        System.out.println("Dashboard opened");

        Thread.sleep(2000);

        driver.get("https://www.leafground.com/link.xhtml");
        Thread.sleep(2000);

        // Find URL
        String url = driver.findElement(By.partialLinkText("Find the URL"))
                .getAttribute("href");

        System.out.println("Destination URL : " + url);

        // Broken link
        driver.findElement(By.partialLinkText("Broken")).click();

        Thread.sleep(2000);

        String currentURL = driver.getCurrentUrl();

        System.out.println("Current URL : " + currentURL);

        if (currentURL.contains("error") || currentURL.contains("404")) {
            System.out.println("The link is broken");
        } else {
            System.out.println("The link is NOT broken");
        }

        driver.get("https://www.leafground.com/link.xhtml");
        Thread.sleep(2000);

        // Duplicate link
        driver.findElement(By.linkText("Go to Dashboard")).click();

        System.out.println("Duplicate dashboard clicked");

        Thread.sleep(2000);

        // IMPORTANT: RESET PAGE STATE (KEY FIX)
        driver.get("https://www.leafground.com/link.xhtml");

        Thread.sleep(3000);

        // =====================================================
        // COUNT LINKS (FIXED STABLE VERSION)
        // =====================================================

        driver.get("https://www.leafground.com/link.xhtml");

     // IMPORTANT WAIT (not optional here)
        Thread.sleep(5000);

       // NOW count links
        List<WebElement> allLinks =
                driver.findElements(By.tagName("a"));

        System.out.println("How many links in this page? : " + allLinks.size());

        // =====================================================
        // PART 2: GRID PAGE
        // =====================================================

        driver.get("https://www.leafground.com/grid.xhtml");
        Thread.sleep(4000);

        // Rows
        List<WebElement> rows =
                driver.findElements(By.xpath("//table/tbody/tr"));

        System.out.println("Total Rows : " + rows.size());

        // Columns
        List<WebElement> columns =
                driver.findElements(By.xpath("//table/thead/tr/th"));

        System.out.println("Total Columns : " + columns.size());

        // First cell
        WebElement cell =
                driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));

        System.out.println("First Cell Value : " + cell.getText());

        // Print all data
        List<WebElement> allData =
                driver.findElements(By.xpath("//table/tbody/tr/td"));

        System.out.println("----- TABLE DATA -----");

        for (WebElement data : allData) {
            System.out.println(data.getText());
        }

        Thread.sleep(3000);

        driver.quit();
    }
}