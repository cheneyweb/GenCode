package com.cheney.gencode.gen.javascript;

/**
 * @Moudle: GenAjaxCode 
 * @version:v1.0
 * @Description: Ajax代码生成器
 * @author: xuyushuai
 * @date: 2015年3月27日 下午2:34:40
 *
 */
public class GenAjaxCode {
	/**
	 * <p>Title: genJquery</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年3月27日 下午2:34:42</p>
	 * @return Jquery版本的Ajax代码
	 */
	public static String genJquery(String type) {
		String jqueryAjaxCode = "jQuery.ajax({";
		// 根据type选择使用post或get
		jqueryAjaxCode += "\r\n\t";
		if ("post".equals(type)) {
			jqueryAjaxCode += "type:'POST',";
		} else if ("get".equals("type")) {
			jqueryAjaxCode += "type:'GET',";
		} else {
			jqueryAjaxCode += "type:'',";
		}
		jqueryAjaxCode += "\r\n\t";
		jqueryAjaxCode += "url:,''";
		jqueryAjaxCode += "\r\n\t";
		jqueryAjaxCode += "data:{},";
		jqueryAjaxCode += "\r\n\t";
		jqueryAjaxCode += "async:true,";
		jqueryAjaxCode += "\r\n\t";
		jqueryAjaxCode += "success:function(response){";
		jqueryAjaxCode += "\r\n\t\t";
		jqueryAjaxCode += "if(response == 'success'){";
		jqueryAjaxCode += "\r\n\t\t";
		jqueryAjaxCode += "}";
		jqueryAjaxCode += "\r\n\t";
		jqueryAjaxCode += "}";
		jqueryAjaxCode += "\r\n";
		jqueryAjaxCode += "});";
		return jqueryAjaxCode;
	}

	/**
	 * <p>Title: genJavaScript</p>
	 * <p>author : xuyushuai</p>
	 * <p>date : 2015年3月27日 下午2:34:43</p>
	 * @return JavaScript版本的Ajax代码
	 */
	public static String genJavaScript(String type) {
		String javaScriptAjax = "var xmlhttp;";
		javaScriptAjax += "\r\n";
		javaScriptAjax += "var result;";
		javaScriptAjax += "\r\n";
		javaScriptAjax += "if(this.browser=='MSIE'){";
		javaScriptAjax += "\r\n\t";
		javaScriptAjax += "try{";
		javaScriptAjax += "\r\n\t\t";
		javaScriptAjax += "xmlhttp=new ActiveXObject('microsoft.xmlhttp');";
		javaScriptAjax += "\r\n\t";
		javaScriptAjax += "}";
		javaScriptAjax += "catch(e){";
		javaScriptAjax += "\r\n\t\t";
		javaScriptAjax += "xmlhttp=new ActiveXObject('msxml2.xmlhttp');";
		javaScriptAjax += "\r\n\t";
		javaScriptAjax += "}";
		javaScriptAjax += "\r\n";
		javaScriptAjax += "}";
		javaScriptAjax += "\r\n";
		javaScriptAjax += "else{";
		javaScriptAjax += "\r\n\t";
		javaScriptAjax += "xmlhttp=new XMLHttpRequest();";
		javaScriptAjax += "\r\n";
		javaScriptAjax += "};";
		javaScriptAjax += "\r\n";
		javaScriptAjax += "xmlhttp.onreadystatechange=function(){";
		javaScriptAjax += "\r\n\t";
		javaScriptAjax += "if(xmlhttp.readyState==4 && xmlhttp.status==200){";
		javaScriptAjax += "\r\n\t\t";
		javaScriptAjax += "result = xmlhttp.responseText;";
		javaScriptAjax += "\r\n\t";
		javaScriptAjax += "}";
		javaScriptAjax += "\r\n\t";
		javaScriptAjax += "else{";
		javaScriptAjax += "\r\n\t";
		javaScriptAjax += "}";
		javaScriptAjax += "\r\n";
		javaScriptAjax += "};";
		javaScriptAjax += "\r\n";
		// 根据type选择使用post或get
		if("get".equals(type)){
		javaScriptAjax += "xmlhttp.open('GET','');";
		javaScriptAjax += "\r\n";
		javaScriptAjax += "xmlhttp.send(null);";
		}else{
			javaScriptAjax += "xmlhttp.open('POST','',true);";
			javaScriptAjax += "\r\n";
			javaScriptAjax += "xmlhttp.setRequestHeader('Content-Type','application/x-www-form-urlencoded');";
			javaScriptAjax += "\r\n";
			javaScriptAjax += "xmlhttp.send();";
		}

		return javaScriptAjax;
	}
}
