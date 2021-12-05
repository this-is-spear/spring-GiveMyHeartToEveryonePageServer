package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain;

/**
 * Created by Imaspear on 2021-12-05
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class CardItem {
    private long id;
    private String name;

    public CardItem() {
    }

    public CardItem(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CardItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
