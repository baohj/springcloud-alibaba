//package com.tjgx.order;
//
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.*;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//
///**
//*@Description:
//*@Author: 鲍红建
//*@date: 2020/11/5
//*/
//public class GeneratorCodeConfig {
//
//    //多个用逗号分隔
//    private static String tablename = "sys_operation_log";
//
//    public static void main(String[] args) {
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//        GlobalConfig gc = new GlobalConfig();
//        String projectPath = "D:\\workSpace\\pfc-ms-sys\\micro-sys-server";
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
//        dsc.setUrl("jdbc:mysql://rm-2zep31ce52217wr58.mysql.rds.aliyuncs.com:3306/performance_db?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai");
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        dsc.setUsername("performance");
//        dsc.setPassword("KxAtjHrOR%kwvg2U");
//        mpg.setDataSource(dsc);
//
//        /**
//         * 包配置，指定生成文件所在的目录
//         */
//        PackageConfig pc = new PackageConfig();
//        pc.setParent("com.tojoy.pfc.sys.module");
//        pc.setModuleName("sysOperationLog");
//        pc.setEntity("domain");
//        pc.setMapper("mapper");
//        pc.setService("service");
//        pc.setServiceImpl("service.impl");
//        pc.setController("api");
//        pc.setXml("mapper.xml");
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
//
//
//     <dependency>
//            <groupId>com.baomidou</groupId>
//            <artifactId>mybatis-plus-generator</artifactId>
//            <version>3.4.1</version>
//        </dependency>
//
//        <dependency>
//            <groupId>org.apache.velocity</groupId>
//            <artifactId>velocity-engine-core</artifactId>
//            <version>2.2</version>
//        </dependency>
//}
