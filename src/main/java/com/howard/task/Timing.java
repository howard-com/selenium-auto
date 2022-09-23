package com.howard.task;

import com.howard.task.BasicTask;
import com.howard.task.BossTask;
import com.howard.task.LoginTask;
import com.howard.utils.MouseAction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Timing {
    public int instanceNumber;
    public int start;
    public int end;
    public BasicTask[] tasks = null;

    public Timing(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public Timing(int start, int end, BasicTask[] tasks) {
        this.start = start;
        this.end = end;
        this.tasks = tasks;
    }

    public BasicTask[] getTasks() {
        return this.tasks;
    }
}
