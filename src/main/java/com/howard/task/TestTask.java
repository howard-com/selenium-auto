package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;

import java.util.Date;

public class TestTask extends BasicTask{
    public TestTask() {
        super();
    }

    public TestTask(MouseAction mouseAction) {
        super(mouseAction);
    }

    @Override
    public void run() throws InterruptedException {
        System.out.println("Test class" + new Date());
    }
}
