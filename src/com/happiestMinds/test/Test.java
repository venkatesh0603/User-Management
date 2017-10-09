/**
 * 
 */
package com.happiestMinds.test;

import java.text.ParseException;
import java.util.BitSet;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @author Mahesh Chouhan
 *
 */
public class Test {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	
	
	
	public static void main(String[] args) throws ParseException {
	
	Enumeration days;
	
	Vector day=new Vector();
	day.add("Sunday");
	day.add("Monday");
	
	days=day.elements();
	
	while(days.hasMoreElements()){
		System.out.println(days.nextElement());
	}
	
	BitSet bits1 = new BitSet(16);
    BitSet bits2 = new BitSet(16);
    
    // set some bits
    for(int i = 0; i < 16; i++) {
       if((i % 2) == 0) bits1.set(i);
       if((i % 5) != 0) bits2.set(i);
    }
   
    System.out.println("Initial pattern in bits1: ");
    System.out.println(bits1);
    System.out.println("\nInitial pattern in bits2: ");
    System.out.println(bits2);

    // AND bits
    bits2.and(bits1);
    System.out.println("\nbits2 AND bits1: ");
    System.out.println(bits2);

    // OR bits
    bits2.or(bits1);
    System.out.println("\nbits2 OR bits1: ");
    System.out.println(bits2);

    // XOR bits
    bits2.xor(bits1);
    System.out.println("\nbits2 XOR bits1: ");
    System.out.println(bits2);
	}

}



