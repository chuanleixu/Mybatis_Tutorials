package com.xcl.mybatis;

import com.xcl.mybatis.beans.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

/**
 * @version 1.0
 * @author chuanlei.xu
 * @date 2019/3/21 11:09
 */



public class TestMybatis {

    @Test
    public void testSqlSessionFactory() throws Exception{

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println(sqlSessionFactory);
        SqlSession session = sqlSessionFactory.openSession();
        System.out.println(session);

        try {
            Employee employee = (Employee) session.selectOne("org.mybatis.example.EmployeeMapper.selectEmployee", 1);
            System.out.println(employee);
        } finally {
            session.close();
        }
    }
}
