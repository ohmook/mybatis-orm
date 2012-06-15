package org.mybatisorm.sql.source.oracle;

import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.log4j.Logger;
import org.mybatisorm.annotation.handler.ColumnHandler;
import org.mybatisorm.annotation.handler.FieldList;
import org.mybatisorm.sql.source.AbstractInsertSqlSource;

public class InsertSqlSource extends AbstractInsertSqlSource {

	private static Logger logger = Logger.getLogger(InsertSqlSource.class);
	
	public InsertSqlSource(SqlSourceBuilder sqlSourceParser, Class<?> clazz) {
		super(sqlSourceParser,clazz);
	}

	public BoundSql getBoundSql(final Object parameter) {
		return getBoundSql(parameter,ColumnHandler.getNotNullFieldList(parameter));
	}
}