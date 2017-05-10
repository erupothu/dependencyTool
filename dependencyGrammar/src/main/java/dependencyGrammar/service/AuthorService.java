package dependencyGrammar.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dependencyGrammar.dao.AuthorRepository;
import dependencyGrammar.model.AuthorModel;

@Service
@Transactional
public class AuthorService {
	
	AuthorRepository authorRepository;

	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	public List<AuthorModel> findAllAuthors(){
		List<AuthorModel> authors = new ArrayList<>();
		for(AuthorModel author : authorRepository.findAll()){
			authors.add(author);
		}
		return authors;
	}
	
	public void saveAuthor(AuthorModel task){
		authorRepository.save(task);
	}
	
	public AuthorModel findAuthor(int id){
		return authorRepository.findOne(id);
	}
	
	public void deleteAuthor(int id){
		authorRepository.delete(id);
	}
	
	
}
