//package com.tjgx.order.common;
//
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
//
///**
//*@Description:
//*@Author: 鲍红建
//*@date: 2020/11/5
//*/
//public class GeneratorCodeConfig {
//
//    //多个用逗号分隔
//    private static String tablename = "project";
//
//    public static void main(String[] args) {
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//        GlobalConfig gc = new GlobalConfig();
//        String projectPath = "D:/workSpace/marketing-admin";
//        gc.setOutputDir(projectPath + "/src/main/java");
//        /**
//         *  作者
//         */
//        gc.setAuthor("baohongjian");
//        //生成代码后是否打开文件夹
//        gc.setOpen(false);
//        //实体属性 Swagger2 注解
//        gc.setSwagger2(false);
//        //XML ResultMap
//        gc.setBaseResultMap(true);
//        // XML columList
//        gc.setBaseColumnList(true);
//
//        /**
//         * 自定义文件命名，注意 %s 会自动填充表实体属性！
//         */
//        gc.setControllerName("%sApi");
//        // 设置Service接口生成名称,这样生成接口前面就不会有 I
//        gc.setServiceName("%sService");
//        gc.setServiceImplName("%sServiceImpl");
//        gc.setMapperName("%sMapper");
//        gc.setXmlName("%sMapper");
//        mpg.setGlobalConfig(gc);
//
//        /**
//         * 数据源配置
//         */
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://rm-2zep31ce52217wr58.mysql.rds.aliyuncs.com:3306/marketing_db?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowPublicKeyRetrieval=true");
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        dsc.setUsername("policy_admin");
//        dsc.setPassword("CIM8wgaq^gI$*90OHgv!");
//        mpg.setDataSource(dsc);
//
//        /**
//         * 包配置，指定生成文件所在的目录
//         */
//        PackageConfig pc = new PackageConfig();
//        pc.setParent("com.marketing.admin.module");
//        pc.setModuleName("projectMode");
//        pc.setEntity("domain.test");
//        pc.setMapper("mapper.test");
//        pc.setService("service.test");
//        pc.setServiceImpl("service.impl.test");
//        pc.setController("api.test");
//        pc.setXml("mapper.test.xml");
//        mpg.setPackageInfo(pc);
//        /**
//         * 策略配置
//         */
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setNaming(NamingStrategy.underline_to_camel);
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
//        //支持注解 @RestController
//        strategy.setRestControllerStyle(true);
//        //支持lombok
//        strategy.setEntityLombokModel(true);
//
//
//        //设置表名，多个用逗号分隔
//        strategy.setInclude(tablename);
//        //开启驼峰命名格式
//        strategy.setControllerMappingHyphenStyle(true);
//        //配置表前缀，生成实体时去除表前缀
//        strategy.setTablePrefix(pc.getModuleName());
//        mpg.setStrategy(strategy);
//        mpg.execute();
//    }
//}
