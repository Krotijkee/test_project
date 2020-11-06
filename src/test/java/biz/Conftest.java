package biz;

import org.openqa.selenium.chrome.ChromeDriver;

public class Conftest {
    public static ChromeDriver webdriver(){
        System.setProperty("webdriver.chrome.driver", Cnst.chromedriver_url);

        return new ChromeDriver();
    }
}
