package co.grandcircus.VoteAssist.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import co.grandcircus.VoteAssist.entity.Scripts;

public interface ScriptRepository extends JpaRepository <Scripts, Long> {
	
	Scripts findByScriptName(String scriptName);
	

}
