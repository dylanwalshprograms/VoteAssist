package co.grandcircus.VoteAssist.Service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import co.grandcircus.VoteAssist.model.CivicApiResponse;

@Service
public class GoogleCivicsApiService {
	
	private RestTemplate rest = new RestTemplate();
	
	@Value("${app.key}")
	private String appKey; 
	
	public CivicApiResponse civicResponse(String address, String city, String state, String zip) {
		
		URI url = buildAddressList(address, city, state, zip);
		
		CivicApiResponse response = rest.getForObject(url, CivicApiResponse.class);
		
		return response;
	}
	
	private URI buildAddressList(String address, String city, String state, String zip) {
		
		UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl("https://www.googleapis.com/civicinfo/v2/representatives")
				.queryParam("app.key", appKey)
				.queryParam("address", address + " " + city + " " + state + " " + zip);
		
		return b.build().toUri();
	}
	

}
