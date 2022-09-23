package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;

public class BossTask extends BasicTask{
    public BossTask() {super();}

    public BossTask(MouseAction mouseAction) {
        super(mouseAction);
    }

    @Override
    public void run() throws InterruptedException {
        for (int i = 0; i < 15; i++) {
            //点击BOSS
            clickAt(Coordination.R_BOSS);
            //跨服BOSS
            clickAt(Coordination.BO_KUAFU);

            if (i % 3 == 0) {
                //跨服BOSS
                clickAt(Coordination.BO_KF_KFBOSS);
                //开始挑战
                clickAt(Coordination.BO_KF_KF_START);
                //抢夺归属
                Thread.sleep(120000);
                clickAt(Coordination.BO_KF_FIGHT);
            }
            //重生遗迹
            clickAt(Coordination.BO_KF_CSYJ);
            //开始挑战
            clickAt(Coordination.BO_KF_CS_START);
            //抢夺归属
            Thread.sleep(2000);
            clickAt(Coordination.BO_KF_FIGHT);

            //天使圣殿
            clickAt(Coordination.BO_KF_TIANSHI);
            clickAt(Coordination.BO_KF_TIANSHI);
            //开始挑战
            clickAt(Coordination.BO_KF_TS_START);

            //等待挑战
            Thread.sleep(130000);
            //返回主页
            clickAt(Coordination.T_BLANK);
            Thread.sleep(1000);

            if (i % 4 == 0) {
                WholePeopletBossTask wholePeopletBossTask = new WholePeopletBossTask(this.g_mouseAction);
                wholePeopletBossTask.run();
                clickAt(Coordination.T_BLANK);
            }
        }
    }
}
