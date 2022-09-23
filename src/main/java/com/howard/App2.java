package com.howard;

import com.howard.task.*;
import com.howard.utils.MouseAction;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App2 {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=C:\\Users\\Huang\\AppData\\Local\\Google\\Chrome\\User Data 2");

        driver = new ChromeDriver(options);
        driver.get("http://wan.baidu.com/game?gameId=26588310&serverId=11082&idfrom=5056");

        Thread.sleep(3000);

        driver.manage().window().setSize(new Dimension(677, 1242));
        driver.switchTo().frame(0);
        WebElement mainCanvas = driver.findElement(By.cssSelector("canvas"));


        MouseAction action = new MouseAction(driver, mainCanvas, 200);
        LoginTask loginTask = new LoginTask(action);
        DailyInstanceTask dailyInstanceTask = new DailyInstanceTask(action);
        ExpInstanceTask expInstanceTask = new ExpInstanceTask(action);
        GriffinTask griffinTask = new GriffinTask(action);
        EquipementBossTask equipementBossTask = new EquipementBossTask(action);
        WholePeopletBossTask wholePeopletBossTask = new WholePeopletBossTask(action);
        UpgradeCardTask upgradeCardTask = new UpgradeCardTask(action);
        BossTask bossTask = new BossTask(action);
        BesiegeBossTask besiegeBossTask = new BesiegeBossTask(action);
        TreasureTask treasureTask = new TreasureTask(action);
        UpgradePropertyTask upgradePropertyTask = new UpgradePropertyTask(action);
        CleanBagTask cleanBagTask = new CleanBagTask(action);
        GloryTask gloryTask = new GloryTask(action);
        EmailTask emailTask = new EmailTask(action);

        C_UpgrateAndClean c_upgrateAndClean = new C_UpgrateAndClean(action);
        C_Daily c_daily = new C_Daily(action);

        //------------------tasks--------------------
        loginTask.run();;
        //dailyInstanceTask.run();
        //expInstanceTask.run();
        //griffinTask.run();
        //equipementBossTask.run();
        //wholePeopletBossTask.run();
        //upgradeCardTask.run();
        c_daily.run();
        //besiegeBossTask.run();
        //treasureTask.run();
        //upgradePropertyTask.run();
        //cleanBagTask.run();
        //gloryTask.run();
        //c_upgrateAndClean.run();
        //emailTask.run();

        //driver.quit();
    }
}
