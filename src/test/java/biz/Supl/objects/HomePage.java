package biz.Supl.objects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Elem {
    protected WebElement home_page;
    public WebElement sign_up_button;

    public HomePage(WebDriver driver){

        super(driver);
    }

    void _elements(){
        this.home_page = this.driver.findElement(By.xpath(".//body"));
        this.sign_up_button = this.home_page.findElement(By.xpath(".//button[.=\"Регистрация\"]"));
    }

}
