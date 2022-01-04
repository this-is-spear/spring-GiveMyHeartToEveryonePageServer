package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.Member;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.enums.Grade;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.repository.MemberRepository;

/**
 * Created by Imaspear on 2022-01-04
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(String memberName, Grade grade) {
        Long memberId = 0L;
        Member member = new Member(memberId, memberName, grade);
        memberRepository.setMember(memberId, member);
    }

    @Override
    public void gradeUp(Long memberId, Grade grade) {
        if(memberRepository.getMemberByMemberId(memberId).getGrade() != grade){
            Member member = memberRepository.getMemberByMemberId(memberId);
            member.setGrade(grade);
            memberRepository.setMember(memberId, member);
        }
    }

    @Override
    public void editName(Long memberId) {

    }
}
