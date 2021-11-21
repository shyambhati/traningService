package com.technical99.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;

@Configuration
public class CookieConfigration {
	
	@Value("${spring.profiles.active}")
	private String activeProfile;

	@Bean
	public CookieSerializer cookieSerializer() {
		DefaultCookieSerializer serializer = new DefaultCookieSerializer();
		serializer.setCookieName("NODBSESSION");
		serializer.setCookiePath("/");
		if ("dev".equals(activeProfile)) {
			serializer.setDomainName("localhost");
		} else {
			serializer.setDomainName("technical99.com");
			serializer.setUseHttpOnlyCookie(true);
			serializer.setUseSecureCookie(true);
		}
		return serializer;
	}

}
