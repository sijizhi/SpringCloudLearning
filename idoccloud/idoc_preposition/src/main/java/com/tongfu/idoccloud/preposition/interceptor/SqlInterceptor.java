package com.tongfu.idoccloud.preposition.interceptor;

import com.tongfu.idoccloud.preposition.utils.DbUtil;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.Properties;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/1/16 13:52
 */
@Intercepts(value = {
        @Signature(type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class,Integer.class})})
public class SqlInterceptor implements Interceptor {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String preState="/*!mycat:schema=";
    private static final String afterState="*/";
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler=(StatementHandler)invocation.getTarget();
        MetaObject metaStatementHandler= SystemMetaObject.forObject(statementHandler);
        String sql=(String)metaStatementHandler.getValue("delegate.boundSql.sql");
        String db_name= DbUtil.getDbName();
        if(db_name.isEmpty()){
            logger.error("db name is null");
            return null;
        }else{
            sql = preState + db_name + afterState + sql;
        }
        System.out.println("sql is "+sql);
        metaStatementHandler.setValue("delegate.boundSql.sql",sql);
        Object result = invocation.proceed();
        return result;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
