package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;

public class MythicalTask extends BasicTask{
    public MythicalTask() {
        super();
    }

    public MythicalTask(MouseAction mouseAction) {
        super(mouseAction);
    }

    @Override
    public void run() throws InterruptedException {
        //点击副本
        clickAt(Coordination.R_FUBEN);
        //神兽岛
        clickAt(Coordination.FB_D_SHENSHOU);
        //无尽岛
        clickAt(Coordination.FB_SS_WUJIN);
        //选择左边关卡
        clickAt(Coordination.FB_SS_WJ_LEFT);
        //开始挑战
        clickAt(Coordination.FB_SS_WJ_START);
        Thread.sleep(95000);

        //选择中间关卡
        clickAt(Coordination.FB_SS_WJ_CENTER);
        Thread.sleep(95000);

        //选择右边关卡
        clickAt(Coordination.FB_SS_WJ_RIGHT);
        Thread.sleep(95000);

        //退出神兽岛
        clickAt(Coordination.FB_SS_WJ_RETURN);
        clickAt(Coordination.FB_SS_WJ_RETURN_YES);
    }
}
