package ${package.Service};

import com.han.lin.model.po.admin.UmsAdminOperLogPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import java.util.List;
/**
 * <p>
 * ${table.comment!} 服务类
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if kotlin>
interface ${table.serviceName} : ${superServiceClass}<${entity}>
<#else>
public interface ${table.serviceName} extends ${superServiceClass}<${entity}> {

    /**
     * 查询${table.comment!}分页数据
     *
     * @param page      页码
     * @param pageSize 每页条数
     * @param recode 查询条件
     * @return  IPage< ${entity}>
     */
     IPage<${entity}> findListByPage(Integer page, Integer pageSize , ${entity}  recode);

    /**
     * 添加${table.comment!}
     *
     * @param recode
     */
    int add(${entity} recode);

    /**
     * 删除${table.comment!}
     *
     * @param id 主键
     */
     int delete(Long id);

    /**
    * 删除${table.comment!}
    *
    * @param ids 主键
    */
    int delete(List<Long> ids);

    /**
     * 修改${table.comment!}
     *
     * @param recode
     */
    int updateData(${entity} recode);

    /**
    *  条件修改
    *
    * @param setData   set ? = ?
    * @param whereWrapper    where ? = ?
    */
    int updateData(${entity} setData,  Wrapper whereWrapper);

    /**
     * id查询数据
     *
     * @param id id
     * @return  ${entity}
     */
    ${entity} findById(Long id);

    /**
    * 根据Ids 查询
    *
    * @param ids
    * @return  List<${entity}>
    */
    List<${entity}> findById(List<Long> ids);
}
</#if>
