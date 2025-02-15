package com.arun.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class NormalControllere {
	
	private OAuth2AuthorizedClientService oAuth2AuthorizedClientService;
	
	public NormalControllere(OAuth2AuthorizedClientService oAuth2AuthorizedClientService) {
		System.out.println("data =>"+oAuth2AuthorizedClientService);
		this.oAuth2AuthorizedClientService = oAuth2AuthorizedClientService;
	}

	@GetMapping
	public String data(Model model) {
		System.out.println("datad d achg");
		model.addAttribute("restData", "");
		model.addAttribute("data", "");
		return "index";
	}
	
	@GetMapping("/all")
	public String firstPage(Model model, @AuthenticationPrincipal OidcUser principel) {
		System.out.println("data");
		Authentication authentication =	SecurityContextHolder.getContext().getAuthentication();
		OAuth2AuthenticationToken oautToken  = (OAuth2AuthenticationToken) authentication;
		OAuth2AuthorizedClient oAuth2AuthorizedClient = oAuth2AuthorizedClientService.loadAuthorizedClient(oautToken.getAuthorizedClientRegistrationId(), oautToken.getName());
		String jwtToken = oAuth2AuthorizedClient.getAccessToken().getTokenValue();
		System.out.println("jwtToken => "+jwtToken);
		
		System.out.println(principel);
		
		OidcIdToken idToken = principel.getIdToken();
		String idTokenValue = idToken.getTokenValue();
		System.out.println("idTokenValue => "+idTokenValue);
	
		RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(jwtToken);
		HttpEntity<String> entity = new HttpEntity<>(headers);
		
		String restData = restTemplate.exchange("http://localhost:8081/check", HttpMethod.GET,entity,String.class).getBody();
		model.addAttribute("restData", restData);
		model.addAttribute("data", getManyData());
		return "index";
	}
	
	
	
	
	private Object getManyData() {
		return "[{\r\n"
				+ "  \"id\": 1,\r\n"
				+ "  \"first_name\": \"Chip\",\r\n"
				+ "  \"last_name\": \"Cressingham\",\r\n"
				+ "  \"email\": \"ccressingham0@boston.com\",\r\n"
				+ "  \"gender\": \"Bigender\",\r\n"
				+ "  \"ip_address\": \"146.221.212.240\"\r\n"
				+ "}, {\r\n"
				+ "  \"id\": 2,\r\n"
				+ "  \"first_name\": \"Tad\",\r\n"
				+ "  \"last_name\": \"Simonel\",\r\n"
				+ "  \"email\": \"tsimonel1@amazon.co.uk\",\r\n"
				+ "  \"gender\": \"Bigender\",\r\n"
				+ "  \"ip_address\": \"104.199.40.100\"\r\n"
				+ "}, {\r\n"
				+ "  \"id\": 3,\r\n"
				+ "  \"first_name\": \"Aubry\",\r\n"
				+ "  \"last_name\": \"Corbin\",\r\n"
				+ "  \"email\": \"acorbin2@latimes.com\",\r\n"
				+ "  \"gender\": \"Agender\",\r\n"
				+ "  \"ip_address\": \"32.15.97.105\"\r\n"
				+ "}, {\r\n"
				+ "  \"id\": 4,\r\n"
				+ "  \"first_name\": \"Al\",\r\n"
				+ "  \"last_name\": \"Burkart\",\r\n"
				+ "  \"email\": \"aburkart3@instagram.com\",\r\n"
				+ "  \"gender\": \"Female\",\r\n"
				+ "  \"ip_address\": \"221.203.21.39\"\r\n"
				+ "}, {\r\n"
				+ "  \"id\": 5,\r\n"
				+ "  \"first_name\": \"Tamra\",\r\n"
				+ "  \"last_name\": \"Oles\",\r\n"
				+ "  \"email\": \"toles4@psu.edu\",\r\n"
				+ "  \"gender\": \"Bigender\",\r\n"
				+ "  \"ip_address\": \"177.104.41.73\"\r\n"
				+ "}, {\r\n"
				+ "  \"id\": 6,\r\n"
				+ "  \"first_name\": \"Ermina\",\r\n"
				+ "  \"last_name\": \"Burford\",\r\n"
				+ "  \"email\": \"eburford5@storify.com\",\r\n"
				+ "  \"gender\": \"Male\",\r\n"
				+ "  \"ip_address\": \"188.201.124.69\"\r\n"
				+ "}, {\r\n"
				+ "  \"id\": 7,\r\n"
				+ "  \"first_name\": \"Dasha\",\r\n"
				+ "  \"last_name\": \"Ferrero\",\r\n"
				+ "  \"email\": \"dferrero6@nih.gov\",\r\n"
				+ "  \"gender\": \"Male\",\r\n"
				+ "  \"ip_address\": \"25.231.145.194\"\r\n"
				+ "}, {\r\n"
				+ "  \"id\": 8,\r\n"
				+ "  \"first_name\": \"Tamarah\",\r\n"
				+ "  \"last_name\": \"Millea\",\r\n"
				+ "  \"email\": \"tmillea7@who.int\",\r\n"
				+ "  \"gender\": \"Genderfluid\",\r\n"
				+ "  \"ip_address\": \"226.240.17.21\"\r\n"
				+ "}, {\r\n"
				+ "  \"id\": 9,\r\n"
				+ "  \"first_name\": \"Findley\",\r\n"
				+ "  \"last_name\": \"Samuels\",\r\n"
				+ "  \"email\": \"fsamuels8@jiathis.com\",\r\n"
				+ "  \"gender\": \"Male\",\r\n"
				+ "  \"ip_address\": \"87.223.250.0\"\r\n"
				+ "}, {\r\n"
				+ "  \"id\": 10,\r\n"
				+ "  \"first_name\": \"August\",\r\n"
				+ "  \"last_name\": \"Signoret\",\r\n"
				+ "  \"email\": \"asignoret9@behance.net\",\r\n"
				+ "  \"gender\": \"Agender\",\r\n"
				+ "  \"ip_address\": \"249.139.191.212\"\r\n"
				+ "}]";
	}
}
