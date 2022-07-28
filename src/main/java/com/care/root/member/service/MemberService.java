package com.care.root.member.service;

import org.springframework.ui.Model;

import com.care.root.member.dto.MemberDTO;

public interface MemberService {
	public void insert(MemberDTO dto);
	public void getMember(Model model);
}
