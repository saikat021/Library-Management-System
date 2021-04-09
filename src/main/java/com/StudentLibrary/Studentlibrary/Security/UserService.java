package com.StudentLibrary.Studentlibrary.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(s);
        if (user==null)
            throw new UsernameNotFoundException("Username invalid");
        return user;

    }
    public void saveUser(User user){
        userRepository.save(user);
    }
}
