package com.howard.utils;

public class MyLogger {
    private static MyLogger g_myLogger = new MyLogger();
    private int g_logLevel = 3;
    public static MyLogger getLogger() {
        return g_myLogger;
    }

    private void writeLog(String str) {
        //String logStr = str;
        //String logStr = getClassName() + str;
        System.out.println(str);
    }

    public void log(String str){
        if (g_logLevel > 2) {
            return;
        }

        this.writeLog(str);
    }

    public void debug(String str){
        if (g_logLevel > 3) {
            return;
        }

        this.writeLog(str);
    }

    public void log(String str, String className){
        System.out.println(className+ ":" + str);
    }

    private String getClassName() {

        StackTraceElement[] stes = Thread.currentThread().getStackTrace();
        StackTraceElement ste = stes[stes.length-2];

        String className = ste.getClassName();
        String methodName = ste.getMethodName();
        int lineNumber = ste.getLineNumber();
        String ret =  className+"." +methodName+"()-"+lineNumber+":";
        return ret;
    }
}
