package ${package.Mapper};

import ${package.Entity}.${entity};
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
@Mapper
public interface ${entity?substring(0,(entity)?length-2)}Mapper {

    /**
    * 插入
    *
    * @param ${(entity?substring(0))?uncap_first} ${(entity?substring(0))?uncap_first}
    * @return int
    */
    int insertSelective(${entity} ${(entity?substring(0))?uncap_first});

    /**
    * 批量插入
    *
    * @param ${(entity?substring(0))?uncap_first}List ${(entity?substring(0))?uncap_first}List
    * @return int
    */
    int bathInsertSelective(@Param("list")List<${entity}> ${(entity?substring(0))?uncap_first}List);

    /**
    * 主键删除
    *
    * @param ${(entity?substring(0))?uncap_first} ${(entity?substring(0))?uncap_first}
    * @return int int
    */
    int del${entity}PrimaryKey(${entity} ${(entity?substring(0))?uncap_first});

    /**
    * 主键修改
    *
    * @param ${(entity?substring(0))?uncap_first} ${(entity?substring(0))?uncap_first}
    * @return int
    */
    int update${entity}PrimaryKey(${entity} ${(entity?substring(0))?uncap_first});

    /**
    * 主键搜索
    *
    * @param ${(entity?substring(0))?uncap_first} ${(entity?substring(0))?uncap_first}
    * @return ${entity} ${entity}
    */
    ${entity} select${entity}PrimaryKey(${entity} ${(entity?substring(0))?uncap_first});

}