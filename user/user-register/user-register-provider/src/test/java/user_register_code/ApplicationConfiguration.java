package user_register_code;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = {"org.ndshop.user.common.dao"})
@EnableTransactionManagement(proxyTargetClass = true)
@EnableCaching
@PropertySource({"classpath:config.properties","classpath:corgi.properties"})
@ComponentScan(basePackages = {"user_register_code","org.ndshop.user.common","org.ndshop.user.register"},
        excludeFilters = {@ComponentScan.Filter(
                type = FilterType.ANNOTATION,
                value = {Configuration.class})})
public class ApplicationConfiguration {

}

