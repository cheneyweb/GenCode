/**
 * @Title: GenGlobalConfig.java
 * @Package: com.cheney.gencode
 * @Description: TODO
 * @author: xuyushuai
 * @date: 2014年10月21日 下午2:55:47
 * @version: V1.0
 */
package com.cheney.gencode.gen.java.module;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.cheney.gencode.module.GlobalConfig;

/**
 * @Moudle: GenGlobalConfig
 * @version:v1.0
 * @Description: 生成全局配置
 * @author: xuyushuai
 * @date: 2014年10月21日 下午2:55:47
 *
 */
public class GenGlobalConfig {
	
	private static GlobalConfig globalConfig;
	
	
	
    public static GlobalConfig getGlobalConfig() {
		return globalConfig;
	}

	public static void setGlobalConfig(GlobalConfig globalConfig) {
		GenGlobalConfig.globalConfig = globalConfig;
	}

	/**
     *
     * <p>Title: 获取全局配置</p>
     * <p>author : xuyushuai</p>
     * <p>date : 2014年10月21日 下午3:03:05</p>
     * 
     * @param document
     * @return 全局配置
     */
    public static GlobalConfig getGlobalConfig(Document document) {

        GlobalConfig globalConfig = null;
        // 全局设置
        NodeList globalList = document.getElementsByTagName("global");
        Element element = (Element) globalList.item(0);

        if (element != null) {
            globalConfig = new GlobalConfig();
            NodeList servicePrefixList = element.getElementsByTagName("servicePrefix");
            NodeList managerPrefixList = element.getElementsByTagName("managerPrefix");
            NodeList daoPrefixList = element.getElementsByTagName("daoPrefix");
            NodeList beanPrefixList = element.getElementsByTagName("beanPrefix");

            NodeList hasNotesList = element.getElementsByTagName("hasNotes");
            NodeList hasTryCatchList = element.getElementsByTagName("hasTryCatch");
            NodeList outputPathList = element.getElementsByTagName("outputPath");
            NodeList authorList = element.getElementsByTagName("author");
            NodeList basepackageList = element.getElementsByTagName("basepackage");

            if (servicePrefixList.item(0) != null) {
                globalConfig.setServicePrefix(servicePrefixList.item(0).getFirstChild().getNodeValue());
            }
            if (managerPrefixList.item(0) != null) {
                globalConfig.setManagerPrefix(managerPrefixList.item(0).getFirstChild().getNodeValue());
            }
            if (daoPrefixList.item(0) != null) {
                globalConfig.setDaoPrefix(daoPrefixList.item(0).getFirstChild().getNodeValue());
            }
            if (beanPrefixList.item(0) != null) {
                globalConfig.setBeanPrefix(beanPrefixList.item(0).getFirstChild().getNodeValue());
            }
            if (hasTryCatchList.item(0) != null) {
                globalConfig.setHasTryCatch(hasTryCatchList.item(0).getFirstChild().getNodeValue());
            }
            if (hasNotesList.item(0) != null) {
                globalConfig.setHasNotes(hasNotesList.item(0).getFirstChild().getNodeValue());
            }
            if (outputPathList.item(0) != null) {
                globalConfig.setOutputPath(outputPathList.item(0).getFirstChild().getNodeValue());
            }
            if (authorList != null) {
                globalConfig.setAuthor(authorList.item(0).getFirstChild().getNodeValue());
            } else {
                globalConfig.setAuthor("");
            }
            if (basepackageList != null) {
                globalConfig.setBasepackage(basepackageList.item(0).getFirstChild().getNodeValue());
            }

            // 数据库设置
            NodeList databaseList = document.getElementsByTagName("database");
            element = (Element) databaseList.item(0);

            if (element != null) {
                NodeList driverClassNameList = element.getElementsByTagName("driverClassName");
                NodeList urlList = element.getElementsByTagName("url");
                NodeList usernameList = element.getElementsByTagName("username");
                NodeList passwordList = element.getElementsByTagName("password");
                NodeList tableList = element.getElementsByTagName("table");

                if (driverClassNameList.item(0) != null) {
                    globalConfig.setDriverClassName(driverClassNameList.item(0).getFirstChild().getNodeValue());
                }
                if (urlList.item(0) != null) {
                    globalConfig.setUrl(urlList.item(0).getFirstChild().getNodeValue());
                }

                if (usernameList.item(0) != null) {
                    globalConfig.setUsername(usernameList.item(0).getFirstChild().getNodeValue());
                }
                if (passwordList.item(0) != null) {
                    globalConfig.setPassword(passwordList.item(0).getFirstChild().getNodeValue());
                }
                if (tableList.item(0) != null) {
                    globalConfig.setTable(tableList.item(0).getFirstChild().getNodeValue());
                }
            }
        }

        return globalConfig;
    }

    /**
     *
     * <p>Title: editGlobalConfig</p>
     * <p>author : xuyushuai</p>
     * <p>date : 2014年10月28日 上午10:06:47</p>
     * 
     * @param document
     * @param nodeName
     * @param childNodeName
     * @param nodeContent
     */
    public static void editConfig(Document document, String nodeName, String childNodeName, String nodeContent) {

        Element node = (Element) document.getElementsByTagName(nodeName).item(0);
        Element childNode = document.createElement(childNodeName);
        childNode.setTextContent(nodeContent);
        node.appendChild(childNode);
        // document.getDocumentElement().appendChild(node);
    }

    /**
     *
     * <p>Title: cleanEdit</p>
     * <p>author : xuyushuai</p>
     * <p>date : 2014年10月28日 上午10:13:34</p>
     * 
     * @param document
     */
    public static void cleanGlobalConfigEdit(Document document) {
        Element node = (Element) document.getElementsByTagName("global").item(0);

        if (node.getElementsByTagName("servicePrefix").item(0) != null) {
            Node oldNode = (Element) node.getElementsByTagName("servicePrefix").item(0);
            node.removeChild(oldNode);
        }
        if (node.getElementsByTagName("managerPrefix").item(0) != null) {
            Node oldNode = (Element) node.getElementsByTagName("managerPrefix").item(0);
            node.removeChild(oldNode);
        }

        if (node.getElementsByTagName("daoPrefix").item(0) != null) {
            Node oldNode = (Element) node.getElementsByTagName("daoPrefix").item(0);
            node.removeChild(oldNode);
        }

        if (node.getElementsByTagName("beanPrefix").item(0) != null) {
            Node oldNode = (Element) node.getElementsByTagName("beanPrefix").item(0);
            node.removeChild(oldNode);
        }
        if (node.getElementsByTagName("hasNotes").item(0) != null) {
            Node oldNode = (Element) node.getElementsByTagName("hasNotes").item(0);
            node.removeChild(oldNode);
        }
        if (node.getElementsByTagName("hasInterface").item(0) != null) {
            Node oldNode = (Element) node.getElementsByTagName("hasInterface").item(0);
            node.removeChild(oldNode);
        }
        if (node.getElementsByTagName("hasTryCatch").item(0) != null) {
            Node oldNode = (Element) node.getElementsByTagName("hasTryCatch").item(0);
            node.removeChild(oldNode);
        }
        if (node.getElementsByTagName("outputPath").item(0) != null) {
            Node oldNode = (Element) node.getElementsByTagName("outputPath").item(0);
            node.removeChild(oldNode);
        }
    }

    /**
     *
     * <p>Title: cleanDatabaseEdit</p>
     * <p>author : xuyushuai</p>
     * <p>date : 2014年10月28日 上午10:31:43</p>
     * 
     * @param document
     */
    public static void cleanDatabaseEdit(Document document) {
        if (document.getElementsByTagName("database").item(0) != null) {
            Element node = (Element) document.getElementsByTagName("database").item(0);

            if (node.getElementsByTagName("table").item(0) != null) {
                Node oldNode = (Element) node.getElementsByTagName("table").item(0);
                node.removeChild(oldNode);
            }
        }
    }
}
