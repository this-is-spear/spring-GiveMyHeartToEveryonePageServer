package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.domain.TextItem;

import java.util.Map;

/**
 * Created by Imaspear on 2022-01-03
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class TextServiceImpl implements TextService{
    @Override
    public void setTextItems(Long cardId, Map<Long, TextItem> textItem) {

    }

    @Override
    public TextItem getTextItem(Long cardId, Long textId) {
        return null;
    }

    @Override
    public void deleteTextItemsByCardId(Long cardId) {

    }

    @Override
    public Map<Long, TextItem> getTextItemListByCardId(Long cardId) {
        return null;
    }
}
