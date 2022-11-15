package com.asm1.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Math {
	Scanner scanner =new Scanner(System.in);

	 public void writeFile1(String fileName,float[] arr) throws IOException {
		 
		 FileWriter cin = null;

		 try {
			 cin = new FileWriter(fileName);
			 //System.out.println("Enter characters: ");
			 int i = 0;
	
			 while (i < arr.length) {
				 cin.write(arr[i] + " ");
				 i++;
			 }
		 } catch (Exception e) {
			 System.out.println("Ngoai le");
		 }

			 if (cin != null) {
			 cin.close();
		 }

	}
	 public float[] readFile(String fileName) throws IOException {
		 FileReader fileReader = new FileReader(fileName);
		 BufferedReader bufferedReader = new BufferedReader(fileReader);
		 int i=0;
		 String arr=bufferedReader.readLine();
		 String[] arr1=arr.split("\\s");
		 float[] arr2 = new float[arr1.length];
		 while (i<arr1.length) {
			 arr2[i]=Float.parseFloat(arr1[i]);
			 i++;
		 }
		 System.out.print("Các phần tử trong mảng là : ");
		 display(arr2);
		 fileReader.close();
		 bufferedReader.close();
		 
		 return arr2;
	 }
	 public void display(float[] arr) {
		 for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
		System.out.println();
	 }
	 public float[] scanf() {
		 int n;
		 System.out.print("Mời nhập n : ");
		 n =scanner.nextInt();
		 float[] a=new float[n];
		 for (int i = 0; i < n; i++) {
			 System.out.println("Mời nhập arr tại vị trí " +i+ " : ");
			a[i]= scanner.nextInt();
		 }
		 return a;
	 }
	 
	 public void prinf(float[] a) {
		 System.out.println();
		 for (int i = 0; i < a.length; i++) {
			 System.out.printf("%.1f ",a[i]);
		}
	 }
	 
	 public void swapArray(float arr[], int i, int j){
	        float temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	 }
	 
	 public float[] bubbleSort(float arr[]) throws IOException {
		for (int i = 0; i < arr.length-1-i; i++) {
			display(arr);
			for (int j = 0; j < arr.length-1; j++) {
				if(arr[j]>arr[j+1]) {
					swapArray(arr, j, j+1);
				}
			}
		}
		System.out.println("Kết quả cuối cùng là: ");
		display(arr);
		writeFile1("output.txt", arr);
		return arr;
	 }
	 public float[] selectionSort(float arr[]) throws IOException {
		for (int i = 0; i < arr.length-1; i++) {
			display(arr);
			int index =i;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[index]>arr[j]) {
					index=j;
				}
			}
			swapArray(arr, index, i);
		}
		System.out.println("Kết quả cuối cùng là: ");
		display(arr);
		writeFile1("output.txt", arr);
		return arr;
	 }

	 public float[] insertionSort(float arr[]) throws IOException {
		for (int i = 1; i < arr.length; ++i) {
			display(arr);
			float key=arr[i];
			int j=i-1;
			
			while(j>=0 && arr[j]>key) {
				arr[j+1]=arr[j];
				j=j-1;
			}
			arr[j+1]=key;
		}
		display(arr);
		System.out.println("Kết quả cuối cùng là: ");
		display(arr);
		writeFile1("output.txt", arr);
		return arr;
	 }

	 public void search(float arr[], float value) throws IOException {
		 float arr1[] = new float[arr.length];
		 int j=0;
		 System.out.print("Các phần tử là : ");
		 for (int i = 0; i < arr.length; i++) {
			if (arr[i]>value) {
				System.out.print(i+" ");
				arr1[j] =arr[i];
				j++;
			}
		}
		System.out.println();
		writeFile1("output.txt", arr1);
	 }


	 public float binarySearch(float arr[], int left, int right, float value) {
		while (left<=right) {
			int mid=(left+right)/2;
			if (arr[mid] ==value) {
				System.out.println("Vị trí của số cần tìm là : " +mid);
				return mid;
			}else if(value <arr[mid]) {
				return binarySearch(arr, left, mid-1, value);
			}else if(value > arr[mid]) {
				return binarySearch(arr, mid+1, right, value);
			}
		}
		return -1;

	 }
	 
	    public static int first(int arr[], int low, int high,
                int x, int n)
		{
			if (high >= low) {
			int mid = low + (high - low) / 2;
			if ((mid == 0 || x > arr[mid - 1])
			    && arr[mid] == x)
			    return mid;
			else if (x > arr[mid])
			    return first(arr, (mid + 1), high, x, n);
			else
			    return first(arr, low, (mid - 1), x, n);
			}
			return -1;
		}
		
		/* if x is present in arr[] then returns the index of
		LAST occurrence of x in arr[0..n-1], otherwise
		returns -1 */
		public static int last(int arr[], int low, int high,
		               int x, int n)
		{
			if (high >= low) {
			int mid = low + (high - low) / 2;
			if ((mid == n - 1 || x < arr[mid + 1])
			    && arr[mid] == x)
			    return mid;
			else if (x < arr[mid])
			    return last(arr, low, (mid - 1), x, n);
			else
			    return last(arr, (mid + 1), high, x, n);
			}
			return -1;
		}
		
		public static void main(String[] args)
		{
			int arr[] = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
			int n = arr.length;
			int x = 8;
			System.out.println("First Occurrence = "
			               + first(arr, 0, n - 1, x, n));
			System.out.println("Last Occurrence = "
			               + last(arr, 0, n - 1, x, n));
		}
}
