package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.domain.CardItem;

import java.util.Map;

/**
 * Created by Imaspear on 2021-12-17
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface CardRepository {
    CardItem getOndByCardId(Long cardId);
    Map<Long ,CardItem> getListByMemberId(Long memberId);
    Map<Long ,CardItem> getListByCardName(String cardName);
    void saveOneByCardId(Long cardId, CardItem cardItem);
    void deleteOneByCardId(Long cardId, CardItem cardItem);
}
