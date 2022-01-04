package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.domain.CardItem;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Imaspear on 2021-12-18
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class CardMemoryRepository implements CardRepository{
    Map<Long, CardItem> cardItem = new ConcurrentHashMap<>();

    @Override
    public CardItem getCardItemByCardId(Long cardId) {
        return cardItem.get(cardId);
    }

    @Override
    public Map<Long, CardItem> getCardListByMemberId(Long memberId) {
        return null;
    }

    @Override
    public Map<Long, CardItem> getCardListByCardName(String cardName) {
        return null;
    }

    @Override
    public void setCardItem(Long cardId, CardItem Item) {
        cardItem.put(cardId,Item);
    }

    @Override
    public void deleteCardItem(Long cardId) {
        cardItem.remove(cardId);
    }

    @Override
    public Map<Long, CardItem> getCardListAll() {
        return cardItem;
    }
}
