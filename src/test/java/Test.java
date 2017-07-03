import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by serzhan on 29.06.2017.
 */
@Features("Тестирование Вкантакте")
@Stories("Вход в систему")
@Title("Тестирование Вк")
public class Test extends Driver {


    @Title("Не заполнено поле Дата рождения")
    @org.junit.Test
    public void errorRegistDate () {
        open("https://www.vk.com");
        LoginPage loginPage = new LoginPage("Ser");
        loginPage.setFirstUserName();
        loginPage.setFirsLastName();
        loginPage.setDropDate();
        loginPage.setButtonSumbit();
        loginPage.setErrorMessageDate();
    }

    @Title("Не заполнено поле Фамилия пользователя")
    @org.junit.Test
    public void errorRegistLastName () {
        open("https://www.vk.com");
        LoginPage loginPage = new LoginPage("Ser");
        loginPage.setFirstUserName();
        loginPage.setButtonSumbit();
        loginPage.setErrorMessageLastName();
    }

    @Title("Вход в систему")
    @org.junit.Test
    public void loginUserPass () {
        open("https://www.vk.com");
        LoginPage loginPage = new LoginPage("Ser");
        loginPage.userEmail();
        loginPage.userPass();
        loginPage.loginButton();
        sleep(1000);
    }


}
