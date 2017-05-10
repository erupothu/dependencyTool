package dependencyGrammar.dao;

import org.springframework.data.repository.CrudRepository;

import dependencyGrammar.model.RulesModel;

public interface RulesRepository extends CrudRepository<RulesModel, Integer>{

}
