package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;

public class GloryTask extends BasicTask{
    public GloryTask() {super();}

    public GloryTask(MouseAction mouseAction) {
        super(mouseAction);
    }

    @Override
    public void run() throws InterruptedException {
        //点击竞技
        clickAt(Coordination.R_JINGJI);
        //单人竞技
        clickAt(Coordination.JJ_DANREN);
        //荣耀之巅
        clickAt(Coordination.JJ_DR_RONGYAO);
        for (int j = 0; j < 5; j++) {
            //匹配对手
            clickAt(Coordination.JJ_DR_RY_PIPEI);
            clickAt(Coordination.JJ_DR_RY_PIPEI);
            Thread.sleep(40000);
        }
        //返回主页
        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);
        Thread.sleep(500);
    }
}
