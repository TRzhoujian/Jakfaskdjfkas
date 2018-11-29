package miniMVC;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Util.ActionContext;
import config.MyConfig;
@SuppressWarnings("all")
public class MyAction {
	public String execute() throws Exception	 {
		String name = ActionContext.getContext().getRequest().getParameter("name");
		System.out.println(name);
		return "list";
	}
}
