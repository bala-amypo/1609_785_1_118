// // // package com.example.demo.security;

// // // import jakarta.servlet.FilterChain;
// // // import jakarta.servlet.ServletException;
// // // import jakarta.servlet.http.HttpServletRequest;
// // // import jakarta.servlet.http.HttpServletResponse;
// // // import org.springframework.beans.factory.annotation.Autowired;
// // // import org.springframework.stereotype.Component;
// // // import org.springframework.web.filter.OncePerRequestFilter;
// // // import org.springframework.security.core.context.SecurityContextHolder;
// // // import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

// // // import java.io.IOException;

// // // @Component
// // // public class JwtAuthenticationFilter extends OncePerRequestFilter {

// // //     @Autowired
// // //     private JwtTokenProvider jwtTokenProvider;

// // //     @Autowired
// // //     private CustomUserDetailsService userDetailsService; // Your UserDetailsService

// // //     @Override
// // //     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, 
// // //                                   FilterChain filterChain) throws ServletException, IOException {
// // //         String token = getTokenFromRequest(request);

// // //         if (token != null && jwtTokenProvider.validateToken(token)) {
// // //             // Extract username from JWT
// // //             String username = jwtTokenProvider.getUsernameFromToken(token);

// // //             // Load user details
// // //             var userDetails = userDetailsService.loadUserByUsername(username);

// // //             // Create Authentication object
// // //             UsernamePasswordAuthenticationToken auth =
// // //                     new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

// // //             // Set authentication in SecurityContext
// // //             SecurityContextHolder.getContext().setAuthentication(auth);
// // //         }

// // //         filterChain.doFilter(request, response);
// // //     }

// // //     private String getTokenFromRequest(HttpServletRequest request) {
// // //         String bearerToken = request.getHeader("Authorization");
// // //         if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
// // //             return bearerToken.substring(7);
// // //         }
// // //         return null;
// // //     }
// // // }
// // // package com.example.demo.security;

// // // import jakarta.servlet.FilterChain;
// // // import jakarta.servlet.ServletException;
// // // import jakarta.servlet.http.HttpServletRequest;
// // // import jakarta.servlet.http.HttpServletResponse;
// // // import org.springframework.beans.factory.annotation.Autowired;
// // // import org.springframework.stereotype.Component;
// // // import org.springframework.web.filter.OncePerRequestFilter;
// // // import org.springframework.security.core.context.SecurityContextHolder;
// // // import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

// // // import java.io.IOException;

// // // @Component
// // // public class JwtAuthenticationFilter extends OncePerRequestFilter {

// // //     @Autowired
// // //     private JwtTokenProvider jwtTokenProvider;

// // //     @Autowired
// // //     private CustomUserDetailsService userDetailsService;

// // //     @Override
// // //     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
// // //                                     FilterChain filterChain) throws ServletException, IOException {

// // //         String path = request.getRequestURI();

// // //         // ✅ Skip JWT validation for public endpoints
// // //         if (path.startsWith("/auth/") || path.startsWith("/v3/api-docs") || path.startsWith("/swagger-ui")) {
// // //             filterChain.doFilter(request, response);
// // //             return;
// // //         }

// // //         String token = getTokenFromRequest(request);

// // //         if (token != null && jwtTokenProvider.validateToken(token)) {
// // //             String username = jwtTokenProvider.getUsernameFromToken(token);

// // //             var userDetails = userDetailsService.loadUserByUsername(username);

// // //             UsernamePasswordAuthenticationToken auth =
// // //                     new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

// // //             SecurityContextHolder.getContext().setAuthentication(auth);
// // //         }

// // //         filterChain.doFilter(request, response);
// // //     }

// // //     private String getTokenFromRequest(HttpServletRequest request) {
// // //         String bearerToken = request.getHeader("Authorization");
// // //         if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
// // //             return bearerToken.substring(7);
// // //         }
// // //         return null;
// // //     }
// // // }
// // package com.example.demo.security;

// // import jakarta.servlet.FilterChain;
// // import jakarta.servlet.ServletException;
// // import jakarta.servlet.http.HttpServletRequest;
// // import jakarta.servlet.http.HttpServletResponse;
// // import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// // import org.springframework.security.core.context.SecurityContextHolder;
// // import org.springframework.security.core.userdetails.UserDetails;
// // import org.springframework.security.core.userdetails.UserDetailsService;
// // import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// // import org.springframework.stereotype.Component;
// // import org.springframework.web.filter.OncePerRequestFilter;

// // import java.io.IOException;

// // @Component
// // public class JwtAuthenticationFilter extends OncePerRequestFilter {

// //     @Autowired
// //     private JwtTokenProvider jwtTokenProvider;

// //     @Autowired
// //     private UserDetailsService userDetailsService;

// //     @Override
// //     protected void doFilterInternal(
// //             HttpServletRequest request,
// //             HttpServletResponse response,
// //             FilterChain filterChain)
// //             throws ServletException, IOException {

// //         String path = request.getServletPath();

// //         // ✅ IMPORTANT: Skip JWT check for Auth and Swagger paths
// //         // This ensures the filter doesn't block "permitAll" URLs
// //         if (path.contains("/auth") || 
// //             path.contains("/swagger-ui") || 
// //             path.contains("/v3/api-docs") || 
// //             path.contains("/webjars")) {
// //             filterChain.doFilter(request, response);
// //             return;
// //         }

// //         String authHeader = request.getHeader("Authorization");

// //         if (authHeader == null || !authHeader.startsWith("Bearer ")) {
// //             filterChain.doFilter(request, response);
// //             return;
// //         }

// //         String jwt = authHeader.substring(7);
// //         String username;

// //         try {
// //             username = jwtTokenProvider.extractUsername(jwt);
// //         } catch (Exception e) {
// //             // Token invalid or expired, move to next filter
// //             filterChain.doFilter(request, response);
// //             return;
// //         }

// //         if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
// //             UserDetails userDetails = userDetailsService.loadUserByUsername(username);

// //             if (jwtTokenProvider.isTokenValid(jwt, userDetails)) {
// //                 UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
// //                                 userDetails, null, userDetails.getAuthorities());

// //                 authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
// //                 SecurityContextHolder.getContext().setAuthentication(authToken);
// //             }
// //         }

// //         filterChain.doFilter(request, response);
// //     }
// // }
// package com.example.demo.security;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import java.io.IOException;

// @Component
// public class JwtAuthenticationFilter extends OncePerRequestFilter {

//     @Autowired private JwtTokenProvider jwtTokenProvider;
//     @Autowired private UserDetailsService userDetailsService;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {

//         String path = request.getServletPath();

//         // ✅ BYPASS SECURITY FOR SWAGGER AND AUTH
//         if (path.contains("/auth") || path.contains("/v3/api-docs") || path.contains("/swagger-ui")) {
//             filterChain.doFilter(request, response);
//             return;
//         }

//         String authHeader = request.getHeader("Authorization");
//         if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//             filterChain.doFilter(request, response);
//             return;
//         }

//         String jwt = authHeader.substring(7);
//         try {
//             String username = jwtTokenProvider.extractUsername(jwt);
//             if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                 UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//                 if (jwtTokenProvider.isTokenValid(jwt, userDetails)) {
//                     UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
//                             userDetails, null, userDetails.getAuthorities());
//                     authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                     SecurityContextHolder.getContext().setAuthentication(authToken);
//                 }
//             }
//         } catch (Exception e) {
//             // Silently fail authentication for invalid tokens
//         }

//         filterChain.doFilter(request, response);
//     }
// }
package com.example.demo.config;

import com.example.demo.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // ✅ PUBLIC PATHS
                .requestMatchers("/api/auth/**", "/auth/**").permitAll()
                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html", "/webjars/**").permitAll()
                // ✅ SECURE PATHS
                .anyRequest().authenticated()
            )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}