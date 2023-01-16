package org.idb.emf.EMFCourier.entity;

import org.idb.emf.EMFCourier.repository.SenderDetailsRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {
    private SenderDetails u;

    public CustomUserDetails(SenderDetails u) {
        this.u = u;
    }

    private SenderDetailsRepository repo;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(u.getRole());

        return Collections.singletonList(simpleGrantedAuthority);

        // user role-----> USER, ADMIN, SALES
//        Set<Role> roles = u.getRoles();
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//
//        for (Role role : roles) {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//
//        return authorities;

    }

    @Override
    public String getPassword() {
        return u.getPassword();
    }

    @Override
    public String getUsername() {
        return u.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }




    @Override

    public boolean isEnabled() { // Our Task for 7-01-22

        return u.isEnabled();
    }
}

