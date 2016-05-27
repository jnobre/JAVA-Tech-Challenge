package testing;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import classes.Purchase;
import classes.PurchaseDetails;
import dao.PurchaseDAO;

public class PurchaseTesting implements PurchaseDAO {
	/**TODO Junit em falta **/
	
	public PurchaseTesting( ){ }
	@Override
	public boolean create(long id, String productType, Date expire, PurchaseDetails detail) {
		//TODO nao implementado
		return true;
	}

	@Override
	public boolean delete(long id) {
		//TODO nao implementado
		return true;
	}

	@Override
	public boolean updateExpireTime(long id, Date expire) {
		//TODO nao implementado
		return true;
	}

	@Override
	public List<Purchase> findByAllPurchase() {
		List< Purchase > listaux = new LinkedList< Purchase >( );
		long time = 123456;
		Date _date = new Date( time );
		
		for( int i = 0 ; i < 20 ; i++ ){
			if( i > 10 )
				listaux.add( new Purchase( (long) i , "type1" , new Date(  ) , new PurchaseDetails( (long) (i+1) , "example" + i , i , 200 * i  ) ) );
			else
				listaux.add( new Purchase( (long) i , "type1" , _date , new PurchaseDetails( (long) (i+1) , "example" + i , i , 200 * i  ) ) );
		}
		
		return listaux;
	}

	@Override
	public List<Purchase> findByExpireDate(Date expire) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Purchase> findByID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
