package com.globallogic.car.dashboard.security;

import static com.globallogic.car.dashboard.controller.TokenController.TOKEN;
import static java.util.Collections.emptyList;

import java.util.Optional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
	}

	@Override
	protected UserDetails retrieveUser(String userName, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
		Object token = usernamePasswordAuthenticationToken.getCredentials();
		if (!Optional.ofNullable(token).map(String::valueOf).get().equals(TOKEN)) {
			new UsernameNotFoundException("Cannot find user with authentication token=" + token);
		}
		return new User("user", "password", emptyList());
	}
}