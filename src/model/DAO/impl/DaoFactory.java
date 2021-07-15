package model.DAO.impl;

import model.DAO.SellerDAO;

public class DaoFactory {

    public static SellerDAO createSellerDAO (){
        return new SellerDAOimplJDBC();
    }

}
