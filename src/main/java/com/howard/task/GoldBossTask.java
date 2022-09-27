package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;

public class GoldBossTask extends BasicTask{
    public GoldBossTask() {super();}

    public GoldBossTask(MouseAction mouseAction) {
        super(mouseAction);
    }

    public int g_bossNO = 1;

    @Override
    public void run() throws InterruptedException {
        //点击BOSS
        clickAt(Coordination.R_BOSS);
        //本服BOSS
        clickAt(Coordination.BO_BENFU);
        //黄金BOSS
        clickAt(Coordination.BO_BF_HUANGJIN);

        //挑战对应BOSS
        switch(g_bossNO) {
            case 1:
                clickAt(Coordination.BO_BF_HJ_BOSS1);
                clickAt(Coordination.BO_BF_HJ_START);
                Thread.sleep(15000);
                break;
            case 2:
                clickAt(Coordination.BO_BF_HJ_BOSS2);
                clickAt(Coordination.BO_BF_HJ_START);
                Thread.sleep(25000);
                break;
            case 3:
                clickAt(Coordination.BO_BF_HJ_BOSS3);
                clickAt(Coordination.BO_BF_HJ_START);
                Thread.sleep(40000);
                break;
            case 4:
                clickAt(Coordination.BO_BF_HJ_BOSS4);
                clickAt(Coordination.BO_BF_HJ_START);
                Thread.sleep(45000);
                break;
            case 5:
                clickAt(Coordination.BO_BF_HJ_BOSS5);
                clickAt(Coordination.BO_BF_HJ_START);
                Thread.sleep(55000);
                break;
            default:
                break;
        }
        g_bossNO++;
    }
}
