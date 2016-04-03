package com.studevs.scheduling;

/**
 *
 * @author ashik
 */
public class SJF implements Runnable {

    @Override
    public void run() {

        try {

            while (true) {

                if (!ProcessInitializer.isEmpty()) {

                    ProcessModel pm = ProcessInitializer.getFromProcessQueue();
                    System.out.println("\n\nProcess " + pm.getProcessID() + " is running now.");
                    System.out.println("Arrival time in ms is : " + pm.getArrivalTime());
                    System.out.println("Duration is second is: " + pm.getDuration());
                    System.out.println("\n\n\n");
                    Thread.sleep(pm.getDuration() * 1000);
                    ProcessInitializer.setTotalWaitingTime(ProcessInitializer.getTotalWaitingTime() + ((System.currentTimeMillis() - pm.getArrivalTime()) - pm.getDuration()));
                } else {

                    System.err.println("\n........No Process is in queue.......\n");
                    Thread.sleep(3000);
                }
            }
        } catch (Exception e) {

            System.err.println(e.toString());
            this.run();
        }
    }
}
