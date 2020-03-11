package cn.tedu.test;

import cn.tedu.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * mybatis实现CRUD
 */
public class Test01 {
    private SqlSession session = null;
    @Before
    public void before() throws IOException {
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();

    }

    @After
    public void after(){
        session.close();
    }

    /**
     * delete操作
     */
    @Test
    public void test09(){
        List<Integer> list = Arrays.asList(7,8);
        session.delete("cn.tedu.UserMapper.delete03",list);
        session.commit();
    }

    /**
     * delete操作
     */
    @Test
    public void test08(){
        User user = new User(9,"xxx",33);
        session.delete("cn.tedu.UserMapper.delete02",user);
        session.commit();
    }

    /**
     * delete操作
     */
    @Test
    public void test07(){
        session.delete("cn.tedu.UserMapper.delete01",11);
        session.commit();
    }

    /**
     * insert操作
     */
    @Test
    public void test06(){
        User user = new User(0,"zzz",44);
        session.insert("cn.tedu.UserMapper.insert02",user);
        session.commit();
    }

    /**
     * insert操作
     */
    @Test
    public void test05(){
        User user = new User(0,"xxx",33);
        session.insert("cn.tedu.UserMapper.insert01",user);
        session.commit();
    }

    /**
     * select操作
     */
    @Test
    public void test04(){
        User user = new User(4,"ddd",19);
        List<User> list = session.selectList("cn.tedu.UserMapper.selc02",user);
        System.out.println(list);
    }

    /**
     * select操作
     */
    @Test
    public void test03(){
        List<User> list = session.selectList("cn.tedu.UserMapper.selc01",3);
        System.out.println(list);
    }

    /**
     * update操作
     */
    @Test
    public void test02(){
        User user = new User(7,"zs",18);
        session.update("cn.tedu.UserMapper.update02",user);
        session.commit();
    }

    /**
     * update操作
     */
    @Test
    public void test01(){
        User user = new User(7,"ls",19);
        session.update("cn.tedu.UserMapper.update01",user);
        session.commit();
    }
}
