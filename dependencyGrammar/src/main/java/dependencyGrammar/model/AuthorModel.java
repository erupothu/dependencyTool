package dependencyGrammar.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="author_table")
public class AuthorModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String authorName;
	private String authorLang;
	private String authorXmlStoragePath;
	
	public AuthorModel(){
		
	}
	public AuthorModel(String authorName, String authorLang, String authorXmlStoragePath) {
		super();
		this.authorName = authorName;
		this.authorLang = authorLang;
		this.authorXmlStoragePath = authorXmlStoragePath;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getAuthorLang() {
		return authorLang;
	}
	public void setAuthorLang(String authorLang) {
		this.authorLang = authorLang;
	}
	public String getAuthorXmlStoragePath() {
		return authorXmlStoragePath;
	}
	public void setAuthorXmlStoragePath(String authorXmlStoragePath) {
		this.authorXmlStoragePath = authorXmlStoragePath;
	}
	@Override
	public String toString() {
		return "AuthorModel [id=" + id + ", authorName=" + authorName + ", authorLang=" + authorLang
				+ ", authorXmlStoragePath=" + authorXmlStoragePath + "]";
	}
	
	
}
