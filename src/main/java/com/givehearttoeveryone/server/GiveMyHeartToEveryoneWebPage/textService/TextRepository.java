package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.TextItem;

import java.util.Map;

/**
 * Created by Imaspear on 2021-12-17
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface TextRepository {
    Map<Long, TextItem> getTextItemsByCardId(Long cardId);
    void saveTextItems(Long cardId, Map<Long, TextItem> textItems);
    void editTextItems(Long cardId, Map<Long, TextItem> textItems);
    void deleteTextItemsByCardId(Long cardId);
}
