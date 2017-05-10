package dependencyGrammar.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dependencyGrammar.dao.CategoryRepository;
import dependencyGrammar.model.CategoryModel;
import dependencyGrammar.model.RulesModel;

@Service
@Transactional
public class CategoryService {
	
	CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<CategoryModel> findAllCategories(){
		List<CategoryModel> categories = new ArrayList<>();
		for(CategoryModel category : categoryRepository.findAll()){
			categories.add(category);
		}
		return categories;
	}
	
	public void saveCategory(CategoryModel task){
		categoryRepository.save(task);
	}
	
	public CategoryModel findCategory(int id){
		return categoryRepository.findOne(id);
	}
	
	public void deleteCategory(int id){
		categoryRepository.delete(id);
	}

}
