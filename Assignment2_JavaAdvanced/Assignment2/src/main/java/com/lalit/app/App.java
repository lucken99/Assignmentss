package com.lalit.app;

import com.lalit.csvutil.ProcessCSVFiles;

public class App {
    public static void main(String[] args) {

        ProcessCSVFiles launcher = new ProcessCSVFiles();
        launcher.initiateCSVHandlerThread();
    }
}
