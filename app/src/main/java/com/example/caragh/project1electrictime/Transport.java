package com.example.caragh.project1electrictime;

public class Transport {
    private String name;
    private double speed;
    private String time;
    private int range;

    public Transport(){
    }

    public Transport (String name, double speed, double distance, int range){
        this.name = name;
        this.speed = speed;
        this.range = range;
        this.time = this.completeJourney(distance);
    }

    public String getName(){
        return name;
    }

    public String getTime(){
        return time;
    }

    public String completeJourney (double distance){
        if (distance > range) {
            return "Too far.";
        } else {
            int temp = (int) Math.round((distance / speed) * 60);
            time = String.valueOf(temp);
            return time + " mins";
        }
    }
}
