package dependencyGrammar.RulesJackson;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

import com.fasterxml.jackson.xml.annotate.JacksonXmlProperty;

public class WrongExamples {
	@JacksonXmlProperty(isAttribute=true)
	private String typeW;
	private List<String> example;
	
	public WrongExamples(){
		
	}

	public WrongExamples(String typeW, List<String> example) {
		super();
		this.typeW = typeW;
		this.example = example;
	}

	public String getTypeW() {
		return typeW;
	}

	public void setTypeW(String typeW) {
		this.typeW = typeW;
	}

	public List<String> getExample() {
		return example;
	}

	public void setExample(List<String> example) {
		this.example = example;
	}

	@Override
	public String toString() {
		return "WrongExamples [typeW=" + typeW + ", example=" + example + "]";
	}
	
	
}
