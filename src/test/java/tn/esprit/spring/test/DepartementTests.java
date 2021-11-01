package tn.esprit.spring.test;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EntrepriseServiceImpl;
import tn.esprit.spring.services.IEmployeService;

//SYRINE WORK TEST 
@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementTests {

	@Autowired
	public EntrepriseServiceImpl entrepriseServiceImpl;
	
	@Autowired
	public IEmployeService ies;
	

	
	public static final int IdEmploye=0;
	public static final Departement idDepart=null;
	public static final Entreprise idEntre= null;
	
	private static final Logger l= LogManager.getLogger(DepartementTests.class);
	
	
	
	@Test
	public void TestAjoutDeppartement(){
			//créer un nouveau departement
		Departement d1= new Departement("IT",  new Entreprise("SOFRECOM", "LAC"));
		entrepriseServiceImpl.ajouterDepartement(d1);
		entrepriseServiceImpl.deleteDepartementById(d1.getId());
		ies.getSalaireMoyenByDepartementId(d1.getId());
	}
	
	@After("execution(* tn.esprit.spring.service.*.*(..))")
	public void logMethodExit(JoinPoint joinPoint){
		String name= joinPoint.getSignature().getName();
		l.info("Out of method : " +name);
	}
	@Around("execution(* tn.esprit.spring.service.*.*(..))")
	public Object profile(ProceedingJoinPoint pjp) throws Throwable {
	long start = System.currentTimeMillis();
	Object obj = pjp.proceed();
	long elapsedTime = System.currentTimeMillis() - start;
	if (elapsedTime > 3000) {
		l.fatal("This process takes more than 3sec to execute");
	}
	l.info("Method execution time: " + elapsedTime + " milliseconds.");
		return obj;
	}
}
