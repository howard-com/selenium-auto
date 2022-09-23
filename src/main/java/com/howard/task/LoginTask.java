package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class LoginTask extends BasicTask  {
    public LoginTask(){
        super();
    }

    public LoginTask (MouseAction mouseAction) {
        super(mouseAction);
    }

    @Override
    public void run() throws InterruptedException {
        Thread.sleep(1000);
        clickAt(Coordination.L_START);
        clickAt(Coordination.L_START);

        Thread.sleep(5000);
        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);
        Thread.sleep(1000);
    }
}
