package com.arun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

public class JwtGetRole  implements Converter<Jwt, Collection<GrantedAuthority>> {

	@Override
	public Collection<GrantedAuthority> convert(Jwt jwt) {
		Map<String, Object> realmeAccess =  jwt.getClaimAsMap("realm_access");
		if(realmeAccess == null || realmeAccess.isEmpty()) 
			return new ArrayList<>();
		
		Collection<GrantedAuthority> value = ((List<String>) realmeAccess.get("roles")).stream()
					.map(x -> "ROLE_"+x).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		return value;
	}

}
