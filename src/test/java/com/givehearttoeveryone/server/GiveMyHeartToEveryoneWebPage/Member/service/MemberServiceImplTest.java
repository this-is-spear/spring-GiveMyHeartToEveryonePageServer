package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.AppConfig;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.Member;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.enums.Grade;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Imaspear on 2022-01-04
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
class MemberServiceImplTest {
    private final MemberRepository memberRepository;
    private final MemberService memberService;

    public MemberServiceImplTest(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        this.memberRepository = applicationContext.getBean("memberRepository", MemberRepository.class);
        this.memberService = applicationContext.getBean("memberService", MemberService.class);
    }

    @Test
    @DisplayName("멤버 등급 수정")
    public void upgradeMember() throws Exception{
        Long memberId = 0L;
        String memberName = "ThisIsSpear";
        Grade grade = Grade.VIP;
        Member member = new Member(memberId, memberName, grade);
        memberService.join(memberName, grade);
        grade = Grade.Basic;
        memberService.gradeUp(memberId, grade);
        Assertions.assertThat(memberRepository.getMemberByMemberId(memberId).getGrade()).isEqualTo(Grade.Basic);
    }
}