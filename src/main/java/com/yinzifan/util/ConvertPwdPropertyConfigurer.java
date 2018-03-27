package com.yinzifan.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class ConvertPwdPropertyConfigurer extends PropertyPlaceholderConfigurer {
	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		System.out.println("==================" + propertyName + ":" + propertyValue);
		if ("userName".equals(propertyName)) {
			return "czw";
		}
		if ("password".equals(propertyName)) {
			return "czw";
		}
		return propertyValue;
	}
}