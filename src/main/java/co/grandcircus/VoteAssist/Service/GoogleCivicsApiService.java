package co.grandcircus.VoteAssist.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.grandcircus.VoteAssist.model.CivicApiResponse;

@Service
public class GoogleCivicsApiService {
	
	private RestTemplate rest = new RestTemplate();
	
	@Value("${app.key}")
	private String appKey; 
	
	public CivicApiResponse civicResponse(String address) {
		
		String url = "https://www.googleapis.com/civicinfo/v2/representatives?key=" + appKey + "&address=" + address;
		
		CivicApiResponse response = rest.getForObject(url, CivicApiResponse.class);
		
		return response;
	}
	
	

}
