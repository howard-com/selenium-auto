package com.howard.task;

import com.howard.utils.Coordination;
import com.howard.utils.MouseAction;

public class DailyInstanceTask extends BasicTask{
    public DailyInstanceTask (MouseAction mouseAction) {
        super(mouseAction);
    }

    @Override
    public void run() throws InterruptedException {
        int[] wait = {195000, 195000, 50000, 50000, 50000, 50000, 50000, 50000, 60000};

        for (int i = 0; i < 9; i++) {
            clickAt(Coordination.R_FUBEN);
            clickAt(Coordination.FB_D_DANREN);
            clickAt(Coordination.FB_DR_MEIRI);
            clickAt(Coordination.FB_DR_MR_TIAOZHAN);

            Thread.sleep(wait[i]);
        }

        clickAt(Coordination.R_FUBEN);
        clickAt(Coordination.FB_D_DANREN);
        clickAt(Coordination.FB_DR_MEIRI);
        for (int i = 0; i < 9; i++) {
            clickAt(Coordination.FB_DR_MR_TIAOZHAN);
            clickAt(Coordination.FB_DR_MR_SAODANGGB);
        }
        clickAt(Coordination.C_RETURN);
    }
}
