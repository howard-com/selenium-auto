package com.howard;

import com.howard.utils.MouseAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowObject {
    WebDriver driver;
    MouseAction action;
    ChromeOptions options;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public MouseAction getAction() {
        return action;
    }

    public void setAction(MouseAction action) {
        this.action = action;
    }
}
