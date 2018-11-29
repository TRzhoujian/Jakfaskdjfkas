package config;

import java.util.HashMap;
import java.util.Map;

public class MyConfig {
	private String name;
	private String ClassName;
	private String Method;
	private Map<String,ResultConfig> ResultMap = new HashMap<String,ResultConfig>();
	public MyConfig(String name, String className, String method) {
		super();
		this.name = name;
		ClassName = className;
		Method = method;
	}
	public MyConfig() {
	}
	
	
	public Map<String, ResultConfig> getResultMap() {
		return ResultMap;
	}
	public void setResultMap(Map<String, ResultConfig> resultMap) {
		ResultMap = resultMap;
	}
	@Override
	public String toString() {
		return "MyConfig [name=" + name + ", ClassName=" + ClassName + ", Method=" + Method + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public String getMethod() {
		return Method;
	}
	public void setMethod(String method) {
		Method = method;
	}
}
