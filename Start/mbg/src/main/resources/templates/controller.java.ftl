package ${package.Controller};



import com.han.lin.comment.result.R;
import com.han.lin.model.dto.UpdateAdminDto;
import com.han.lin.model.dto.UserinfoDto;
import com.han.lin.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
<#if restControllerStyle>
import org.springframework.web.bind.annotation.RestController;
<#else>
import org.springframework.stereotype.Controller;
</#if>
<#if superControllerClassPackage??>
import ${superControllerClassPackage};
</#if>

/**
 * <p>
 * ${table.comment!} 前端控制器
 * </p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@Api(tags = {"${table.comment!}"})
@RestController
<#else>
@Controller
</#if>@RequestMapping("<#if package.ModuleName??>/${package.ModuleName}</#if>/<#if controllerMappingHyphenStyle??>${controllerMappingHyphen}<#else>${table.entityPath}</#if>")
<#if kotlin>class ${table.controllerName}<#if superControllerClass??>:${superControllerClass}()</#if><#else><#if superControllerClass??>public class ${table.controllerName} extends ${superControllerClass}{<#else>public class ${table.controllerName} {</#if>

<#--    private Logger log = LoggerFactory.getLogger(getClass());-->
    @Autowired
    private ${table.serviceName} ${(table.serviceName?substring(0))?uncap_first};


    @ApiOperation(value = "新增${table.comment!}")
    @PostMapping()
    public CommonResult add(@RequestBody ${entity} recode){

         ${(table.serviceName?substring(0))?uncap_first}.add(recode);
         return  CommonResult.success("添加成功");
    }

    @ApiOperation(value = "删除${table.comment!}")
    @DeleteMapping("{id}")
    public CommonResult delete(@PathVariable("id") Long id){
       ${(table.serviceName?substring(0))?uncap_first}.delete(id);
       return  CommonResult.success("删除成功");
    }

    @ApiOperation(value = "更新${table.comment!}")
    @PutMapping()
    public CommonResult update(@RequestBody ${entity} recode){

          ${(table.serviceName?substring(0))?uncap_first}.updateData(recode);
          return  CommonResult.success("修改成功");
    }

    @GetMapping("list")
    public CommonResult<IPage<${entity}>>  findListByPage(@RequestParam(value = "pageSize" ,defaultValue = "10" ,required = false) Integer pageSize ,
                                        @RequestParam(value = "pageNum" ,defaultValue = "1" ,required = false) Integer pageNum ,
                                        ${entity} recode){

        return  CommonResult.success( ${(table.serviceName?substring(0))?uncap_first}.findListByPage(pageSize, pageSize,recode));
    }

    @ApiOperation(value = "id查询${table.comment!}")
    @GetMapping("{id}")
    public CommonResult<${entity}> findById(@PathVariable Long id){
        return CommonResult.success( ${(table.serviceName?substring(0))?uncap_first}.findById(id));
    }

}
</#if>