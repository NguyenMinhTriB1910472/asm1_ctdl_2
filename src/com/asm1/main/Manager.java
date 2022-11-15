package com.asm1.main;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Manager {
	static Scanner scanner =new Scanner(System.in);
	static Math Math = new Math();
	static float[] arrr;
	static float[] arr;
	public static void main(String[] args) throws IOException {
		Math main=new Math();
		//float[] arr = {100,1,55,2,2,3} ;
		//float[] a= main.scanf();
		
		//float[] c=main.insertionSort(a);
		//float[] d=main.selectionSort(a);
//		main.search(a, 12);
		//main.prinf(a);
//		try {
//			main.writeFile1("input.txt",arr);
//			float[] arr1=main.readFile("input.txt");
//			float[] b =main.bubbleSort(arr1);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		choice();
	}
	public static void welcome() {
	    // menu khi start
	 	System.out.println("+-------------------Menu------------------+\r\n"
	 			+ "|      1.Input                                      |\r\n"
	 			+ "|      2.Output                                   |\r\n"
	 			+ "|      3.Bubble sort                            |\r\n"
	 			+ "|      4.Selection sort                        |\r\n"
	 			+ "|      5.Insertion sort                        |\r\n"
	 			+ "|      6.Search > value                      |\r\n"
	 			+ "|      7.Search = value                      |\r\n"
	 			+ "|      0.Exit                                        |\r\n"
	 			+ "+-----------------------------------------.+");
	    
	    System.out.print("Your choice: ");
	}
	public static void choice() throws IOException {
		  int choice = 0;
		  do {
		    welcome();
		    choice = Utils.getAnInteger();
		    while (choice <= 0 || choice >=8) {
		      System.out.print("Nhap loi! (yeu cau nhap lai) : ");
		      choice = Utils.getAnInteger();
		    }
		    
	 		
		    switch (choice) {
		      case 1:
		    	System.out.println("Mời bạn nhập số lượng phần phần tử của mảng : ");
			 	int n=scanner.nextInt();
			 	arr=new float[n];
		 		 for (int i = 0; i < n; i++) {
		 			System.out.println("Mời nhập phần tử tại vị trí "+i+" : ");
		 			arr[i]=scanner.nextFloat();
		 		}
		        Math.writeFile1("input.txt", arr);
		        break;
		      case 2:
		    	if (arr==null) {
					System.out.println("Bạn chưa nhập dữ liệu !");
				}else {
					arrr= Math.readFile("input.txt");
				}
		    	
		        break;
		      case 3:
		    	  if (arr==null) {
						System.out.println("Bạn chưa nhập dữ liệu !");
					}else {
						arrr=Math.bubbleSort(arr);
					}
		        break;
		      case 4:
		    	  if (arr==null) {
						System.out.println("Bạn chưa nhập dữ liệu !");
					}else {
						arrr=Math.selectionSort(arr);
					}
		    	
		        break;
		      case 5:  
		    	if (arr==null) {
					System.out.println("Bạn chưa nhập dữ liệu !");
				}else {
					arrr=Math.insertionSort(arr);
				}
		        break;
		      case 6:
		    	if (arr==null) {
		    		System.out.println("Bạn chưa nhập dữ liệu !");
		    	}
				else {
					System.out.println("Mời nhập giá trị cần tìm giá trị lớn hơn : ");
					arrr=Math.insertionSort(arr);
				}
		    	
		    	float index = scanner.nextFloat();
		    	boolean isRight =false;
//		    	for (int i = 0; i < arr.length; i++) {
//					if (index==arr[i]) {
//						System.out.println(index);
//						System.out.println(isRight);
//						isRight=true;
//						break;
//					}
//					
//				}
		    	Math.search(arrr,index);
//		    	if (isRight==true) {
//		    		int count1=0;
//			    	for (int i = 0; i < arr.length; i++) {
//						if(arr[i]==arrr[i]) count1++;
//					}
//			    	if(count1<arrr.length-1) {
			    		
//			    	}else {
//						System.out.println("Mời bạn sắp xếp các phần tử trong mảng trước khi tìm kiếm: ");
//						break;
//					}
//				}else if((isRight==true)){
//					System.out.println("Không có giá trị bạn cần tìm trong mảng!");
//					break;
//				}
		    	
		    	
			    break;
		      case 7:
		    	System.out.println("Nhập số cần tìm : ");
		    	arrr=Math.selectionSort(arr);
		    	float value =scanner.nextFloat();
		    	float number=Math.binarySearch(arrr, 0, arrr.length-1, value);
			    float[] arrr1 = {number};
		    	System.out.println(arrr1[0]);
			    Math.writeFile1("output", arrr1);
		    	
				break;
			  case 0:
				  System.out.println("Exit");
				  System.exit(0);
		      default:
		        break;
		      }
		    }while(choice !=12);
	}
}
