package aplication;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		//Department dp = new Department(1, "Eletronics");
		//Seller sl = new Seller(1, "Rafael", "eng@gmail.com", new Date(), 3350.50, dp);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== Test 1: Seller findById! ===");
		Seller seller = sellerDao.findById(3);		
		System.out.println(seller);
		
		System.out.println("=== Test 2: Seller findByDepartment! ===");
		Department dp = new Department(2, null);
		List<Seller> slr = sellerDao.findByDepartment(dp);
		for (Seller x : slr) {
			System.out.println(x);
		}
		
		System.out.println("=== Test 3: Seller findAll! ===");		
		slr = sellerDao.findAll();
		for (Seller x : slr) {
			System.out.println(x);
		}
		
		System.out.println("=== Test 4: Seller insert! ===");
		Seller newSeller = new Seller(null, "Bella", "bella@gmail.com", new Date(), 9999.9, dp);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! Id: " + newSeller.getId());
		
		System.out.println("=== Test 5: Seller update! ===");
		seller = sellerDao.findById(1);
		System.out.println("Before: " + seller);
		seller.setName("Rafael Martins");
		sellerDao.update(seller);
		System.out.println("After: " + seller);
		
		System.out.println("=== Test 6: Seller delete! ===");
		int id = 3;
		sellerDao.deleteById(id);
		System.out.println("Seller deleted!");
	}
}
