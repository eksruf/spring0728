package com.care.root.member.dao;

import java.util.List;

import com.care.root.member.dto.MemberDTO;

public interface MemberDAO {
	public void insert(MemberDTO dto);
	public List<MemberDTO> getMember();
}
