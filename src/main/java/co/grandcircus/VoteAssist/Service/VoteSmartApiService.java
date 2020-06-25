package co.grandcircus.VoteAssist.Service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import co.grandcircus.VoteAssist.model.StateVoteInfoResponse;

/**
 * In this service the url for the VoteSmart API is being built,
 * pulls the registation information based on the current voters 
 * state. 
 */
@Service
public class VoteSmartApiService {

	private RestTemplate rest = new RestTemplate();
	
	@Value("${voteSmart.key}")
	private String key;
	
	public StateVoteInfoResponse stateVoterInfoResponse(String state) {
		
		URI url = buildStateInfoList(state);
		
		StateVoteInfoResponse response = rest.getForObject(url, StateVoteInfoResponse.class);
		
		return response;
		
	}
	
	private URI buildStateInfoList(String state) {
		
		UriComponentsBuilder b = UriComponentsBuilder.fromHttpUrl("http://api.votesmart.org/State.getState")
				.queryParam("key", key)
				.queryParam("stateId", state)
				.queryParam("o", "JSON");
		
		return b.build().toUri();
				
		
	}
	
}
