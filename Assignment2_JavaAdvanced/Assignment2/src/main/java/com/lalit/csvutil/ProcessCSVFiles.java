package com.lalit.csvutil;


public class ProcessCSVFiles {
    /**
     * starts the CSVHandlerThread that read csv files and add data to data store.
     */
    public void initiateCSVHandlerThread() {
        CSVHandlerThread csvHandlerThread = new CSVHandlerThread();
        Thread csvThread = new Thread(csvHandlerThread);
        csvThread.start();
    }
}
