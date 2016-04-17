/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studevs.reader_writer;

/**
 *
 * @author ashik
 */
class AccessControl {

    private static int readerCount = 0;
    private static boolean writerActive = false;
    private static final Object lockObject = new Object();

    public static int getReaderCount() {

        synchronized (lockObject) {

            return readerCount;
        }
    }

    public static void setReaderCount(int readerCount) {

        synchronized (lockObject) {

            AccessControl.readerCount = readerCount;
        }
    }

    public static boolean isWriterActive() {

        synchronized (lockObject) {

            return writerActive;
        }
    }

    public static void setWriterActive(boolean writerActive) {

        synchronized (lockObject) {

            AccessControl.writerActive = writerActive;
        }
    }
}
