package com.han.mbg;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

//@SpringBootApplication
public class MbgApplication {

    public static void _main(String[] args) {
        SpringApplication.run(MbgApplication.class, args);
    }

    public static void main(String[] args) {

        //用来获取Mybatis-Plus.properties文件的配置信息
        final ResourceBundle rb = ResourceBundle.getBundle("mybatis-plus");

        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(rb.getString("OutputDir"));
        gc.setOpen(false);
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        gc.setAuthor(rb.getString("author"));
        gc.setFileOverride(true); // 是否覆盖已有文件, 默认false
        gc.setIdType(IdType.AUTO); // 生成主键得id类型
        gc.setEntityName("%sDO");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        gc.setDateType(DateType.ONLY_DATE); // 数据库中的时间类型对应的java类, 此设置表示Date类, 默认是java8的时间类

        gc.setSwagger2(true); //实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl(rb.getString("url"));
        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setDriverName(rb.getString("driverClassName"));
        dsc.setUsername(rb.getString("userName"));
        dsc.setPassword(rb.getString("password"));
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(rb.getString("parent"));
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service" + ".impl");
        pc.setEntity("entiy" +"."+ rb.getString("className"));
        pc.setMapper("mapper" +"."+ rb.getString("className"));
        pc.setXml("XML");

        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return rb.getString("OutputDirXml") + "/mapper/" + rb.getString("className") + "/" + tableInfo.getEntityName() + StringPool.DOT_XML;
            }
        });
//            focList.add(new FileOutConfig("/templates/mapper.java.ftl") {
//                @Override
//                public String outputFile(TableInfo tableInfo) {
//                    // 自定义输入文件名称
//                    return rb.getString("OutputDir") + "/mapperr/" + rb.getString("className") + "/" + tableInfo.getEntityName() + StringPool.DOT_JAVA;
//                }
//            });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
//        templateConfig.setMapper("/templates/mapper.java");
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
//        strategy.setInclude(new String[]{rb.getString("tableName")});
        strategy.setInclude(new String[]{
                "base"
        });


//        strategy.setEntityTableFieldAnnotationEnable(true); // 为实体类的类上加@TableName, 所有字段上加注解
        strategy.setControllerMappingHyphenStyle(false); // RequestMapping种的驼峰是否转成用"-"连接, 默认是false
//        strategy.setTablePrefix("t_"); // 按照表名生成实体类时去掉表名前面的"t_"前缀
        // strategy.setLogicDeleteFieldName("deleted"); // 数据库中表示逻辑删除的字段名
        // strategy.setVersionFieldName("version"); // 数据库中表示乐观锁版本号的字段名

        strategy.setRestControllerStyle(true); // 加上@RestController注解
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名转换方式: 数据库中的下划线转成java驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); // 列名转换方式
        strategy.setEntityLombokModel(true);// 自动加上lombok注解


        // 自动填充配置: 插入时间, 最后一次更新时间
        ArrayList<TableFill> tableFills = new ArrayList<>();
//        TableFill gmtCreate = new TableFill("created", FieldFill.INSERT); // 插入时改变的时间纪录, created为表的字段名
//        TableFill gmtModified = new TableFill("updated", FieldFill.INSERT_UPDATE); // 最后一次更新时updated表字段的时间记录
//        tableFills.add(gmtCreate);
//        tableFills.add(gmtModified);
        strategy.setTableFillList(tableFills);

        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        mpg.execute();
    }

}
