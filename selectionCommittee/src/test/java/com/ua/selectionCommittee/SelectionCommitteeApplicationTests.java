package com.ua.selectionCommittee;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import com.ua.selectionCommittee.dao.AdministratorRepository;
import com.ua.selectionCommittee.dao.EnrolleeRepository;
import com.ua.selectionCommittee.dao.StatementRepository;
import com.ua.selectionCommittee.dao.UniversityRepository;
import com.ua.selectionCommittee.domain.Administrator;
import com.ua.selectionCommittee.domain.Enrollee;
import com.ua.selectionCommittee.domain.Role;
import com.ua.selectionCommittee.domain.Statement;
import com.ua.selectionCommittee.domain.University;
import com.ua.selectionCommittee.service.AdministratorService;
import com.ua.selectionCommittee.service.EnrolleeService;
import com.ua.selectionCommittee.service.StatementService;
import com.ua.selectionCommittee.service.UniversityService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectionCommitteeApplicationTests {

	@Autowired
	private EnrolleeService enrolleeService;

	@Autowired
	private EnrolleeRepository enrolleeRepository;

	@Autowired
	private AdministratorService adminService;

	@Autowired
	private AdministratorRepository adminRepository;

	@Autowired
	private UniversityService universityService;

	@Autowired
	private UniversityRepository universityRepository;

	@Autowired
	private StatementRepository statementRepository;

	@Autowired
	private StatementService statementService;

	@Before
	public void clearDataBase() {
		adminRepository.deleteAll();
		statementRepository.deleteAll();
		enrolleeRepository.deleteAll();
		universityRepository.deleteAll();
	}

	@Test
	public void saveEnrollee() throws IOException {
		List<Enrollee> listEnrollee = enrolleeRepository.findAll();
		assertThat(listEnrollee, hasSize(0));

		Enrollee enrollee = new Enrollee();
		enrollee.setEnglishScore(176.54);
		enrollee.setLogin("user");
		enrollee.setMathScore(1.1);
		enrollee.setPassword("1");
		enrollee.setPasswordConfirm("1");
		enrollee.setName("u");
		enrollee.setPhysicsScore(1.1);
		enrollee.setRole(Role.ROLE_USER);
		enrollee.setSurname("r");
		enrollee.setImage("1");
		enrollee.setUkraineScore(1.1);

		enrolleeService.save(enrollee);
		listEnrollee = enrolleeRepository.findAll();
		assertThat(listEnrollee, hasSize(1));
		Enrollee enrl = listEnrollee.get(0);
		assertTrue(enrl.getLogin().equals(enrollee.getLogin()));
		assertTrue(enrl.getName().equals(enrollee.getName()));
		assertTrue(enrl.getSurname().equals(enrollee.getSurname()));
	}

	@Test
	public void readEnrollee() throws IOException {
		Enrollee enrollee = new Enrollee();
		enrollee.setEnglishScore(176.54);
		enrollee.setLogin("user");
		enrollee.setMathScore(1.1);
		enrollee.setPassword("1");
		enrollee.setPasswordConfirm("1");
		enrollee.setName("u");
		enrollee.setPhysicsScore(1.1);
		enrollee.setRole(Role.ROLE_USER);
		enrollee.setSurname("r");
		enrollee.setImage("1");
		enrollee.setUkraineScore(1.1);

		enrolleeService.save(enrollee);

		Enrollee e = enrolleeRepository.findByLogin("user").get();
		assertTrue(e.getName().equals("u"));
	}

	@Test
	public void saveAdmin() {
		List<Administrator> list = adminRepository.findAll();
		assertThat(list, hasSize(0));

		Administrator admin = new Administrator();
		admin.setLogin("admin");
		admin.setName("Jack");
		admin.setPassword("1");
		admin.setPasswordConfirm("1");
		admin.setRole(Role.ROLE_ADMIN);

		adminService.save(admin);

		list = adminRepository.findAll();
		assertThat(list, hasSize(1));
	}

	@Test
	public void readAdmin() {
		Administrator admin = new Administrator();
		admin.setLogin("admin");
		admin.setName("Jack");
		admin.setPassword("1");
		admin.setPasswordConfirm("1");
		admin.setRole(Role.ROLE_ADMIN);

		adminService.save(admin);

		Administrator readAdmin = adminRepository.findByLogin("admin").get();
		assertTrue(readAdmin.getName().equals("Jack"));
	}

	@Test
	public void saveUniversity() {
		List<University> list = universityRepository.findAll();
		assertThat(list, hasSize(0));

		University u = new University();
		u.setAverageScore(133.4);
		u.setImage("1");
		u.setLocation("1");
		u.setName("unic");

		universityService.save(u);
		list = universityRepository.findAll();
		assertThat(list, hasSize(1));
	}

	@Test
	public void readUniversity() {

		University u = new University();
		u.setAverageScore(133.4);
		u.setImage("1");
		u.setLocation("1");
		u.setName("unic");

		University unic = universityService.save(u);

		University unicRead = universityRepository.findById(unic.getId()).get();
		assertTrue(unicRead.getName().equals("unic"));
	}

	@Test
	public void saveStatement() throws IOException {
		List<Statement> list = statementRepository.findAll();
		assertThat(list, hasSize(0));

		Enrollee enrollee = new Enrollee();
		enrollee.setEnglishScore(176.54);
		enrollee.setLogin("user");
		enrollee.setMathScore(1.1);
		enrollee.setPassword("1");
		enrollee.setPasswordConfirm("1");
		enrollee.setName("u");
		enrollee.setPhysicsScore(1.1);
		enrollee.setRole(Role.ROLE_USER);
		enrollee.setSurname("r");
		enrollee.setImage("1");
		enrollee.setUkraineScore(1.1);
		
		University u = new University();
		u.setAverageScore(133.4);
		u.setImage("1");
		u.setLocation("1");
		u.setName("unic");

		enrolleeService.save(enrollee);
		universityService.save(u);

		Statement s = new Statement();
		s.setEnrollee(enrollee);
		s.setUniversity(u);
		s.setReceiptDate(new Date());

		statementService.save(s);

		list = statementRepository.findAll();
		assertThat(list, hasSize(1));
	}

	@Test
	public void deleteStatement() throws IOException {
		List<Statement> list = statementRepository.findAll();
		Enrollee enrollee = new Enrollee();
		enrollee.setEnglishScore(176.54);
		enrollee.setLogin("user");
		enrollee.setMathScore(1.1);
		enrollee.setPassword("1");
		enrollee.setPasswordConfirm("1");
		enrollee.setName("u");
		enrollee.setPhysicsScore(1.1);
		enrollee.setRole(Role.ROLE_USER);
		enrollee.setSurname("r");
		enrollee.setImage("1");
		enrollee.setUkraineScore(1.1);

		University u = new University();
		u.setAverageScore(133.4);
		u.setImage("1");
		u.setLocation("1");
		u.setName("unic");

		enrolleeService.save(enrollee);
		universityService.save(u);

		Statement s = new Statement();
		s.setEnrollee(enrollee);
		s.setUniversity(u);
		s.setReceiptDate(new Date());

		Statement statement = statementService.save(s);
		list = statementRepository.findAll();
		
		assertThat(list, hasSize(1));

		statementService.delete(statement);

		list = statementRepository.findAll();
		assertThat(list, hasSize(0));
	}

}
