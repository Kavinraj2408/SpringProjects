package com.kavindev.springjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.kavindev.springjdbc.dao.AlienDAO;
import com.kavindev.springjdbc.entity.Alien;

@SpringBootApplication
public class SpringJdbcDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(SpringJdbcDemoApplication.class, args);
		
		Alien alien = context.getBean(Alien.class);
		
		alien.setId(101);
		alien.setName("Kavin");
		alien.setTech("Java");
		
		AlienDAO dao = context.getBean(AlienDAO.class);
		
		dao.save(alien);
		System.out.println(dao.getAllAliens());
	}

}
