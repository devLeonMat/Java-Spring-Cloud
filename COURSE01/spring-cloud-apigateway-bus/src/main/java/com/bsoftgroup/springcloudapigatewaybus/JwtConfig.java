package com.bsoftgroup.springcloudapigatewaybus;

import org.springframework.beans.factory.annotation.Value;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtConfig {

	@Value("${security.jwt.uri:/security/**}")
	private String Uri;
	@Value("${security.jwt.header:Authorization}")
	private String header;
	@Value("${security.jwt.prefix:Bearer }")
	private String prefix;
	@Value("${security.jwt.expiration:#{1*60*60}}")
	private int expiration;
	@Value("${security.jwt.secret:JwtSecretKey}")
	private String secret;
	
}
