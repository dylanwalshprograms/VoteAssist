package co.grandcircus.VoteAssist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.grandcircus.VoteAssist.entity.Scripts;

public interface ScriptRepository extends JpaRepository <Scripts, Long> {
	
	Scripts findByScriptName(String scriptName);
	// Scripts deleteByScriptName(String scriptName);
	
	// @Query (value = "UPDATE scripts SET script_text WHERE script_name = ?;", nativeQuery = true)
	// String updateScriptText(String scriptText);

}
