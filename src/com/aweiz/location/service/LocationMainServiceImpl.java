package com.aweiz.location.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.aweiz.location.DAO.LocationMainDAO;
import com.aweiz.location.entity.LocationMain;

@Component
public class LocationMainServiceImpl implements LocationMainService {

	@Autowired
	private LocationMainDAO mainDAO;

	@Transactional
	public Integer createLocation(Double latitude, Double longitude, String createdBy) {
		LocationMain main = new LocationMain();
		main.setCreateDate(new Date());
		main.setLatitude(latitude);
		main.setLongitude(longitude);
		main.setCreatedBy(createdBy);
		return mainDAO.save(main);
	}

	@Override
	@Transactional(readOnly=true)
	public LocationMain getCurrentLocation() {
		return mainDAO.getLastLocation();
	}
}
