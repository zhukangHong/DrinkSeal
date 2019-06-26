package cn.time.mapper;

import cn.time.entity.TbDetail;
import cn.time.entity.TbDetailExample;
import cn.time.entity.TbDetailKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDetailMapper {
    long countByExample(TbDetailExample example);

    int deleteByExample(TbDetailExample example);

    int deleteByPrimaryKey(TbDetailKey key);

    int insert(TbDetail record);

    int insertSelective(TbDetail record);

    List<TbDetail> selectByExample(TbDetailExample example);

    TbDetail selectByPrimaryKey(TbDetailKey key);

    int updateByExampleSelective(@Param("record") TbDetail record, @Param("example") TbDetailExample example);

    int updateByExample(@Param("record") TbDetail record, @Param("example") TbDetailExample example);

    int updateByPrimaryKeySelective(TbDetail record);

    int updateByPrimaryKey(TbDetail record);
    
    List<TbDetail> selectById(@Param("dd_id") String dd_id);
    
    
}