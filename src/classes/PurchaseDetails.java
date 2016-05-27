package classes;

public class PurchaseDetails {

	private long 	id;
	private String 	description;
	private int 	quantity;
	private double  value;
	
	public PurchaseDetails( long _id , String _description , int _quantity , double _value ){
		this.id 		 = _id;
		this.description = _description;
		this.quantity  	 = _quantity;
		this.value 		 = _value;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
