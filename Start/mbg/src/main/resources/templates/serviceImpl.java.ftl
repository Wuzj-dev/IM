package ${package.ServiceImpl};

import org.springframework.beans.factory.annotation.Autowired;
import com.han.lin.model.po.admin.UmsAdminOperLogPo;
import com.han.lin.mapper.UmsAdminOperLogMapper;
import com.han.lin.service.UmsAdminOperLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * <p>
 * ${table.comment!} 服务实现类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

}
<#else>
public class ${table.serviceImplName}
                extends ${superServiceImplClass}<${table.mapperName}, ${entity}> implements ${table.serviceName} {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private ${table.mapperName} ${(table.mapperName?substring(0))?uncap_first};


    @Override
    public  IPage<${entity}> findListByPage(Integer page, Integer pageSize , ${entity}  recode){
        IPage<${entity}> wherePage = new Page<>(page, pageSize);
        ${entity} where = new ${entity}();

<#--        QueryWrapper  queryWrapper = Bilder${entity}(recode);-->
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>(recode);
        IPage<${entity}> results = ${(table.mapperName?substring(0))?uncap_first}.selectPage(wherePage, queryWrapper);

        return results;
    }

    @Override
    public int  add(${entity} recode){
        return ${(table.mapperName?substring(0))?uncap_first}.insert(recode);
    }

    @Override
    public int  delete(Long id){
        return ${(table.mapperName?substring(0))?uncap_first}.deleteById(id);
    }

    @Override
    public int  delete(List<Long>  ids){
        return ${(table.mapperName?substring(0))?uncap_first}.deleteBatchIds(ids);
    }

    @Override
    public int  updateData(${entity} recode){
        return ${(table.mapperName?substring(0))?uncap_first}.updateById(recode);
    }

    @Override
    public int updateData(${entity} whereData,  Wrapper wrapper) {
        return ${(table.mapperName?substring(0))?uncap_first}.update(whereData,wrapper);
    }

    @Override
    public ${entity} findById(Long id){
        ${entity} result = ${(table.mapperName?substring(0))?uncap_first}.selectById(id);
        return result ;
    }

    @Override
    public List<${entity}> findById(List<Long> ids) {
        QueryWrapper<${entity}> wrapper = Wrappers.query();
        List<${entity}> bpsBrands = ${(table.mapperName?substring(0))?uncap_first}.selectBatchIds(ids);

        return bpsBrands;
    }

    /**
    *  构建查询条件
    *
    * @param recode
    * @return
    */
    private QueryWrapper Bilder${entity}Select (${entity} recode){
        QueryWrapper<${entity}> queryWrapper = new QueryWrapper<>();

<#--            Map<String, Object> params = recode.getParams();-->

<#--            if (params.size()<=0)-->
<#--            return queryWrapper;-->

<#--            Map<String , Object> map = new LinkedHashMap<>(); Set<String> keySet = map.keySet();-->

<#--            for(String key : keySet) {-->
<#--                queryWrapper.eq(key , map.get(key));-->
<#--            }-->

            return queryWrapper;
     }


}
</#if>
