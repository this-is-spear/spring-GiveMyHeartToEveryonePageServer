package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.domain.CardItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.ImageItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.domain.TextItem;

import java.util.Map;

/**
 * Created by Imaspear on 2021-12-17
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface SimpleCardService {
    CardItem showCardOneByCardId(Long cardId);
    Map<Long, CardItem> showCardListByMemberId(Long memberId);
    Map<Long, CardItem> showCardListByCardName(String cardName);
    Map<Long, CardItem> showCardListAll();
    Long makeCard(Long memberId, Map<Long, ImageItem> imageItems ,Map<Long, TextItem> textItems);
    void saveImageItems(Long cardId, Map<Long, ImageItem> imageItems);
    void saveTextItems(Long cardId, Map<Long, TextItem> textItems);
    void editCard(Long cardId,Long memberId);
    void deleteCardByCardId(Long cardId, Long memberId);
}
