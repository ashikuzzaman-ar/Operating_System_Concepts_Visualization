package com.studevs.scheduling.rr;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ashik
 */
public class RoundRobin implements Runnable {

    private final long quanta;

    public RoundRobin(long quanta) {

        this.quanta = quanta;
    }

    @Override
    public void run() {

        try {

            while (true) {

                if (!ProcessInitializer.getPROCESS_MAP().isEmpty()) {

                    Set<Map.Entry<Integer, ProcessModel>> processSet =  ProcessInitializer.getPROCESS_MAP().entrySet();

                    Iterator it = processSet.iterator();
                    while(it.hasNext()){
                        
                        Map.Entry processEntry = (Map.Entry) it.next();
                        ProcessModel pm = (ProcessModel) processEntry.getValue();
                        System.out.println("\n\nProcess " + pm.getId() + " is running now.");
                        System.out.println("Arrival time in ms is : " + pm.getArrivalTime());
                        System.out.println("Duration is second is: " + pm.getRemainingTime());
                        System.out.println("\n\n\n");
                        if (pm.getRemainingTime() <= quanta) {

                            Thread.sleep(pm.getRemainingTime());
                            ProcessInitializer.getPROCESS_MAP().remove(pm.getId());
                        } else {

                            Thread.sleep(quanta);
                            pm.setRemainingTime(pm.getRemainingTime() - quanta);
                            ProcessInitializer.getPROCESS_MAP().replace(pm.getId(), pm);
                        }
                    }
                    
//                    for (int i = 0; i < processSet.size(); i++) {
//
//                        
//                        
//                    }
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
