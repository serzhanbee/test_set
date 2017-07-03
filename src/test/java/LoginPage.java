import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by serzhan on 29.06.2017.
 */
public class LoginPage {

    private String userFirstName ;
    String userLsatName = "Есенбек";
    String userDate = "5";
    String errorMessageDate ="Пожалуйста, укажите дату рождения.";
    String errorMessageLastName = "Пожалуйста, укажите Ваше имя и фамилию";

    public  LoginPage (String userFirstName){
        this.userFirstName = userFirstName;

    }

    private SelenideElement first_UserName = $("#ij_first_name");
    private SelenideElement firs_LastName = $("#ij_last_name");
    private SelenideElement drop_Date = $("#dropdown1");
    private SelenideElement button_Sumbit = $("#ij_submit");
    private SelenideElement index_Email = $("#index_email");
    private SelenideElement index_Pass = $("#index_pass");
    private SelenideElement login_Button =$("#index_login_button");

    @Step("Нажатия на кнопку Войти")
    public void loginButton (){
        login_Button.click();
    }

    @Step("Вводим пароль")
    public void userPass(){
        index_Pass.setValue("****");
    }

    @Step("Вводим Логин")
    public void userEmail(){
        index_Email.setValue("*****");
    }

    @Step("Заполнен поле Имя")
    public void setFirstUserName (){
        first_UserName.setValue(userFirstName);
    }

    @Step("Заполнен поле Фамиля")
    public void setFirsLastName (){

        firs_LastName.setValue(userLsatName);
    }

    @Step("Нажатие на кнопку Зарегистрироваться")
    public void setButtonSumbit (){
        button_Sumbit.click();
    }

    @Step("Выбирать Дату рождения")
    public void setDropDate (){
        drop_Date.click();
        $(byText(userDate)).click();
    }

    @Step("Сообщения об ошибке: Пожалуйста, укажите дату рождения.")
    public void setErrorMessageDate () {
        $(byText(errorMessageDate)).is(visible);
        sleep(100);
    }

    @Step("Сообщения об ошибке: Пожалуйста, укажите Ваше имя и фамилию")
    public void setErrorMessageLastName(){
        $(byText(errorMessageLastName)).is(visible);
        sleep(100);
    }




}
