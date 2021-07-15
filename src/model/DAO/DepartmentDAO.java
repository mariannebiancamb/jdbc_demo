package model.DAO;

import model.entities.Department;

import java.util.List;

public interface DepartmentDAO {
    void insert(Department department);
    void update(Department department);
    void deleteByID(Integer id);
    Department findById(Integer id);
    List<Department> findAll();

}
