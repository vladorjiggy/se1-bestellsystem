package system;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import datamodel.Article;
import datamodel.Customer;
import datamodel.Order;
import datamodel.OrderItem;

final class OutputProcessor implements Components.OutputProcessor{

    //public OutputProcessor outputProcessor;
    public InventoryManager inventoryManager;
    public OrderProcessor orderProcessor;
    private final int printLineWidth = 95;

    OutputProcessor(InventoryManager inventoryManager, OrderProcessor orderProcessor){
        //this.outputProcessor = new OutputProcessor(inventoryManager, orderProcessor);
        this.inventoryManager = inventoryManager;
        this.orderProcessor = orderProcessor;
    }

    @Override
    public void printOrders(List<Order> orders, boolean printVAT) {
        
        StringBuffer sbAllOrders = new StringBuffer( "-------------" );
		StringBuffer sbLineItem = new StringBuffer();
        long totalVat = 0L;
		int totalPrice = 0;
        for (int i = 0; i < orders.size(); i++) {			
            Order order = orders.get(i);
            long orderId = order.getId();
            Customer customer = order.getCustomer();
            String customerName = splitName( customer, customer.getFirstName() + " " + customer.getLastName() );		
            Iterable<OrderItem> orderItems = order.getItems();            
			ArrayList<String> items = new ArrayList<String>();
			long orderPrice = 0L;
			for(OrderItem item : orderItems){
				Article art = item.getArticle();
				orderPrice+= (art.getUnitPrice() * item.getUnitsOrdered());
				totalVat += orderProcessor.vat((art.getUnitPrice() * item.getUnitsOrdered()), 1);;
				totalPrice+= (art.getUnitPrice() * item.getUnitsOrdered());
				items.add(item.getUnitsOrdered() + "x " + item.getDescription());				
			}
			
			String orderPriseString = fmtPrice( orderPrice, "EUR", 14 );
			String listString = String.join(", ", items);
            String desc = "#" + orderId + ", " + customerName + "'s Bestellung: " + listString ;
			sbLineItem = fmtLine( desc, orderPriseString, printLineWidth );
			sbAllOrders.append( "\n" );
			sbAllOrders.append( sbLineItem );            
        }
		
		System.out.println(totalPrice);
		String fmtPriceTotal = pad( fmtPrice( totalPrice, "EUR" ), 14, true );
        sbAllOrders.append( "\n" )
			.append( fmtLine( "-------------", "------------- -------------", printLineWidth ) )
			.append( "\n" )
			.append( fmtLine( "Gesamtwert aller Bestellungen:", fmtPriceTotal, printLineWidth ) );

		String fmtVatTotal = pad( fmtPrice( totalVat, "EUR" ), 14, true );
		if(printVAT){
			sbAllOrders.append( "\n" )
			.append( fmtLine( "Im Gesamtbetrag enthaltene MWST (19%):", fmtVatTotal, printLineWidth ) );
		}
		
		// Hier MWST

		// print sbAllOrders StringBuffer with all output to System.out
		System.out.println( sbAllOrders.toString() );
        
    }

    @Override
    public void printInventory(boolean sortedByInventoryValue) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public String fmtPrice(long price, String currency) {
        String fmtPrice = pad( fmtPrice( price, "", " " + currency ), 14, true );
		return fmtPrice;
    }

    @Override
    public String fmtPrice(long price, String currency, int width) {
        String fmtPrice = pad( fmtPrice( price,"", " " + currency ), width, true );
		return fmtPrice;
    }

    private String fmtPrice( long price, String prefix, String postfix ) {
		StringBuffer fmtPriceSB = new StringBuffer();
		if( prefix != null ) {
			fmtPriceSB.append( prefix );
		}

		fmtPriceSB = fmtPrice( fmtPriceSB, price );

		if( postfix != null ) {
			fmtPriceSB.append( postfix );
		}
		return fmtPriceSB.toString();
	}

    private StringBuffer fmtPrice( StringBuffer sb, long price ) {
		if( sb == null ) {
			sb = new StringBuffer();
		}
		double dblPrice = ( (double)price ) / 100.0;			// convert cent to Euro
		DecimalFormat df = new DecimalFormat( "#,##0.00",
			new DecimalFormatSymbols( new Locale( "de" ) ) );	// rounds double to 2 digits

		String fmtPrice = df.format( dblPrice );				// convert result to String in DecimalFormat
		sb.append( fmtPrice );
		return sb;
	}

    @Override
    public StringBuffer fmtLine(String leftStr, String rightStr, int width) {
        StringBuffer sb = new StringBuffer( leftStr );
		int shiftable = 0;		// leading spaces before first digit
		for( int i=1; rightStr.charAt( i ) == ' ' && i < rightStr.length(); i++ ) {
			shiftable++;
		}
		final int tab1 = width - rightStr.length() + 1;	// - ( seperator? 3 : 0 );
		int sbLen = sb.length();
		int excess = sbLen - tab1 + 1;
		int shift2 = excess - Math.max( 0, excess - shiftable );
		if( shift2 > 0 ) {
			rightStr = rightStr.substring( shift2, rightStr.length() );
			excess -= shift2;
		}
		if( excess > 0 ) {
			switch( excess ) {
			case 1:	sb.delete( sbLen - excess, sbLen ); break;
			case 2: sb.delete( sbLen - excess - 2 , sbLen ); sb.append( ".." ); break;
			default: sb.delete( sbLen - excess - 3, sbLen ); sb.append( "..." ); break;
			}
		}
		String strLineItem = String.format( "%-" + ( tab1 - 1 ) + "s%s", sb.toString(), rightStr );
		sb.setLength( 0 );
		sb.append( strLineItem );
		return sb;
    }

    @Override
    public String splitName(Customer customer, String name) {  // AUSGABE DER NAMEN STIMMT NOCH NICHT GANZ
        String[] parts = name.split(" ");
        if (parts.length > 2){
            customer.setFirstName(parts[0] + ' ' + parts[1]);
            customer.setLastName(parts[2]);
        }
        else{
            customer.setFirstName(parts[0]);
            customer.setLastName(parts[1]);
        }
        return customer.getLastName() + "," + customer.getFirstName();
    }

    @Override
    public String singleName(Customer customer) {
        return customer.getLastName() + "," + customer.getFirstName();
    }

    private String pad( String str, int width, boolean rightAligned ) {
		String fmtter = ( rightAligned? "%" : "%-" ) + width + "s";
		String padded = String.format( fmtter, str );
		return padded;
	}
    
}
