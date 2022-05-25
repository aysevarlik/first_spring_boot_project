package com.aysevarlik.springboothomework.database.dao;

import com.aysevarlik.springboothomework.database.DatabaseConnection;

import java.sql.Connection;
import java.util.ArrayList;

    public interface daoConnection<T> {
        public void create(T t);
        public void update(T t);
        public void delete(T t);
        public ArrayList<T> list();

        default Connection getInterfaceConnection(){
            return DatabaseConnection.getInstance().getConnection();
        }



    }

