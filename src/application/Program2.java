package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("----Teste #1: Department findById----");
		Department department= departmentDao.findById(3);
		System.out.println(department);

		
		System.out.println("\n----Teste #2: Department findAll----");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		for (Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n----Teste #3: Department Insert----");
		
		Department newDepartment = new Department(null, "Tools");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = "+newDepartment.getId());
		
		System.out.println("\n----Teste #4: Department Update ----");
		department = departmentDao.findById(4);
		department.setName("Clothes");
		departmentDao.update(department);
		System.out.println("Update Completed! "+department);
		
		System.out.println("\n----Teste #5: Department Delete----");
		System.out.println("Digite o Id para ser deletado: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete Completed! ");
		
		sc.close();

	}

}
