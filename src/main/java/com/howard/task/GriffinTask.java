package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;

public class GriffinTask extends BasicTask{
    public GriffinTask(MouseAction mouseAction) {
        super(mouseAction);
    }

    @Override
    public void run() throws InterruptedException {
        //点击战盟
        clickAt(Coordination.D_ZHANMENG);
        //点击狮鹫
        clickAt(Coordination.ZM_SHIJIU);

        for (int i = 0; i < 5; i++) {
            //开始挑战
            clickAt(Coordination.ZM_SJ_START);
            clickAt(Coordination.ZM_SJ_START);
            clickAt(Coordination.ZM_SJ_START);
            //等待狮鹫
            Thread.sleep(68000);
        }

        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);
    }
}
