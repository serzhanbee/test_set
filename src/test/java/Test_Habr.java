import com.codeborne.selenide.Condition;
import org.junit.*;
import org.junit.Test;
import org.openqa.selenium.Keys;

import java.security.Key;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selectors.by;

/**
 * Created by serzhan on 30.06.2017.
 */
public class Test_Habr extends Driver {

    @Test
    public void loginHabr() throws Exception {
        open("https://habrahabr.ru/");
        $("#login").click();
        $(byName("email")).setValue("Serzhan");
        $(by("class","s-error")).getText()
        .equals("Введите корректный адрес");

        $(byName("email")).setValue("S**");
        $(byName("password")).setValue("*****")
        .sendKeys(Keys.ENTER);
        sleep(1000);
        $("#search-form-btn").click();
        $("#search-form-field").setValue("Автоматизация тестирования")
        .sendKeys(Keys.ENTER);
        sleep(10000);
    }
}
