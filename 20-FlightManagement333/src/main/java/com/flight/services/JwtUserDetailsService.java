package com.flight.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

//	@Autowired
//	private CustomerRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		Customer cus = repo.findById(username);
//		return new User(cus.getUsername(), cus.getPassword(), null);
		if("admin".equals(username)) {
			Set<SimpleGrantedAuthority> authorities = new HashSet<>();
	        authorities.add(new SimpleGrantedAuthority("ROLE_" + "ADMIN"));

//			return new User("admin", "{noop}admin@123", authorities);
//			return new User("admin", "{bcrypt}$2a$10$ECmy69y3AUynkQtUo.P1n.0Fv/A3q2SHDXjy55AMaU0Fyc4okZOu2", authorities);
			return new User("admin", "$2a$10$ECmy69y3AUynkQtUo.P1n.0Fv/A3q2SHDXjy55AMaU0Fyc4okZOu2", authorities);
		}  else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}