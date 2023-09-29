package com.example.demo.repository.jdbc;

import com.example.demo.domain.Member;
import com.example.demo.dto.member.MemberSaveDto;
import com.example.demo.dto.member.MemberUpdateDto;
import com.example.demo.repository.MemberRepository;

import java.util.List;

public class MemberJdbcRepository implements MemberRepository {
    @Override
    public Long save(MemberSaveDto member) {
        return null;
    }

    @Override
    public Member findById(Long memberId) {
        return null;
    }

    @Override
    public List<Member> findAll() {
        return null;
    }

    @Override
    public void update(MemberUpdateDto dto) {

    }

    @Override
    public void delete(Member member) {

    }
}
