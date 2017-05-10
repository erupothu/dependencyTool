package dependencyGrammar.dao;

import org.springframework.data.repository.CrudRepository;

import dependencyGrammar.model.AuthorModel;

public interface AuthorRepository extends CrudRepository<AuthorModel, Integer>{

}
