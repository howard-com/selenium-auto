package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;

import static com.howard.utils.CommonTool.getCurrentTime;

public class RedHoodTask extends BasicTask{
    public RedHoodTask(MouseAction mouseAction) {
        super(mouseAction);
    }

    public RedHoodTask() {
        super();
    }

    /* 12:15~12:25, 19:30~19:40 */
    @Override
    public void run() throws InterruptedException {
        Thread.sleep(1000);
        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);

        //点击竞技
        clickAt(Coordination.R_JINGJI);
        //多人竞技
        clickAt(Coordination.JJ_DUOREN);
        //赤色要塞
        clickAt(Coordination.JJ_DUOR_CHISE);
        //进入要塞
        clickAt(Coordination.JJ_DUOR_CHISE_ENTER);

        //等待完成
        int curTime = getCurrentTime();
        while ((curTime >= 1215 && curTime<1225) || (curTime >= 1930 && curTime<1939)) {
            Thread.sleep(1000);
            //保持中心
            clickAt(Coordination.JJ_DUOR_CHISE_CENTER);
            curTime = getCurrentTime();
        }

        //返回主页
        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);
        Thread.sleep(2000);
    }
}
