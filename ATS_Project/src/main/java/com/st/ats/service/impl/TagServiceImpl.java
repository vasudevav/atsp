package com.st.ats.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.st.ats.constant.ATSConstants;
import com.st.ats.domain.VehicleSummary;
import com.st.ats.properties.AppProperties;
import com.st.ats.service.TagService;

@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private AppProperties appProperties;

	@Autowired
	private RestTemplate template;

	@Override
	public VehicleSummary invokeRestApi(String regNum) {
		Integer statusCode = null;
		ResponseEntity<VehicleSummary> resEntity = null;
		VehicleSummary vehicleSummary = null;
		if (regNum != null && !"".equals(regNum)) {
			String restUrl = appProperties.getMessages().get(ATSConstants.KEY_FOR_REST_API_URL);
			try {
				resEntity = template.exchange(restUrl, HttpMethod.GET, null, VehicleSummary.class, regNum);
				statusCode = resEntity.getStatusCode().value();
			} catch (HttpClientErrorException he) {
				statusCode = HttpStatus.BAD_REQUEST.value();
			}
		}
		if (statusCode == 400) {
			return null;
		}
		if (statusCode == 200) {
			vehicleSummary = resEntity.getBody();
		}
		return vehicleSummary;
	}
}
