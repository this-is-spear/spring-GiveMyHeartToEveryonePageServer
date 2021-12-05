package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain;

/**
 * Created by Imaspear on 2021-12-05
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class TextItem {
    private long id;
    private String path;
    private int fontSize;
    private int alignText;
    private long cardId;

    public TextItem() {
    }

    public TextItem(long id, String path, int fontSize, int alignText, long cardId) {
        this.id = id;
        this.path = path;
        this.fontSize = fontSize;
        this.alignText = alignText;
        this.cardId = cardId;
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

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public int getAlignText() {
        return alignText;
    }

    public void setAlignText(int alignText) {
        this.alignText = alignText;
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    @Override
    public String toString() {
        return "TextItem{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", fontSize=" + fontSize +
                ", alignText=" + alignText +
                ", cardId=" + cardId +
                '}';
    }
}
