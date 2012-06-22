package org.mybatisorm.sql.source;

import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.SqlCommandType;
import org.mybatisorm.annotation.SqlCommand;
import org.mybatisorm.sql.builder.DynamicSqlBuilder;

@SqlCommand(SqlCommandType.UPDATE)
public abstract class AbstractUpdateSqlSource extends DynamicSqlBuilder {

	protected String where;
	
	public AbstractUpdateSqlSource(SqlSourceBuilder sqlSourceParser, Class<?> clazz) {
		super(sqlSourceParser,clazz);
		staticSql = "UPDATE " + handler.getName() + " SET ";
		where = handler.getPrimaryKeyColumnEqualFieldAnd();
	}
	
	protected BoundSql makeSet(String set, Object parameter) {
		StringBuilder sb = new StringBuilder(staticSql);
		sb.append(set).append(" WHERE ").append(where);
		return getBoundSql(sb.toString(),parameter);
	}
}
