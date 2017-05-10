package dependencyGrammar.RulesJackson;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

import com.fasterxml.jackson.xml.annotate.JacksonXmlProperty;

public class Rule {
	@JacksonXmlProperty(isAttribute = true)
	private String ruleId;
	@JacksonXmlProperty(isAttribute = true)
	private String ruleName;
	@JacksonXmlProperty(isAttribute = true)
	private String ruleType;
	private CorrectExamples correctExamples;
	private WrongExamples wrongExamples;
	private Node node;
	//private List<Edge> edge;
	public Rule(){
		
	}
	public Rule(String ruleId, String ruleName, String ruleType, CorrectExamples correctExamples,
			WrongExamples wrongExamples, Node node) {
		super();
		this.ruleId = ruleId;
		this.ruleName = ruleName;
		this.ruleType = ruleType;
		this.correctExamples = correctExamples;
		this.wrongExamples = wrongExamples;
		this.node = node;
	}
	public String getRuleId() {
		return ruleId;
	}
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getRuleType() {
		return ruleType;
	}
	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}
	public CorrectExamples getCorrectExamples() {
		return correctExamples;
	}
	public void setCorrectExamples(CorrectExamples correctExamples) {
		this.correctExamples = correctExamples;
	}
	public WrongExamples getWrongExamples() {
		return wrongExamples;
	}
	public void setWrongExamples(WrongExamples wrongExamples) {
		this.wrongExamples = wrongExamples;
	}
	public Node getNode() {
		return node;
	}
	public void setNode(Node node) {
		this.node = node;
	}
	@Override
	public String toString() {
		return "Rule [ruleId=" + ruleId + ", ruleName=" + ruleName + ", ruleType=" + ruleType + ", correctExamples="
				+ correctExamples + ", wrongExamples=" + wrongExamples + ", node=" + node + "]";
	}
	
}
