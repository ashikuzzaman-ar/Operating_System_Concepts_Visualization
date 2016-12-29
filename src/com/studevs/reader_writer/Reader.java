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
public class Reader implements Runnable {

    private final int readerID;
    private final int maximumWorkingTime;
    private final int idleTime;

    public Reader(int readerID, int maximumWorkingTime, int idleTile) {
        this.readerID = readerID;
        this.maximumWorkingTime = maximumWorkingTime;
        this.idleTime = idleTile;
    }

    @Override
    public void run() {

        try {

            while (true) {

                if (AccessControl.getReaderCount() >= 0 && !AccessControl.isWriterActive()) {

                    AccessControl.setReaderCount(AccessControl.getReaderCount() + 1);
                    System.out.println("\n\nReaderer " + this.readerID + " is reading data...");
                    Thread.sleep((long) new RandomNumberGenerator(200, this.maximumWorkingTime).getGeneratedNumber());
                    System.out.println("\n\nReader " + this.readerID + " is finished...");
                    AccessControl.setReaderCount(AccessControl.getReaderCount() - 1);
                }

                Thread.sleep(this.idleTime);
            }
        } catch (Exception e) {

            System.err.println(e.toString());
        }
    }
}
