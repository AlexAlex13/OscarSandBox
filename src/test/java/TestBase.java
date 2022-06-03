import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    ChromeDriver driver = new ChromeDriver();

    @BeforeMethod
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver", "/Users/alex/IdeaProjects/OscarSandbox/chromedriver");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("http://selenium1py.pythonanywhere.com/en-gb/");
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }


}
