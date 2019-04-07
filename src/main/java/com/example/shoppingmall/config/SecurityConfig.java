package com.example.shoppingmall.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring()
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                .requestMatchers(new AntPathRequestMatcher("/**.html"))
                .requestMatchers(new AntPathRequestMatcher("/templates/**"))
                .requestMatchers(new AntPathRequestMatcher("/static/**"))
                 .requestMatchers(new AntPathRequestMatcher("/tmp/**"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .logout() // logout설정
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/main")
                .permitAll().and()
                .authorizeRequests() // 인가에 대한 설정
                .antMatchers(HttpMethod.GET,"/api/comments").permitAll()
                .antMatchers(HttpMethod.POST,"/api/comments").permitAll()
                .antMatchers("/users/delete").permitAll()
                .antMatchers("/users/join").permitAll()
                .antMatchers("/users/welcome").permitAll()
                .antMatchers("/users/login").permitAll()
                .antMatchers("/users/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/posts/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/main").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin() // 사용자가 정의하는 로그인 화면을 만들겠다.
                .loginProcessingUrl("/users/login") // 로그인 화면
                .loginPage("/users/login") // 사용자가 입력한 id, password가 전달되는 url경로(필터가처리)
                .usernameParameter("email")
                .passwordParameter("password")
                .failureUrl("/users/login?fail=true").and().csrf().ignoringAntMatchers("/**");;
    }
}
