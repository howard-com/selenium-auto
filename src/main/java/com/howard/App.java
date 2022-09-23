package com.howard;

import com.howard.task.*;
import com.howard.utils.MouseAction;
import com.howard.utils.Timer;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        test3();
    }

    public static void test1() {
        Worker worker1 = new Worker(1);
        Worker worker2 = new Worker(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker1.startWork();
                worker1.stopWork();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker2.startWork();
                worker2.stopWork();
            }
        }).start();
    }

    public static void test2() {
        Timer timer1 = new Timer(1);
        Timer timer2 = new Timer(2);

        Timing[] timings1 = new Timing[] {
                new Timing(1900, 1909, new BasicTask[]{new WorldBossTask()}),
                new Timing(1910, 1924, new BasicTask[]{new TreasureTask()}),
                new Timing(1930, 1939, new BasicTask[]{new RedHoodTask()}),

                new Timing(600, 630, new BasicTask[]{new BossTask()}),

        };

        Timing[] timings2 = new Timing[] {
                new Timing(1900, 1909, new BasicTask[]{new WorldBossTask()}),
                new Timing(1910, 1924, new BasicTask[]{new TreasureTask()}),
                new Timing(1930, 1939, new BasicTask[]{new RedHoodTask()}),

                new Timing(600, 630, new BasicTask[]{new BossTask()}),
        };

        timer1.setTimings(timings1);
        timer1.start();

        timer2.setTimings(timings2);
        timer2.start();
    }


    public static void test3() {
        Worker worker1 = new Worker(1);
        Worker worker2 = new Worker(2);

        worker1.setTasks(new BasicTask[]{new LoginTask()});
        worker2.setTasks(new BasicTask[]{new LoginTask()});

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                worker1.startWork();
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                worker2.startWork();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BasicTask[] tasks1 = null;
        BasicTask[] tasks2 = null;

        String command = null;       // 记录输入度的字符串
        do{
            System.out.print("等待命令输入>>>：");
            Scanner input = new Scanner(System.in);
            command = input.next();       // 等待输入值
            //System.out.println("您输入的是："+command);

            switch (command) {
                case "sj":
                    System.out.println("将要启动: UpgradePropertyTask");
                    tasks1 = new BasicTask[]{new UpgradePropertyTask()};
                    tasks2 = new BasicTask[]{new UpgradePropertyTask()};
                    break;
                case "ry":
                    System.out.println("将要启动: GloryTask");
                    tasks1 = new BasicTask[]{new GloryTask()};
                    tasks2 = new BasicTask[]{new GloryTask()};
                    break;
                case "boss":
                    System.out.println("将要启动: BossTask");
                    tasks1 = new BasicTask[]{new BossTask()};
                    tasks2 = new BasicTask[]{new BossTask()};
                    break;
                case "clean":
                    System.out.println("将要启动: CleanBagTask");
                    tasks1 = new BasicTask[]{new CleanBagTask()};
                    tasks2 = new BasicTask[]{new CleanBagTask()};
                    break;
                case "end":
                    System.out.println("退出程序");
                    input.close(); // 关闭资源
                    break;
                case "daily":
                    System.out.println("将要启动: C_Daily");
                    tasks1 = new BasicTask[]{new C_Daily()};
                    tasks2 = new BasicTask[]{new C_Daily()};
                    break;
                default:
                    System.out.println("无法识别的命令");
                    break;
            }
            worker1.setTasks(tasks1);
            worker2.setTasks(tasks2);
            new Thread(new Runnable() { public void run() { worker1.startWork();}}).start();
            new Thread(new Runnable() { public void run() { worker2.startWork();}}).start();
        } while(!command.equals("end"));   // 如果输入的值不版是#就继续输入

        worker1.stopWork();
        worker2.stopWork();
    }
        // 启动线程
        //t.start();


//        ChromeOptions options = new ChromeOptions();
//        //options.setBinary("D:\\CentBrowser\\Application\\chrome.exe");
//        options.addArguments("--user-data-dir=C:\\Users\\Huang\\AppData\\Local\\Google\\Chrome\\User Data 1");
//        //options.addArguments("--user-data-dir=C:\\Users\\Huang\\AppData\\Local\\CentBrowser\\User Data");
//
//        driver = new ChromeDriver(options);
//
//        driver.get("http://wan.baidu.com/game?gameId=26588310&serverId=11082&idfrom=5056");
//        //driver.get("file:///C:/Users/Huang/Desktop/test111.html");
//
//        Thread.sleep(3000);
//        //driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
//
////        Integration1Test it = new Integration1Test();
////        it.setDriver(driver);
////        it.Integration1();
//
//        driver.manage().window().setSize(new Dimension(677, 1242));
//        driver.switchTo().frame(0);
//        WebElement mainCanvas = driver.findElement(By.cssSelector("canvas"));
//        //WebElement mainCanvas = driver.findElement(By.id("canvas1"));
//
//        MouseAction action = new MouseAction(driver, mainCanvas, 100);
//        LoginTask loginTask = new LoginTask(action);
//        DailyInstanceTask dailyInstanceTask = new DailyInstanceTask(action);
//        ExpInstanceTask expInstanceTask = new ExpInstanceTask(action);
//        GriffinTask griffinTask = new GriffinTask(action);
//        EquipementBossTask equipementBossTask = new EquipementBossTask(action);
//        WholePeopletBossTask wholePeopletBossTask = new WholePeopletBossTask(action);
//        UpgradeCardTask upgradeCardTask = new UpgradeCardTask(action);
//        BossTask bossTask = new BossTask(action);
//        BesiegeBossTask besiegeBossTask = new BesiegeBossTask(action);
//        TreasureTask treasureTask = new TreasureTask(action);
//        UpgradePropertyTask upgradePropertyTask = new UpgradePropertyTask(action);
//        CleanBagTask cleanBagTask = new CleanBagTask(action);
//        GloryTask gloryTask = new GloryTask(action);
//        EmailTask emailTask = new EmailTask(action);
//
//        C_UpgrateAndClean c_upgrateAndClean = new C_UpgrateAndClean(action);
//        C_Daily c_daily = new C_Daily(action);

        //------------------tasks--------------------
//        loginTask.run();;
//        wholePeopletBossTask.run();
//        dailyInstanceTask.run();
//        expInstanceTask.run();
//        griffinTask.run();
//        equipementBossTask.run();
//        wholePeopletBossTask.run();
//        upgradeCardTask.run();
        //bossTask.run();
        //besiegeBossTask.run();
        //treasureTask.run();
        //upgradePropertyTask.run();
        //cleanBagTask.run();
        //gloryTask.run();
        //c_upgrateAndClean.run();
        //emailTask.run();
        //c_daily.run();


        //Thread.sleep(2000);
        //action.clickAt(-300,200);

        //action.clickAt(-10,-200);
        //Thread.sleep(4000);
        //action.clickAt(328,877);

        //builder.moveToElement(mainCanvas, 200, 300).pause(Duration.ofSeconds(1)).click().perform();

        //WebElement searchBox = driver.findElement(By.name("q"));
        //WebElement searchButton = driver.findElement(By.name("btnK"));

        //searchBox.sendKeys("Selenium");
        //searchButton.click();

        //searchBox = driver.findElement(By.name("q"));
        //Thread.sleep(5000);

        //driver.quit();

}
