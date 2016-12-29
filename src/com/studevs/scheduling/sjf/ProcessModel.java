package com.studevs.scheduling.sjf;

/**
 *
 * @author ashik
 */
public class ProcessModel {

    private final long processID;
    private final long arrivalTime;
    private final long duration;
//    private static long globalTimer = 0;

    public ProcessModel(long processID, long duration) {
        this.processID = processID;
        this.duration = duration;
//        ProcessModel.globalTimer += this.duration;
        this.arrivalTime = System.currentTimeMillis();
    }

//    public long getGlobalTimer() {
//        return globalTimer;
//    }

//    public void setGlobalTimer(long globalTimer) {
//        ProcessModel.globalTimer = globalTimer;
//    }

    public long getDuration() {
        return duration;
    }

    public long getProcessID() {
        return processID;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }
}
