package org.mybatisorm.sql.source;

import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.SqlCommandType;
import org.mybatisorm.annotation.AnnotationUtil;
import org.mybatisorm.annotation.SqlCommand;
import org.mybatisorm.sql.builder.DynamicSqlBuilder;

@SqlCommand(SqlCommandType.DELETE)
public class DeleteSqlSource extends DynamicSqlBuilder {

	public DeleteSqlSource(SqlSourceBuilder sqlSourceParser, Class<?> clazz) {
		super(sqlSourceParser);
		staticSql = "DELETE FROM "+AnnotationUtil.getTableName(clazz);
	}

	public BoundSql getBoundSql(Object parameter) {
		String where = AnnotationUtil.getNotNullColumnEqualFieldAnd(parameter);
		return makeWhere(where,parameter);
	}

}