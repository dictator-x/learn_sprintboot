package com.learnspringboot.repository;

import com.learnspringboot.bean.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
