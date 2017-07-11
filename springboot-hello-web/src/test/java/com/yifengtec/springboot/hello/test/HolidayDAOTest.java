package com.yifengtec.springboot.hello.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yifengtec.springboot.hello.Application;
import com.yifengtec.springboot.hello.datasource.dao.HolidayDAO;
import com.yifengtec.springboot.hello.datasource.model.Holiday;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class HolidayDAOTest {

	@Autowired
	private HolidayDAO holidayDao;

	@Test
	public void testQuery() {
		Holiday ret = holidayDao.selectById(1l);
		System.out.println(ret);
	}

}
