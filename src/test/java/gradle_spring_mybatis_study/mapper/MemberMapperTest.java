package gradle_spring_mybatis_study.mapper;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gradle_spring_mybatis_study.config.ControllerConfig;
import gradle_spring_mybatis_study.dto.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ControllerConfig.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberMapperTest {

	protected static final Log log = LogFactory.getLog(MemberMapperTest.class);

	@Autowired
	private MemberMapper mapper;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectMemberByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Member> list = mapper.selectMemberByAll();
		Assert.assertNotNull(list);
		list.forEach(member -> log.debug(member.toString()));
	}

	@Test
	public void test02SelectMemberByEmail() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member member = mapper.selectMemberByEmail("test@test.co.kr");
		Assert.assertNotNull(member);
		log.debug(member.toString());
	}

	@Test
	public void test03InsertMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member member = new Member("test33@test.co.kr", "1234", "test33");
		int res = mapper.insertMember(member);
		Assert.assertEquals(1, res);

	}

	@Test
	public void test04UpdateMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Member member = new Member("test33@test.co.kr", "2222", "test44");
		int res = mapper.updateMember(member);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test05DeleteMember() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int Member = mapper.deleteMember("test33@test.co.kr");
		Assert.assertSame(1, Member);

	}

}
