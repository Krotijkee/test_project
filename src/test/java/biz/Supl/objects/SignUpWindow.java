package biz.Supl.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpWindow extends Elem {
    WebElement _sign_up_form;
    public WebElement phone_input;
    public WebElement email_input;
    public WebElement password_input;
    public WebElement sign_up_button;

    public SignUpWindow(WebDriver driver) {
        super(driver);
    }

    void _elements() {
        this._sign_up_form = this.driver.findElement(By.xpath(".//form[@data-cy='sign-up-form']"));
        this.phone_input = this._sign_up_form.findElement(By.xpath(".//input[@id='input-phone']"));
        this.email_input = this._sign_up_form.findElement(By.xpath(".//input[@id='input-email']"));
        this.password_input = this._sign_up_form.findElement(By.xpath(".//input[@id='input-password']"));
        this.sign_up_button = this._sign_up_form.findElement(By.xpath(".//button[.='Зарегистрироваться']"));
    }

    public boolean email_error_is_visible() {
        return !this.email_input.findElements(By.xpath("./following-sibling::div")).isEmpty();
    }
}