package com.howard.task;

import com.howard.utils.MouseAction;

public abstract class BasicTask {

    protected MouseAction g_mouseAction = null;
    public void setMouseAction(MouseAction g_mouseAction) {
        this.g_mouseAction = g_mouseAction;
    }

    public BasicTask() {};

    public BasicTask(MouseAction mouseAction) {
        this.g_mouseAction = mouseAction;
    }

    public abstract void run() throws InterruptedException;

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
