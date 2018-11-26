package smis.handler.impl;

import java.sql.ResultSet;

import smis.handler.IresultSetHandler;

public class ScalarHander <T> implements IresultSetHandler<T>{

	private Class<T> clz;
	
	public ScalarHander(Class<T> clz) {
		super();
		this.clz = clz;
	}
	@Override
	public T handler(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		T obj = null;
		Class<?> type = clz;
		if (rs.next()) {
			Object value = rs.getObject(1);
			if (clz == Long.class) {
				type = long.class;
			}else if(clz == Integer.class) {
				type = int.class;
			}
			obj = clz.getConstructor(type).newInstance(value);
		}
		return obj;
	}

}
