package com.care.root;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.care.root.member.controller.MemberController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


@RunWith(SpringRunner.class )
@ContextConfiguration( locations = {"classpath:testMember.xml",
		"file:src/main/webapp/WEB-INF/Spring/root-context.xml"})

public class TestMock {
	@Autowired MemberController mc;
	MockMvc mock;
	
	@org.junit.Before 
	public void setUp() {
		System.out.println("test실행전-----");
		mock = MockMvcBuilders.standaloneSetup(mc).build();
	}
	@Test
	public void testIndex() throws Exception {
		System.out.println("-----testindex실행");
		mock.perform( get("/index"))
			.andDo(print())
			.andExpect( status().isOk())
			.andExpect(forwardedUrl("member/index"));
	}
	
	@Test
	@Transactional(transactionManager =  "txMgr")
	public void testInsert() throws Exception {
		mock.perform( post("/insert").param("id", "989").param("name","연습"))
			.andDo(print()) //redirect는 302를 돌려 준다. 302면 다른 위치로 이동
			.andExpect(status().is3xxRedirection());
	}
	
	
	@Test
	public void testMemberview() throws Exception {
		mock.perform( get("/memberview")).andDo(print())
		.andExpect(status().isOk())
		.andExpect( forwardedUrl("member/memberview"))
		.andExpect(model().attributeExists("list"));
	}
}
