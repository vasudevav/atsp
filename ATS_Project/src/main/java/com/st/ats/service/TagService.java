package com.st.ats.service;

import com.st.ats.domain.VehicleSummary;

public interface TagService {

	public VehicleSummary invokeRestApi(String regNum);
}
