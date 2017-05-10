package dependencyGrammar.dao;

import org.springframework.data.repository.CrudRepository;

import dependencyGrammar.model.CategoryModel;

public interface CategoryRepository extends CrudRepository<CategoryModel, Integer>{

}