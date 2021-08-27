package com.example.demo.domain.userdomain.image;

import javax.persistence.Embeddable;


@Embeddable
public class ImageAlgolia {

    public String asset_id;
    
    public String public_id;
    
    public String url;
}
