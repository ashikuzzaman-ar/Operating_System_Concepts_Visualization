package com.studevs.scheduling.sjf;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author ashik
 */
public class ProcessInitializer implements Runnable {

    private static final Comparator<ProcessModel> comparator = (ProcessModel o1, ProcessModel o2) -> (int) (o1.getDuration() - o2.getDuration());
    private static final PriorityQueue<ProcessModel> processQueue = new PriorityQueue<>(ProcessInitializer.comparator);
    private static long totalWaitingTime = 0;

    @Override
    public void run() {

        try {

            long processID = 1;
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
                ProcessInitializer.setInProcessQueue(new ProcessModel(processID++, duration));
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

    public static synchronized ProcessModel getFromProcessQueue() {
        return processQueue.poll();
    }

    public static synchronized void setInProcessQueue(ProcessModel processModel) {
        processQueue.add(processModel);
    }

    public static synchronized boolean isEmpty() {

        return processQueue.isEmpty();
    }
}
