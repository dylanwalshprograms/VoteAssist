package co.grandcircus.VoteAssist.Service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import co.grandcircus.VoteAssist.model.CivicApiResponse;

/**
 * In this service the url for the Google Civics API is being built, pulls 
 * representative information based on the address, city, state, and zip code that
 * is passed in.
 */
@Service
public class GoogleCivicsApiService {
	
	private RestTemplate rest = new RestTemplate();
	
	@Value("${app.key}")
	private String key; 

	public CivicApiResponse civicResponse(String address, String city, String state, String zip) {
		
		URI url = buildAddressList(address, city, state, zip);
		
		CivicApiResponse response = rest.getForObject(url, CivicApiResponse.class);
		
		return response;
	}
	
	private URI buildAddressList(String address, String city, String state, String zip) {
		
		UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl("https://www.googleapis.com/civicinfo/v2/representatives")
				.queryParam("key", key)
				.queryParam("address", address + " " + city + " " + state + " " + zip);
		
		return b.build().toUri();
	}
	
}
