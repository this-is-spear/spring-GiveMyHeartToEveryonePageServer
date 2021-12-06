package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain.CardItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.repository.ItemRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.repository.MemoryRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.repository.MemoryRepositoryTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Imaspear on 2021-12-05
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
class SaveImageCardServiceTest {
    MemoryRepositoryTest itemRepository;
    SaveImageCardService saveImageCardService;

    @BeforeEach
    public void beforeEach(){
        itemRepository = new MemoryRepositoryTest();
        saveImageCardService = new SaveImageCardService(itemRepository);
    }

    public boolean saveImageCard() {
        try {
            CardItem cardItem = itemRepository.temporarySaveCardItem();
            itemRepository.saveTextItembyCardId(cardItem.getId());
            itemRepository.saveImageItembyCardId(cardItem.getId());
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Test
    public void test() throws Exception{
        //given
        //when
        boolean validate = saveImageCard();
        //then
        Assertions.assertThat(validate).isTrue();
    }
}