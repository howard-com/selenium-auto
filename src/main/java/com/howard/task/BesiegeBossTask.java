package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;

public class BesiegeBossTask extends BasicTask{
    public BesiegeBossTask(MouseAction mouseAction) {
        super(mouseAction);
    }

    @Override
    public void run() throws InterruptedException {
        //点击BOSS
        clickAt(Coordination.R_BOSS);
        //中立BOSS
        clickAt(Coordination.BO_ZHONGLI);
        //魔物围城
        clickAt(Coordination.BO_ZL_MWWC);
        //前往围城
        clickAt(Coordination.BO_ZL_MW_ENTER);

        Thread.sleep(12000);

        //寻找魔物
        clickAt(Coordination.BO_ZL_MW_PLACE1);
        clickAt(Coordination.BO_ZL_MW_PLACE2);
        clickAt(Coordination.BO_ZL_MW_PLACE3);
        clickAt(Coordination.BO_ZL_MW_PLACE4);
        clickAt(Coordination.BO_ZL_MW_PLACE5);
        clickAt(Coordination.BO_ZL_MW_PLACE6);
        clickAt(Coordination.BO_ZL_MW_PLACE7);

        //挑战围城
        clickAt(Coordination.BO_ZL_MW_START);

        Thread.sleep(61000);

        //返回野外
        clickAt(Coordination.C_CITY);
    }
}
