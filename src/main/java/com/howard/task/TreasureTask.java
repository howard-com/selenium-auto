package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;

import static com.howard.utils.CommonTool.getCurrentTime;

public class TreasureTask extends BasicTask{
    public TreasureTask(MouseAction mouseAction) {
        super(mouseAction);
    }

    public TreasureTask() {
        super();
    }

    /* 12:00~12:15, 19:10~19:25 */
    @Override
    public void run() throws InterruptedException {
        Thread.sleep(1000);
        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);

        //点击回城
        clickAt(Coordination.C_CITY);
        Thread.sleep(2000);
        //红龙宝箱
        clickAt(Coordination.T_REDBOX);
        Thread.sleep(1000);
        //红龙宝箱
        clickAt(Coordination.T_REDBOX);

        int curTime = getCurrentTime();
        while ((curTime >= 1200 && curTime<1214) || (curTime >= 1910 && curTime<1924)) {
            Thread.sleep(10000);
            curTime = getCurrentTime();
        }

        clickAt(Coordination.C_CITY);
        Thread.sleep(2000);
        clickAt(Coordination.T_BLANK);
    }
}
