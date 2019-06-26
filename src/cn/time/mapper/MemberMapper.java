package cn.time.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;

import cn.time.entity.Member;
import cn.time.test.MyBatisUtil;

public interface MemberMapper {

	public List<Member> findAll() ;
	
	public List<Member> queryLike(@Param("m_id")String m_id,@Param("name")String name ) ;		
	
	public void upDateMember(@Param("memb")Member member,@Param("om_id")String oldm_id) ;
	
	public void	delMember(@Param("m_id")String m_id) ;
		
	public void	addMember(@Param("memb")Member member);








}
