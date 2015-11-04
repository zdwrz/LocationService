package com.aweiz.location.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aweiz.location.entity.LocationMain;
import com.aweiz.location.service.LocationMainService;

@RestController
@RequestMapping("/location")
public class Location {
	@Autowired
	LocationMainService mainService;

	@RequestMapping(value = "/add/{param}/", method = RequestMethod.GET)
	public String addLocation(@PathVariable String param) {
		String[] params = param.split("&&");
		Double latitude = Double.parseDouble(params[0]);
		Double longitude = Double.parseDouble(params[1]);
		Integer res = mainService
				.createLocation(latitude, longitude, params[2]);
		if (res != null) {
			return "OK";
		}
		return "fail";
	}
	@RequestMapping(value = "/getCurrentLocation", method = RequestMethod.GET)
	public @ResponseBody LocationMain getLocation() {
		LocationMain main = mainService.getCurrentLocation();
		return main;
	}

}
