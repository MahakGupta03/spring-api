package com.practice.practice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.practice.entities.Statistics;
import com.practice.practice.service.StaticsticsServiceInterface;
import com.practice.practice.service.StatisticsService;


@RestController
@RequestMapping("/api")
public class classController {
	@Autowired
	private StaticsticsServiceInterface stats;
	 
	@GetMapping("/{email}")
	public ResponseEntity<Map<String, Object>> getData(@PathVariable String email){
		HashMap<String, Object> map = this.stats.getData(email);
		
		String secreatKey = (String)map.get("secret key");
		List<Integer> list = (List<Integer>)map.get("numbers");
		Statistics data = this.stats.calculateStats(list);
		
		Map<String , Object> tempMap = this.stats.submitData(secreatKey, data);
		
		return new ResponseEntity<Map<String,Object>>(tempMap, HttpStatus.OK);
	}
	
	@PostMapping("/submit")
	public ResponseEntity<String> postData(Statistics stats) {
		if(validateData(stats)==true) {
			return new ResponseEntity<String>("Your response has been submitted successfully", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Please Try again", HttpStatus.OK);
		}
	}
	
	public boolean validateData(Statistics stats) {
		return (stats!=null);
	}
}
