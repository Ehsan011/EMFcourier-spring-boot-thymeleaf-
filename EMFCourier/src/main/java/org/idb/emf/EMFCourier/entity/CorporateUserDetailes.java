package org.idb.emf.EMFCourier.entity;

import org.idb.emf.EMFCourier.repository.SenderDetailsRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CorporateUserDetailes implements UserDetails {
    private CorporateCustomer ccu;

    public CorporateUserDetailes(CorporateCustomer ccu) {
        this.ccu = ccu;
    }

//    private CorporateCustomer repo;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(ccu.getRole());
        return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return ccu.getCcPassword();
    }

    @Override
    public String getUsername() {
        return ccu.getCcEmail();
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
    public boolean isEnabled() {
        return ccu.isEnabled();
    }
}
