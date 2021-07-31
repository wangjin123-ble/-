package com.example.demo.service.impl;

import com.example.demo.service.Stopwatch;

public class StopWatch implements Stopwatch {
    public long start;



    @Override
    public double Stopwatch() {
        start = System.currentTimeMillis();
        return start;
    }

    @Override
    public double elapseTime() {
        long now = System.currentTimeMillis();
        return (now - start)/1000.0;
    }
}
