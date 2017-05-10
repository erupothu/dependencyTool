package dependencyGrammar.matcher;

import java.util.HashMap;
import java.util.Map;

import dependencyGrammar.RulesJackson.Rules;


public class RuleMatcher {
	static Map<String, Rules> mapRules = new HashMap<>();
	private int grammarId;
	private int ruleId;
	public RuleMatcher(int grammarId, int ruleId) {
		super();
		this.grammarId = grammarId;
		this.ruleId = ruleId;
	}
	public static Map<String, Rules> getMapRules() {
		return mapRules;
	}
	public static void setMapRules(Map<String, Rules> mapRules) {
		RuleMatcher.mapRules = mapRules;
	}
	public int getGrammarId() {
		return grammarId;
	}
	public void setGrammarId(int grammarId) {
		this.grammarId = grammarId;
	}
	public int getRuleId() {
		return ruleId;
	}
	public void setRuleId(int ruleId) {
		this.ruleId = ruleId;
	}
	@Override
	public String toString() {
		return "RuleMatcher [grammarId=" + grammarId + ", ruleId=" + ruleId + "]";
	}
	
	
	
	
}
