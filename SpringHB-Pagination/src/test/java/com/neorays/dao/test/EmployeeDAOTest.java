/**
 * 
 */
package com.neorays.dao.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.neorays.dao.EmployeeDAO;
import com.neorays.dao.EmployeeDAOImpl;

/**
 * @author Neorays
 *
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:**/persistance-bean.xml")
//@Transactional
public class EmployeeDAOTest {

	//@Autowired
	// @Qualifier("mithu")
	// @Resource
	private EmployeeDAO daoTest;
	/*  this error is comming because of autowire
	 * expected at least 1 bean which qualifies as autowire candidate.
	Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}*/
	
	public void setDaoTest(EmployeeDAO daoTest) {
		this.daoTest = (EmployeeDAOImpl) daoTest;
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("before");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("after");
	}

	/**
	 * Test method for {@link com.neorays.dao.EmployeeDAOImpl#insertEmp(com.neorays.domain.EmpInsertBO)}.
	 */
	@Test
	@Ignore
	public void testInsertEmp() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.neorays.dao.EmployeeDAOImpl#deleteEmp(int)}.
	 */
	@Test
	@Ignore
	public void testDeleteEmp() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.neorays.dao.EmployeeDAOImpl#loginCred()}.
	 */
	@Test
	// @Transactional
	 @Ignore
	   // @Rollback(true)
	public void testLoginCred() {
		System.out.println("before asser method");
		assertEquals(1, daoTest.loginCred());
		System.out.println("after asser method");
	}//login credentails

}
