package com.esi5.validebook;

import java.util.ArrayList;
import java.util.List;

import com.esi5.validebook.entity.BookEntity;
import com.esi5.validebook.entity.EditeurEntity;
import com.esi5.validebook.entity.ForWebRequest.BookEntityRequest;
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
	@Autowired
	EditeurRepository editeurRepository;

	@Test
	void contextLoads() {

	}

	@Test
	void GetBookList() throws Exception{
		List<BookEntity> bookList = bookRepository.findAll();
		if(bookList == null || bookList.size() <= 0)
			throw new Exception("Erreur : Aucun livre retrouvé");
	}

	@Test
	void GetBookById() throws Exception{
		BookEntity bookById = bookRepository.getOne((long)1);
		if(bookById == null)
			throw new Exception("Erreur : Le livre avec l'id 1 n'a pas pu être récupéré");
	}

	//for commit push jenkins
	@Test
	void GetListEditeurs() throws Exception{
		List<EditeurEntity> editeurList = editeurRepository.findAll();
		if(editeurList != null || editeurList.size() <= 0)
			throw new Exception("Erreur : Aucun editeur retrouvé");
	}

}
