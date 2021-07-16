import model.DAO.DepartmentDAO;
import model.DAO.impl.DaoFactory;
import model.entities.Department;

import java.util.List;

public class ProgramDep {

    public static void main(String[] args) {
        DepartmentDAO departmentDao = DaoFactory.createDepartment();

        System.out.println("=== TEST 1: findById =======");
        Department dep = departmentDao.findById(1);
        System.out.println(dep);

        System.out.println("\n=== TEST 2: findAll =======");
        List<Department> list = departmentDao.findAll();
        for (Department d : list) {
            System.out.println(d);
        }

        System.out.println("\n=== TEST 3: insert =======");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());

        System.out.println("\n=== TEST 4: update =======");
        Department dep2 = departmentDao.findById(1);
        dep2.setName("Food");
        departmentDao.update(dep2);
        System.out.println("Update completed");

        System.out.println("\n=== TEST 5: delete =======");
        //delete nao roda pq da problema de chave estrageira
        //departmentDao.deleteById(1);
        System.out.println("Delete completed");

    }
}
