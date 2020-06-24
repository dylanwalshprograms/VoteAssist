package co.grandcircus.VoteAssist.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;

import co.grandcircus.VoteAssist.entity.Scripts;
import co.grandcircus.VoteAssist.model.VoterElectionInformation;
import co.grandcircus.VoteAssist.repository.ScriptRepository;

@Service
public class JMustacheService {
	
	@Autowired
	private ScriptRepository scriptRepo;

	public String changeExpressionLanguageToContext(VoterElectionInformation voterElectionInformation) { 
		String text = "";
		
		if (voterElectionInformation.getVoterData().getResult() == null) {
			Scripts mainScript = scriptRepo.findByScriptName("main_script");
			text = mainScript.getScriptText();
		} else if (voterElectionInformation.getVoterData().getResult().equals("VIP")) {
			Scripts voteInPersonScript = scriptRepo.findByScriptName("vip_reminder_script");
			text = voteInPersonScript.getScriptText();
		} else if (voterElectionInformation.getVoterData().getResult().equals("WVBM")) {
			Scripts voteByMailScript = scriptRepo.findByScriptName("vbm_reminder_script");
			text = voteByMailScript.getScriptText();
		}
		
		System.out.println(text);

		Template tmpl = Mustache.compiler().compile(text);
		Map<String, String> data = new HashMap<String, String>();
		data.put("voterInformation.voterData.name", voterElectionInformation.getVoterData().getName());
		data.put("voterInformation.currentVolunteer.name", voterElectionInformation.getCurrentVolunteer().getName());
		data.put("voterInformation.campaignName", voterElectionInformation.getCampaignName());
		data.put("voterInformation.voterData.state", voterElectionInformation.getVoterData().getState());
		data.put("voterInformation.getElectionDateInWords()", voterElectionInformation.getElectionDateInWords());
		data.put("voterInformation.getRegCutoffDateInWords()", voterElectionInformation.getRegCutoffDateInWords());
		data.put("voterInformation.getLastCallInWords()", voterElectionInformation.getLastCallInWords());
		
		String renderedTemplate = tmpl.execute(data);
		return renderedTemplate;
	}
}
