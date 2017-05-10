package dependencyGrammar.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dependencyGrammar.dao.GrammarRepository;
import dependencyGrammar.model.GrammarModel;

@Service
@Transactional
public class GrammarService {
	
	GrammarRepository grammarRepository;

	public GrammarService(GrammarRepository grammarRepository) {
		super();
		this.grammarRepository = grammarRepository;
	}
	
	public List<GrammarModel> findAllGrammars(){
		List<GrammarModel> grammars = new ArrayList<>();
		
		for(GrammarModel model : grammarRepository.findAll()){
			grammars.add(model);
		}
		
		return grammars;
	}
	
	public void saveGrammar(GrammarModel grammarModel){
		grammarRepository.save(grammarModel);
	}
	
	public GrammarModel findGrammar(int id){
		return grammarRepository.findOne(id);
	}
	
	public void deleteGrammar(int id){
		grammarRepository.delete(id);
	}

}
