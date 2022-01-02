package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.domain.TextItem;

import java.util.Map;

/**
 * Created by Imaspear on 2021-12-29
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface TextService {
    // 저장
    void setTextItems(Long cardId, Map<Long, TextItem> textItem);
    // 수정
    //void editTextItemListByCardIdAndItemId(Long cardId, Long ItemId);
    TextItem getTextItem(Long cardId, Long textId);
    // 삭제
    void deleteTextItemsByCardId(Long cardId);
    // 조회
    Map<Long, TextItem> getTextItemListByCardId(Long cardId);
}
