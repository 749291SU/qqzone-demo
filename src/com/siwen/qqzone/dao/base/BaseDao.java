package com.siwen.qqzone.dao.base;


import com.siwen.qqzone.dao.utils.Jdbc;
import com.siwen.qqzone.exceptions.DaoException;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: LearnJava
 * @package: com.siwen.fruit.dao.base
 * @className: BaseDao
 * @author: 749291
 * @description: TODO
 * @date: 2/8/2023 4:59 PM
 * @version: 1.0
 */

public abstract class BaseDao<T> {
    protected int update(String sql, Object... params) {
        try {
            Connection connection = Jdbc.getConnection();
//            System.out.println(connection);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int effectedRows = 0;
            if (preparedStatement != null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }
                effectedRows = preparedStatement.executeUpdate();
            }
            preparedStatement.close();
            if (connection.getAutoCommit()) {
                connection.close();
            }
            return effectedRows;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException("Dao update encountered mistakes.");
        }
    }

    protected List<T> query(String sql, Object... params) {
        try {
            Connection connection = Jdbc.getConnection();
//            System.out.println(connection);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            List<T> resultList = null;
            if (preparedStatement != null) {
                resultList = new ArrayList<>();
                ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
                Class actualTypeArgument = (Class) parameterizedType.getActualTypeArguments()[0];

                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1, params[i]);
                }

                ResultSet resultSet = preparedStatement.executeQuery();
                ResultSetMetaData metaData = resultSet.getMetaData();

                int columnCount = metaData.getColumnCount();
                while (resultSet.next()) {
                    T t = (T) actualTypeArgument.getDeclaredConstructor().newInstance();
                    for (int i = 1; i <= columnCount; i++) {
                        setVal(actualTypeArgument, t, metaData.getColumnLabel(i), resultSet.getObject(i));
                    }
                    resultList.add(t);
                }
                resultSet.close();
                preparedStatement.close();
            }
            if (connection.getAutoCommit()) {
                connection.close();
            }
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new DaoException("Dao query encountered mistakes");
        }
    }

    private void setVal(Class clazz, T t, String fieldName, Object fieldValue) throws Exception {
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);

        String typeName = field.getType().getName();
        if (checkNoPrimitiveType(typeName)) {
            fieldValue = Class.forName(typeName).getDeclaredConstructor(fieldValue.getClass()).newInstance(fieldValue);
        }
        field.set(t, fieldValue);
    }
    private boolean checkNoPrimitiveType(String typeName) {
        if ("java.lang.Integer".equals(typeName)
            || "java.lang.String".equals(typeName)
             || "java.time.LocalDateTime".equals(typeName)) {
            return false;
        }
        return true;
    }
}