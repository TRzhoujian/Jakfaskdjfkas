package smis.handler.impl;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import smis.handler.IresultSetHandler;

public class BeanListHandler<T> implements IresultSetHandler<List<T>> {
	private Class<T> clz;

	public BeanListHandler(Class<T> clz) {
		super();
		this.clz = clz;
	}
	@Override
	public List<T> handler(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		List<T> list = new ArrayList<>();
		PropertyDescriptor[] pds = Introspector.getBeanInfo(clz,Object.class).getPropertyDescriptors();
		while(rs.next()) {
			T obj = clz.getDeclaredConstructor().newInstance();
			for (PropertyDescriptor pd : pds) {
				String name = pd.getName();
				Object value = rs.getObject(name);
				pd.getWriteMethod().invoke(obj, value);
			}
			list.add(obj);
		}
		return list;
	}

}
