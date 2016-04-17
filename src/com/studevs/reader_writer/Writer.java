/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studevs.reader_writer;

import com.studevs.falgun.util.RandomNumberGenerator;

/**
 *
 * @author ashik
 */
public class Writer implements Runnable {

    private final int writerID;
    private final int maximumWorkingTime;
    private final int idleTime;

    public Writer(int writerID, int maximumWorkingTime, int idleTile) {
        this.writerID = writerID;
        this.maximumWorkingTime = maximumWorkingTime;
        this.idleTime = idleTile;
    }

    @Override
    public void run() {

        try {

            while (true) {

                if (AccessControl.getReaderCount() == 0 && !AccessControl.isWriterActive()) {

                    AccessControl.setWriterActive(true);
                    System.err.println("\n\nWriter " + this.writerID + " is writing data...");
                    Thread.sleep((long) new RandomNumberGenerator(50, this.maximumWorkingTime).getGeneratedNumber());
                    System.err.println("\n\nWriter " + this.writerID + " is finished...");
                    AccessControl.setWriterActive(false);
                }

                Thread.sleep(this.idleTime);
            }
        } catch (Exception e) {

            System.err.println(e.toString());
        }
    }
}
