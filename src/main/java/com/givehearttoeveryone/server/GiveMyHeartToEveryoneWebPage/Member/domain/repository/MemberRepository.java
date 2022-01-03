package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.repository;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.Member;
import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.enums.Grade;

/**
 * Created by Imaspear on 2021-12-18
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface MemberRepository {
    Long setMember(Long memberId, String memberName, Grade grade);
    Member getOneByMemberId(Long memberId);
    void updateGradeMember(Long memberId, Grade grade);
    Long updateMemberName(Long memberId, String memberName);
}
