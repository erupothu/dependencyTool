package dependencyGrammar.RulesJackson;

import java.util.List;

import com.fasterxml.jackson.xml.annotate.JacksonXmlProperty;

public class Node {
	@JacksonXmlProperty(isAttribute = true)
	private String id;
	@JacksonXmlProperty(isAttribute = true)
	private String personal;
	@JacksonXmlProperty(isAttribute = true)
	private String label;
	@JacksonXmlProperty(isAttribute = true)
	private String nodeMarkerStart;
	@JacksonXmlProperty(isAttribute = true)
	private String nodeMarkerEnd;
	
	@JacksonXmlProperty(isAttribute = true)
	private String relationToParent;
	
	@JacksonXmlProperty(isAttribute = true)
	private String tagList;
	@JacksonXmlProperty(isAttribute = true)
	private String wordList;
	@JacksonXmlProperty(isAttribute = true)
	private String lemmaList;
	@JacksonXmlProperty(isAttribute = true)
	private String exWordList;
	@JacksonXmlProperty(isAttribute = true)
	private String exLemmaList;
	
	
	private List<Node> node;
	
	public Node(){
		
	}

	public Node(String id, String personal, String label, String nodeMarkerStart, String nodeMarkerEnd, String relationToParent, List<String> tagList, List<String> wordList,
			List<String> lemmaList, List<String> exWordList, List<String> exLemmaList, List<Node> node) {
		super();
		this.id = id;
		this.personal = personal;
		this.label = label;
		this.nodeMarkerStart = nodeMarkerStart;
		this.nodeMarkerEnd = nodeMarkerEnd;
		this.relationToParent = relationToParent;
		this.tagList = tagList.toString().replace(",", "|");
		this.wordList = wordList.toString().replace(",", "|");
		this.lemmaList = lemmaList.toString().replace(",", "|");
		this.exWordList = exWordList.toString().replace(",", "|");
		this.exLemmaList = exLemmaList.toString().replace(",", "|");
		this.node = node;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPersonal() {
		return personal;
	}

	public void setPersonal(String personal) {
		this.personal = personal;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getRelationToParent() {
		return relationToParent;
	}

	public void setRelationToParent(String relationToParent) {
		this.relationToParent = relationToParent;
	}

	public String getTagList() {
		return tagList;
	}

	public void setTagList(List<String> tagList) {
		this.tagList = tagList.toString().replace(",", "|");
	}

	public String getWordList() {
		return wordList;
	}

	public void setWordList(List<String> wordList) {
		this.wordList = wordList.toString().replace(",", "|");
	}

	public String getLemmaList() {
		return lemmaList;
	}

	public void setLemmaList(List<String> lemmaList) {
		this.lemmaList = lemmaList.toString().replace(",", "|");
	}

	public String getExWordList() {
		return exWordList;
	}

	public void setExWordList(List<String> exWordList) {
		this.exWordList = exWordList.toString().replace(",", "|");
	}

	public String getExLemmaList() {
		return exLemmaList;
	}

	public void setExLemmaList(List<String> exLemmaList) {
		this.exLemmaList = exLemmaList.toString().replace(",", "|");
	}

	public List<Node> getNode() {
		return node;
	}

	public void setNode(List<Node> node) {
		this.node = node;
	}

	public String getNodeMarkerStart() {
		return nodeMarkerStart;
	}

	public void setNodeMarkerStart(String nodeMarkerStart) {
		this.nodeMarkerStart = nodeMarkerStart;
	}

	public String getNodeMarkerEnd() {
		return nodeMarkerEnd;
	}

	public void setNodeMarkerEnd(String nodeMarkerEnd) {
		this.nodeMarkerEnd = nodeMarkerEnd;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", personal=" + personal + ", label=" + label + ", nodeMarkerStart=" + nodeMarkerStart
				+ ", nodeMarkerEnd=" + nodeMarkerEnd + ", relationToParent=" + relationToParent + ", tagList=" + tagList
				+ ", wordList=" + wordList + ", lemmaList=" + lemmaList + ", exWordList=" + exWordList
				+ ", exLemmaList=" + exLemmaList + ", node=" + node + "]";
	}

	
	
	
}
