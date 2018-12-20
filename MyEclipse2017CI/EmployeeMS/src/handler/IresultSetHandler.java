package handler;

import java.sql.ResultSet;

public interface IresultSetHandler<T> {
	T handler(ResultSet rs) throws Exception;
}
