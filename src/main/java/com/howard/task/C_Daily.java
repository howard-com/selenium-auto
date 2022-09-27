package com.howard.task;

import com.howard.utils.MouseAction;

public class C_Daily extends BasicTask{
    public C_Daily() {super();}

    public C_Daily(MouseAction mouseAction) {
        super(mouseAction);
    }

    @Override
    public void run() throws InterruptedException {
        MouseAction action = this.g_mouseAction;

        WholePeopletBossTask wholePeopletBossTask = new WholePeopletBossTask(action);
        EquipementBossTask equipementBossTask = new EquipementBossTask(action);
        DailyInstanceTask dailyInstanceTask = new DailyInstanceTask(action);
        ExpInstanceTask expInstanceTask = new ExpInstanceTask(action);
        GriffinTask griffinTask = new GriffinTask(action);
        EmailTask emailTask = new EmailTask(action);
        CleanBagTask cleanBagTask = new CleanBagTask(action);
        UpgradePropertyTask upgradePropertyTask = new UpgradePropertyTask(action);
        GloryTask gloryTask = new GloryTask(action);

        cleanBagTask.lanuch();
        wholePeopletBossTask.lanuch();
        equipementBossTask.lanuch();
        dailyInstanceTask.lanuch();
        expInstanceTask.lanuch();
        griffinTask.lanuch();
        equipementBossTask.lanuch();
        wholePeopletBossTask.lanuch();
        gloryTask.lanuch();
    }
}
