package dependencyGrammar.RulesJackson;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

import com.fasterxml.jackson.xml.annotate.JacksonXmlProperty;

public class Category {
	@JacksonXmlProperty(isAttribute = true)
	private String categoryId;
	@JacksonXmlProperty(isAttribute = true)
	private String categoryName;
	@JacksonXmlProperty(isAttribute = true)
	private String categoryType;
	private Rule rule;
	
	public Category(){
		
	}

	public Category(String categoryId, String categoryName, String categoryType, Rule rule) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryType = categoryType;
		this.rule = rule;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryType="
				+ categoryType + ", rule=" + rule + "]";
	}
	
}
