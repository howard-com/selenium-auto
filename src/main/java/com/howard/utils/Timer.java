package com.howard.utils;

import com.howard.Worker;
import com.howard.task.*;

import java.util.Calendar;

import static com.howard.utils.CommonTool.getCurrentTime;

public class Timer extends Thread {

    public int g_instanceNum = 1;
    public Timing[] g_timings;
    private MyLogger g_Logger = MyLogger.getLogger();

    public static void main(String[] args) {
        Timer timer = new Timer(1);
        timer.test2();
    }

    public Timer(int intNum) {
        this.g_instanceNum = intNum;
    }

    private void test2() {
        g_timings = new Timing[] {
            new Timing(1410, 1411),
            new Timing(1412, 1413),
            new Timing(1415, 1416),
            new Timing(1420, 1422),
            new Timing(1500, 1510),
            new Timing(2020, 1422),
        };

        run();
    }

    public void setTimings(Timing[] timings) {
        this.g_timings = timings;
    }

    @Override
    public void run() {
        int threshold1 = 5;  //预先打开window阈值
        int threshold2 = 1;  //调整检查频率阈值
        int interval = 1000; //等待间隔默认1秒

        Worker worker = new Worker(this.g_instanceNum);

        if (g_timings == null || g_timings.length == 0) {
            g_Logger.log("没有可执行任务！");
            return;
        }

        int idx = 0;
        while(idx < g_timings.length) {
            int curTime = getCurrentTime();
            Timing timing = g_timings[idx];

            //还没到时间
            if (curTime < timing.start) {
                try {
                    int hh_rem = timing.start/100 - curTime/100;
                    int mm_rem = timing.start%100 - curTime%100;
                    mm_rem += hh_rem*60;
                    g_Logger.log("第" + (idx+1) + "个任务还未到时间，剩余" + mm_rem + "分钟...");
                    //当剩余时间大于5分钟的时候，降低检查频率并关闭窗口
                    if (mm_rem >= threshold1) {
                        //保持窗口关闭，节省资源
                        worker.stopWork();
                        interval = 50000;
                    } else {
                        //log
                        g_Logger.debug("预先开启window. 调整检查频率为10秒");
                        interval = 10000;
                        openWindow(worker);
                        if (mm_rem <= threshold2) {
                            g_Logger.debug("调整检查频率为1秒");
                            interval = 1000;
                        }
                    }

                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            } else if (curTime < timing.end) { // 任务开始
                g_Logger.log("***第" + (idx+1) + "任务处于运行时间开始任务***");
                if (timing.getTasks() != null) {
                    openWindow(worker);
                    worker.setTasks(timing.getTasks());
                    worker.startWork();
                }
                idx++;
                continue;
            } else {    // 时间已过
                g_Logger.log("第" + (idx+1) + "个任务已经超时跳过");
                idx++;
                continue;
            }
        }

        worker.stopWork();
        g_Logger.log("任务全部执行完毕！");
    }

    private void openWindow(Worker worker) {
        if (worker.windowObject == null) {
            worker.setTasks(new BasicTask[]{new LoginTask()});
            worker.startWork();
        }
    }
}
