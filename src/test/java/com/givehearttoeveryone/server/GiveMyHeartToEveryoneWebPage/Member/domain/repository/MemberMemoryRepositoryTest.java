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
        memberRepository.setMember(memberId, memberName, grade);
        Assertions.assertThat(memberRepository.getOneByMemberId(memberId).getMemberId()).isEqualTo(memberId);
    }

    @Test
    @DisplayName("멤버 등급 수정")
    public void upgradeMember() throws Exception{
        Long memberId = 0L;
        String memberName = "ThisIsSpear";
        Grade grade = Grade.VIP;
        memberRepository.setMember(memberId, memberName, grade);
        memberRepository.updateGradeMember(memberId, Grade.Basic);
        Assertions.assertThat(memberRepository.getOneByMemberId(memberId).getGrade()).isEqualTo(Grade.Basic);
    }

    @Test
    @DisplayName("멤버 수정")
    public void updateMember() throws Exception{
        Long memberId = 0L;
        String memberName = "ThisIsSpear";
        Grade grade = Grade.VIP;
        memberRepository.setMember(memberId, memberName, grade);
        memberRepository.updateMemberName(memberId, "ImNotSpear");
        Assertions.assertThat(memberRepository.getOneByMemberId(memberId).getMemberName()).isEqualTo("ImNotSpear");
    }

//    @Test
//    @DisplayName("멤버 조회")
//    public void getMember() throws Exception{
//
//        //given
//
//        //when
//
//        //then
//
//    }
}