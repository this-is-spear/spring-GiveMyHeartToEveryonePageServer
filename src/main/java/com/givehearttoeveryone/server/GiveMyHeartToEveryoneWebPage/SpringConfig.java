package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.repository.ItemRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.repository.MemoryRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.service.ViewImageCardService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Imaspear on 2021-12-05
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
@Configuration
public class SpringConfig {

    @Bean
    public ViewImageCardService viewCardService(){
        return new ViewImageCardService(itemRepository());
    }

    @Bean
    public ItemRepository itemRepository(){
        return new MemoryRepository();
    }
}
