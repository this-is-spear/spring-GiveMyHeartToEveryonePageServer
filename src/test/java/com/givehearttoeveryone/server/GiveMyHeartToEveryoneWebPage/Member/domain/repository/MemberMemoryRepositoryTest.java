package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.AppConfig;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.repository.TextRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Imaspear on 2022-01-03
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
class MemberMemoryRepositoryTest {
    private final MemberRepository memberRepository;

    public MemberMemoryRepositoryTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        this.memberRepository = applicationContext.getBean("memberRepository", MemberRepository.class);
    }

    @Test
    @DisplayName("멤버 저장")
    public void joinMember() throws Exception{
    
        //given
        
        //when
        
        //then
    
    }

    @Test
    @DisplayName("멤버 등급 수정")
    public void upgradeMember() throws Exception{

        //given

        //when

        //then

    }

    @Test
    @DisplayName("멤버 수정")
    public void updateMember() throws Exception{

        //given

        //when

        //then

    }

    @Test
    @DisplayName("멤버 조회")
    public void getMember() throws Exception{

        //given

        //when

        //then

    }
}