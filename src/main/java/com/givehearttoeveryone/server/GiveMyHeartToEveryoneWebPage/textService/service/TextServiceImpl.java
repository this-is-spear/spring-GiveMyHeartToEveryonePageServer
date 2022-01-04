package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.domain.TextItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.repository.TextRepository;

import java.util.Map;

/**
 * Created by Imaspear on 2022-01-03
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class TextServiceImpl implements TextService{
    private final TextRepository textRepository;

    public TextServiceImpl(TextRepository textRepository) {
        this.textRepository = textRepository;
    }

    @Override
    public void setTextList(Long cardId, Map<Long, TextItem> textItem) {
        textRepository.setTextListByCardId(cardId, textItem);
    }

    @Override
    public TextItem getTextItem(Long cardId, Long textId) {
        return textRepository.getTextItemByCardIdAndTextId(cardId, textId);
    }

    @Override
    public void deleteTextListByCardId(Long cardId) {
        textRepository.deleteTextListByCardId(cardId);
    }

    @Override
    public Map<Long, TextItem> getTextListByCardId(Long cardId) {
        return textRepository.getTextListByCardId(cardId);
    }
}
