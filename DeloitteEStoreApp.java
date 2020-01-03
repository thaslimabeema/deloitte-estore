package com.deloitte.estore.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.deloitte.estore.model.Product;
import com.deloitte.estore.service.ProductService;
import com.deloitte.estore.service.ProductServiceImpl;

public class DeloitteEStoreApp 
{
	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ProductService service=new ProductServiceImpl();
		System.out.println("Enter your choice");
		System.out.println("1.add 2.delete 3.update 4.getbyid 5.list");
		int ch=Integer.parseInt(br.readLine());
		switch(ch)
		{
		
		
		
case 1:	Product p1=new Product(189,"mobile",400);
		try {
			if(service.addProduct(p1))
			{System.out.println("product added");}
			else
				System.out.println("not added");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	    break;

		
	
case 2:	Product p2=new Product(189,null,0);
		try {
		 if(service.deleteProduct(p2))
			{System.out.println("product deleted");}
			else
				System.out.println("not ");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	    break;
		
	
case 3:	Product p3=new Product(101,"watch",90);
		try {
		   if(service.updateProduct(p3))
			{System.out.println("product updated");}
			else
				System.out.println("not ");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		break;
		
	
case 4:	int prodId;
		System.out.println("enter id");
		prodId=Integer.parseInt(br.readLine());
		Product p=new Product();
		try {
			    p=service.getProductById(prodId);
			    if(p!=null)
				{System.out.println(p.toString());}
				 else
				 	System.out.println("not ");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			break;
			
case 5:  List<Product> products=new ArrayList<>();
		 try
		 {
			 products=service.getAllProducts();
			 System.out.println(products);
		 }
		 catch(Exception e)
			{
				e.printStackTrace();
			}
			break;
			 
		
		
		
		
		
			

		}
		
	}

}

