package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.domain.CardItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.domain.ImageItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.domain.TextItem;

import java.util.Map;

/**
 * Created by Imaspear on 2021-12-17
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface SimpleCardService {
    CardItem showCardItemByCardId(Long cardId);
    Map<Long, CardItem> showCardListByMemberId(Long memberId);
    Map<Long, CardItem> showCardListByCardName(String cardName);
    Map<Long, CardItem> showCardListAll();
    Long setCardItem(Long memberId, String cardName, Map<Long, ImageItem> imageItems ,Map<Long, TextItem> textItems);
    boolean saveImageList(Long cardId, Map<Long, ImageItem> imageItems);
    boolean saveTextList(Long cardId, Map<Long, TextItem> textItems);
    void editCardItem(Long cardId,Long memberId);
    void deleteCardItemByCardId(Long cardId, Long memberId);
}
