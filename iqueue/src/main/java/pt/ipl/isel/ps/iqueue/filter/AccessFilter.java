package pt.ipl.isel.ps.iqueue.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Set common Response Headers values:
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Headers", "Authorization");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type");

        if (request.getMethod() != "DELETE")
            response.addHeader("Content-Type", "application/json");

        filterChain.doFilter(request, response);
    }
}
