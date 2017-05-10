package dependencyGrammar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="grammar_rule_table")
public class GrammarRuleModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int grammarId;
	private int ruleId;
	
	public GrammarRuleModel(){
		
	}
	public GrammarRuleModel(int grammarId, int ruleId) {
		super();
		this.grammarId = grammarId;
		this.ruleId = ruleId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
		return "GrammarRuleModel [id=" + id + ", grammarId=" + grammarId + ", ruleId=" + ruleId + "]";
	}
	
	

}
