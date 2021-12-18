package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.repository.CardMemoryRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Card.repository.CardRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.repository.MemberMemoryRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.repository.MemberRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.repository.ImageMemoryRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.imageService.repository.ImageRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.repository.TextMemoryRepository;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.repository.TextRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Imaspear on 2021-12-18
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
class AppConfigTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("카드 저장소, 이름으로 조회")
    public void findCardRepositoryBeanByName() throws Exception{
        //then
        CardRepository cardRepository = applicationContext.getBean("cardRepository", CardRepository.class);
        //when
        assertThat(cardRepository).isInstanceOf(CardMemoryRepository.class);
    }

    @Test
    @DisplayName("이미지 저장소, 빈 이름으로 조회")
    public void findImageRepositoryBeanByName() throws Exception{
        //then
        ImageRepository imageRepository = applicationContext.getBean("imageRepository", ImageRepository.class);
        //when
        assertThat(imageRepository).isInstanceOf(ImageMemoryRepository.class);
    }

    @Test
    @DisplayName("텍스트 저장소, 빈 이름으로 조회")
    public void findTextRepositoryBeanByName() throws Exception{
        //then
        TextRepository textRepository = applicationContext.getBean("textRepository", TextRepository.class);
        //when
        assertThat(textRepository).isInstanceOf(TextMemoryRepository.class);
    }

    @Test
    @DisplayName("멤버 저장소, 빈 이름으로 조회")
    public void findMemberRepositoryBeanByName() throws Exception{
        //then
        MemberRepository memberRepository = applicationContext.getBean("memberRepository", MemberRepository.class);
        //when
        assertThat(memberRepository).isInstanceOf(MemberMemoryRepository.class);
    }
}