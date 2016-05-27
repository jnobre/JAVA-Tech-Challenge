package testing;

import java.util.LinkedList;
import java.util.List;

import classes.Purchase;
import classes.PurchaseDetails;
import dao.PurchaseDetailsDAO;

public class PurchaseDetailTesting implements PurchaseDetailsDAO{
	/**TODO Junit em falta **/
	
	public PurchaseDetailTesting( ){ }
	
	@Override
	public boolean create(long id, String description, int quantity, Double value) {
		// TODO não implementado
		return true;
	}

	@Override
	public boolean delete(long id) {
		// TODO não implementado
		return true;
	}

	@Override
	public boolean updateQuantity(long id, int quantity) {
		// TODO não implementado
		return true;
	}

	@Override
	public boolean updateDescription(long id, String description) {
		// TODO não implementado
		return true;
	}

	@Override
	public List<PurchaseDetails> findAllByListPurchase(List<Purchase> listPurchase) {
		List< PurchaseDetails > listaux = new LinkedList< PurchaseDetails >( );
		for( int i = 0 ; i < 20 ; i++ ){
			listaux.add(  new PurchaseDetails( (long) (i+1) , "example" + i , i , 200 * i  ) );
		}
		return listaux;
	}

	
	
}
