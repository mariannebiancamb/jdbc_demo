import model.DAO.SellerDAO;
import model.DAO.impl.DaoFactory;
import model.entities.Department;
import model.entities.Seller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        SellerDAO sellerDAO = DaoFactory.createSellerDAO();

        System.out.println("========== TEST 1 =========");
        System.out.println();
        Seller seller1 = sellerDAO.findById(2);
        System.out.println(seller1);
        System.out.println();

        System.out.println("========== TEST 2 =========");
        System.out.println();
        List<Seller> seller2 = sellerDAO.findByDepartment(4);
        seller2.forEach(System.out::println);
        System.out.println();

        System.out.println("========== TEST 3 ==========");
        System.out.println();
        List<Seller> seller3 = sellerDAO.findAll();
        seller3.forEach(System.out::println);
        System.out.println();

        System.out.println("========== TEST 3 ==========");
        System.out.println();
        sellerDAO.deleteByID(10);
        System.out.println("Seller delected!");
        sellerDAO.insert(seller1);
        System.out.println("Seller was insert!");

        Department dep = new Department(1, "Shoes");
        Seller seller = new Seller(7, "Marianne Bianca", "marianneb@email.com", new Date(1996, Calendar.FEBRUARY,24), 3000.0, dep);
        sellerDAO.update(seller);
        System.out.println("User update!");
    }


}
