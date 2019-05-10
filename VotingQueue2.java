/*******************************************************************************
Name: Sarah Redmon
Date: 4/30/19
Instructor: Ms. Tucker
Class: VotingQueue2
Purpose: To let the user control the queue and do certain actions to present the queue
*******************************************************************************
*/

import jsjf.CircularArrayQueue;
import java.util.Scanner;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class VotingQueue2
{
   /*  This program should use the Scanner class to input the number of voters arriving at a 
	   voting precinct. There are 2 items on each line (record) in the file:
			(1)  A sequential car number
			(2)  The number of voters arriving in the car
		

	   This program will be used to process the voters in a queue.             */
   
   public static void main (String[] args) throws IOException
   {
       /*------------------------------------------------------------------------------
        Initializes queue and variables needed
        ------------------------------------------------------------------------------
        */
       CircularArrayQueue<String> queue = new CircularArrayQueue<String>();
       String carNumber, numOfVoters;
       int numOfVoters2 = 0, time = 0, voterNum = 0, voterCount = 0, 
       totalTime = 0, averageTime = 0, counter = 0;

       /*------------------------------------------------------------------------------
        Header
        ------------------------------------------------------------------------------
        */
       System.out.printf("%-30.30s  %-30.30s", "Car Number", "Number of Voters");
       System.out.println();
        
       //-----------------------------------------------------------------
        // Reads the file and picks out all of the info needed to put into 
        // the queue & display onto terminal window
        //-----------------------------------------------------------------
        
       Scanner fileScan, lineScan;
       fileScan = new Scanner(new File("Voters.csv"));
        
       while (fileScan.hasNext()) {
           String string = fileScan.nextLine();
                
           lineScan = new Scanner(string);
           lineScan.useDelimiter(",");
            
           carNumber = lineScan.next();
           numOfVoters = lineScan.next();

           queue.enqueue(numOfVoters);
           
           queue.dequeue();
           
           numOfVoters2 = Integer.parseInt(numOfVoters);
           
           //-----------------------------------------------------------------
        // Take element out of queue, randomize time, add that to totalTime, 
        // add numOfVoters2 to voterCount, & increment counter
        //-----------------------------------------------------------------
           while (!queue.isEmpty() && counter <= 10) {
               queue.dequeue();
               
               voterNum++;
               
               Random rand = new Random();
               time = rand.nextInt(600) + 10;
               
               totalTime = totalTime + time;
               voterCount = voterCount + numOfVoters2;
               
               counter++;
           }
           
           System.out.println(carNumber + " " + numOfVoters);
       }
       
       //-----------------------------------------------------------------
        // Ask for user input
        //-----------------------------------------------------------------
       System.out.println();
       Scanner scnr = new Scanner(System.in);
       System.out.print("Type 1 if you want to add a carload of voters to ");
       System.out.println("the queue, type 2 if you want to process voters from ");
       System.out.print("a car, or type 3 if you want to display statistics.");
       String choice = scnr.nextLine();
       System.out.println();
       
       if (choice.equals("1")) {
           /*------------------------------------------------------------------------------
            If 1, ask user number of voters and add to queue
            ------------------------------------------------------------------------------
            */
           System.out.println("Enter the number of voters from your car: ");
           String answer = scnr.nextLine();
           
           queue.enqueue(answer);
       }
       if (choice.equals("2")) {
           /*------------------------------------------------------------------------------
            If 2, process the queue
            ------------------------------------------------------------------------------
            */
           while (!queue.isEmpty()) {
               queue.dequeue();
               
               voterNum++;
               
               Random rand = new Random();
               time = rand.nextInt(600) + 10;
               
               totalTime = totalTime + time;
               voterCount = voterCount + numOfVoters2;
           }
       }
       if (choice.equals("3")) {
           /*------------------------------------------------------------------------------
            If 3, do same as above except for display statistics
            ------------------------------------------------------------------------------
            */
           while (!queue.isEmpty()) {
               queue.dequeue();
               
               voterNum++;
               
               Random rand = new Random();
               time = rand.nextInt(600) + 10;
               
               totalTime = totalTime + time;
               voterCount = voterCount + numOfVoters2;
           }
           System.out.println();
           averageTime = totalTime / numOfVoters2;
           System.out.println("NUMBER OF VOTERS: " + voterNum);
           System.out.println("TOTAL TIME: " + time);
           System.out.println("AVERAGE TIME: " + averageTime);
       }
   }
}