package com.ocr.clientui.services;

import com.ocr.clientui.beans.CustomerBean;
import com.ocr.clientui.beans.Role;
import com.ocr.clientui.proxies.BookProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CustomerServiceImpl implements UserDetailsService {

@Autowired
    BookProxy bookProxy;

    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        CustomerBean customer = bookProxy.findCustomerByEmail( userName );
        Role role = bookProxy.findCustomerRolesByEmail(customer.getEmail());

        List<GrantedAuthority> authorities = getUserAuthority( role );
        return buildUserForAuthentication( customer, authorities );
    }

    private List<GrantedAuthority> getUserAuthority(Role role ) {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();

        roles.add( new SimpleGrantedAuthority( role.getRole() ) );

        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>( roles );
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication( CustomerBean customer, List<GrantedAuthority> authorities ) {
        return new org.springframework.security.core.userdetails.User( customer.getEmail(), customer.getPassword(),
                customer.isActive(), true, true, true, authorities );
    }

}

