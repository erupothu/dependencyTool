package dependencyGrammar.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dependencyGrammar.dao.GrammarRuleRepository;
import dependencyGrammar.model.GrammarRuleModel;

@Service
@Transactional
public class GrammarRuleService {
	
	GrammarRuleRepository grammarRuleRepository;

	public GrammarRuleService(GrammarRuleRepository grammarRuleRepository) {
		super();
		this.grammarRuleRepository = grammarRuleRepository;
	}
	
	public List<GrammarRuleModel> findAllGrammarRules(){
		List<GrammarRuleModel> grammarRules = new ArrayList<>();
		for(GrammarRuleModel entity : grammarRuleRepository.findAll()){
			grammarRules.add(entity);
		}
		return grammarRules;
	}
	
	public void saveGrammarRules(GrammarRuleModel task){
		grammarRuleRepository.save(task);
	}
	
	public GrammarRuleModel findGrammarRule(int id){
		return grammarRuleRepository.findOne(id);
	}
	
	public void deleteGrammarRule(int id){
		grammarRuleRepository.delete(id);
	}
	
}
