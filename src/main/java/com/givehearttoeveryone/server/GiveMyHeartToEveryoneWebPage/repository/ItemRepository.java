package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain.CardItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain.ImageItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain.TextItem;

import java.util.List;

/**
 * Created by Imaspear on 2021-12-05
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface ItemRepository {
    List<TextItem> findTextItembyCardId(long cardId);
    List<ImageItem> findImageItembyCardId(long cardId);
    boolean findCardItem(long cardId);
    boolean saveTextItembyCardId(long cardId);
    boolean saveImageItembyCardId(long cardId);
    CardItem temporarySaveCardItem();
}
