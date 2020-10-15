package xyz.lwz;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * 运行此方法生成mybatis代码
 * 生成代码自动放入对应目录
 *
 * @author liwz
 * @date 2020/10/14 22:40
 */
public class CodeGenerator {

    /**
     * 数据库类型
     */
    private static final DbType DB_TYPE = DbType.MYSQL;

    /**
     * 数据库连接信息
     */
    private static final String DB_URL = "jdbc:mysql://47.100.185.35:3306/blog?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&useSSL=false&allowPublicKeyRetrieval=true" ;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver" ;
    private static final String USERNAME = "root" ;
    private static final String PASSWORD = "dytqce94lwz" ;

    /**
     * 项目地址
     */
    private static final String PROJECT_PATH = "E:/code-github/study/" ;

    /**
     * 项目名
     */
    private static final String PROJECT_NAME = "spring-cloud-alibaba-demo/mybatis-plus-generator" ;

    /**
     * 指定包名
     */
    private static final String PACKAGE_NAME = "xyz.lwz" ;

    /**
     * controller基础类
     */
    private static final String SUPER_CONTROLLER_CLASS = PACKAGE_NAME + ".common.BaseController" ;

    /**
     * service基础类
     */
    private static final String SUPER_SERVICE_CLASS = PACKAGE_NAME + ".common.BaseService" ;

    /**
     * entity基础类
     */
    private static final String SUPER_ENTITY_CLASS = PACKAGE_NAME + ".common.BaseEntity" ;

    /**
     * 作者名
     */
    private static final String AUTHOR = "liwz" ;

    /**
     * 指定生成的表名
     */
    private static final String[] TABLE_NAMES = new String[]{"user"};

    public static void main(String[] args) {
        // serviceNameStartWithI：user -> UserService, 设置成true: user -> IUserService
        new CodeGenerator().generateByTables(TABLE_NAMES);
    }

    /**
     * 根据表自动生成
     *
     * @param tableNames 表名
     * @author Terry
     */
    private void generateByTables(String... tableNames) {
        // 配置数据源
        DataSourceConfig dataSourceConfig = getDataSourceConfig();
        // 策略配置
        StrategyConfig strategyConfig = getStrategyConfig(tableNames);
        // 全局变量配置
        GlobalConfig globalConfig = getGlobalConfig();
        // 包名配置
        PackageConfig packageConfig = getPackageConfig();
        // 自动生成
        autoGenerator(dataSourceConfig, strategyConfig, globalConfig, packageConfig);
    }

    /**
     * 集成
     *
     * @param dataSourceConfig 配置数据源
     * @param strategyConfig   策略配置
     * @param config           全局变量配置
     * @param packageConfig    包名配置
     * @author Terry
     */
    private void autoGenerator(DataSourceConfig dataSourceConfig, StrategyConfig strategyConfig, GlobalConfig config, PackageConfig packageConfig) {
        new AutoGenerator()
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    /**
     * 设置包名
     *
     * @return PackageConfig 包名配置
     * @author Terry
     */
    private PackageConfig getPackageConfig() {
        return new PackageConfig()
                .setParent(PACKAGE_NAME)
                .setXml("mapper.xml" )
                .setMapper("mapper" )
                .setController("controller" )
                .setEntity("entity" );
    }

    /**
     * 全局配置
     *
     * @return GlobalConfig
     * @author Terry
     */
    private GlobalConfig getGlobalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig
                .setBaseColumnList(true)
                .setBaseResultMap(true)
                // 开启 ActiveRecord 模式
                .setActiveRecord(false)
                // 作者
                .setAuthor(AUTHOR)
                // 设置输出路径
                .setOutputDir(getOutputDir())
                // 是否覆盖已有文件
                .setFileOverride(true)
                // 是否打开输出目录
                .setOpen(false);
        // 设置service名
        globalConfig.setServiceName("%sService" );
        return globalConfig;
    }

    /**
     * 返回项目路径
     *
     * @return 项目路径
     * @author Terry
     */
    private String getOutputDir() {
        return PROJECT_PATH + PROJECT_NAME + "/src/main/java/" ;
    }

    /**
     * 策略配置
     *
     * @param tableNames 表名
     * @return StrategyConfig
     * @author Terry
     */
    private StrategyConfig getStrategyConfig(String... tableNames) {
        return new StrategyConfig()
                // 全局大写命名 ORACLE 注意
                .setCapitalMode(true)
                // 表名生成策略 下划线转驼峰
                .setNaming(NamingStrategy.underline_to_camel)
                // 表字段生成策略 下划线转驼峰
                .setColumnNaming(NamingStrategy.underline_to_camel)
                // 需要生成的的表名，多个表名传数组
                .setInclude(tableNames)
                // 公共父类
//                .setSuperControllerClass(SUPER_CONTROLLER_CLASS)
//                .setSuperServiceClass(SUPER_SERVICE_CLASS)
//                .setSuperEntityClass(SUPER_ENTITY_CLASS)
                // 写于父类中的公共字段
//                .setSuperEntityColumns("id" )
                // 使用lombok
                .setEntityLombokModel(true)
                // rest风格
                .setRestControllerStyle(true);
    }

    /**
     * 配置数据源
     *
     * @return 数据源配置 DataSourceConfig
     * @author Terry
     */
    private DataSourceConfig getDataSourceConfig() {
        return new DataSourceConfig().setDbType(DB_TYPE)
                .setUrl(DB_URL)
                .setUsername(USERNAME)
                .setPassword(PASSWORD)
                .setDriverName(DRIVER);
    }
}
