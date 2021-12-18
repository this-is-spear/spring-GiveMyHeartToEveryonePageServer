package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService;

/**
 * Created by Imaspear on 2021-12-17
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class ImageItem {
    private Long imageId;
    private String path;

    public ImageItem(Long imageId, String path) {
        this.imageId = imageId;
        this.path = path;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
