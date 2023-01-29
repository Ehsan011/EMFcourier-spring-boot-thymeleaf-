package org.idb.emf.EMFCourier.security;


import org.idb.emf.EMFCourier.service.CorporateUserTokenService;
import org.idb.emf.EMFCourier.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService(){
        return new CustomUserDetailsService();
    }


    @Bean
    public UserDetailsService corporateUser(){
        return new CorporateUserTokenService();
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }



    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService());
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/","/home","/admin","/**","/assets/**","/s_reg_form","/add_sender","/r_reg_form/{send_id}","/add_recipient", "/p_reg_form/{send_id}/{rec_id}","/add_parcel","/cc_save_form", "/all_parcelDetails/{sender_id}/{recipent_id}/{precel_id}")
                .permitAll()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/cb_save_form").hasAnyAuthority("CORPORATE_USER")
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .usernameParameter("email")
//                .defaultSuccessUrl("/")
//                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .permitAll();
//                .and()
//                .exceptionHandling()
//                .accessDeniedPage("/403");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
}
