package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.domain.CardItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.repository.CardRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.domain.ImageItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.repository.ImageRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.domain.TextItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.repository.TextRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Imaspear on 2021-12-19
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

@Slf4j
public class SimpleQuickCardService implements SimpleCardService{
    CardRepository cardRepository;
    ImageRepository imageRepository;
    TextRepository textRepository;

    public SimpleQuickCardService(CardRepository cardRepository, ImageRepository imageRepository, TextRepository textRepository) {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        this.cardRepository = applicationContext.getBean("cardRepository", CardRepository.class);
        this.cardRepository = cardRepository;
        this.imageRepository = imageRepository;
        this.textRepository = textRepository;
    }

    @Override
    public CardItem showCardOneByCardId(Long cardId) {
        CardItem cardItem = cardRepository.getOneByCardId(cardId);
        return null;
    }

    @Override
    public Map<Long, CardItem> showCardListAll() {
        return cardRepository.getListAll();
    }

    @Override
    public Map<Long, CardItem> showCardListByMemberId(Long memberId) {
        Map<Long, CardItem> cardListByMemberId = new HashMap<>();
        Map<Long, CardItem> listAll = cardRepository.getListAll();
        for(Long key: listAll.keySet()){
            if(Objects.deepEquals(listAll.get(key).getMemberId(), memberId)){
                cardListByMemberId.put(listAll.get(key).getCardId(), listAll.get(key));
            }
        }
        return cardListByMemberId;
    }

    @Override
    public Map<Long, CardItem> showCardListByCardName(String cardName) {
        return null;
    }

    @Override
    public Long makeCard(Long memberId, Map<Long, ImageItem> imageItems ,Map<Long, TextItem> textItems) {
        CardItem cardItem = new CardItem(0L, "name", memberId);
        saveImageItems(cardItem.getCardId(), imageItems);
        saveTextItems(cardItem.getCardId(), textItems);

        cardRepository.saveOneByCardId(cardItem.getCardId(), cardItem);
        return cardItem.getCardId();
    }

    @Override
    public void saveImageItems(Long cardId, Map<Long, ImageItem> imageItems) {
        imageRepository.setImageItemsByCardId(cardId,imageItems);
    }

    @Override
    public void saveTextItems(Long cardId, Map<Long, TextItem> textItems) {
        textRepository.setTextItemsByCardId(cardId,textItems);
    }

    @Override
    public void editCard(Long cardId, Long memberId) {

    }

    @Override
    public void deleteCardByCardId(Long cardId, Long memberId) {

    }


}
