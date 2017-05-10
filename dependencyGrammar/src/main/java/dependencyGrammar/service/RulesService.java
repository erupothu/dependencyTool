package dependencyGrammar.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dependencyGrammar.dao.RulesRepository;
import dependencyGrammar.model.RulesModel;

@Service
@Transactional
public class RulesService{
	
	private final RulesRepository ruleRepository;

	public RulesService(RulesRepository ruleRepository) {
		this.ruleRepository = ruleRepository;
	}

	public List<RulesModel> findAllRules(){
		List<RulesModel> rules = new ArrayList<>();
		for(RulesModel rule : ruleRepository.findAll()){
			rules.add(rule);
		}
		return rules;
	}
	
	public void saveRules(RulesModel task){
		ruleRepository.save(task);
	}
	
	public RulesModel findRule(int id){
		return ruleRepository.findOne(id);
	}
	
	public void deleteRule(int id){
		ruleRepository.delete(id);
	}
	
	
}
