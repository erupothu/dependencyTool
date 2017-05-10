package dependencyGrammar.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name="grammar_table")
public class GrammarModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String grammarName;
	private String author;
	private String language;
	private String xmlStoragePath;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;

	public GrammarModel(String grammarName, String author, String language, String xmlStoragePath,
			Date timeStamp) {
		super();
		this.grammarName = grammarName;
		this.author = author;
		this.language = language;
		this.xmlStoragePath = xmlStoragePath;
		this.timeStamp = timeStamp;
	}

	public GrammarModel() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGrammarName() {
		return grammarName;
	}

	public void setGrammarName(String grammarName) {
		this.grammarName = grammarName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getXmlStoragePath() {
		return xmlStoragePath;
	}

	public void setXmlStoragePath(String xmlStoragePath) {
		this.xmlStoragePath = xmlStoragePath;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "GrammarModel [id=" + id + ", grammarName=" + grammarName + ", author=" + author + ", language="
				+ language + ", xmlStoragePath=" + xmlStoragePath + ", timeStamp=" + timeStamp + "]";
	}
	
	
}
