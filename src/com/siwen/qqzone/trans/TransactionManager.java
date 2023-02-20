package com.siwen.qqzone.trans;


import com.siwen.qqzone.dao.utils.Jdbc;

/**
 * @projectName: JavaWeb
 * @package: siwen.trans
 * @className: TransactionManager
 * @author: 749291
 * @description: TODO
 * @date: 2/13/2023 8:11 PM
 * @version: 1.0
 */

public class TransactionManager {
    public static void openTrans() throws Exception {
        Jdbc.getConnection().setAutoCommit(false);
    }
    public static void commit() throws Exception {
        Jdbc.getConnection().commit();
        Jdbc.freeConnection();
    }
    public static void rollback() throws Exception {
        Jdbc.getConnection().rollback();
        Jdbc.freeConnection();
    }
}
