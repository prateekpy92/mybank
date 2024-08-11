package com.techlabs.mybank.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import com.techlabs.mybank.Model.Roles;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    SecurityService securityService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(securityService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .httpBasic()
            .and()
            .authorizeRequests()
                .antMatchers("/application-status", "/admins", "/branches", "/customers", "/requested_accounts", "/requests").permitAll()
                .antMatchers(HttpMethod.GET, "/approve_requested_accounts/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/application-status").hasAnyRole("ADMIN", "CUSTOMER")
                .antMatchers(HttpMethod.POST, "/add/admin").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/add/branch").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/deactivate/branch/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/activate/branch/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/branch/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/update/branch/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/customers/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/add/customerToBranch/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/delete/requested_accounts/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/under_processing/requested_accounts/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/update/customer/**").hasAnyRole("ADMIN", "CUSTOMER")
                .antMatchers(HttpMethod.GET, "/requested_accounts/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/delete/request/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/under_processing/request/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/send_notifications_to_Customer/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/notifications").hasAnyRole("ADMIN", "CUSTOMER")
                .antMatchers(HttpMethod.GET, "/approve/request/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/send_money_to_accNo/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.POST, "/add/requestsOfCustomers/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.GET, "/customer_from_session/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.GET, "/deposit_money/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.GET, "/withdraw_money/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.GET, "/deposited_money/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.GET, "/withdrawal_money/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.GET, "/money_sended/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.GET, "/money_received/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.GET, "/send_money_to_accNo/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.GET, "/seen/noti/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.GET, "/getUnseenNotification/**").hasRole("CUSTOMER")
                .antMatchers(HttpMethod.GET, "/noOfbranches").hasAnyRole("CUSTOMER", "ADMIN")
                .antMatchers(HttpMethod.GET, "/noOfCustomers").hasRole("ADMIN")
                .and()
            .csrf().disable();
    }
}
