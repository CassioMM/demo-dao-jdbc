package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("\n=== Test 1: department findById ===");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);
		
		
		System.out.println("\n=== Test 2: department findAll ===");
		List<Department> list = departmentDao.findAll();
		
		for(Department d : list) {
			System.out.println(d);
		}
		
		
		System.out.println("\n=== Test 3: department insert ===");
		Department newDep = new Department(null, "Music");
		departmentDao.insert(newDep);
		System.out.println("Inserted! New id = " + newDep.getId());

		
		System.out.println("\n=== Test 4: department update ===");
		dep = departmentDao.findById(8);
		dep.setName("library");
		departmentDao.update(dep);
		System.out.println("Update completed");
		
		
		System.out.println("\n=== Test 5: department delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete complected");
		
		sc.close();
	}
}
