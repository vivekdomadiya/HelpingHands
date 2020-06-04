package com.helpingHands.Security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {
		
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted())
			return;
	
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	protected String determineTargetUrl(Authentication authentication) {

		boolean isDonor = false;
		boolean isReceiver = false;
		boolean isAdmin = false;

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ROLE_DONOR")) {
				isDonor = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_RECEIVER")) {
				isReceiver = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
				isAdmin = true;
				break;
			}
		}

		if (isDonor) {
			return "/donor/";
		} else if (isReceiver) {
			return "/receiver/";
		} else if (isAdmin) {
			return "/admin/";
		} else {
			throw new IllegalStateException();
		}
	}

}
