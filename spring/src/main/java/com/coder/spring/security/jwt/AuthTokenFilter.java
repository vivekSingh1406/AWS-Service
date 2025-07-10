package com.coder.spring.security.jwt;

import java.io.IOException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import com.coder.spring.security.services.UserDetailsServiceImpl;

/**
 * Filter to validate the JWT token and set user authentication in the security context.
 */
public class AuthTokenFilter extends OncePerRequestFilter {

  @Autowired
  private JwtUtils jwtUtils;

  @Autowired
  private UserDetailsServiceImpl userDetailsService;

  private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);


  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
          throws ServletException, IOException {
    try {
      // Parse and validate the JWT token from the request
      String jwt = parseJwt(request);
      if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
        // Get the username from the validated JWT token
        String username = jwtUtils.getUserNameFromJwtToken(jwt);

        // Load user details from the username
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        // Create an authentication token with the user details
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
                userDetails.getAuthorities());

        // Set additional details from the request
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        // Set the authentication in the security context
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    } catch (Exception e) {
      // Log any errors that occur during authentication
      logger.error("Cannot set user authentication: {}", e);
    }

    // Continue the filter chain
    filterChain.doFilter(request, response);
  }

  private String parseJwt(HttpServletRequest request) {
    // Get the Authorization header from the request
    String headerAuth = request.getHeader("Authorization");

    // Check if the header is valid and starts with "Bearer "
    if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
      // Extract the JWT token from the header
      return headerAuth.substring(7);
    }

    return null; // Return null if no valid token is found
  }
}
