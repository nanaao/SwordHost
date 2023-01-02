package com.swordHostDemo.Dao;

import com.swordHostDemo.Dao.impl.VaulesMenuDaoImpl;

/**
 * @date: 2022/12/31 9:25
 * @description:
 */
public class VaulesMenuDao implements VaulesMenuDaoImpl {


    @Override
    public String updataValues(String nameValue, String name) {
        String sql = "UPDATE menu SET namevalue='"+nameValue+"' WHERE name='"+name+"';";
        return sql;
    }

    @Override
    public String selectValues() {
        String sql = "SELECT * FROM menu WHERE name = ?";
        return sql;
    }

    @Override
    public String updataCustomValues(String nameValue, String name) {
        String sql ="UPDATE custom SET namevalue='"+nameValue+"' WHERE name='"+name+"';";
        return sql;
    }
}
