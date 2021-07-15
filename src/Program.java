import model.DAO.SellerDAO;
import model.DAO.impl.DaoFactory;
import model.entities.Seller;

public class Program {

    public static void main(String[] args) {
        SellerDAO sellerDAO = DaoFactory.createSellerDAO();

        System.out.println("===== TEST 1 =====");
        Seller seller = sellerDAO.findById(1);
        System.out.println(seller);
    }
}
