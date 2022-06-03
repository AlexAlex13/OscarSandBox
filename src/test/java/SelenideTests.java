import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideTests {
    @BeforeMethod

    public void initTest(){
        open("http://selenium1py.pythonanywhere.com/en-gb/");

}

    @AfterMethod void closedTest(){
        closeWebDriver();
    }

    @Test
    public void changelangTest() throws InterruptedException {
        SelenideElement lang_selector = $("[name='language']");
        SelenideElement goButton = $("button.btn-default");
        SelenideElement viewbasket = $(".btn-group a.btn.btn-default");

        lang_selector.selectOption("Русский");
        goButton.click();
        viewbasket.shouldHave(Condition.text("посмотреть корзину"));
        Thread.sleep(2000);


    }
}
