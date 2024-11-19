package com.practice.practice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.practice.practice.entities.Statistics;

public interface StaticsticsServiceInterface {
	public HashMap<String, Object> getData(String email);
	public Statistics calculateStats(List<Integer> list);
	public Map<String, Object> submitData(String secreatKey, Statistics data);
}
