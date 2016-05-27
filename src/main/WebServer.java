package main;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import companys.Info;

public class WebServer {
	
	  /**
	   * Start the microservice.
	   * 
	   * @param args
	   *           
	   */
	   public static void main( String[] args ) {
		   try {
			   HttpServer server = HttpServer.create( new InetSocketAddress( 8000 ) , 0 );
			   server.createContext( "/blipTest" , new serverHandler( ) );
			   server.setExecutor( Executors.newCachedThreadPool( ) );
			   server.start( );
		   } catch ( IOException e ) {
			   System.out.println( "[StartServer][InitServer] " + e.getMessage( ) );
		   }
	   }
	   
	   /**
	    * 
	    * @author João Nobre
	    *
	    */
	   static class serverHandler implements HttpHandler {
		  
		   public void handle( HttpExchange t ) throws IOException {
				  String response 	 = "",
						 _idPurchose = "",
						 _idPurchoseDetail = "",
						 _quantity	 = "",
						 _productType = "",
						 _description = "",
			             requestURI = t.getRequestURI( ).getQuery( ),
			            _expireDate,
			            _value;
				  String[] params , values;
				  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd"); /** assume format **/
				  Info api = new Info( );
			      System.out.println( "Param => " + requestURI );
			      try{
					     
			      if( requestURI != null && !requestURI.equals( "" ) ) {
			    	  params = requestURI.split( "&" );
				    	 for( String param : params ){
				    		 values = param.split( "=" );
				    		 if( values[ 0 ].equals( "operation" ) && values[ 1 ].equals( "1" ) ){ /* fetch purchase */
					    		 /**  retrieves purchase details   **/
					    		 System.out.println( "[Operation 1] get valid Purchase" ); //TODO change to log4j
					    		 response = api.getValidPurchase( );
					    		 if( response.equals( "" ) )
					    			 response = "Não existem compras válidas.";
					    		 break;
					    	 } else if( values[ 0 ].equals( "operation" ) && values[ 1 ].equals( "2" ) ) { /** update purchase **/
					    		 _idPurchose = findParameter( params , "idPurchase" );
					    		 _quantity   = findParameter( params , "quantity" );
					    		 if( _idPurchose == null || _idPurchose.equals( "" ) || _quantity == null || _quantity.equals( "" ) ) 
					    			 response = "Parametros em falta.";
					    		 else{
					    			 /** Update quantity the Purchose Detail with idPurchose **/
					    			 if( api.updatePurchaseDetailQuantity( Long.parseLong( _idPurchose) , Integer.parseInt( _quantity ) ) )
					    				 response = "Quantidade actuaizada com sucesso";
					    			 else
					    				 response = "Erro["+_idPurchose+"] a actualizar quantidade";
					    		 }
					    		 break; 
					    		 
					    	 } else if( values[ 0 ].equals( "operation" ) && values[ 1 ].equals( "3" ) ) { /**  stored purchase **/
					    		 _idPurchose = findParameter( params , "idPurchase" );
					    		 _idPurchoseDetail = findParameter( params , "idPurchaseDetail" );
					    		 _quantity 	  = findParameter( params , "quantity" );
					    		 _productType = findParameter( params , "productType" );
					    		 _description = findParameter( params , "description" );
					    		 _expireDate  = findParameter( params , "expire" );
					    		 _value 	  = findParameter( params , "value" );
					    		 if( _idPurchose 		== null || _idPurchose.equals( "" )|| 
					    	 		 _idPurchoseDetail 	== null || _idPurchoseDetail.equals( "" ) ||
					    	 		 _quantity 			== null || _quantity.equals( "" ) ||
					    	 		 _productType 		== null || _productType.equals( "" ) ||
					    	 		 _description 		== null || _description.equals( "" ) ||
					    	 		 _expireDate		== null || _expireDate.equals( "" ) || 
					    	 		 _value 			== null || _expireDate.equals( "" ) ) 
					    			  response = "Paramêtros incorrectos.";
					    		 else{
					    			 if( api.storedPurchase( Long.parseLong( _idPurchose ) , Long.parseLong( _idPurchoseDetail ) , Integer.parseInt( _quantity ) , _productType , _description , formatter.parse( _expireDate ) , Double.parseDouble( _value ) ) )
					    				 response = "["+ Long.parseLong( _idPurchose ) +"] stored Successful";
					    		 }
					    		 break;
					    		 
					    	 } else
					    		 response = "Parametros inválidos.";
				    	 }
			    } else 
			    	response = "Pedido vazio.";
			    
			    } catch (ParseException e) {
		    			e.printStackTrace( );
		    			response = "[ERRO] Formato dos dados incorrecta.";
		    	} finally {
					  t.sendResponseHeaders( 200, response.length( ) );
				      OutputStream os = t.getResponseBody( );
				      os.write( response.getBytes( ) );
				      os.close( );
		    	}
		   }
		   
		   public String findParameter( String[] values , String value ) throws ParseException {
			  DateFormat originalFormat = new SimpleDateFormat("yyyyMMdd");
			  String _aux = "";
			  
			  for( String str : values ){
				  if( str.contains( value ) ){
					  try{
						  if( value.contains( "idPurchase" ) || value.contains( "idPurchaseDetail" ) )
						    Long.parseLong( str.split( "=" )[1] );
						  else if( value.contains( "quantity" ) )
							  Integer.parseInt( str.split( "=" )[1] );
						  else if( value.contains( "value" )  )
							  Double.parseDouble( str.split( "=" )[1] );
						  else if( value.contains( "expire" )  )
							  originalFormat.parse( str.split( "=" )[1] );
						  _aux = str.split( "=" )[1];
						  break;
					  } catch( Exception e ){
						  return "";
					  }
				  } 
			  }
			  return   _aux;
		   }
	  }
	
}
