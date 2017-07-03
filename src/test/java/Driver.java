import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.ScreenShooter;
import com.google.common.io.Files;
import com.jcraft.jsch.JSchException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by serzhan on 20.04.2017.
 */
public  class Driver {

    @Rule
    public ScreenShooter makeScreenshotOnFailure = ScreenShooter.failedTests().succeededTests();


    private static WebDriver getChrome  () {
        final ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:/infor/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        final ChromeOptions option = new ChromeOptions();
        option.addArguments("--always-authorize-plugins", "--start-maximized", "--scroll-end-effect=1");
        EventFiringWebDriver newDriver = new EventFiringWebDriver(new ChromeDriver(service, option));
        return newDriver;
    }


    @Before
    public void start () throws JSchException {
        WebDriverRunner.setWebDriver(getChrome());
    }


    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }

    @After
    public void closer () throws IOException, NullPointerException {
        screenshot();
        close();
    }

}
