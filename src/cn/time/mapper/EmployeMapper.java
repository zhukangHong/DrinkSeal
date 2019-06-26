package cn.time.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.time.entity.Employe;
import cn.time.entity.Member;



public interface EmployeMapper {
  
	
	public List<Employe> findAll() ;
	
	public List<Employe> queryLike(@Param("user")String user,@Param("name")String name,@Param("sex")String sex ) ;	
	
	public void upDateEmploye(@Param("empl")Employe employe,@Param("oe_id")String olde_id) ;
	
	public void	delEmploye(@Param("e_id")String e_id) ;
	
	public void	addEmploye(@Param("empl")Employe employe);
}