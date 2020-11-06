package biz.Supl.objects;

import org.openqa.selenium.WebDriver;

public abstract class Elem {
    WebDriver driver;

    Elem(WebDriver driver){
        this.driver = driver;
        this._elements();
    }

    abstract void _elements();
}
