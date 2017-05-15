package dependencyGrammar.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.xml.XmlMapper;

import dependencyGrammar.RulesJackson.Node;
import dependencyGrammar.RulesJackson.Rule;
import dependencyGrammar.RulesJackson.Rules;
import dependencyGrammar.model.RulesModel;

public class LoadRuleTable {
	private static String marker = "";
	private static List<String> markerList = new ArrayList<>();
	private static boolean markerFlagOnOrOff = false;

	public LoadRuleTable(){
		
	}
	public RulesModel loadParams(Rules rule) {
		XmlMapper xmlMapper = new XmlMapper();
		ObjectMapper mapper = new ObjectMapper();
		RulesModel model = new RulesModel();
		//String name = rule.getCategory().getRule().getRuleName();
		model.setRuleName(rule.getCategory().getRule().getRuleId());
		try {
			model.setRuleXml(xmlMapper.writeValueAsString(rule));
			model.setRuleJson(mapper.writeValueAsString(rule));
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.setRuleLang(rule.getLang());
		model.setDateCreated(new Date());
		model.setDateModified(new Date());
		model.setModifiedBy("Haish");
		model.setAuthorId(7282);
		model.setCategoryId(4);
		return model;
	}
	public String getQuery(Rules rule) {
		String response = "";
		Node tmpNode = new Node();
		//List<Node> tmpNode = new ArrayList<>();
		tmpNode = rule.getCategory().getRule().getNode();
		//response = printLevelOrder(tmpRule, "root");
		
		response = printGivenLevel(tmpNode);
		
		return null;
	}
	
	private String printLevelOrder(List<Node> root) {
		
		String response = "";
		
		if(root==null)
			return "";
		
		String currentResponse = "";
		for (Node node : root) {
			response += " >" + node.getRelationToParent() + " ( ";
			currentResponse = printGivenLevel(node);
			if (currentResponse == "INVALID") {
				return currentResponse;
			}
			response += currentResponse;
			response += " ) ";
		}
		return response;
	}

	private String printGivenLevel(Node node1) {
		if (node1 == null)
			return "";
		
		String tagsList = node1.getTagList();
		String wordsList = node1.getWordList();
//		if (node1.getTagList() != null) {
//			String[] tags = node1.getTagList().split("\\|");
//			tagsList += "[";
//			int i = 0;
//			for (; i < tags.length - 1; i++) {
//				boolean tagsValid = validateTags(tags[i]);
//				if (tagsValid) {
//					tagsList += "{tag:" + tags[i] + "} | ";
//				} else {
//					return "INVALID TAG";
//				}
//			}
//			boolean tagsValid = validateTags(tags[i]);
//			
//			if (tagsValid) {
//				tagsList += "{tag:" + tags[i] + "} = " + node1.getLabel() + "]";
//			} else {
//				return "INVALID TAG";
//			}
//		}
//		if (node1.getWordList() != null) {
//			String[] words1 = node1.getWordList().split("|");
//			wordsList += "[";
//			int j = 0;
//			for (; j < words1.length - 1; j++) {
//				wordsList += "{word:" + words1[j] + "} |";
//			}
//			wordsList += "{word:" + words1[j] + "} = " + node1.getLabel() + "]";
//		}

		
		
//		if (markerFlagOnOrOff) {
//			markerList.add(tagsList);
//		}
//		if (node1.getMarkerStart() != null && node1.getMarkerStart().equals("yes")) {
//			markerFlagOnOrOff = true;
//			markerList.add(tagsList);
//		}
//		if (node1.getMarkerEnd() != null && node1.getMarkerEnd().equals("yes")) {
//			markerFlagOnOrOff = false;
//		}

		String responseCenter = "";
		if (tagsList!=null && wordsList!=null) {
			responseCenter += "[" + tagsList + "&" + wordsList + "]";
		} else if (tagsList!=null) {
			responseCenter += tagsList;
		} else if (wordsList!=null) {
			responseCenter += wordsList;
		}else{
			responseCenter += wordsList;
		}

		String responseChild = printLevelOrder(node1.getNode());
		if (responseChild == "INVALID") {
			return responseChild;
		}
		return responseCenter + responseChild;

	}
	
	public enum edgeType {
		left, right, root, generic
	}

	public enum pennTreebanktagset {
		CC, CD, DT, EX, FW, IN, JJ, JJR, JJS, LS, MD, NN, NNS, NNP, NNPS, PDT, POS, PRP, PRP$, RB, RBR, RBS, RP, SYM, TO, UH, VB, VBD, VBG, VBN, VBP, VBZ, WDT, WP, WP$, WRB
	}

	private static boolean validateTags(String tag) {
		try {
			if (pennTreebanktagset.valueOf(tag).toString().equals(tag)) {
				return true;
			}
		} catch (Exception e) {

		}

		return false;
	}

}
