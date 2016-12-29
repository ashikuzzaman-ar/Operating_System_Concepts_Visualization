/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.studevs.scheduling.rr;

import java.util.Date;

/**
 *
 * @author ashik
 */
public class ProcessModel {
    
    private final int id ;
    private final long arrivalTime ;
    private final long duration ;
    private long remainingTime ;

    public ProcessModel(int id, long duration) {
        this.id = id;
        this.arrivalTime = new Date().getTime();
        this.duration = duration;
        this.remainingTime = duration;
    }

    public void setRemainingTime(long remainingTime) {
        this.remainingTime = remainingTime;
    }

    public int getId() {
        return id;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public long getDuration() {
        return duration;
    }

    public long getRemainingTime() {
        return remainingTime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + (int) (this.arrivalTime ^ (this.arrivalTime >>> 32));
        hash = 79 * hash + (int) (this.duration ^ (this.duration >>> 32));
        hash = 79 * hash + (int) (this.remainingTime ^ (this.remainingTime >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProcessModel other = (ProcessModel) obj;
        return this.id == other.id;
    }
}
