package com.example.demo.core.configuration.cloudinaryconfiguration;

import java.util.Map;

import com.cloudinary.utils.ObjectUtils;



public class cloudinaryConfiguration {

    static final Map config= ObjectUtils.asMap(
        "cloud_name", System.getenv("cloud_name"),
        "api_key", System.getenv("API_key"),
        "api_secret", System.getenv("API_secret"),
        "secure", true
    );
    
}
