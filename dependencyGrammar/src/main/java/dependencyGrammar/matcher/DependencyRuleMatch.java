package dependencyGrammar.matcher;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dependencyGrammar.RulesJackson.Rules;
import dependencyGrammar.model.GrammarModel;
import dependencyGrammar.model.GrammarRuleModel;
import dependencyGrammar.model.RulesModel;
import dependencyGrammar.service.GrammarRuleService;
import dependencyGrammar.service.GrammarService;
import dependencyGrammar.service.RulesService;

public class DependencyRuleMatch{
	@Autowired
	RulesService ruleService;
	@Autowired
	GrammarRuleService grammarRuleService;
	@Autowired
	GrammarService grammarService;
	static Map<String, Rules> mapRules = new HashMap<>();
	static Map<Integer, Rules> mapGrammarRule = new HashMap<>();
	
	
	public void fetchParams(){
		ObjectMapper mapper = new ObjectMapper();
		List<RulesModel> myrules = ruleService.findAllRules();
		
		if(mapRules == null || mapRules.isEmpty()){
			for(RulesModel rule : ruleService.findAllRules()){
				String jsonInString = rule.getRuleJson();
				try {
					Rules ruleObj = mapper.readValue(jsonInString, Rules.class);
					mapRules.put(ruleObj.getCategory().getRule().getRuleId(), ruleObj);
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}else if(myrules.size() > mapRules.size()){
			for(int i=mapRules.size(); i<myrules.size();i++){
				String jsonInString = myrules.get(i).getRuleJson();
				try {
					Rules ruleObj = mapper.readValue(jsonInString, Rules.class);
					mapRules.put(ruleObj.getCategory().getRule().getRuleId(), ruleObj);
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (JsonMappingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
//		Map<Integer, Map<Integer, Rules>>  xyz = new HashMap<>();
//		
//		Map<String, Map<String, RulesModel>> map = new HashMap<>();
//		Map<String, RulesModel> itemMap = new HashMap<>();
//		map.put("harish", itemMap);
//		map.get("harish").put("key", myrules.get(0));
//		map.get("harish").get("key");
//		
//		
//		List<GrammarModel> grammar1 = grammarService.findAllGrammars();
//		for(GrammarModel grammar : grammarService.findAllGrammars()){
//			Map<Integer, Rules>  abc = new HashMap<>();
//			xyz.put(grammar.getId(), abc);
//			
//			grammar.getId();
//		}
		
//		List<GrammarRuleModel> grammarRule = grammarRuleService.findAllGrammarRules();
//		for(GrammarRuleModel grammrRule : grammarRuleService.findAllGrammarRules()){
//			xyz.get(grammrRule.getGrammarId());
//			mapGrammarRule.put(grammrRule.getGrammarId(),  mapRules.get(grammrRule.getRuleId()));
//		}
		
		
		
	}
	
}
