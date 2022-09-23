package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;

public class EmailTask extends BasicTask{
    public EmailTask() {
        super();
    }

    public EmailTask(MouseAction mouseAction) {
        super(mouseAction);
    }

    @Override
    public void run() throws InterruptedException {
        Thread.sleep(1000);
        //清空主页
        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);

        //点击邮件
        clickAt(Coordination.U_EMAIL);
        //收取邮件
        clickAt(Coordination.EMAIL_READ);
        Thread.sleep(4000);
        //返回首页
        clickAt(Coordination.T_BLANK);
        clickAt(Coordination.T_BLANK);
        Thread.sleep(500);
    }
}
