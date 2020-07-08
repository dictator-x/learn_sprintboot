package com.learnspringboot.controller;

import com.learnspringboot.bean.Member;
import com.learnspringboot.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/member/{id}")
    public Member getMember(@PathVariable("id") Integer id) {
        Member member = memberRepository.getOne(id);
        return member;
    }

    @GetMapping("/user")
    public Member insertMember(Member member) {
        return memberRepository.save(member);
    }
}
