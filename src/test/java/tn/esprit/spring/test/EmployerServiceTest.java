package tn.esprit.spring.test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
@RunWith(SpringRunner.class)
@SpringBootTest

public class EmployerServiceTest {
	@Autowired
	DepartementRepository depRepo;

	@Autowired
	IEmployeService es;

	public static final String PRENOM ="benhassine";

	@Test
	public void testAjouterEmployer() {
	es.ajouterEmploye(new Employe("ahmed", PRENOM, "ahmedbenhassine@esprit.tn", true, Role.CHEF_DEPARTEMENT));
		
	
	}


	
	
	@Test
	public void testGetEmployerPrenomById()  {
	
		
	assertEquals(PRENOM,es.getEmployePrenomById(11));
	
	}
	

	@Test
public void testgetAllEmployes()  {
		
		
		es.getAllEmployes();
		
		}

	

	


      @Test
		public void testmettreAjourEmailByEmployeIdJPQL() {
				
				
			es.mettreAjourEmailByEmployeIdJPQL("ahmedbnnh@gmail.com",11);
				
		}


  

	
	
	

}

	


