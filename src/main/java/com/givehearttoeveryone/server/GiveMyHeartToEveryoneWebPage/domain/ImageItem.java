package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by Imaspear on 2021-12-05
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

public class ImageItem {
    private long id;
    private int depth;
    private String path;
    private int size;
    private long CardId;

    public ImageItem() {
    }

    public ImageItem(long id, int depth, String path, int size, long cardId) {
        this.id = id;
        this.depth = depth;
        this.path = path;
        this.size = size;
        CardId = cardId;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getCardId() {
        return CardId;
    }

    public void setCardId(long cardId) {
        CardId = cardId;
    }

    @Override
    public String toString() {
        return "ImageItem{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", size=" + size +
                ", CardId='" + CardId + '\'' +
                '}';
    }
}
