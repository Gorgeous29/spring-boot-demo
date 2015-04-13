package cn.webim;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * 用JavaConfig的方式配置bean
 */
@org.springframework.context.annotation.Configuration
public class Configuration {
    @Value("${webim.datasource.url}")
    private String jdbcUrl;
    @Value("${webim.datasource.username}")
    private String username;
    @Value("${webim.datasource.password}")
    private String password;

    /**
     * 数据源
     */
    @Bean(initMethod = "init", destroyMethod = "close")
    DruidDataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);

        return druidDataSource;
    }
}
