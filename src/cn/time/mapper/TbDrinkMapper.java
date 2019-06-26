package cn.time.mapper;


import cn.time.entity.TbCategory;
import cn.time.entity.TbDrink;
import cn.time.entity.TbDrinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbDrinkMapper {
    long countByExample(TbDrinkExample example);

    int deleteByExample(TbDrinkExample example);

    int deleteByPrimaryKey(Integer dId);

    int insert(TbDrink record);

    int insertSelective(TbDrink record);

    List<TbDrink> selectByExample(TbDrinkExample example);

    TbDrink selectByPrimaryKey(Integer dId);

    int updateByExampleSelective(@Param("record") TbDrink record, @Param("example") TbDrinkExample example);

    int updateByExample(@Param("record") TbDrink record, @Param("example") TbDrinkExample example);

    int updateByPrimaryKeySelective(TbDrink record);

    int updateByPrimaryKey(TbDrink record);
       
    List<TbDrink> queryLike(@Param("d_Name") String d_Name);
    
    public List<TbDrink> findAll() ;
    
    
}