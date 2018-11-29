package Util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import config.MyConfig;
import config.ResultConfig;
@SuppressWarnings("all")
public class MyUtil {
	public static Map<String, MyConfig> getMap() {
		InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("resources/Action.xml");
		Map<String,MyConfig> ConfigMap = new HashMap<String,MyConfig>();
		try {
			NodeList nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in).getElementsByTagName("action");
			System.out.println(nodeList.getLength());
			for (int i = 0; i < nodeList.getLength(); i++) {;
				Element actionElement = (Element) nodeList.item(i);
				String name = actionElement.getAttribute("name");
				String className = actionElement.getAttribute("class");
				String method = actionElement.getAttribute("method");
				NodeList resultNodeList = actionElement.getElementsByTagName("result");
				Map<String,ResultConfig> ResultMap = new HashMap<String,ResultConfig>();
				for (int j = 0; j < resultNodeList.getLength(); j++) {
					System.out.println(i);
					Element resultActionEl = (Element) resultNodeList.item(j);
					System.out.println(resultActionEl.getAttribute("name"));
					String resultName = resultActionEl.getAttribute("name");
					String resultType = resultActionEl.getAttribute("type");
					String resultPath = resultActionEl.getTextContent();
					ResultConfig resultConfig = new ResultConfig(resultName, resultType, resultPath);
					ResultMap.put(resultName, resultConfig);
				}
				MyConfig config = new MyConfig(name, className, method);
				config.setResultMap(ResultMap);
				ConfigMap.put(name, config);
			}
			return ConfigMap;
		} catch (SAXException | IOException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static ResultConfig goAction(MyConfig config) {
		try {
			Class actionClass = Class.forName(config.getClassName());
			Object object = actionClass.getDeclaredConstructor().newInstance();
			Method actionMethod = actionClass.getMethod(config.getMethod());
			String resultName = (String) actionMethod.invoke(object);
			System.out.println(resultName);
			if (StingUtil.hasLength(resultName)) {
				System.out.println(resultName);
				ResultConfig resultConfig = config.getResultMap().get(resultName);
				System.out.println(resultConfig);
				return resultConfig;
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
