package companys;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import classes.Purchase;
import classes.PurchaseDetails;
import testing.PurchaseDetailTesting;
import testing.PurchaseTesting;

public class Info {
	
	public Info( ){}
	
	/**
	 * Get all purchases within the validity (current time < expiry Date)
	 * @return 
	 */
	public String getValidPurchase(  ) {
		System.out.println( "Start..." ); //TODO log4j
		List< Purchase > listPurchase 		 = new LinkedList< Purchase >( );
		List< Purchase > listPurchaseValid 	 = new LinkedList< Purchase >( );
		List< PurchaseDetails > listPurchaseDetails = new LinkedList< PurchaseDetails >( ); 
		//PurchaseDAO values = null; /* interface não implementada */
		//PurchaseDetailsDAO valuesDetails = null; /* interface não implementada */
		PurchaseTesting values = new PurchaseTesting( ); 
		PurchaseDetailTesting valuesDetails = new PurchaseDetailTesting( );
		Date currentTime = new Date( );
		StringBuilder textFormat = new StringBuilder( );
		listPurchase = values.findByAllPurchase( ); /** get Purchase assume result is not sorted **/
		
		Collections.sort( listPurchase ); /** order by expire date **/
		
		for( Purchase purchase : listPurchase ) { /** build new list only valid purchases **/
			if( currentTime.after( purchase.getExpire( ) ) ) 
				 break;
			 else
				 listPurchaseValid.add( purchase );
		}
		listPurchaseDetails = valuesDetails.findAllByListPurchase( listPurchaseValid ); /** get purchase details **/
		
		/** Transform in textual data format **/
		for( PurchaseDetails detail : listPurchaseDetails ) {
			textFormat.append( "ID [".concat( String.valueOf( detail.getId( ) ) ).concat("] Description[" ).concat( detail.getDescription() ).concat( "] Quanitty[" ) .concat( String.valueOf( detail.getQuantity( ) ) ).concat( "] Value[" ).concat( String.valueOf( detail.getValue( ) ) ).concat( "]" ) );
			textFormat.append( "\n" );
		}
		return textFormat == null || textFormat.length( ) <= 0  ? "" : textFormat.toString( ) ;
	}
	
	
	/**
	 * Second operation:  storing - or handling updates - on the product purchases
	 * @param _idPurchose
	 * @param _idPurchoseDetail
	 * @param _quantity
	 * @param _productType
	 * @param _description
	 * @param _expireDate
	 * @param _value
	 * @return
	 */
	public boolean storedPurchase( long _idPurchase , long _idPurchoseDetail , int _quantity  , String _productType , String _description , Date _expireDate , Double _value ){
		//PurchaseDetailsDAO daoDetail = null; /** not implemented interface ( insert into ... )**/
		//PurchaseDAO purchase = null;
		PurchaseDetailTesting daoDetail = new PurchaseDetailTesting( ) ; 
		PurchaseTesting purchase = new PurchaseTesting( );
		PurchaseDetails _aux = new PurchaseDetails( _idPurchoseDetail , _description , _quantity , _value ); 
		return daoDetail.create( _idPurchoseDetail ,  _description , _quantity , _value ) && purchase.create( _idPurchase, _productType , _expireDate , _aux );
	}
	
	/**
	 * Update quantity to product purchase
	 * @param idPurchaseDetail
	 * @param quantity
	 * @return
	 */
	public synchronized boolean updatePurchaseDetailQuantity( long idPurchaseDetail , int  quantity ) {
		//PurchaseDetailsDAO daoDetail = null; /** not implemented interface ( update purchosedetail set quantity = ? where id = ? )**/
		PurchaseDetailTesting daoDetail = new PurchaseDetailTesting( );
		return daoDetail.updateQuantity( idPurchaseDetail ,  quantity );
	}
	
}
