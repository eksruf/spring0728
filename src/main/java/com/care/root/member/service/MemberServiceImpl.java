package com.care.root.member.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.care.root.member.dao.MemberDAO;
import com.care.root.member.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired 
	MemberDAO mapper;
	public void insert(MemberDTO dto) {
		mapper.insert(dto);
	}
	
	public void getMember(Model model) {
		//ArrayList<MemberDTO>list = mapper.getMember();
		//model.addAttribute("list",list);
		model.addAttribute("list",mapper.getMember());
	}
}
