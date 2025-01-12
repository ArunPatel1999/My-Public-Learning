package com.chatapp.secuirty;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JWTUtil {

	  private final String SECRETKEY = "Chat$$App@@ALVV";
	  
	    public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	    }
	    
	    public String extractClass(String token) {
	    	return extractClaim(token, Claims::getIssuer);
	    }

	    public Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }

	    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);
	    }
	    private Claims extractAllClaims(String token) {
	        return Jwts.parser().setSigningKey(SECRETKEY).parseClaimsJws(token).getBody();
	    }

	    private Boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }

	    public String generateToken(UserDetailsImpl userDetails) {
	        Map<String, Object> claims = new HashMap<>();
	        return createToken(claims, userDetails.getUsername(), userDetails.getClassname());
	    }

	    @SuppressWarnings("deprecation")
		private String createToken(Map<String, Object> claims, String subject, String className) {
	    	Date expiredDate = new Date();
	    	expiredDate.setMinutes(expiredDate.getMinutes()+180);
	    	return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
	        		.setExpiration(expiredDate) .setIssuer(className)
	                .signWith(SignatureAlgorithm.HS256, SECRETKEY).compact(); //SignatureAlgorithm.HS512
	    }

	    public Boolean validateToken(String token, UserDetailsImpl userDetails) {
	        final String username = extractUsername(token);
	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	    }
}
