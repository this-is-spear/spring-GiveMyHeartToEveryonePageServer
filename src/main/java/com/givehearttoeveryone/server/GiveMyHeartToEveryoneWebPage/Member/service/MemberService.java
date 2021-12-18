package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.service;

/**
 * Created by Imaspear on 2021-12-18
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public interface MemberService {
    void join();
    void gradeUp(Long memberId);
    void editName(Long memberId);
}
