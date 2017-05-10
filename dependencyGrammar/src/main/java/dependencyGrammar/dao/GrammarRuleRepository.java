package dependencyGrammar.dao;

import org.springframework.data.repository.CrudRepository;

import dependencyGrammar.model.GrammarRuleModel;

public interface GrammarRuleRepository extends CrudRepository<GrammarRuleModel, Integer>{

}
