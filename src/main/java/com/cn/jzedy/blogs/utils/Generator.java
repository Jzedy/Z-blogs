package com.cn.jzedy.blogs.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.sql.Driver;

/**
 * @author Jzedy
 * @time 19-6-3
 * @description
 */
public class Generator {


    public static void main(String[] args) {
        String [] tableNames =new String [] {"users"};
        String location = "com.cn.jzedy.blogs";
        String author = "Jzedy";
        generator(location, author,tableNames);
    }

    private static void generator(String location, String author,String[] tableNames) {
        GlobalConfig globalConfig = new GlobalConfig();// 全局配置
        globalConfig.setOpen(false)//是否打开输出目录 默认true
                .setOutputDir(System.getProperty("user.dir")+"/src/main/java")//生成文件的输出目录
                .setFileOverride(true)//是否覆盖已有文件 默认false
//                .setBaseResultMap(true)//开启 BaseResultMap 默认false
//                .setBaseColumnList(true)//开启 baseColumnList 默认false
                .setActiveRecord(false)//开启 ActiveRecord 模式 默认false
                .setAuthor(author)//开发人员
                .setDateType(DateType.ONLY_DATE)
                .setServiceName("%sService");//service 命名方式 例如：%sBusiness 生成 UserBusiness


        DataSourceConfig dataSourceConfig = new DataSourceConfig();// 数据源配置
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName(Driver.class.getName())
                .setUsername("root")
                .setPassword("root")
                .setUrl("jdbc:mysql:///z-blogs?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&allowMultiQueries=true");

        PackageConfig packageConfig = new PackageConfig();// 包配置
        packageConfig.setParent(location)
                .setEntity("model")//Entity包名
                .setMapper("mapper")//mapper包名
                .setService("service")
                .setController("web");

        StrategyConfig strategyConfig = new StrategyConfig();// 策略配置
        strategyConfig
                .setCapitalMode(true)//驼峰命名
                .setEntityLombokModel(true)//【实体】是否为lombok模型（默认 false）
                .setRestControllerStyle(false)//生成 @RestController 控制器
                .setNaming(NamingStrategy.underline_to_camel)//数据库表映射到实体的命名策略,该处下划线转驼峰命名
                .setInclude(tableNames);//需要包含的表名，允许正则表达式（与exclude二选一配置）

        TemplateConfig tc = new TemplateConfig();

//        tc.setServiceImpl(null);
//        tc.setService(null);

        new AutoGenerator()//// 代码生成器
                .setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setPackageInfo(packageConfig)
                .setStrategy(strategyConfig)
                .setTemplate(tc)
                .execute();

    }
}
