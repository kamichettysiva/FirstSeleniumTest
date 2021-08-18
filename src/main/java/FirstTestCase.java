import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;


public class FirstTestCase {
            public static void main(String args[]){
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                System.setProperty("webdriver.chrome.driver", "/Users/sivakumarkamichetty/IdeaProjects/FirstSeleniumTest/chromedriver");
                WebDriver driver = new ChromeDriver();
                driver.get("https://www.google.com/");
                String title = driver.getTitle();
                System.out.println(dtf.format(now));
                System.out.println("The page title is : " +title);

                //Implicit wait
                /*driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                WebElement uName = driver.findElement(By.xpath("//div[text()='Lyrics']"));*/

                //Explicit Wait
                /*WebDriverWait wait = new WebDriverWait(driver,10);
                wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[text()='Lyrics']")))).click();*/

                Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(30))
                        .pollingEvery(Duration. ofMillis(500))
                        .withMessage("Wait for the element to be loaded")
                        .ignoring(NoSuchElementException.class);
                wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[text()='Lyrics']")))).click();
                System.out.println(dtf.format(now));
                driver.quit();

            }
}
