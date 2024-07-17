package edu.csueb.android.zoodirectory2;


import java.io.Serializable;

public class Animal implements Serializable {
    private String name;
    private int thumbnailImage;
    private int largeImage;
    private String description;

    public Animal(String name, int thumbnailImage, int largeImage, String description) {
        this.name = name;
        this.thumbnailImage = thumbnailImage;
        this.largeImage = largeImage;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getThumbnailImage() {
        return thumbnailImage;
    }

    public int getLargeImage() {
        return largeImage;
    }

    public String getDescription() {
        return description;
    }
}
