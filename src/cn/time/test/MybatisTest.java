package cn.time.test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.time.entity.Employe;
import cn.time.entity.Member;
import cn.time.entity.TbCategory;
import cn.time.mapper.EmployeMapper;
import cn.time.mapper.MemberMapper;
import cn.time.mapper.TbCategoryMapper;


public class MybatisTest {

	
	List<Member> mlist=new ArrayList<>();
	@Test
	public void testQu2()
	{			
	SqlSession session =MyBatisUtil.getSession();	
	MemberMapper memberMapper = session.getMapper(MemberMapper.class);
	mlist=memberMapper.findAll();	
	for (Member member : mlist) {
		System.out.println(member.getM_id());
	}
	
	}

	@Test
	public void testQu()
	{			
	SqlSession session =MyBatisUtil.getSession();	
	MemberMapper memberMapper = session.getMapper(MemberMapper.class);

	List<Member> mlist = memberMapper.queryLike("吴","吴");
		for (Member member : mlist) {
			System.out.println(member.getName());
		}
	}
	
	
	@Test
	public void testQu3()
	{			
	SqlSession session =MyBatisUtil.getSession();	
	MemberMapper memberMapper = session.getMapper(MemberMapper.class);
	Member member=new Member();
	member.setM_id("13751210787");
	member.setName("余");
	member.setSex("男");
	member.setPoint(10);
	String oldm_id="137";
	 memberMapper.upDateMember(member,oldm_id);
		session.commit();
		MyBatisUtil.closeSession();
	}
	
	
	
	
	@Test
	public void testDel()
	{			
	SqlSession session =MyBatisUtil.getSession();	
	MemberMapper memberMapper = session.getMapper(MemberMapper.class);
	
	 memberMapper.delMember("137");
		session.commit();
		MyBatisUtil.closeSession();
	}
	
	
	
	@Test
	public void testAdd()
	{			
	SqlSession session =MyBatisUtil.getSession();	
	MemberMapper memberMapper = session.getMapper(MemberMapper.class);
	Member member=new Member();
	member.setM_id("1375");
	member.setName("许");
	member.setSex("女");
	member.setPoint(10);
	//String oldm_id="137";
	 memberMapper.addMember(member);
		session.commit();
		MyBatisUtil.closeSession();
	}
	
	@Test
	public void testQu1()
	{			
	SqlSession session =MyBatisUtil.getSession();	
	EmployeMapper employeMapper = session.getMapper(EmployeMapper.class);

	List<Employe> mlist = employeMapper.findAll();
		for (Employe member : mlist) {
			System.out.println(member.getUser());
		}
	}

	
	@Test
	public void testLike()
	{			
	SqlSession session =MyBatisUtil.getSession();	
	EmployeMapper employeMapper = session.getMapper(EmployeMapper.class);

	List<Employe> mlist = employeMapper.queryLike("kb", "kb",  "kb");
	for (Employe member : mlist) {
		System.out.println(member.getUser());
	}
	}
	
	
	@Test
	public void testQu22()
	{			
	SqlSession session =MyBatisUtil.getSession();	
	EmployeMapper employeMapper = session.getMapper(EmployeMapper.class);
	Employe employe=new Employe();
	employe.setName("钟");
	employe.setSex("男");
	employe.setUser("zonk");
	employe.setPasswd("123456");
	String olde_id="2";
	employeMapper.upDateEmploye(employe,olde_id);
		session.commit();
		MyBatisUtil.closeSession();
	}
	
	
	@Test
	public void testAdd2()
	{			
	SqlSession session =MyBatisUtil.getSession();	
	EmployeMapper employeMapper = session.getMapper(EmployeMapper.class);
	Employe employe=new Employe();	
	employe.setName("管理");
	employe.setSex("男");
	employe.setUser("admin");
	employe.setPasswd("123456");	
	employeMapper.addEmploye(employe);
		session.commit();
		MyBatisUtil.closeSession();
	}
	
	@Test
	public void testLike2()
	{			
	SqlSession session =MyBatisUtil.getSession();	
	TbCategoryMapper categoryMapper = session.getMapper(TbCategoryMapper.class);
	List<TbCategory> clist = categoryMapper.queryLike("夏");
	for (TbCategory category : clist) {
		System.out.println(category.getC_Name());
	}
	}

	
	@Test
	public void testFile() throws IOException
	{			
		FileReader reader = new FileReader("config/my.conf");
        BufferedReader br = new BufferedReader(reader);     
        String[] path=new String[5];
        int i=1;
        
        while ((path[0] = br.readLine()) != null) {     
        	path[i]=path[0];
        	i++;
           
	}
        for (String string : path) {
			System.out.println(string);
		}

	
	}
	
	
}
