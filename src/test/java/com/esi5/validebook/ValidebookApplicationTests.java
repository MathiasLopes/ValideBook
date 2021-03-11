package com.esi5.validebook;

import com.esi5.validebook.service.CustomUserDetailService;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootTest
class ValidebookApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	void GetUserByUsername(){
		new CustomUserDetailService().loadUserByUsername("mathias@test.fr");
	}

}
