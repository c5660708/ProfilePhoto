package com.example.materialdesign;

/**
 * Created by Skyia_ccf on 2017/12/5.
 */

public class Wallpaper {
    private String name;
    private int imageId;

    public Wallpaper(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}
