package co.grandcircus.VoteAssist.Service;

import org.springframework.stereotype.Service;

/**
 * In this service is the logic to determine which script the admin would like to edit.
 */
@Service
public class AdminService {

	public String adminScriptEditor(String scriptName) {
		String script = "";
		
		if (scriptName.equals("main_script")) {
			script = "main_script";
		} else if (scriptName.equals("vip_reminder_script")) {
			script = "vip_reminder_script";
		} else if (scriptName.equals("vbm_reminder_script")) {
			script = "vbm_reminder_script";
		}
		
		return script;
	}
}
