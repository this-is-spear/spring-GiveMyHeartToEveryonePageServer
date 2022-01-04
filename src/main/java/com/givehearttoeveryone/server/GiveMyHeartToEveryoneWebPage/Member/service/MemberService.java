package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.service;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.enums.Grade;

/**
 * Created by Imaspear on 2021-12-18
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface MemberService {
    void join(String memberName, Grade grade);
    void gradeUp(Long memberId, Grade grade);
    void editName(Long memberId);
}
