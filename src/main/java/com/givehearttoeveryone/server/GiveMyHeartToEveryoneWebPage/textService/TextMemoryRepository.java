package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Imaspear on 2021-12-17
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class TextMemoryRepository implements TextRepository{
    Map<Long, Map<Long, TextItem>> saveTextItemsByCardId = new HashMap<>();

    @Override
    public Map<Long, TextItem> getTextItemsByCardId(Long cardId) {
        return saveTextItemsByCardId.get(cardId);
    }

    @Override
    public void saveTextItems(Long cardId, Map<Long, TextItem> textItems) {
        saveTextItemsByCardId.put(cardId, textItems);
    }

    @Override
    public void editTextItems(Long cardId, Map<Long, TextItem> textItems) {
        saveTextItemsByCardId.put(cardId, textItems);
    }

    @Override
    public void deleteTextItemsByCardId(Long cardId) {
        saveTextItemsByCardId.remove(cardId);
    }
}
