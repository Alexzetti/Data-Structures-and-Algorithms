package data.structures;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AR
 */
import java.util.Scanner;
public class Problem1
{
public static void main(String[] args)
{
int n, max;
Scanner s = new Scanner(System.in);
System.out.print("Enter number of elements in the array:"); 
n = s.nextInt();
int a[] = new int[n]; 
System.out.println("Enter elements of array:");
for(int i = 0; i < n; i++) 
{
a[i] = s.nextInt();
}
max = a[0];
final long startTime = System.currentTimeMillis(); 
for(int i = 0; i < n; i++)
{
if(max < a[i])
{
max = a[i];
}
}
final long endTime = System.currentTimeMillis(); 
System.out.println("Maximum value:"+max); 
System.out.println("Start time: " + startTime );
System.out.println("End time time: " + endTime );
System.out.println("Total execution time: " + (endTime - startTime) );
}
}