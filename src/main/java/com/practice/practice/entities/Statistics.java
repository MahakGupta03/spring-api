package com.practice.practice.entities;

import java.util.List;

public class Statistics {
	private int count;
    private int minimum;
    private int maximum;
    private double mean;
    private double median;
    private List<Integer> mode;
    
    
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getMinimum() {
		return minimum;
	}
	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
	public int getMaximum() {
		return maximum;
	}
	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}
	public double getMean() {
		return mean;
	}
	public void setMean(double mean) {
		this.mean = mean;
	}
	public double getMedian() {
		return median;
	}
	public void setMedian(double median) {
		this.median = median;
	}
	public List<Integer> getMode() {
		return mode;
	}
	public void setMode(List<Integer> mode) {
		this.mode = mode;
	}
    
	
    
	
	
}
