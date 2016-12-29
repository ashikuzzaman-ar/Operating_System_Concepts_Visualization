package com.studevs.scheduling.rr;

import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author ashik
 */
public class ProcessInitializer implements Runnable {

    private static Map<Integer, ProcessModel> PROCESS_MAP = new ConcurrentHashMap<>();
    private static long totalWaitingTime = 0;

    @Override
    public void run() {

        try {

            int processID = 1;
            Scanner scan = new Scanner(System.in);
            while (true) {

                System.out.println("\n");
                System.out.print("Enter process duration for process ID " + processID + " [0 to exit]: ");
                long duration = scan.nextLong();
                if (duration <= 0) {

                    System.out.println("\n\nTotal Waiting time in ms: " + ProcessInitializer.getTotalWaitingTime());
                    System.out.println("Total Process: " + (processID - 1));
                    System.out.println("Average waiting time in ms: " + (ProcessInitializer.getTotalWaitingTime() / (processID - 1)));
                    System.exit(0);
                }
                processID++;
                ProcessInitializer.getPROCESS_MAP().put(processID, new ProcessModel(processID, duration));
            }
        } catch (Exception e) {

            System.err.println(e.toString());
            this.run();
        }
    }

    public synchronized static long getTotalWaitingTime() {
        return totalWaitingTime;
    }

    public synchronized static void setTotalWaitingTime(long totalWaitingTime) {
        ProcessInitializer.totalWaitingTime = totalWaitingTime;
    }

    public static Map<Integer, ProcessModel> getPROCESS_MAP() {
        return PROCESS_MAP;
    }

    public static void setPROCESS_MAP(Map<Integer, ProcessModel> PROCESS_MAP) {
        ProcessInitializer.PROCESS_MAP = PROCESS_MAP;
    }
}
