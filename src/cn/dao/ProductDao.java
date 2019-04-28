package cn.dao;

import cn.model.Product;
import cn.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductDao {

    public static void main(String[] args) {

//        dao.save("huawei", 1800, "lalala");
        ProductDao dao = new ProductDao();
//        dao.update(4,"meizu", 1800, "lalala");
//        dao.del(4);
        Product product=new Product();
        product.setId(3);
        product.setName("xiaomi");
        product.setPrice(9999);
        product.setRemark("llala");
        dao.update(product);

    }

    public void save(String name, double price, String remark) {
        //1 获取数据库连接对象 2 传入参数
        String sql = "insert into product (name ,price,remark) values (?,?,?) ";
        Connection con = JdbcUtils.getConnection();
        PreparedStatement pre = null;
        try {
            pre = con.prepareStatement(sql);
            //配置参数
            pre.setString(1, name);
            pre.setDouble(2, price);
            pre.setString(3, remark);
            pre.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void del(int id) {
        //1 获取数据库连接对象 2 传入参数
        String sql = "delete from product where id=? ";
        Connection con = JdbcUtils.getConnection();
        PreparedStatement pre = null;
        try {
            pre = con.prepareStatement(sql);
            //配置参数
            pre.setInt(1, id);
            pre.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void update(Product product) {
        //1 获取数据库连接对象 2 传入参数
        String sql = "update product set name=?,price=?,remark=? where id=?;";
        Connection con = JdbcUtils.getConnection();
        PreparedStatement pre = null;
        try {
            pre = con.prepareStatement(sql);
            //配置参数
            pre.setString(1, product.getName());
            pre.setDouble(2, product.getPrice());
            pre.setString(3, product.getRemark());
            pre.setInt(4, product.getId());
            pre.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }
}