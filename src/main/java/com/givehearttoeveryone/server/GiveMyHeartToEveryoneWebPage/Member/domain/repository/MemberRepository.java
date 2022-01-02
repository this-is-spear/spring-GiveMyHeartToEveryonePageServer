package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.Member;

/**
 * Created by Imaspear on 2021-12-18
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface MemberRepository {
    Member getOneByMemberId(Long memberId);
    void upgradeMember(Long memberId);
    Member updateMember(Long memberId);
}
