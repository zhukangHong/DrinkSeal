package cn.time.mapper;

import cn.time.entity.Member;
import cn.time.entity.TbDeal;
import cn.time.entity.TbDealExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDealMapper {
    long countByExample(TbDealExample example);

    int deleteByExample(TbDealExample example);

    int deleteByPrimaryKey(String ddId);

    int insert(TbDeal record);

    int insertSelective(TbDeal record);

    List<TbDeal> selectByExample(TbDealExample example);

    TbDeal selectByPrimaryKey(String ddId);

    int updateByExampleSelective(@Param("record") TbDeal record, @Param("example") TbDealExample example);

    int updateByExample(@Param("record") TbDeal record, @Param("example") TbDealExample example);

    int updateByPrimaryKeySelective(TbDeal record);

    int updateByPrimaryKey(TbDeal record);
    
    
    public List<TbDeal> findAll() ;
    
    public List<TbDeal> queryLike(@Param("dd_id")String dd_id,@Param("m_id")String m_id ) ;	
    
    public void upDate(TbDeal record) ;	
    
    public void deleteDeal(@Param("dd_id")String dd_id) ;	
    
}