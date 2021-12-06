package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain.enums.AlignText;

/**
 * Created by Imaspear on 2021-12-05
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class TextItem {
    private long id;
    private String path;
    private int depth;
    private int fontSize;
    private AlignText alignText;
    private long cardId;

    public TextItem() {
    }

    public TextItem(long id, String path, int depth, int fontSize, AlignText alignText, long cardId) {
        this.id = id;
        this.path = path;
        this.depth = depth;
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

    public AlignText getAlignText() {
        return alignText;
    }

    public void setAlignText(AlignText alignText) {
        this.alignText = alignText;
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
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
