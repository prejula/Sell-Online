/*package org.prej.ecom.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.MDC;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.util.UrlPathHelper;

import com.google.common.base.Optional;

public class AuthenticationTokenProcessingFilter extends GenericFilterBean {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = asHttp(request);
	    HttpServletResponse httpResponse = asHttp(response);

	    Optional username = Optional.fromNullable(httpRequest.getHeader("X-Auth-Username"));
	    Optional password = Optional.fromNullable(httpRequest.getHeader("X-Auth-Password"));
	    Optional token = Optional.fromNullable(httpRequest.getHeader("X-Auth-Token"));

	    String resourcePath = new UrlPathHelper().getPathWithinApplication(httpRequest);

	    try {
	        if (postToAuthenticate(httpRequest, resourcePath)) {
	            logger.debug("Trying to authenticate user {} by X-Auth-Username method", username);
	            processUsernamePasswordAuthentication(httpResponse, username, password);
	            return;
	        }

	        if (token.isPresent()) {
	            logger.debug("Trying to authenticate user by X-Auth-Token method. Token: {}", token);
	            processTokenAuthentication(token);
	        }

	        logger.debug("AuthenticationFilter is passing request down the filter chain");
	        addSessionContextToLogging();
	        chain.doFilter(request, response);
	    } catch (InternalAuthenticationServiceException internalAuthenticationServiceException) {
	        SecurityContextHolder.clearContext();
	        logger.error("Internal authentication service exception", internalAuthenticationServiceException);
	        httpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	    } catch (AuthenticationException authenticationException) {
	        SecurityContextHolder.clearContext();
	        httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, authenticationException.getMessage());
	    } finally {
	        MDC.remove(TOKEN_SESSION_KEY);
	        MDC.remove(USER_SESSION_KEY);
	    }
	}
}*/