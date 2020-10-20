package greekn.io.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * <p>
 *
 * </p>
 *
 * @author Greekn
 * @version 0.1
 * @date 2020-10-19 0:27
 * @package greekn.io.config
 * @modified Greekn
 * @description
 */
@Configuration
@PropertySource("classpath:db.properties")
public class RedisConfig {

    @Value("${redis.host}")
    private String host;
    @Value("${redis.port}")
    private Integer port;

    /**
     * lettuce工厂bean
     *
     * @return LettuceConnectionFactory
     */
    @Bean
    public LettuceConnectionFactory connectionFactory() {
        return new LettuceConnectionFactory(standaloneConfiguration(), clientConfiguration());
    }

    /**
     * 单节点redis配置
     *
     * @return RedisStandaloneConfiguration
     */
    private RedisStandaloneConfiguration standaloneConfiguration() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(host);
        configuration.setPort(port);
        return configuration;
    }

    private LettuceClientConfiguration clientConfiguration() {
        return LettuceClientConfiguration.builder().commandTimeout(Duration.ofSeconds(30)).build();
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(LettuceConnectionFactory connectionFactory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setDefaultSerializer(stringRedisSerializer);
        return redisTemplate;
    }

}
