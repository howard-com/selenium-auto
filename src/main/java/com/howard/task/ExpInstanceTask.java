package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;

public class ExpInstanceTask extends BasicTask{
    public ExpInstanceTask (MouseAction mouseAction) {
        super(mouseAction);
    }

    @Override
    public void run() throws InterruptedException {
        Thread.sleep(1000);

        enterExpInstance();
        //血色城堡
        clickAt(Coordination.FB_DR_JY_XUESE);
        //增加门票
        clickAt(Coordination.FB_DR_JY_TICKET);
        //数量加二
        clickAt(Coordination.FB_DR_JY_TICKET_ADD);
        clickAt(Coordination.FB_DR_JY_TICKET_ADD);
        //点击购买
        clickAt(Coordination.FB_DR_JY_TICKET_BUY);
        //开始血色
        clickAt(Coordination.FB_DR_JY_XUESE_START);
        Thread.sleep(1000);
        //点击鼓舞
        clickAt(Coordination.FB_DR_JY_GUWU);
        //钻石鼓舞
        Thread.sleep(1000);
        clickAt(Coordination.FB_DR_JY_GUWU_ZS);
        clickAt(Coordination.FB_DR_JY_GUWU_ZS);
        clickAt(Coordination.FB_DR_JY_GUWU_ZS);
        clickAt(Coordination.FB_DR_JY_GUWU_ZS);
        //等待血色
        Thread.sleep(130000);

        enterExpInstance();
        //恶魔广场
        clickAt(Coordination.FB_DR_JY_EMO);
        //增加门票
        clickAt(Coordination.FB_DR_JY_TICKET);
        //数量加二
        clickAt(Coordination.FB_DR_JY_TICKET_ADD);
        clickAt(Coordination.FB_DR_JY_TICKET_ADD);
        //点击购买
        clickAt(Coordination.FB_DR_JY_TICKET_BUY);
        //开始血色
        //开始广场
        clickAt(Coordination.FB_DR_JY_EMO_START);
        Thread.sleep(1000);
        //点击鼓舞
        clickAt(Coordination.FB_DR_JY_GUWU);
        //钻石鼓舞
        Thread.sleep(1000);
        clickAt(Coordination.FB_DR_JY_GUWU_ZS);
        clickAt(Coordination.FB_DR_JY_GUWU_ZS);
        //等待广场
        Thread.sleep(200000);
    }

    private void enterExpInstance () {
        //点击副本
        clickAt(Coordination.R_FUBEN);
        //经验副本
        clickAt(Coordination.FB_D_JINGYAN);
    }
}
