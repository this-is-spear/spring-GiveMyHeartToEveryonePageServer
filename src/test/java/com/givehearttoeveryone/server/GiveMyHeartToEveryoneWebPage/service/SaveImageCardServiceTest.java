package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.domain.CardItem;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.repository.ItemRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.repository.MemoryRepository;
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
    MemoryRepository itemRepository;
    SaveImageCardService saveImageCardService;

    @BeforeEach
    public void beforeEach(){
        itemRepository = new MemoryRepository();
        saveImageCardService = new SaveImageCardService(itemRepository);
    }

    public boolean saveImageCard() {
        CardItem cardItem = itemRepository.saveCardItem();
        return itemRepository.saveALlItem(cardItem.getId());
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