package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.domain.CardItem;

import java.util.Map;

/**
 * Created by Imaspear on 2021-12-17
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface SimpleQuickCardService {
    CardItem showCardOneByCardId(Long cardId);
    Map<Long, CardItem> showCardListByUserId(Long userId);
    Map<Long, CardItem> showCardListByCardName(String cardName);
    void makeCard(Long userId);
    void editCard(Long cardId,Long userId);
    void deleteCardByCardId(Long cardId, Long userId);
}
