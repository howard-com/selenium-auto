package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;

public class UpgradePropertyTask extends BasicTask{
    public UpgradePropertyTask(){
        super();
    }

    public UpgradePropertyTask(MouseAction mouseAction) {
        super(mouseAction);
    }

    @Override
    public void run() throws InterruptedException {
        //挂机圆球
        clickAt(Coordination.GJ_YUANQIU);
        //挂机圆球
        clickAt(Coordination.GJ_SHOUYI);
        //返回主页
        clickAt(Coordination.T_BLANK);
        Thread.sleep(500);

        //点击技能
        clickAt(Coordination.D_JINENG);
        clickAt(Coordination.JN_JINENG);
        for (int i = 0; i < 6; i++) {
            //一键升级
            clickAt(Coordination.JN_JN_YIJIAN);
        }
        //返回主页
        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);
        Thread.sleep(500);

        //点击锻造
        clickAt(Coordination.D_DUANZAO);
        //注灵标签
        clickAt(Coordination.DZ_ZHULING);
        for (int i = 0; i < 6; i++) {
            //一键注灵
            clickAt(Coordination.DZ_ZL_YIJIAN);
        }
        //返回主页
        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);
        Thread.sleep(500);

        //点击锻造
        clickAt(Coordination.D_DUANZAO);
        //宝石标签
        clickAt(Coordination.DZ_BAOSHI);
        //一键升级
        clickAt(Coordination.DZ_BS_SHENGJI);
        for (int i = 0; i < 3; i++) {
            //一键镶嵌
            clickAt(Coordination.DZ_BS_XIANGQIAN);
        }
        //返回主页
        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);
        Thread.sleep(500);

        //点击锻造
        clickAt(Coordination.D_DUANZAO);
        //追加标签
        clickAt(Coordination.DZ_ZHUIJIA);
        for (int i = 0; i < 8; i++) {
            //一键追加
            clickAt(Coordination.DZ_ZJ_YIJIAN);
        }
        //返回主页
        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);
        Thread.sleep(500);

        //点击锻造
        clickAt(Coordination.D_DUANZAO);
        //培养标签
        clickAt(Coordination.DZ_PEIYANG);
        //培养十次
        for (int i = 0; i < 6; i++) {
            clickAt(Coordination.DZ_PEIYANG_10);
        }
        //培养一次
        for (int i = 0; i < 10; i++) {
            clickAt(Coordination.DZ_PEIYANG_1);
        }
        //返回主页
        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);
        Thread.sleep(500);

    }
}
