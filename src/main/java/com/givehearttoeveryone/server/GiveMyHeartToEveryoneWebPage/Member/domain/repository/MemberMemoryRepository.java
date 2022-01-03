package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.Member;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.enums.Grade;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Imaspear on 2021-12-18
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class MemberMemoryRepository implements MemberRepository{

    Map<Long, Member> memberList =new ConcurrentHashMap<>();

    @Override
    public Long setMember(Long memberId, String memberName, Grade grade) {
        Member member = new Member(memberId, memberName, grade);
        memberList.put(memberId, member);
        return memberId;
    }

    @Override
    public Member getOneByMemberId(Long memberId) {
        return memberList.get(memberId);
    }

    @Override
    public void updateGradeMember(Long memberId, Grade grade) {
        if(memberList.get(memberId).getGrade() != grade){
            Member member = memberList.get(memberId);
            member.setGrade(grade);
        }
    }

    @Override
    public Long updateMemberName(Long memberId, String memberName) {
        Member member = memberList.get(memberId);
        member.setMemberName(memberName);
        return memberId;
    }
}
