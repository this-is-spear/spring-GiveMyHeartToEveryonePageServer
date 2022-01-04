package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.Member;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.enums.Grade;

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
    public Long setMember(Long memberId, Member member) {
        memberList.put(memberId, member);
        return memberId;
    }

    @Override
    public Member getMemberByMemberId(Long memberId) {
        return memberList.get(memberId);
    }
}
