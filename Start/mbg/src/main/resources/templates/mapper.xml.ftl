<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">

    <#if enableCache>
        <!-- 开启二级缓存 -->
        <cache type="org.mybatis.caches.ehcache.LoggingEhcache"/>

    </#if>
    <#if baseResultMap>
        <!-- 通用查询映射结果 -->
        <resultMap id="BaseResultMap" type="${package.Entity}.${entity}">
            <#list table.fields as field>
                <#if field.keyFlag><#--生成主键排在第一位-->
                    <id column="${field.name}" property="${field.propertyName}"/>
                </#if>
            </#list>
            <#list table.commonFields as field><#--生成公共字段 -->
                a
                <result column="${field.name}" property="${field.propertyName}"/>
            </#list>
            <#list table.fields as field>
                <#if !field.keyFlag><#--生成普通字段 -->
                    <result column="${field.name}" property="${field.propertyName}"/>
                </#if>
            </#list>
        </resultMap>

    </#if>
    <#if baseColumnList>
        <!-- 通用查询结果列1 -->
        <sql id="Base_Column_List">
            <#list table.commonFields as field>
                ${field.name},
            </#list>
            ${table.fieldNames}
        </sql>
    </#if>


    <#if baseColumnList>
        <!-- 搜索-->
        <select id="select${entity}PrimaryKey"
                resultType="${package.Entity}.${entity}">
                select
                <include refid="Base_Column_List"/>
                from  ${table.name}
                <#if table.fields?? && (table.fields?size>0)>
                <where>
                </#if>
                <#list table.fields as field>
                  <#if field.keyFlag><#--生成主键排在第一位-->
                    <#if field.propertyType == "String">
                      <if test="${field.propertyName} != null and ${field.propertyName} != ''">
                        and  ${field.name} = #${'{'}${field.propertyName}${'}'}
                      </if>
                    </#if>
                    <#if field.propertyType != "String">
                      <if test="${field.propertyName} != null">
                        and  ${field.name} = #${'{'}${field.propertyName}${'}'}
                      </if>
                    </#if>
                  </#if>
                </#list>
                <#if table.fields?? && (table.fields?size>0)>
                </where>
                </#if>
        </select>
    </#if>

    <#if baseColumnList>
        <!-- 刪除-->
        <delete id="del${entity}PrimaryKey">
            delete from  ${table.name}
            <#if table.fields?? && (table.fields?size>0)>
            <where>
            </#if>
            <#list table.fields as field>
              <#if field.keyFlag><#--生成主键排在第一位-->
                <#if field.propertyType == "String">
                 <if test="${field.propertyName} != null and ${field.propertyName} != ''">
                    and  ${field.name} = #${'{'}${field.propertyName}${'}'}
                 </if>
                 </#if>
                 <#if field.propertyType != "String">
                  <if test="${field.propertyName} != null">
                     and  ${field.name} = #${'{'}${field.propertyName}${'}'}
                  </if>
                </#if>
              </#if>
            </#list>
             <#if table.fields?? && (table.fields?size>0)>
            </where>
            </#if>
        </delete>
    </#if>

    <#if baseColumnList>
        <!-- 插入-->
        <insert id="insertSelective"
                parameterType="${package.Entity}.${entity}">
            insert into ${table.name}
            <trim prefix="(" suffix=")" suffixOverrides=",">
                <#list table.fields as field>
<#--                    <#if field.keyFlag>&lt;#&ndash;生成主键排在第一位&ndash;&gt;-->
                        <#if field.propertyType == "String">
              <if test="${field.propertyName} != null and ${field.propertyName} != ''">
                ${field.name},
              </if>
                        </#if>
                        <#if field.propertyType != "String">
              <if test="${field.propertyName} != null">
                ${field.name},
               </if>
                        </#if>
<#--                    </#if>-->
                </#list>
            </trim>
            <trim prefix="values (" suffix=")" suffixOverrides=",">
                <#list table.fields as field>
<#--                    <#if field.keyFlag>&lt;#&ndash;生成主键排在第一位&ndash;&gt;-->
                        <#if field.propertyType == "String">
              <if test="${field.propertyName} != null and ${field.propertyName} != ''">
                #${'{'}${field.propertyName}${'}'},
              </if>
                        </#if>
                        <#if field.propertyType != "String">
              <if test="${field.propertyName} != null">
                #${'{'}${field.propertyName}${'}'},
              </if>
                        </#if>
<#--                    </#if>-->
                </#list>
            </trim>
        </insert>
    </#if>


    <#if baseColumnList>
        <!-- 批量插入-->
        <insert id="bathInsertSelective"
                parameterType="${package.Entity}.${entity}">
            insert into ${table.name}
            <trim prefix="(" suffix=")" suffixOverrides=",">
                <#list table.fields as field>
                <#--                    <#if field.keyFlag>&lt;#&ndash;生成主键排在第一位&ndash;&gt;-->
                    <#if field.propertyType == "String">
                <if test="${field.propertyName} != null and ${field.propertyName} != ''">
                    ${field.name},
                </if>
                    </#if>
                    <#if field.propertyType != "String">
                <if test="${field.propertyName} != null">
                    ${field.name},
                </if>
                    </#if>
                <#--                    </#if>-->
                </#list>
            </trim>
            <foreach collection="list" item="item" index="index" separator=",">
              <trim prefix="values (" suffix=")" suffixOverrides=",">
                <#list table.fields as field>
                <#--                    <#if field.keyFlag>&lt;#&ndash;生成主键排在第一位&ndash;&gt;-->
                    <#if field.propertyType == "String">
                <if test="item.${field.propertyName} != null and item.${field.propertyName} != ''">
                  #${'{item.'}${field.propertyName}${'}'},
                </if>
                    </#if>
                    <#if field.propertyType != "String">
                <if test="${field.propertyName} != null">
                  #${'{item.'}${field.propertyName}${'}'},
                </if>
                    </#if>
                <#--                    </#if>-->
                </#list>
              </trim>
            </foreach>
        </insert>
    </#if>


    <#if baseColumnList>
        <!-- 修改-->
        <update id="update${entity}PrimaryKey" >
            update  ${table.name}
            <set>
            <#list table.fields as field>
                <#if !field.keyFlag><#--生成主键排在第一位-->
                <#if field.propertyType == "String">
                <if test="${field.propertyName} != null and ${field.propertyName} != ''">
                  ${field.name} = #${'{'}${field.propertyName}${'}'},
                 </if>
                </#if>
                <#if field.propertyType != "String">
                <if test="${field.propertyName} != null">
                   ${field.name} = #${'{'}${field.propertyName}${'}'},
                </if>
                </#if>
                </#if>
            </#list>
            </set>
            <#if table.fields?? && (table.fields?size>0)>
            <where>
            </#if>
              <#list table.fields as field>
                <#if field.keyFlag><#--生成主键排在第一位-->
                  <#if field.propertyType == "String">
                  <if test="${field.propertyName} != null and ${field.propertyName} != ''">
                    and  ${field.name} = #${'{'}${field.propertyName}${'}'}
                  </if>
                  </#if>
                  <#if field.propertyType != "String">
                  <if test="${field.propertyName} != null">
                    and  ${field.name} = #${'{'}${field.propertyName}${'}'}
                  </if>
                  </#if>
                </#if>
              </#list>
             <#if table.fields?? && (table.fields?size>0)>
            </where>
            </#if>
        </update>
    </#if>


</mapper>