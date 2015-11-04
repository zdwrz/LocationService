package com.aweiz.location.DAO;

import com.aweiz.location.entity.LocationMain;

public interface LocationMainDAO {
	public Integer save(LocationMain main);
	public LocationMain getLastLocation();
}
