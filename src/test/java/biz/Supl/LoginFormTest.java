package biz.Supl;


import biz.Cnst;
import biz.Conftest;
import biz.Supl.objects.HomePage;
import biz.Supl.objects.SignUpWindow;
import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@Epic(value = "Тестирование регистрации на supl.biz")
@RunWith(value = Parameterized.class)
public class LoginFormTest {
    private static WebDriver driver;
    static HomePage home_page;
    static SignUpWindow sign_up_window;

    @Parameterized.Parameter(value = 0)
    public String email;

    @Parameterized.Parameter(value = 1)
    public Boolean is_valid;

    @Parameterized.Parameters(name = "{index}: parameters({0}+{1})")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"address@host.domain", false},
                {"ADDRESS@host.domain", false},
                {"address@hostdomain", true}
        });
    }

    @BeforeClass
    public static void setUp(){
        driver = Conftest.webdriver();
        driver.get(Cnst.url);
    }

    @Story(value = "Валидация поля email формы регистрации")
    @Test
    public void email_input_is_valid(){
        this.open_sign_up_window();
        this.insert_email(email);
        this.error_is_visible(is_valid);

    }
    @Step(value = "Открыть окно регистрации")
    private void open_sign_up_window(){
        home_page = new HomePage(driver);
        if (driver.findElements(By.xpath("//form[@data-cy='sign-up-form']")).isEmpty()){
            home_page.sign_up_button.click();
        }
    }
    @Step(value = "Заполнить поле 'email'")
    private void insert_email(String email){
        sign_up_window = new SignUpWindow(driver);
        sign_up_window.email_input.sendKeys(Keys.CONTROL + "A" + Keys.DELETE);
        sign_up_window.email_input.sendKeys(email);
    }
    @Step(value = "Предупреждение присутствует")
    private void error_is_visible(boolean is_valid){
        sign_up_window.sign_up_button.click();
        assertEquals(sign_up_window.email_error_is_visible(), is_valid);
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
