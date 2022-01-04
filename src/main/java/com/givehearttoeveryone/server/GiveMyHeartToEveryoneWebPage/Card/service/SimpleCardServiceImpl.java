package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.domain.CardItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.repository.CardRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.domain.ImageItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.repository.ImageRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.domain.TextItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.repository.TextRepository;

import java.util.Map;
import java.util.Objects;

/**
 * Created by Imaspear on 2022-01-04
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class SimpleCardServiceImpl implements SimpleCardService{
    private final CardRepository cardRepository;
    private final ImageRepository imageRepository;
    private final TextRepository textRepository;

    public SimpleCardServiceImpl(CardRepository cardRepository, ImageRepository imageRepository, TextRepository textRepository) {
        this.cardRepository = cardRepository;
        this.imageRepository = imageRepository;
        this.textRepository = textRepository;
    }

    @Override
    public CardItem showCardItemByCardId(Long cardId) {
        return cardRepository.getCardItemByCardId(cardId);
    }

    @Override
    public Map<Long, CardItem> showCardListByMemberId(Long memberId) {
        return cardRepository.getCardListByMemberId(memberId);
    }

    @Override
    public Map<Long, CardItem> showCardListByCardName(String cardName) {
        return cardRepository.getCardListByCardName(cardName);
    }

    @Override
    public Map<Long, CardItem> showCardListAll() {
        return cardRepository.getCardListAll();
    }

    @Override
    public Long setCardItem(Long memberId, String cardName, Map<Long, ImageItem> imageItemList, Map<Long, TextItem> textItemList) {
        Long cardId = 0L;
        CardItem cardItem = new CardItem(cardId, cardName, memberId);
        if(saveImageList(cardId, imageItemList) && saveTextList(cardId, textItemList)){
            cardRepository.setCardItem(cardId, cardItem);
            return cardId;
        }
        return -1L;
    }

    @Override
    public boolean saveImageList(Long cardId, Map<Long, ImageItem> imageItemList) {
        try {
            imageRepository.setImageItemsByCardId(cardId, imageItemList);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean saveTextList(Long cardId, Map<Long, TextItem> textItemList) {
        try {
            textRepository.setTextListByCardId(cardId, textItemList);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public void editCardItem(Long cardId, Long memberId) {

    }

    @Override
    public void deleteCardItemByCardId(Long cardId, Long memberId) {
        if(cardRepository.getCardItemByCardId(cardId).getMemberId().equals(memberId)){
            cardRepository.deleteCardItem(cardId);
        }
    }

}
