package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;

import static com.howard.utils.CommonTool.getCurrentTime;

public class WorldBossTask extends BasicTask{
    public WorldBossTask() {super();}
    public WorldBossTask(MouseAction mouseAction) {
        super(mouseAction);
    }

    /* 12:30~12:40, 19:00~19:10 */
    @Override
    public void run() throws InterruptedException {
        Thread.sleep(1000);
        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);

        //点击BOSS
        clickAt(Coordination.R_BOSS);
        //中立BOSS
        clickAt(Coordination.BO_ZHONGLI);
        //世界BOSS
        clickAt(Coordination.BO_ZL_SHIJIE);
        //进入世界
        clickAt(Coordination.BO_ZL_SHIJIE_ENTER);

        //等待完成
        int curTime = getCurrentTime();
        while ((curTime >= 1230 && curTime<1240) || (curTime >= 1900 && curTime<1909)) {
            Thread.sleep(10000);
            curTime = getCurrentTime();
        }

        //返回主页
        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);
    }
}
