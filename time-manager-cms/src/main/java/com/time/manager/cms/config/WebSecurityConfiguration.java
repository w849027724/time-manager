package com.time.manager.cms.config;

import com.time.manager.cms.security.AuthPermitUrlConfig;
import com.time.manager.cms.security.AuthenticationFailHandler;
import com.time.manager.cms.security.AuthenticationSuccessHandler;
import com.time.manager.cms.security.MyAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.annotation.Resource;

/**
 * @author wlj
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    public static final String LOGIN_PROCESSING_URL = "/auth/login";
    @Resource
    private UserDetailsService timeManagerUserDetailsService;

    @Resource
    private MyAuthenticationFilter myAuthenticationFilter;

    @Resource
    private AuthPermitUrlConfig authPermitUrlConfig;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return new AuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationFailHandler authenticationFailHandler() {
        return new AuthenticationFailHandler();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义UserDetailsService
        auth
                .userDetailsService(timeManagerUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //表单登录方式
                .formLogin()
                //登录请求url
                .loginProcessingUrl("/login").permitAll()
                .usernameParameter("userName")
                .passwordParameter("userPassword")
                //成功处理类
                .successHandler(authenticationSuccessHandler())
                .failureHandler(authenticationFailHandler())
                .and()
                .logout().disable()
                .httpBasic().disable()
                .csrf().disable()
                .cors()
                .and()
                //关闭session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(myAuthenticationFilter, FilterSecurityInterceptor.class);

        // 禁用csrf防御机制(跨域请求伪造)，这么做在测试和开发会比较方便。
        http.csrf().disable();

        //允许使用iframe 嵌套，避免swagger-ui 不被加载的问题
        http.headers().frameOptions().disable();
        // 添加忽略路径
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();
        authPermitUrlConfig.getIgnoreUrls().forEach(e -> {
            registry.antMatchers(e).permitAll();
        });
        registry.anyRequest().authenticated().and().csrf().disable();

    }

    @Override
    public void configure(WebSecurity web) {
        // AuthenticationTokenFilter will ignore the below paths
        web.ignoring()
                .antMatchers(HttpMethod.GET,
                        "/swagger-ui.html",
                        "/swagger-resources/**",
                        "/swagger/**",
                        "/webjars/springfox-swagger-ui/**",
                        "/**/v2/api-docs",
                        "/favicon.ico",
                        "/error",
                        "/**/favicon.ico",
                        "/*.html",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/**/*.map",
                        "/actuator/**");
    }


}
