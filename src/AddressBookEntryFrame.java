// Fig. 8.37: AddressBookEntryFrame.java
// A subclass of JInternalFrame customized to display and 
// an AddressBookEntry or set an AddressBookEntry's properties
// based on the current data in the UI.


// Java core packages

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

// Java extension packages

public class AddressBookEntryFrame extends JInternalFrame {
   
   // HashMap to store JTextField references for quick access
   private HashMap fields; 
   
   // current AddressBookEntry set by AddressBook application
   private AddressBookEntry person;
   
   // panels to organize GUI
   private JPanel leftPanel, rightPanel;

   // static integers used to determine new window positions  
   // for cascading windows
   private static int xOffset = 0, yOffset = 0;
   
   // static Strings that represent name of each text field.
   // These are placed on JLabels and used as keys in 
   // HashMap fields.
   private static final String FIRST_NAME = "First Name", 
      LAST_NAME = "Last Name", ADDRESS1 = "Address 1", 
      ADDRESS2 = "Address 2", ADDRESS3 = "Address 3", CITY = "City", COUNTY = "County",
      POSTCODE = "Postcode", PHONE = "Phone", LANDLINE = "Landline", EMAIL = "Email", ALTEMAIL = "AltEmail";
  
   // construct GUI
   public AddressBookEntryFrame()
   {
      super( "Address Book Entry", true, true );
      
      fields = new HashMap();  

      leftPanel = new JPanel();

      leftPanel.setLayout( new GridLayout( 12, 1, 0, 5 ) );
      leftPanel.setBackground(Color.LIGHT_GRAY);
      rightPanel = new JPanel();
      rightPanel.setLayout( new GridLayout( 12, 1, 0, 5 ) );
      
      createRow( FIRST_NAME );
      createRow( LAST_NAME );
      createRow( ADDRESS1 );
      createRow( ADDRESS2 );
      createRow( ADDRESS3 );
      createRow( CITY );
      createRow(COUNTY);
      createRow(POSTCODE);
      createRow( PHONE );
      createRow( LANDLINE );
      createRow( EMAIL );
      createRow( ALTEMAIL );


      Container container = getContentPane();
      container.add( leftPanel, BorderLayout.WEST );
      container.add( rightPanel, BorderLayout.CENTER );
     
      setBounds( xOffset, yOffset, 350, 350 );
      xOffset = ( xOffset + 30 ) % 300;
      yOffset = ( yOffset + 30 ) % 300;
   }

   // set AddressBookEntry then use its properties to 
   // place data in each JTextField
   public void setAddressBookEntry( AddressBookEntry entry )
   {
      person = entry;
      
      setField( FIRST_NAME, person.getFirstName() );
      setField( LAST_NAME, person.getLastName() );
      setField( ADDRESS1, person.getAddress1() );
      setField( ADDRESS2, person.getAddress2() );
      setField( ADDRESS3, person.getAddress3() );
      setField( CITY, person.getCity() );
      setField(COUNTY, person.getCounty() );
      setField(POSTCODE, person.getPostcode() );
      setField( PHONE, person.getPhoneNumber() );
      setField( LANDLINE, person.getLandLine() );
      setField( EMAIL, person.getEmailAddress() );
      setField( ALTEMAIL, person.getALtEmailAddress());
   }
   
   // store AddressBookEntry data from GUI and return 
   // AddressBookEntry
   public AddressBookEntry getAddressBookEntry()
   {
      person.setFirstName( getField( FIRST_NAME ) );
      person.setLastName( getField( LAST_NAME ) );
      person.setAddress1( getField( ADDRESS1 ) );
      person.setAddress2( getField( ADDRESS2 ) );
      person.setAddress3( getField( ADDRESS3 ) );
      person.setCity( getField( CITY ) );
      person.setCounty(getField(COUNTY));
      person.setPostcode(getField(POSTCODE));
      person.setPhoneNumber( getField( PHONE ) );
      person.setLandLine(getField(LANDLINE));
      person.setEmailAddress( getField( EMAIL ) );
      person.setAltEmailAddress( getField( ALTEMAIL ) );
      
      return person;
   }

   // set text in JTextField by specifying field's
   // name and value
   private void setField( String fieldName, String value )
   {
      JTextField field = 
         ( JTextField ) fields.get( fieldName );
      
      field.setText( value );
   }
   
   // get text in JTextField by specifying field's name
   private String getField( String fieldName )
   {
      JTextField field = 
         ( JTextField ) fields.get( fieldName );
            
      return field.getText();  
   }
   
   // utility method used by constructor to create one row in
   // GUI containing JLabel and JTextField
   private void createRow( String name )
   {            
      JLabel label = new JLabel( name, SwingConstants.RIGHT );
      label.setBorder( 
         BorderFactory.createEmptyBorder( 5, 5, 5, 5 ) );
      leftPanel.add( label );
          
      JTextField field = new JTextField( 30 );
      rightPanel.add( field );

      fields.put( name, field );
   }
}  // end class AddressBookEntryFrame


/**************************************************************************
 * (C) Copyright 2001 by Deitel & Associates, Inc. and Prentice Hall.     *
 * All Rights Reserved.                                                   *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
