package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.domain.TextItem;

import java.util.Map;

/**
 * Created by Imaspear on 2021-12-17
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface TextRepository {
    Map<Long, TextItem> getTextItemListByCardId(Long cardId);
    TextItem getTextItemByCardIdAndTextId(Long cardId, Long textId);
    void setTextItemsByCardId(Long cardId, Map<Long, TextItem> textItems);
    void editTextItems(Long cardId, Map<Long, TextItem> textItems);
    void deleteTextItemsByCardId(Long cardId);
}
