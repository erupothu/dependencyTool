package dependencyGrammar.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dependencyGrammar.RulesJackson.Rules;
import dependencyGrammar.model.AuthorModel;
import dependencyGrammar.model.CategoryModel;
import dependencyGrammar.model.GrammarModel;
import dependencyGrammar.model.GrammarRuleModel;
import dependencyGrammar.model.RulesModel;
import dependencyGrammar.service.AuthorService;
import dependencyGrammar.service.CategoryService;
import dependencyGrammar.service.GrammarRuleService;
import dependencyGrammar.service.GrammarService;
import dependencyGrammar.service.RulesService;
import dependencyGrammar.utils.LoadRuleTable;

@RestController
public class GrammarRestController {
	@Autowired
	private RulesService ruleService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private AuthorService authorService;
	@Autowired
	private GrammarService grammarService;
	@Autowired
	private GrammarRuleService grammarRuleService;
	
	//Rules
	@GetMapping("/hello")
	public String hello(){
		return "Hello Harish Good morning!!!";
	}
	
	
	// Dependency Rule Editor
	@GetMapping("/rule-editor-data")
	public String ruleEditorData(@RequestParam String jsonInString){
		ObjectMapper mapper = new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
		List<Rules> rulelist = new ArrayList<>();
		
		try {
		Rules rule = mapper.readValue(jsonInString, Rules.class);
		rulelist.add(rule);
//		mapRules.put(rule.getCategory().getRule().getRuleId(), rule);
//		XmlMapper xmlMapper = new XmlMapper();
//		String testxml = xmlMapper.writeValueAsString(rule);
//		LoadLocalXML laodLocatXml = null;
//		laodLocatXml.saveInXml(rule);
		
		
		
		LoadRuleTable loadRuletable = new LoadRuleTable();
		
		String ruleRuery = loadRuletable.getQuery(rule);
		
		RulesModel ruletable = loadRuletable.loadParams(rule);
		ruleService.saveRules(ruletable); //save rule to Database
		
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String myjson = jsonInString;
		return myjson;
	}
	
	
	// Rule Table crud Operations
	@GetMapping("/all-rules")
	public String allTast(){
		ObjectMapper mapper = new ObjectMapper();
		String response="";
		try {
			response = mapper.writeValueAsString(ruleService.findAllRules());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@GetMapping("/save-rule")
	public String saveRule(@RequestParam String ruleName, @RequestParam String ruleXML, @RequestParam String ruleJSON, @RequestParam String ruleLang, @RequestParam String createdBy, @RequestParam int authorId, @RequestParam int categoryId){
		RulesModel ruletable = new RulesModel(ruleName,ruleXML, ruleJSON,ruleLang, new Date(),new Date(), createdBy, authorId,categoryId);
		ruleService.saveRules(ruletable);
		return "rule Saved";
	}
	
	@GetMapping("/delete-rule")
	public String deleteRule(@RequestParam int id){
		ruleService.deleteRule(id);
		return "rule deleted";
		
	}
	@GetMapping("/find-rule")
	public String findRule(@RequestParam int id){
		
		return ruleService.findRule(id).toString();
	}
	
	//categories Table Crud Operations
	@GetMapping("/all-categories")
	public String allCategories(){
		
		ObjectMapper mapper = new ObjectMapper();
		String response="";
		try {
			response = mapper.writeValueAsString(categoryService.findAllCategories());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@GetMapping("/save-category")
	public String saveCategory(@RequestParam String categoryName, @RequestParam String description){
		CategoryModel category = new CategoryModel(categoryName, description);
		categoryService.saveCategory(category);
		return "Category successfull saved";
	}
	
	@GetMapping("/delete-category")
	public String deleteCategroy(@RequestParam int id){
		
		categoryService.deleteCategory(id);
		return "category successfully delted";
	}
	
	@GetMapping("/find-category")
	public String findCategory(@RequestParam int id){
		
		return categoryService.findCategory(id).toString();
	}
	
	// Authors Table crud Operations
	@GetMapping("/all-authors")
	public String allAuthors(){
		ObjectMapper mapper = new ObjectMapper();
		String response = "";
		
		try{
			response = mapper.writeValueAsString(authorService.findAllAuthors());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@GetMapping("/save-author")
	public String saveAuthor(@RequestParam String authorName, @RequestParam String authorLang, @RequestParam String authorXmlStoragePath){
		AuthorModel author = new AuthorModel(authorName, authorLang, authorXmlStoragePath);
		authorService.saveAuthor(author);
		return "Author successfull saved";
	}
	
	@GetMapping("/delete-author")
	public String deleteAuthor(@RequestParam int id){
		
		authorService.deleteAuthor(id);
		return "author successfully delted";
	}
	
	@GetMapping("/find-author")
	public String findAuthor(@RequestParam int id){
		
		return authorService.findAuthor(id).toString();
	}
	
	// Grammar Table Crud ooperations
	@GetMapping("/findAll-grammars")
	public String findAllGrammars(){
		ObjectMapper mapping = new ObjectMapper();
		String response ="";
		try {
			response = mapping.writeValueAsString(grammarService.findAllGrammars());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	@GetMapping("/save-grammar")
	public String grammmarCreateGrammar(@RequestParam String grammarName, @RequestParam String author, @RequestParam String langauge, @RequestParam String StoragePage){
		
		GrammarModel grammar = new GrammarModel(grammarName, author, langauge, StoragePage, new Date());
		grammarService.saveGrammar(grammar);
		return "Grammar successfully created";
	}
	
	@GetMapping("/find-grammar")
	public String findGrammar(@RequestParam int id){
		String response="";
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			response = mapper.writeValueAsString(grammarService.findGrammar(id));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}
	
	@GetMapping("/delete-grammar")
	public String deleteGrammar(int id){
		grammarService.deleteGrammar(id);
		return "delete successful";
	}
	
	@GetMapping("/grammar-editor-data")
	public String grammarEditorData(@RequestParam int grammarId, @RequestParam int ruleId){
		
		return "successful";
	}
	
	// GrammarRule Table crud Operations
	@GetMapping("/findAll-grammarRules")
	public String findAllGrammarRules(){
		ObjectMapper mapper = new ObjectMapper();
		String response = "";
		
		try {
			response = mapper.writeValueAsString(grammarRuleService.findAllGrammarRules());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} 
		
		return response;
	}
	
	@GetMapping("/save-grammarRule")
	public String saveGrammarRule(@RequestParam int grammarId, @RequestParam int ruleId){
		GrammarRuleModel grammar = new GrammarRuleModel(grammarId, ruleId);
		grammarRuleService.saveGrammarRules(grammar);
		return "successfull saved grammarRule";
	}
	
	@GetMapping("/find-grammarRule")
	public String findGrammarRule(int id){
		ObjectMapper mapper = new ObjectMapper();
		String response = "";
		
		try {
			response = mapper.writeValueAsString(grammarRuleService.findGrammarRule(id));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return response;
	}
	
	@GetMapping("/delete-grammarRule")
	public String deletegrammarRule(int id){
		grammarRuleService.deleteGrammarRule(id);
		
		return "Delete grammarRule successful";
	}
}
