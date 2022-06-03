import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.security.Timestamp;
import java.time.Instant;
import java.util.Date;

public class MainPageTest extends TestBase{

    @Test
    public void  addBasket() throws InterruptedException {
        WebElement drop_menu = driver.findElementByXPath("//li[@class='dropdown-submenu']");
        drop_menu.click();
        Thread.sleep(500);

        WebElement img1 = driver.findElements(By.cssSelector("img")).get(0);
        img1.click();
        Thread.sleep(500);

        WebElement add_to_bascket = driver.findElementByXPath("//button[@value='Add to basket']");
        add_to_bascket.click();
        Thread.sleep(500);

        Assert.assertTrue(driver.findElementByXPath("//div[@class='alertinner ']").isDisplayed());


    }

    @Test
    public void  changeLanguageTest() throws InterruptedException {

        long averageCss =0;
        long averageXpath = 0;

        for (int i=0;i<1000;i++) {
            long timestampCssStart = System.currentTimeMillis();
            driver.findElementByCssSelector("select.form-control");
            long timestampCssFinish = System.currentTimeMillis();
            averageCss= averageCss+timestampCssFinish-timestampCssStart;
        }


        for (int i=0;i<1000;i++) {
            long timestampXPathStart = System.currentTimeMillis();
            driver.findElementByXPath("//select");
            long timestampXPathFinished = System.currentTimeMillis();
            averageXpath= averageXpath+timestampXPathFinished-timestampXPathStart;
        }

        System.out.println(averageCss);
        System.out.println(averageXpath);

    }

    @Test
    public void  cliclkCoupleElements() throws InterruptedException {


        driver.findElementByXPath("//input[@type='search']").click();
        Thread.sleep(5000);

    }

    @Test
    public void  LangMenu() throws InterruptedException {
        Select celestlang = new Select(driver.findElementByXPath("//select[@name='language']"));
        celestlang.selectByValue("pl");
        driver.findElementByXPath("//button[@data-loading-text='Submitting...']").click();
        Assert.assertTrue(driver.findElementByXPath("//*[contains(text(),'Razem produkty:')]").isDisplayed());


    }
}
