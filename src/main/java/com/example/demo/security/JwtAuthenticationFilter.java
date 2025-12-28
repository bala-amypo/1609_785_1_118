// package com.example.demo.security;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

// import java.io.IOException;

// @Component
// public class JwtAuthenticationFilter extends OncePerRequestFilter {

//     @Autowired
//     private JwtTokenProvider jwtTokenProvider;

//     @Autowired
//     private CustomUserDetailsService userDetailsService; // Your UserDetailsService

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
//                                   FilterChain filterChain) throws ServletException, IOException {
//         String token = getTokenFromRequest(request);

//         if (token != null && jwtTokenProvider.validateToken(token)) {
//             // Extract username from JWT
//             String username = jwtTokenProvider.getUsernameFromToken(token);

//             // Load user details
//             var userDetails = userDetailsService.loadUserByUsername(username);

//             // Create Authentication object
//             UsernamePasswordAuthenticationToken auth =
//                     new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

//             // Set authentication in SecurityContext
//             SecurityContextHolder.getContext().setAuthentication(auth);
//         }

//         filterChain.doFilter(request, response);
//     }

//     private String getTokenFromRequest(HttpServletRequest request) {
//         String bearerToken = request.getHeader("Authorization");
//         if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//             return bearerToken.substring(7);
//         }
//         return null;
//     }
// }
// package com.example.demo.security;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

// import java.io.IOException;

// @Component
// public class JwtAuthenticationFilter extends OncePerRequestFilter {

//     @Autowired
//     private JwtTokenProvider jwtTokenProvider;

//     @Autowired
//     private CustomUserDetailsService userDetailsService;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
//                                     FilterChain filterChain) throws ServletException, IOException {

//         String path = request.getRequestURI();

//         // ✅ Skip JWT validation for public endpoints
//         if (path.startsWith("/auth/") || path.startsWith("/v3/api-docs") || path.startsWith("/swagger-ui")) {
//             filterChain.doFilter(request, response);
//             return;
//         }

//         String token = getTokenFromRequest(request);

//         if (token != null && jwtTokenProvider.validateToken(token)) {
//             String username = jwtTokenProvider.getUsernameFromToken(token);

//             var userDetails = userDetailsService.loadUserByUsername(username);

//             UsernamePasswordAuthenticationToken auth =
//                     new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

//             SecurityContextHolder.getContext().setAuthentication(auth);
//         }

//         filterChain.doFilter(request, response);
//     }

//     private String getTokenFromRequest(HttpServletRequest request) {
//         String bearerToken = request.getHeader("Authorization");
//         if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//             return bearerToken.substring(7);
//         }
//         return null;
//     }
// }



package com.example.demo.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                    HttpServletResponse response, 
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            // 1. Get the Authorization Header
            String authHeader = request.getHeader("Authorization");
            String jwt = null;
            String username = null;

            // 2. Check if the header is present and starts with Bearer
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                jwt = authHeader.substring(7);
                
                // 3. Extract username (ensure your TokenProvider handles null/invalid tokens gracefully)
                username = jwtTokenProvider.extractUsername(jwt);
            }

            // 4. If we have a username and the user is not yet authenticated
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

                // 5. If the token is valid, set the security context
                if (jwtTokenProvider.isTokenValid(jwt, userDetails)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails, 
                            null, 
                            userDetails.getAuthorities()
                    );
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    
                    // Set the user as authenticated
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        } catch (Exception e) {
            // Log the error for debugging but don't stop the filter chain
            // This prevents the "500 Internal Server Error" if a token is malformed
            System.out.println("JWT Authentication Error: " + e.getMessage());
        }

        // 6. Always continue the filter chain
        filterChain.doFilter(request, response);
    }
}