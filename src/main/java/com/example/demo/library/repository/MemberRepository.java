package com.example.demo.library.repository;

import com.example.demo.library.entity.Book;
import com.example.demo.library.entity.Member;
import com.example.demo.library.vo.BookId;
import com.example.demo.library.vo.MemberId;

public interface MemberRepository {
    Member findMemberById(MemberId memberId);

    Member updateStatus(Member member);
}
