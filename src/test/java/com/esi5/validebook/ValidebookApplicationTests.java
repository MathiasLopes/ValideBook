package com.esi5.validebook;

import java.util.ArrayList;
import java.util.List;

import com.esi5.validebook.controller.HomeRequestController;
import com.esi5.validebook.entity.BookEntity;
import com.esi5.validebook.entity.EditeurEntity;
import com.esi5.validebook.entity.ThemeEntity;
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
	ThemeRepository themeRepository;
	@Autowired
	EditeurRepository editeurRepository;
	@Autowired
	HomeRequestController homeRequestController;

	@Test
	void contextLoads() {

	}

	@Test
	void GetBookById() throws Exception{
		BookEntity bookById = bookRepository.getOne((long)1);
		if(bookById == null)
			throw new Exception("Erreur : Le livre avec l'id 1 n'a pas pu être récupéré");
	}

	@Test
	void GetListThemes() throws Exception{
		List<ThemeEntity> themeList = homeRequestController.listethemes();
		if(themeList == null || themeList.size() <= 0)
			throw new Exception("Erreur : Aucun theme retrouvé");
			
	}

	@Test
	void GetBookList() throws Exception{
		List<BookEntityRequest> listBook = homeRequestController.listebook("francais");
		if(listBook == null || listBook.size() <= 0)
			throw new Exception("Erreur : Aucun livre retrouvé");
	}
	
}
