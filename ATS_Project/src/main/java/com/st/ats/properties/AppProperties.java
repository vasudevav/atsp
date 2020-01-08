package com.st.ats.properties;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * This class is used as temporary cache to store all messages of yaml file
 * when application is start 
 * 
 * @author Rituraj
 *
 */
@ConfigurationProperties(prefix ="form-app")
@Component
@Data
public class AppProperties {
	/**
	 * in this map variable store all message in form of key and value  
	 */
	private Map<String, String> messages;
}
