package greekn.io.config;

import com.github.pagehelper.PageInterceptor;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @author Greekn
 * @version 0.1
 * @date 2020-10-18 21:47
 * @package greekn.io.config
 * @modified Greekn
 * @description
 */
@Configuration
@MapperScan(basePackages = "greekn.io")
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class PersistenceConfig {

    @Value("${jdbc.driverClassName}")
    public String driverClassName;
    @Value("${jdbc.url}")
    public String url;
    @Value("${jdbc.username}")
    public String username;
    @Value("${jdbc.password}")
    public String password;

    @Bean
    public DataSource dataSource() {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaximumPoolSize(20);
        dataSource.setIdleTimeout(60000);
        dataSource.setMaxLifetime(600000);
        dataSource.setMinimumIdle(10);
        dataSource.setLeakDetectionThreshold(5000);
        dataSource.setConnectionTimeout(60000);
        dataSource.setValidationTimeout(3000);
        return dataSource;
    }

    /**
     * 配置mybatis和pagehelper
     *
     * @param dataSource
     * @return
     * @throws IOException
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setTypeAliasesPackage("greekn.io.**.*Entity");
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:mappers/**/*.xml"));
        PageInterceptor pageInterceptor = new PageInterceptor();
        sqlSessionFactory.setPlugins(new Interceptor[]{ pageInterceptor });
        return sqlSessionFactory;
    }

}
