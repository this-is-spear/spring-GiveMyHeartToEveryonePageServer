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
        CardItem cardItem = itemRepository.saveCardItem();
        boolean validate = itemRepository.saveALlItem(cardItem.getId());
        if(!validate){
            System.out.println("불러온 정보가 없습니다.");
        }else{
            System.out.println();
        }
    }
}
