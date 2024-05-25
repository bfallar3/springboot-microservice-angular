package ph.benjsoft.microservice.with.angular.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ph.benjsoft.microservice.with.angular.filter.CorsFilter;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<CorsFilter> myCorsFilter() {
        FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CorsFilter());
        registrationBean.addUrlPatterns("/api/**");
        registrationBean.setOrder(1);

        return registrationBean;
    }
}
