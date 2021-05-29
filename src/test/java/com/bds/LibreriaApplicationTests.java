package com.bds;



import static org.junit.jupiter.api.Assertions.assertTrue;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bds.dao.IUsuarioDAO;
import com.bds.model.Usuario;

@SpringBootTest
class LibreriaApplicationTests {

	@Autowired
	private IUsuarioDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	//Objetivo: 
	//La clave del usuario que se envia tiene que ser la misma que esta en base de datos
	//crear usuario con clave 123
	@Test
	public void crearUsuario() {
	
		
		Usuario us = new Usuario();
		us.setIdUsuario(1);
		us.setUsername("morozco@gmail.com");
		us.setPassword(bcrypt.encode("123"));
		us.setEnabled(true);
		
		Usuario retorno = dao.save(us);		
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(us.getPassword()));
	}

}
