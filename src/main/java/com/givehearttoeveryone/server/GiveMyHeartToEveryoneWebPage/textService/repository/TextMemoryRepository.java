package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.domain.TextItem;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Imaspear on 2021-12-17
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class TextMemoryRepository implements TextRepository {
    Map<Long, Map<Long, TextItem>> textList = new ConcurrentHashMap<>();

    @Override
    public Map<Long, TextItem> getTextListByCardId(Long cardId) {
        return textList.get(cardId);
    }

    @Override
    public TextItem getTextItemByCardIdAndTextId(Long cardId, Long textId) {
        return textList.get(cardId).get(textId);
    }

    @Override
    public void setTextListByCardId(Long cardId, Map<Long, TextItem> textItems) {
        textList.put(cardId, textItems);
    }

    @Override
    public void editTextList(Long cardId, Map<Long, TextItem> textItems) {
        textList.put(cardId, textItems);
    }

    @Override
    public void deleteTextListByCardId(Long cardId) {
        textList.remove(cardId);
    }
}
