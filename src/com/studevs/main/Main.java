package com.studevs.main;

import com.studevs.scheduling.ProcessInitializer;
import com.studevs.scheduling.SJF;

/**
 *
 * @author ashik
 */
public class Main {

    public static void main(String[] args) {

        new Thread(new ProcessInitializer()).start();
        new Thread(new SJF()).start();
    }
}
