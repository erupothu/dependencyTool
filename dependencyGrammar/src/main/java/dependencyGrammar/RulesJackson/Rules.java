package dependencyGrammar.RulesJackson;

import java.util.List;


import com.fasterxml.jackson.xml.annotate.JacksonXmlProperty;

public class Rules {
	@JacksonXmlProperty(isAttribute=true)
	private String id;
	@JacksonXmlProperty(isAttribute=true)
	private String lang;
	private Category category;

	public Rules() {
		// TODO Auto-generated constructor stub
	}

	public Rules(String id, String lang, Category category) {
		super();
		this.id = id;
		this.lang = lang;
		this.category = category;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Rules [id=" + id + ", lang=" + lang + ", category=" + category + "]";
	}
	

}
