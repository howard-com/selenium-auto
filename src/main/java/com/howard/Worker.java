package com.howard;

import com.howard.task.*;
import com.howard.utils.MouseAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Worker {
    public int g_profileSet;
    public String g_userProfilePath;
    public BasicTask[] g_presetTasks = null;
    public WindowObject windowObject = null;

    public Worker(int setNum) {
        switch (setNum) {
            case 1:
                this.g_profileSet = setNum;
                this.g_userProfilePath = "--user-data-dir=C:\\Users\\Huang\\AppData\\Local\\Google\\Chrome\\User Data 1";
                break;
            case 2:
                this.g_profileSet = setNum;
                this.g_userProfilePath = "--user-data-dir=C:\\Users\\Huang\\AppData\\Local\\Google\\Chrome\\User Data 2";
        }
    }

    public void setTasks(BasicTask[] tasks) {
        this.g_presetTasks = tasks;
    }
    public void startWork() {
        if (windowObject == null) {
            try {
                windowObject = createWindow(g_userProfilePath);
                this.windowObject = windowObject;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        BasicTask[] tasks = getTasks(windowObject.getAction());
        runTask(tasks);
    }

    public WindowObject createWindow(String userProfile) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(userProfile);
        WebDriver driver  = new ChromeDriver(options);
        driver.get("http://wan.baidu.com/game?gameId=26588310&serverId=11082&idfrom=5056");
        Thread.sleep(3000);
        driver.manage().window().setSize(new Dimension(677, 1242));
        driver.switchTo().frame(0);
        WebElement mainCanvas = driver.findElement(By.cssSelector("canvas"));
        MouseAction action = new MouseAction(driver, mainCanvas, 300);

        WindowObject windowObject = new WindowObject();
        windowObject.setAction(action);
        windowObject.setDriver(driver);

        return windowObject;
    }

    public BasicTask[] getTasks(MouseAction action) {
        BasicTask[] res = null;

        if (g_presetTasks == null) {
            ArrayList<BasicTask> array = new ArrayList();
            array.add(new LoginTask(action));
            //array.add(new DailyInstanceTask(action));
            //array.add(new ExpInstanceTask(action));
            //array.add(new GriffinTask(action));
            //array.add(new EquipementBossTask(action));
            //array.add(new WholePeopletBossTask(action));
            //array.add(new UpgradeCardTask(action));
            array.add(new BossTask(action));
            //array.add(new BesiegeBossTask(action));
            //array.add(new TreasureTask(action));
            //array.add(new UpgradePropertyTask(action));
            //array.add(new CleanBagTask(action));
            //array.add(new GloryTask(action));
            //array.add(new DailyInstanceTask(action));
            //array.add(new EmailTask(action));
            //array.add(new BossTask(action));
            //array.add(new C_UpgrateAndClean(action));
            //array.add(new C_Daily(action));
            //array.add(new WorldBossTask(action));
            //array.add(new RedHoodTask(action));

            res = array.toArray(new BasicTask[array.size()]);
        } else {
            for (BasicTask task:g_presetTasks) {
                task.setMouseAction(action);
            }
            res = g_presetTasks;
        }

        return res;
    }

    public void runTask(BasicTask tasks[]) {
        for (BasicTask task: tasks) {
            try {
                task.lanuch();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopWork() {
        if (this.windowObject == null) {
            return;
        }
        this.windowObject.getDriver().close();
        this.windowObject = null;
    }
}
