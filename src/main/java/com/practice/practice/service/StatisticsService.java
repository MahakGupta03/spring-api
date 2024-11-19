package com.practice.practice.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.practice.practice.entities.Statistics;

@Service
public class StatisticsService implements StaticsticsServiceInterface{
	public HashMap<String, Object> getData(String email) {
		HashMap<String, Object> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
//		List<Integer>stats = calculateStats(list);
		map.put("secret key", "sjsdbjshdvb");
		map.put("numbers", list);
		return map;
	}
	
	public Statistics calculateStats(List<Integer> list) {
		Statistics stats = new Statistics();
		stats.setCount(list.size());
		
		//getting min
		int mini = Integer.MAX_VALUE;
		for(int i : list) {
			mini = Math.min(i, mini);
		}
		stats.setMinimum(mini);
		
		//getting max
		int maxi = Integer.MIN_VALUE;
		for(int i : list) {
			maxi = Math.max(i, maxi);
		}
		stats.setMaximum(maxi);
		
		double mean = findMean(list);
		stats.setMean(mean);
		
		return stats;
	}
	
	public double findMean(List<Integer> list) {
		int sum = 0;
        for (int num : list) {
            sum += num;
        }
        System.out.println("Sum: " + sum);

        // Calculate the average of elements
        double average = (double)sum / list.size();
        return average;
	}
	
	
	public Map<String, Object> submitData(String secreatKey, Statistics data){
	        Map<String, Object> payload = Map.of(
	            "secret_key", secreatKey,
	            "count", data.getCount(),
	            "minimum", data.getMinimum(),
	            "maximum", data.getMaximum(),
	            "mean", data.getMean()
	        );
	        return payload;
	}
}
