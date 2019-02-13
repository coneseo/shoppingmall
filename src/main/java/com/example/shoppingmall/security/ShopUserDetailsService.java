package com.example.shoppingmall.security;

import com.example.shoppingmall.domain.Role;
import com.example.shoppingmall.domain.User;
import com.example.shoppingmall.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class ShopUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = false)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(email);

        if(user == null)
            throw new UsernameNotFoundException(email + "의 사용자 없다.");

        List<GrantedAuthority> authorities = new ArrayList<>();
        Set<Role> roles = user.getRoles();
        for(Role role : roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }
        SecurityUser securityUser = new SecurityUser(email, user.getPassword(), authorities);
        securityUser.setId(user.getId());
        securityUser.setName(user.getName());
        securityUser.setName((user.getNickname()));
        return securityUser;
    }
}
