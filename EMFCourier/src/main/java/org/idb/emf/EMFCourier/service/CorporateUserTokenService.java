package org.idb.emf.EMFCourier.service;

import org.idb.emf.EMFCourier.entity.CorporateCustomer;
import org.idb.emf.EMFCourier.entity.CorporateUserDetailes;
import org.idb.emf.EMFCourier.repository.CorporateCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CorporateUserTokenService implements UserDetailsService {

    @Autowired
    CorporateCustomerRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        CorporateCustomer cc= repo.findByccEmail(email);
        if(cc==null){
            throw new UsernameNotFoundException("This email id not found");
        }

        return new CorporateUserDetailes(cc);
    }
}
