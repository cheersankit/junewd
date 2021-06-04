package co.testing;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TestingJava {

    @BeforeSuite
    public void startGoogle(){
        System.setProperty("webdriver.chrome.driver","/Users/ankitmohanty/Downloads/chromedriver");
    }

    @Test
    public void openZoom() throws InterruptedException, MalformedURLException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www1.oanda.com/currency/converter/");

        WebElement eml= driver.findElement(By.id("base_currency_input"));
        eml.sendKeys("CAD",Keys.ENTER);
        Thread.sleep(3000);

        driver.navigate().refresh();
        driver.manage().deleteCookieNamed("base_currency_0");
        Thread.sleep(3000);

        driver.navigate().refresh();
        driver.manage().addCookie(new Cookie("base_currency_0","INR"));
        Thread.sleep(3000);
        driver.navigate().refresh();

        driver.manage().deleteAllCookies();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);

        Cookie cookie= driver.manage().getCookieNamed("base_currency_0");
        System.out.println(cookie);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

        ((JavascriptExecutor) driver).executeScript("console.log('Java is a very Good')");

        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MILLISECONDS);

//        WebElement eml = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[1]/li[9]/a"));
//
//        eml.click();
//        Thread.sleep(3000);
//        driver.navigate().back();
//        Thread.sleep(3000);
//        driver.navigate().forward();
//        Thread.sleep(3000);
//        driver.navigate().refresh();
//        Thread.sleep(3000);
//        driver.navigate().to(new URL("https://www.canada.ca/en/immigration-refugees-citizenship/services/application/account.html"));
//        Thread.sleep(3000);
//
//        driver.manage().window().fullscreen();
//        Thread.sleep(3000);
//        driver.manage().window().setSize(new Dimension(300,800));
//        Thread.sleep(3000);
//        driver.manage().window().setPosition(new Point(300,70));
//        Thread.sleep(3000);
//        driver.navigate().to(new URL("https://zoom.us"));
//        driver.manage().window().fullscreen();
//        Thread.sleep(3000);
//        Actions actions = new Actions(driver);
//
//        actions.keyDown(Keys.COMMAND).pause(1000).click(eml).build().perform();
//
//        Set<String> windows = driver.getWindowHandles();
//        String parentWindow = driver.getWindowHandle();
//
//        for(String window: windows){
//            if(!window.equals(parentWindow)){
//                driver.switchTo().window(window);
//                break;
//            }
//        }
//
//        ((JavascriptExecutor) driver).executeScript("confirm('Fake Alert')");
//
//        Alert alert = driver.switchTo().alert();
//        alert.dismiss();
//         Thread.sleep(1000);
//        driver.findElement(By.cssSelector("#company")).sendKeys("Ankit Mohanty");
//
//        driver.close();
//
//        Thread.sleep(1000);
//
       driver.quit();
    }


}

