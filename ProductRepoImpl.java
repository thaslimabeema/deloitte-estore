package com.deloitte.estore.repo;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.deloitte.estore.model.Product;

public class ProductRepoImpl implements ProductRepo {
 
	@Override
	public Connection getDbConnection() {
		Connection con=null;
		// TODO Auto-generated method stub
		try{con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
		 		"system","admin");
		
		}
		catch(Exception e) {
			System.out.println(e+"error");
		}
		return con;
	
	}

	@Override
	public boolean addProduct(Product product) throws Exception
	{
		Connection con=getDbConnection();
		PreparedStatement ps=con.prepareStatement("insert into product values(?,?,?)");
		ps.setInt(1, product.getPid());
		ps.setString(2, product.getPname());
		ps.setFloat(3,product.getPrice());
		 
	 
		return ps.executeUpdate()>0;
	}

	@Override
	public boolean deleteProduct(Product product) throws Exception {
		Connection con=getDbConnection();
		PreparedStatement ps=con.prepareStatement("delete from product where pid=?");
		ps.setInt(1, product.getPid());
		return ps.executeUpdate()>0;
		
	 
	}

	@Override
	public boolean updateProduct(Product product) throws Exception {
		Connection con=getDbConnection();
		PreparedStatement ps=con.prepareStatement("update product set pname= ?,price=? where pid=?");
		ps.setInt(3, product.getPid());
		ps.setString(1, product.getPname());
		ps.setFloat(2,product.getPrice());
		 
	 
		return ps.executeUpdate()>0;
		 
	}

	@Override
	public Product getProductById(int productId) throws Exception{
		
		Connection con=getDbConnection();
		PreparedStatement ps=con.prepareStatement("select * from product where pid=?");
		 ps.setInt(1, productId);
		 ResultSet rs=ps.executeQuery();
		 if(rs.next())
		 {
		 Product pr=new Product();
		 pr.setPid(productId);
		 pr.setPname(rs.getString("pname"));
		 pr.setPrice(rs.getFloat("price"));
		return pr;
		 }
		 return null;
	}

	@Override
	public List<Product> getAllProducts() throws Exception{
		 
			Connection con=getDbConnection();
			PreparedStatement ps=con.prepareStatement("select * from product");
			// ps.setInt(1, productId);
			 ResultSet rs=ps.executeQuery();
			 List<Product> products=new ArrayList<>();
			
			 while(rs.next())
			 {
			 Product product=new Product();
			 product.setPid(rs.getInt("pid") );
			 product.setPname(rs.getString("pname"));
			 product.setPrice(rs.getFloat("price"));
			 products.add(product);
			 }
				return products;
	}

}
