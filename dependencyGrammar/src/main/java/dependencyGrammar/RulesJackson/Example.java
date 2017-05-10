package dependencyGrammar.RulesJackson;

import java.util.List;

public class Example {
	
	private List<String> example;
	
	public Example(){
		
	}

	public Example(List<String> example) {
		super();
		this.example = example;
	}

	public List<String> getExample() {
		return example;
	}

	public void setExample(List<String> example) {
		this.example = example;
	}

	@Override
	public String toString() {
		return "Example []";
	}
	
	
}
