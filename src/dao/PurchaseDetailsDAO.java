package dao;
import java.util.List;
import classes.Purchase;
import classes.PurchaseDetails;

public interface PurchaseDetailsDAO {

	public boolean create( long id , String description , int quantity , Double value);
	public boolean delete( long id );
	public boolean updateQuantity( long id , int quantity );
	public boolean updateDescription( long id , String description );
	public List< PurchaseDetails > findAllByListPurchase( List< Purchase >  listPurchase );

}
