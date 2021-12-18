package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.Member;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Imaspear on 2021-12-18
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class MemberMemoryRepository implements MemberRepository{
    Map<Long, Member> memberMap = new HashMap<>();
    @Override
    public Member getOneByMemberId(Long memberId) {
        return memberMap.get(memberId);
    }
}
