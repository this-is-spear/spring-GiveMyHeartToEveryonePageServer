package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.domain;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.ImageItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.TextItem;

import java.util.Map;

/**
 * Created by Imaspear on 2021-12-17
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class CardItem {
    private Long CardId;
    private String cardName;
    private Map<Long, ImageItem> imageItems;
    private Map<Long, TextItem> textItems;
}
