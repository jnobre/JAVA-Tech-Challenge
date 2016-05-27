package dao;

import java.util.Date;
import java.util.List;

import classes.Purchase;
import classes.PurchaseDetails;

public interface PurchaseDAO {

	public boolean create( long id , String productType , Date expire , PurchaseDetails detail);
	public boolean delete( long id );
	public boolean updateExpireTime( long id , Date expire );
	public List< Purchase > findByAllPurchase( );
	public List< Purchase > findByExpireDate( Date expire );
	public List< Purchase > findByID( long id );
}

