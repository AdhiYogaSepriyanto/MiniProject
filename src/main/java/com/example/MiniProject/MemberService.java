package com.example.MiniProject;

import java.util.List;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberRepository repo;
	
	public List<Tbl_member> listAll() {
		return repo.findAll();
	}
	
	public void save(Tbl_member tbl_member) {
		repo.save(tbl_member);
	}
	
	public Tbl_member get(Long memberid) {
		return repo.findById(memberid).get();
	}
	
	public void delete(Long memberid) {
		repo.deleteById(memberid);
	}
}