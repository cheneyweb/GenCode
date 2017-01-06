package com.cheney.gencode.gen.html;

public class GenFormCode {
	public static String genForm(String type){
		String htmlFormCode = "";
		if("input".equals(type) || "radio".equals(type) || "checkbox".equals(type)){
			htmlFormCode += "<";
			htmlFormCode += "input";
			if("input".equals(type)){
				htmlFormCode += " type=\"\"";
			}else{
				htmlFormCode = htmlFormCode + " type=\"" + type +"\"";
			}
			htmlFormCode += " name=\"\"";
			htmlFormCode += " value=\"\"";
			htmlFormCode += " class=\"\"";
			htmlFormCode += ">";
			htmlFormCode += "</";
			htmlFormCode += "input";
			htmlFormCode += ">";
		}
		
		if("select".equals(type)){
			htmlFormCode += "<";
			htmlFormCode += type;
			htmlFormCode += " class=\"\"";
			htmlFormCode += ">";
			
			htmlFormCode += "\r\n\t";
			htmlFormCode += "<option value =\"\"></option>";
			
			htmlFormCode += "\r\n";
			htmlFormCode += "</";
			htmlFormCode += type;
			htmlFormCode += ">";
		}
		
		if("textarea".equals(type)){
			htmlFormCode += "<";
			htmlFormCode += type;
			htmlFormCode += " rows=\"\" cols=\"\" class=\"\"";
			htmlFormCode += ">";
			htmlFormCode += "</";
			htmlFormCode += type;
			htmlFormCode += ">";
		}
		return htmlFormCode;
	}
}
