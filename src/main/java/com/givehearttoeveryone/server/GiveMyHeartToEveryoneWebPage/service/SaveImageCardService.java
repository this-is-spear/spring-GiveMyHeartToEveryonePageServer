package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain.CardItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.repository.ItemRepository;

/**
 * Created by Imaspear on 2021-12-05
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class SaveImageCardService {

    private final ItemRepository itemRepository;

    public SaveImageCardService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void saveImageCard() {
        try {
            CardItem cardItem = itemRepository.temporarySaveCardItem();
            itemRepository.saveTextItembyCardId(cardItem.getId());
            itemRepository.saveImageItembyCardId(cardItem.getId());
            System.out.println("성공했습니다.");
        }catch (Exception e){
            System.out.println("저장에 실패했습니다 : " + e);
        }
    }
}
