package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;
import org.openqa.selenium.By;

public class EquipementBossTask extends BasicTask{
    public EquipementBossTask(MouseAction mouseAction) {
        super(mouseAction);
    }

    @Override
    public void run() throws InterruptedException {
        clickAt(Coordination.R_BOSS);

        //点击BOSS
        clickAt(Coordination.R_BOSS);
        //本服BOSS
        clickAt(Coordination.BO_BENFU);

        for (int i = 0; i < 8; i++) {
            //装备BOSS
            clickAt(Coordination.BO_BF_ZHUANGBEI);
            //开始挑战
            clickAt(Coordination.BO_BF_ZB_START);
            //等待挑战
            Thread.sleep(12000);
            //关闭结果
            clickAt(Coordination.BO_BF_ZB_CLOSE);
            Thread.sleep(1000);
        }

        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);
    }
}
