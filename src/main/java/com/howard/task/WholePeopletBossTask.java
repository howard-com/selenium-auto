package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;

public class WholePeopletBossTask extends BasicTask{
    public WholePeopletBossTask(MouseAction mouseAction) {
        super(mouseAction);
    }

    @Override
    public void run() throws InterruptedException {
        //点击BOSS
        clickAt(Coordination.R_BOSS);
        //本服BOSS
        clickAt(Coordination.BO_BENFU);
        //全民OSS
        clickAt(Coordination.BO_BF_QUANMIN);
        //开始挑战
        clickAt(Coordination.BO_BF_QM_START);
        //等待挑战
        Thread.sleep(150000);
        //返回主页
        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);
    }
}
