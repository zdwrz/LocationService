package com.aweiz.location.service;

import com.aweiz.location.entity.LocationMain;

public interface LocationMainService {
	public Integer createLocation(Double Latitude, Double longitude, String createdBy);
	public LocationMain getCurrentLocation();
}
