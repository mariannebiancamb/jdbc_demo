package model.DAO.impl;

import db.DB;
import model.DAO.DepartmentDAO;
import model.DAO.SellerDAO;

public class DaoFactory {

    //So apra nao ter aceso diretamento a entidadeDAO
    public static SellerDAO createSellerDAO (){
        return new SellerDAOimplJDBC(DB.getConnection());
    }

    public static DepartmentDAO createDepartment() { return  new DepartmentDAOJBDC(DB.getConnection());}

}
