package com.cheney.gencode.gen.html;

public class GenHeadCode {
	public static String genHead(String type) {
		String htmlHeadCode = "";
		htmlHeadCode += "<!DOCTYPE html>";
		htmlHeadCode += "\r\n";
		htmlHeadCode += "<html>";
		htmlHeadCode += "\r\n\t";
		htmlHeadCode += "<head>";
		htmlHeadCode += "\r\n\t";
		htmlHeadCode += "<meta charset=\"utf-8\"/>";
		htmlHeadCode += "\r\n\t";
		htmlHeadCode += "<title></title>";
		htmlHeadCode += "\r\n\t";
		htmlHeadCode += "</head>";
		htmlHeadCode += "\r\n\t";
		htmlHeadCode += "<body>";
		htmlHeadCode += "\r\n\t";
		htmlHeadCode += "</body>";
		htmlHeadCode += "\r\n";
		htmlHeadCode += "</html>";
		return htmlHeadCode;
	}
}
