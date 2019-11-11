package com.example.MiniProject;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MiniProject.Tbl_member;

public interface MemberRepository extends JpaRepository<Tbl_member, Long> {

}
