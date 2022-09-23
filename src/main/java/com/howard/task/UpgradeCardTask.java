package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;

public class UpgradeCardTask extends BasicTask{
    public UpgradeCardTask(MouseAction mouseAction) {
        super(mouseAction);
    }

    @Override
    public void run() throws InterruptedException {
        //点击更多
        clickAt(Coordination.D_GENGDUO);
        //点击图鉴
        clickAt(Coordination.GD_TJ);
        //魔兽印记
        clickAt(Coordination.GD_TJ_MOSHOU);
        //印记按钮
        clickAt(Coordination.GD_TJ_YIJI);

        int cnt = 9;    //一个级别中升级卡牌数
        for (int i = 0; i < 4; i++) {
            //选择印记等级
            switch (i) {
                case 0:
                    clickAt(Coordination.GD_TJ_MOSHOU_L1);
                    cnt = 9;
                    break;
                case 1:
                    clickAt(Coordination.GD_TJ_MOSHOU_L2);
                    cnt = 9;
                    break;
                case 2:
                    clickAt(Coordination.GD_TJ_MOSHOU_L3);
                    cnt = 6;
                    break;
                case 3:
                    clickAt(Coordination.GD_TJ_MOSHOU_L4);
                    cnt = 3;
                    break;
            }

            //同一等级多张升级
            for (int j = 0; j < cnt; j++) {
                //选择一张卡片
                clickAt(Coordination.GD_TJ_MOSHOU_OPEN_CARD1);
                //连续升级
                for (int k = 0; k < 4; k++) {
                    //点击升级
                    clickAt(Coordination.GD_TJ_MOSHOU_LEVELUP);
                    //关闭升级提示
                    clickAt(Coordination.GD_TJ_MOSHOU_CLOSE_NOTE);
                }
                //关闭卡牌
                clickAt(Coordination.GD_TJ_MOSHOU_CLOSE_CARD1);
            }
        }

        clickAt(Coordination.C_RETURN);
    }
}
