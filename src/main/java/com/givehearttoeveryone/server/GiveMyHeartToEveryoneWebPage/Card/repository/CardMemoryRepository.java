package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.domain.CardItem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Imaspear on 2021-12-18
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class CardMemoryRepository implements CardRepository{
    Map<Long, CardItem> cardItems = new HashMap<>();

    @Override
    public CardItem getOndByCardId(Long cardId) {
        return cardItems.get(cardId);
    }

    @Override
    public Map<Long, CardItem> getListByMemberId(Long memberId) {
        return null;
    }

    @Override
    public Map<Long, CardItem> getListByCardName(String cardName) {
        return null;
    }

    @Override
    public void saveOneByCardId(Long cardId, CardItem cardItem) {
        cardItems.put(cardId,cardItem);
    }

    @Override
    public void deleteOneByCardId(Long cardId, CardItem cardItem) {
        cardItems.remove(cardId);
    }
}
