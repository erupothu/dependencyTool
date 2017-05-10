package dependencyGrammar.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name="rules_table")
public class RulesModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String ruleName;
	private String ruleXml;
	private String ruleJson;
	private String ruleLang;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateModified;
	private String modifiedBy;
	private int authorId;
	private int categoryId;
	
	public RulesModel(){
		
	}

	public RulesModel(String ruleName, String ruleXml, String ruleJson, String ruleLang, Date dateCreated,
			Date dateModified, String modifiedBy, int authorId, int categoryId) {
		super();
		this.ruleName = ruleName;
		this.ruleXml = ruleXml;
		this.ruleJson = ruleJson;
		this.ruleLang = ruleLang;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
		this.modifiedBy = modifiedBy;
		this.authorId = authorId;
		this.categoryId = categoryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getRuleXml() {
		return ruleXml;
	}

	public void setRuleXml(String ruleXml) {
		this.ruleXml = ruleXml;
	}

	public String getRuleJson() {
		return ruleJson;
	}

	public void setRuleJson(String ruleJson) {
		this.ruleJson = ruleJson;
	}

	public String getRuleLang() {
		return ruleLang;
	}

	public void setRuleLang(String ruleLang) {
		this.ruleLang = ruleLang;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "RulesModel [id=" + id + ", ruleName=" + ruleName + ", ruleXml=" + ruleXml + ", ruleJson=" + ruleJson
				+ ", ruleLang=" + ruleLang + ", dateCreated=" + dateCreated + ", dateModified=" + dateModified
				+ ", modifiedBy=" + modifiedBy + ", authorId=" + authorId + ", categoryId=" + categoryId + "]";
	}
	
	

	
}
