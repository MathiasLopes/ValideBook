package com.esi5.validebook;

import java.util.ArrayList;
import java.util.List;

import com.esi5.validebook.entity.BookEntity;
import com.esi5.validebook.repository.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootTest()
class ValidebookApplicationTests {

	@Autowired
	BookRepository bookRepository;

	@Test
	void contextLoads() {

	}

	@Test
	void GetBookList() throws Exception{
		List<BookEntity> bookList = bookRepository.findAll();
		if(bookList == null || bookList.size() <= 0)
			throw new Exception("Erreur : Aucun livre retrouvé");
	}

}
