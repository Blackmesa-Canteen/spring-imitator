package constant;

/**
 * 定义一个名为 ConfigConstant 的常量接口, 让它来维护配置文件中相关的配置项名称
 */
public interface ConfigConstant {

    // configuration file name
    String CONFIG_FILE_NAME = "imitator.properties";

    // db configs
    String JDBC_DRIVER = "imitator.framework.jdbc.driver";
    String JDBC_URL = "imitator.framework.jdbc.url";
    String JDBC_USERNAME = "imitator.framework.jdbc.username";
    String JDBC_PASSWORD = "imitator.framework.jdbc.password";

    // key locations
    String APP_BASE_PACKAGE_PATH = "imitator.framework.app.base_package";
    String APP_JSP_PATH = "imitator.framework.jsp_path";
    String APP_ASSET_PATH = "imitator.framework.asset_path";
}
