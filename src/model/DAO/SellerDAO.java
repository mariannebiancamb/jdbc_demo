package model.DAO;

import model.entities.Seller;

import java.util.List;

public interface SellerDAO {

    void insert(Seller seller);
    void update(Seller seller);
    void deleteByID(Integer id);
    Seller findById(Integer id);
    List<Seller> findByDepartment(Integer id);
    List<Seller> findAll();

}
