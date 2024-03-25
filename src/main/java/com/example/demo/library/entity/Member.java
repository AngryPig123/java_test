package com.example.demo.library.entity;

import com.example.demo.library.vo.DateInfo;
import com.example.demo.library.vo.MemberGrade;
import com.example.demo.library.vo.MemberId;

public class Member {

    private final MemberId memberId;
    private final String name;
    private final String email;
    private final DateInfo birth;
    private final String description;
    private MemberGrade memberGrade;

    public void updateMemberGrade(MemberGrade memberGrade) {
        this.memberGrade = memberGrade;
    }


    public Member(
            MemberId memberId, String name, String email, DateInfo birth, String description, MemberGrade memberGrade
    ) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.description = description;
        this.memberGrade = memberGrade;
    }

    public MemberId getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public DateInfo getBirth() {
        return birth;
    }

    public String getDescription() {
        return description;
    }

    public MemberGrade getMemberGrade() {
        return memberGrade;
    }

}
