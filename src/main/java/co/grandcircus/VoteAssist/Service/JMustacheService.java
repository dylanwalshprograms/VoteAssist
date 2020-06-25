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

/**
 * This is where we are able to decide which script will be rendered using the JMustache
 * template to display on the volunteer page.
 */
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
		} else {
			Scripts mainScript = scriptRepo.findByScriptName("main_script");
			text = mainScript.getScriptText();
		}

		Template tmpl = Mustache.compiler().compile(text);
		Map<String, String> data = new HashMap<String, String>();
		data.put("Voter Name", voterElectionInformation.getVoterData().getName());
		data.put("Volunteer Name", voterElectionInformation.getCurrentVolunteer().getName());
		data.put("Campaign Name", voterElectionInformation.getCampaignName());
		data.put("Voter State", voterElectionInformation.getVoterData().getState());
		data.put("Election Date", voterElectionInformation.getElectionDateInWords());
		data.put("Registration Cutoff Date", voterElectionInformation.getRegCutoffDateInWords());
		data.put("Last Call", voterElectionInformation.getLastCallInWords());
		
		String renderedTemplate = tmpl.execute(data);
		return renderedTemplate;
	}
}
