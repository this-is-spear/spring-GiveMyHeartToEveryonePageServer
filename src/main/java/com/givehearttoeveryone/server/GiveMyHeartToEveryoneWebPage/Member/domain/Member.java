package com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain;

import com.givehearttoeveryone.server.GiveMyHeartToEveryoneWebPage.Member.domain.enums.Grade;

/**
 * Created by Imaspear on 2021-12-17
 * Blog : https://imspear.tistory.com/
 * Github : https://github.com/Imaspear
 */
public class Member {
    private Long memberId;
    private String memberName;
    private Grade grade;

    public Member(Long memberId, String memberName, Grade grade) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.grade = grade;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
