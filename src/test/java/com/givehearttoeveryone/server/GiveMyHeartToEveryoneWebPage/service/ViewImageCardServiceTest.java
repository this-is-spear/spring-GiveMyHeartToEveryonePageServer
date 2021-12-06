package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.repository.MemoryRepository;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Imaspear on 2021-12-06
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
class ViewImageCardServiceTest {
    MemoryRepository itemRepository;
    ViewImageCardService viewImageCardService;

    @BeforeEach
    public void beforeEach(){
        itemRepository = new MemoryRepository();
        viewImageCardService = new ViewImageCardService(itemRepository);
    }
}