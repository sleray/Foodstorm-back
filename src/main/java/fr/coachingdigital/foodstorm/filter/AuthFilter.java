package fr.coachingdigital.foodstorm.filter;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import fr.coachingdigital.foodstorm.service.AuthService;

@Component
@Order(1)
public class AuthFilter implements Filter {

	private static String BEARER = "Bearer";

	@Autowired
	AuthService authService;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
			throws IOException, ServletException {

		final HttpServletRequest httpRequest = (HttpServletRequest) request;
		final HttpServletResponse httpResponse = (HttpServletResponse) response;

		if(!HttpMethod.OPTIONS.name().equals(httpRequest.getMethod())){
			final Optional<String> token = Optional.ofNullable(httpRequest.getHeader(HttpHeaders.AUTHORIZATION));

			boolean tokenVerify = false;
			if(token.isPresent() && token.get().startsWith(BEARER)) {

				final String bearerToken = token.get().substring(BEARER.length()+1);

				tokenVerify = authService.verifyToken(bearerToken);

			}
			if(!tokenVerify) {
				//	httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}

		chain.doFilter(httpRequest, httpResponse);
	}

	@Override
	public void init(final FilterConfig filterConfig) throws ServletException {

	}

}
