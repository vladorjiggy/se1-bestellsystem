package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datamodel.Article;
import datamodel.Customer;
import datamodel.Order;
import datamodel.OrderItem;
import system.ComponentFactory;
import system.Components;

public final class Application_C3 {

    public static void main( String[] args ) {
        System.out.println( "SE1‐Bestellsystem" );
        ComponentFactory componentFactory = ComponentFactory.getInstance();
        Components.OutputProcessor outputProcessor =  componentFactory.getOutputProcessor();
        Components.DataFactory dataFactory = componentFactory.getDataFactory();
        Components.OrderProcessor orderProcessor = componentFactory.getOrderProcessor();
        
        
        Customer cEric = dataFactory.createCustomer( "Eric Schulz-Mueller", "eric2346@gmail.com" );
        Customer cAnne = dataFactory.createCustomer( "Anne Meyer", "+4917223524" );
		Customer cNadine = dataFactory.createCustomer( "Nadine Ulla Blumenfeld", "+4915292454" );
        Customer tWerner = dataFactory.createCustomer( "Timo Werner", "tw@gmail.com");
        Customer sMueller = dataFactory.createCustomer( "Sandra Müller", "samue62@gmx.de");
        
        
        Article aTasse = dataFactory.createArticle( "Tasse", 299, 2000 );
		Article aBecher = dataFactory.createArticle( "Becher", 149, 8400 );
		Article aKanne = dataFactory.createArticle( "Kanne", 2000, 2400 );
		Article aTeller = dataFactory.createArticle( "Teller", 649, 7000 );
        Article kMaschine = dataFactory.createArticle( "Kaffemaschine", 2999, 500 );
        Article tKocher = dataFactory.createArticle( "Teekocher", 1999, 2000 );
        
        
        // Eric's 1st order
        Order o5234 = dataFactory.createOrder( cEric );
        OrderItem oi1 = dataFactory.createOrderItem( aKanne.getDescription(), aKanne, 1 );
        o5234.addItem( oi1 );

        // Eric's 2nd order
        Order o8592 = dataFactory.createOrder( cEric );

		o8592.addItem(
			dataFactory.createOrderItem( aTeller.getDescription(), aTeller, 4 )
		).addItem(
			dataFactory.createOrderItem( aBecher.getDescription(), aBecher, 8 )
		).addItem(
			dataFactory.createOrderItem( "passende Tassen", aTasse, 4 )
		);

        // Anne's order
		Order o3563 = dataFactory.createOrder(  cAnne );
		o3563.addItem(
			dataFactory.createOrderItem( aKanne.getDescription() + " aus Porzellan", aKanne, 1 )
		);

		// Nadine's order
		Order o6135 = dataFactory.createOrder( cNadine );
		o6135.addItem(
        dataFactory.createOrderItem( aTeller.getDescription() + " blau/weiss Keramik", aTeller, 12 )
		);
        
        // Timo's Order         
        Order o1234 = dataFactory.createOrder(tWerner );
        OrderItem oi01 = dataFactory.createOrderItem( kMaschine.getDescription(), kMaschine, 1 );
        OrderItem oi02 = dataFactory.createOrderItem( aTasse.getDescription(), aTasse, 6 );
        o1234.addItem(oi01).addItem(oi02);

        
        
        Order o5678 = dataFactory.createOrder( sMueller );
        OrderItem oi03 = dataFactory.createOrderItem( tKocher.getDescription(), tKocher, 1 );
        OrderItem oi04 = dataFactory.createOrderItem( aBecher.getDescription(), aBecher, 4 );
        OrderItem oi05 = dataFactory.createOrderItem( aTeller.getDescription(), aTeller, 4 );
        o5678.addItem(oi03).addItem(oi04).addItem(oi05);

        List<Order> orders = new ArrayList<Order>(List.of( o5234, o8592, o3563, o6135, o1234, o5678 ));
        outputProcessor.printOrders( orders, false );
    }
  }
