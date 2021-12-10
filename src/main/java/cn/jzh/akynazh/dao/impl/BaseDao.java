package cn.jzh.akynazh.dao.impl;

import cn.jzh.akynazh.util.JdbcUtils;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;

public class BaseDao {
    private final QueryRunner runner = new QueryRunner();
    public int update(String sql, Object...args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return  runner.update(conn, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null, null, conn);
        }
        return -1;
    }
    public <T> T queryForOne(Class<T> type, String sql, Object...args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return runner.query(conn, sql, new BeanHandler<>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null, null, conn);
        }
        return null;
    }
    public <T> List<T> queryForList(Class<T> type, String sql, Object...args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return runner.query(conn, sql, new BeanListHandler<>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null, null, conn);
        }
        return null;
    }
    public Object queryForSingleValue(String sql, Object...args) {
        Connection conn = JdbcUtils.getConnection();
        try {
            return runner.query(conn, sql, new ScalarHandler<>(), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(null, null, conn);
        }
        return null;
    }
}
