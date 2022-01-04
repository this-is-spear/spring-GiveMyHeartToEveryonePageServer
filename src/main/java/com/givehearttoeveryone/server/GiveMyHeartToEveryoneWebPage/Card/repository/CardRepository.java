package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.domain.CardItem;

import java.util.Map;

/**
 * Created by Imaspear on 2021-12-17
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface CardRepository {
    CardItem getCardItemByCardId(Long cardId);
    Map<Long ,CardItem> getCardListByMemberId(Long memberId);
    Map<Long ,CardItem> getCardListByCardName(String cardName);
    Map<Long ,CardItem> getCardListAll();
    void setCardItem(Long cardId, CardItem cardItem);
    void deleteCardItem(Long cardId);
}
