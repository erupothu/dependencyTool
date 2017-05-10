package dependencyGrammar.dao;

import org.springframework.data.repository.CrudRepository;

import dependencyGrammar.model.GrammarModel;

public interface GrammarRepository extends CrudRepository<GrammarModel, Integer>{

}
