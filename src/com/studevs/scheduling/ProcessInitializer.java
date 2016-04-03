package com.studevs.scheduling;

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

    @Override
    public void run() {

        try {

            long processID = 1;
            Scanner scan = new Scanner(System.in);
            while (true) {

                System.out.println("\n");
                System.out.print("Enter process duration for process ID " + processID + " [-1 to exit]: ");
                long duration = scan.nextLong();
                if (duration < 0) {
                    
                    System.exit(0);
                }
                ProcessInitializer.setInProcessQueue(new ProcessModel(processID++, duration));
            }
        } catch (Exception e) {

            System.err.println(e.toString());
        }
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
