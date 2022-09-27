package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;

public class CleanBagTask extends BasicTask{
    public CleanBagTask() {
        super();
    }

    public CleanBagTask(MouseAction mouseAction) {
        super(mouseAction);
    }

    public int g_loopCnt = 1;

    @Override
    public void run() throws InterruptedException {
        //点击背包
        clickAt(Coordination.D_BEIBAO);
        //道具标签
        clickAt(Coordination.BB_DAOJU);
        //一键使用
        clickAt(Coordination.BB_DJ_SHIYONG);
        //立即使用
        clickAt(Coordination.BB_DJ_LIJI);
        Thread.sleep(3000);
        //返回主页
        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);
        Thread.sleep(500);

        //持续背包 自动升级
        for (int i = 0; i < g_loopCnt ; i++) {
            //点击背包
            clickAt(Coordination.D_BEIBAO);
            //熔炼标签
            clickAt(Coordination.BB_RONGLIAN);
            //一键熔炼
            clickAt(Coordination.BB_RL_RONLIAN);
            Thread.sleep(8000);
            //返回主页
            clickAt(Coordination.T_BLANK);
            clickAt(Coordination.T_BLANK);
            Thread.sleep(21000);
        }
        Thread.sleep(500);
    }
}
