package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.domain;

/**
 * Created by Imaspear on 2021-12-17
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class TextItem {
    private Long textId;
    private String path;

    public TextItem(Long textId, String path) {
        this.textId = textId;
        this.path = path;
    }

    public Long getTextId() {
        return textId;
    }

    public void setTextId(Long textId) {
        this.textId = textId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "TextItem{" +
                "textId=" + textId +
                ", path='" + path + '\'' +
                '}';
    }
}
