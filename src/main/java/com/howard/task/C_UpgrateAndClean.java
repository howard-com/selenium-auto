package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;

public class C_UpgrateAndClean extends BasicTask{
    public C_UpgrateAndClean(MouseAction mouseAction) {
        super(mouseAction);
    }

    @Override
    public void run() throws InterruptedException {
        MouseAction action = this.g_mouseAction;

        GloryTask gloryTask = new GloryTask(action);
        CleanBagTask cleanBagTask = new CleanBagTask(action);
        UpgradeCardTask upgradeCardTask = new UpgradeCardTask(action);
        UpgradePropertyTask upgradePropertyTask = new UpgradePropertyTask(action);
        EmailTask emailTask = new EmailTask(action);

        cleanBagTask.run();
        emailTask.run();
        upgradeCardTask.run();
        upgradePropertyTask.run();
        gloryTask.run();
    }
}
