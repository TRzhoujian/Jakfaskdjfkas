package smis.handler.impl;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

import smis.handler.IresultSetHandler;

public class BeanHandler <T> implements IresultSetHandler<T>{

	private Class<T> clz;
	
	public BeanHandler(Class<T> clz) {
		super();
		this.clz = clz;
	}
	@Override
	public T handler(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		T obj = null;
		if (rs.next()) {
			obj = clz.getDeclaredConstructor().newInstance();
			PropertyDescriptor[] pds = Introspector.getBeanInfo(clz,Object.class).getPropertyDescriptors();
			for (PropertyDescriptor pd : pds) {
				String name = pd.getName();
				Object value = rs.getObject(name);
				pd.getWriteMethod().invoke(obj, value);
			}
		}
		
		return obj;
	}

}
