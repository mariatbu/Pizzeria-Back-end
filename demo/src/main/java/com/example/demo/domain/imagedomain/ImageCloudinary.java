package com.example.demo.domain.imagedomain;

import javax.persistence.Embeddable;

@Embeddable
public class ImageCloudinary {
    
    public String asset_id;
    
    public String public_id;
    
    public String url;
}
