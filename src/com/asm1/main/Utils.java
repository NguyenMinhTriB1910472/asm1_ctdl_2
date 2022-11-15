package com.asm1.main;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Utils {
	  static Scanner scanner= new Scanner(System.in);
	// hàm xử lý số nguyên   
	public static int getAnInteger()
	 {
		// nếu không phải số nguyên thì nhập lại 
	  while (true)
	   try
	   {
	    return scanner.nextInt();
	   }
	   catch (InputMismatchException e)
	   {
	    scanner.next();
	    System.out.print("That’s not "
	     + "an integer. Try again: ");
	   }
	 }


}
