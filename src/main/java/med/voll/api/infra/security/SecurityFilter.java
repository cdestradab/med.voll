package med.voll.api.infra.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    //Lo inmeditamente siguiente es mejor hacerlo a nivel de constructor
    //Pero se deja así con fines didácticos
    @Autowired
    private TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Obtener token del header
        var token = request.getHeader("Authorization");//.replace("Bearer ", "");
        if (token == null || token == "") {
            throw new RuntimeException("El token enviado no es válido");
        }
        token = token.replace("Bearer ", "");
        System.out.println(token);

        System.out.println(tokenService.getSubject(token));

        filterChain.doFilter(request, response);
    }
}
