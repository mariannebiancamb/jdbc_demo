package model.DAO.impl;

import db.DB;
import model.DAO.SellerDAO;

public class DaoFactory {

    //So apra nao ter aceso diretamento a entidadeDAO
    public static SellerDAO createSellerDAO (){
        return new SellerDAOimplJDBC(DB.getConnection());
    }

}
