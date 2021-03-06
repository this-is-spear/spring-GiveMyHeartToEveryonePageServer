package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.AppConfig;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.Member;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.enums.Grade;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.textService.repository.TextRepository;
import org.assertj.core.api.Assertions;
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
        Long memberId = 0L;
        String memberName = "ThisIsSpear";
        Grade grade = Grade.VIP;
        Member member = new Member(memberId, memberName, grade);
        memberRepository.setMember(memberId, member);
        Assertions.assertThat(memberRepository.getMemberByMemberId(memberId).getMemberId()).isEqualTo(memberId);
    }



}