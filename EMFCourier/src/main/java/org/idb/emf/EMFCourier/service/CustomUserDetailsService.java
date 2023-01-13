package org.idb.emf.EMFCourier.service;

import org.idb.emf.EMFCourier.entity.CustomUserDetails;
import org.idb.emf.EMFCourier.entity.SenderDetails;
import org.idb.emf.EMFCourier.repository.SenderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    SenderDetailsRepository senderDetailsRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        SenderDetails u= senderDetailsRepository.findByEmail(email);
        if(u==null){
            throw new UsernameNotFoundException("This email id not found");
        }

        return new CustomUserDetails(u);
    }



}
