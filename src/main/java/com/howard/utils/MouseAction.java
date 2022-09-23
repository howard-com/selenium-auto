package com.howard.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.Collections;

public class MouseAction {
    private WebDriver g_driver;
    private WebElement g_element;
    private Actions g_builder;
    private int g_interval = 200;

    public void setElement(WebElement g_element) {
        this.g_element = g_element;
    }

    public void setDriver(WebDriver driver) {
        this.g_driver = driver;
        this.g_builder = new Actions(g_driver);
    }

    public MouseAction(WebDriver driver, WebElement element) {
        this.g_driver = driver;
        this.g_element = element;
        this.g_builder = new Actions(g_driver);
    }

    public MouseAction(WebDriver driver, WebElement element, int interval) {
        this.g_driver = driver;
        this.g_element = element;
        this.g_interval = interval;
        this.g_builder = new Actions(g_driver);
    }

    public void setInterval(int interval) {
        this.g_interval = interval;
    }

    public void clickAt(int X, int Y) {
        g_builder.moveToElement(g_element, X, Y).pause(Duration.ofMillis(g_interval)).click().build().perform();
    }

    public void clickAt(int[] coordinate) {
        this.clickAt(coordinate[0], coordinate[1]);
    }

    public void clickAt2(int X, int Y) {
        PointerInput mouse = new PointerInput(PointerInput.Kind.MOUSE, "default mouse");

        Sequence actions = new Sequence(mouse, 0)
                .addAction(mouse.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), X, Y));

        ((RemoteWebDriver) g_driver).perform(Collections.singletonList(actions));
    }
}
