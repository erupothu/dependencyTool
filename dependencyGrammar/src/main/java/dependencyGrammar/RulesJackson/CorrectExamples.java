package dependencyGrammar.RulesJackson;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;

import com.fasterxml.jackson.xml.annotate.JacksonXmlProperty;

public class CorrectExamples {
	@JacksonXmlProperty(isAttribute=true)
	private String typeC;
	private List<String> example;
	
	public CorrectExamples(){
		
	}

	public CorrectExamples(String typeC, List<String> example) {
		super();
		this.typeC = typeC;
		this.example = example;
	}

	public String getTypeC() {
		return typeC;
	}

	public void setTypeC(String typeC) {
		this.typeC = typeC;
	}

	public List<String> getExample() {
		return example;
	}

	public void setExample(List<String> example) {
		this.example = example;
	}

	@Override
	public String toString() {
		return "CorrectExamples [typeC=" + typeC + ", example=" + example + "]";
	}
	
	
}
