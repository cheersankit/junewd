package co.pragra.learning;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Set;

public class HomeTest {

    @BeforeSuite
    public void setup(){
        System.setProperty("webdriver.chrome.driver","/Users/ankitmohanty/Downloads/chromedriver");
    }

    @Test
    public void openPragraWeb() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://zoom.us/");

        WebElement eml =driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[1]/li[9]/a"));

        Actions actions = new Actions(driver);

        actions.keyDown(Keys.COMMAND).pause(1000).click(eml).build().perform();
        Thread.sleep(3000);


        Set<String> windows =driver.getWindowHandles();
        String currentWindow = driver.getWindowHandle();

        for(String window: windows){
            if(!window.equals(currentWindow)){
                driver.switchTo().window(window);
                break;
            }
        }

        driver.findElement(By.cssSelector("#email")).click();
        Thread.sleep(3000);
        driver.switchTo().window(currentWindow);

        ((JavascriptExecutor) driver).executeScript("alert('Fake Alert)");

        System.out.println(driver.getWindowHandle());

        Thread.sleep(10000);
        driver.close();
        driver.quit();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        driver.quit();
    }
}
