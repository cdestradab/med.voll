package med.voll.api.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    public String generarToken() {
        try {
            Algorithm algorithm = Algorithm.HMAC256("12345");
            String token = JWT.create()
                    .withIssuer("voll med")
                    .withSubject("cdeb")
                    .sign(algorithm);

            return token;
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }
}
