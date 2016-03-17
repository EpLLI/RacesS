package auth;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.academy.it.pojos.User;
import by.academy.it.service.ILoginService;

@Service("authService")
public class AuthenticationService implements UserDetailsService {
	@Autowired
    private ILoginService loginService;
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = loginService.findByUserName(username);
        System.out.println("User : " + user);
        if (user == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        roles.add( new SimpleGrantedAuthority("ROLE_"+user.getRole_id()));
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),roles);
	}

}
