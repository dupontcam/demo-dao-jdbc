package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== TEST 1: department findById =====");
		Department dep = depDao.findById(3);		
		System.out.println(dep);
		
		System.out.println("\n==== TEST 2: department findAll =====");
		List<Department> list = depDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("==== TEST 3 : department insert =====");
		dep = new Department(null, "Music");
		depDao.insert(dep);
		System.out.println("Inserted! New id = " + dep.getId());
		
		System.out.println("\n=== TEST 4: department update =====");
		dep = depDao.findById(1);
		dep.setName("D4");
		depDao.update(dep);
		System.out.println("Update completed");
		
		System.out.println("\n=== TEST 5: department deleteById =====");
		System.out.println("Enter id for delete test: ");
		int id = in.nextInt();
		depDao.deleteById(id);
		System.out.println("Delete completed");
		
		in.close();

	}

}
