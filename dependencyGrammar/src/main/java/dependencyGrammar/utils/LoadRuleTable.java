package dependencyGrammar.utils;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.xml.XmlMapper;

import dependencyGrammar.RulesJackson.Rule;
import dependencyGrammar.RulesJackson.Rules;
import dependencyGrammar.model.RulesModel;

public class LoadRuleTable {

	public LoadRuleTable(){
		
	}
	public RulesModel loadParams(Rules rule) {
		XmlMapper xmlMapper = new XmlMapper();
		ObjectMapper mapper = new ObjectMapper();
		RulesModel model = new RulesModel();
		//String name = rule.getCategory().getRule().getRuleName();
		model.setRuleName(rule.getCategory().getRule().getRuleId());
		try {
			model.setRuleXml(xmlMapper.writeValueAsString(rule));
			model.setRuleJson(mapper.writeValueAsString(rule));
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setRuleLang(rule.getLang());
		model.setDateCreated(new Date());
		model.setDateModified(new Date());
		model.setModifiedBy("Haish");
		model.setAuthorId(7282);
		model.setCategoryId(4);
		return model;
	}
	public String getQuery(Rules rule) {
		String response = "";
		Rule tmpRule = new Rule();
		tmpRule = rule.getCategory().getRule();
		//response = printLevelOrder(tmpRule, "root");
		
		return null;
	}

}
