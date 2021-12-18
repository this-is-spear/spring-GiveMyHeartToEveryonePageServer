package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.repository.CardMemoryRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.repository.CardRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.repository.MemberMemoryRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.repository.MemberRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.repository.ImageMemoryRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.repository.ImageRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.repository.TextMemoryRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.repository.TextRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Imaspear on 2021-12-18
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */

@Configuration
public class AppConfig {
    @Bean
    public CardRepository cardRepository(){
        return new CardMemoryRepository();
    };
    @Bean
    public ImageRepository imageRepository(){
        return new ImageMemoryRepository();
    };
    @Bean
    public TextRepository textRepository(){
        return new TextMemoryRepository();
    };
    @Bean
    public MemberRepository memberRepository(){
        return new MemberMemoryRepository();
    };
}
