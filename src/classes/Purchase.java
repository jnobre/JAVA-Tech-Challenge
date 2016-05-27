package classes;

import java.util.Date;

public class Purchase implements Comparable< Purchase >  {
	
	private long 			id;
	private String 			ProducType;
	private Date 			expire;
	private PurchaseDetails details;

	public Purchase( long _id , String _producType , Date _expire , PurchaseDetails _details ){
		this.id 		= _id;
		this.ProducType = _producType;
		this.expire 	= _expire;
		this.details 	= _details;
	}
	
	public PurchaseDetails getDetails( ) {
		return details;
	}
	
	public void setDetails(PurchaseDetails details) {
		this.details = details;
	}
	
	public Date getExpire( ) {
		return expire;
	}
	
	public void setExpire(Date expire) {
		this.expire = expire;
	}
	
	public String getProducType( ) {
		return ProducType;
	}
	
	public void setProducType(String producType) {
		ProducType = producType;
	}
	
	public long getId( ) {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	 @Override
	 public int compareTo( Purchase o ) {
		 if ( getExpire( ) == null || o.getExpire( ) == null )
		      return 0;
		 else
			return o.getExpire( ).compareTo( getExpire( ) );
	 }
	
}
