package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;
import com.howard.utils.MyLogger;

public abstract class BasicTask {

    protected MouseAction g_mouseAction = null;
    public void setMouseAction(MouseAction g_mouseAction) {
        this.g_mouseAction = g_mouseAction;
    }
    MyLogger myLogger = new MyLogger();

    public BasicTask() {};

    public BasicTask(MouseAction mouseAction) {
        this.g_mouseAction = mouseAction;
    }

    protected abstract void run() throws InterruptedException;

    public void lanuch() throws InterruptedException {

        Thread.sleep(500);
        //清空主页
        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);

        this.run();

        Thread.sleep(500);
        //返回
        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);
    }

    public void test() {

    }

    protected void clickAt2(int[] coordinate) {
        this.clickAt(cconvert(coordinate));
    }

    protected void clickAt(int[] coordinate) {
        this.g_mouseAction.clickAt(coordinate);
    }

    private int[] cconvert(int[] org) {
        //return new int[]{(org[0] - 330), (org[1] - 620)};
        return new int[]{org[0], org[1]};
    }
}
