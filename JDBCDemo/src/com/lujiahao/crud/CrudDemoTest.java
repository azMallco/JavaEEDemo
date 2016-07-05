package com.lujiahao.crud;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by lujiahao on 2016/7/5.
 */
public class CrudDemoTest {

    private CrudDemo crudDemo;

    @Before
    public void setUp() throws Exception {
        crudDemo = new CrudDemo();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void save() throws Exception {
        crudDemo.save();
    }

    @Test
    public void delete() throws Exception {
        crudDemo.delete();
    }

    @Test
    public void update() throws Exception {
        crudDemo.update();
    }

    @Test
    public void findAll() throws Exception {
        crudDemo.findAll();
    }

}