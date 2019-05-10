/*******************************************************************************
Name: Sarah Redmon
Date: 4/30/19
Instructor: Ms. Tucker
Class: VotingQueue
Purpose: To show a queue of voters and the voting results
*******************************************************************************
*/

/*------------------------------------------------------------------------------
       FEEDBACK FROM INSTRUCTOR:
       First program: Output file was not created correctly.  Queue processing 
       needed a little work. Second program not complete.
------------------------------------------------------------------------------*/

import jsjf.CircularArrayQueue;
import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class VotingQueue
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
       String carNumber = "", numOfVoters = "";
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
           // Take element out of queue, randomize time, add that to totalTime, &
           // add numOfVoters2 to voterCount
           //-----------------------------------------------------------------
           while (!queue.isEmpty() && counter <= 10) {
               queue.dequeue();
               
               voterNum++;
               
               Random rand = new Random();
               time = rand.nextInt(600) + 10;
               
               totalTime = totalTime + time;
               voterCount = voterCount + numOfVoters2;
           }
           
           System.out.println(carNumber + " " + numOfVoters);
       }
       
       /*------------------------------------------------------------------------------
        Display statistics
        ------------------------------------------------------------------------------
        */
       System.out.println();
       averageTime = totalTime / numOfVoters2;
       System.out.println("NUMBER OF VOTERS: " + voterNum);
       System.out.println("TOTAL TIME: " + time);
       System.out.println("AVERAGE TIME: " + averageTime);
       
       /*------------------------------------------------------------------------------
        File writing to VotingReport.txt
        ------------------------------------------------------------------------------
        */
       System.out.println();
       System.out.println("Hold on while processing takes place...");
       PrintWriter writer = new PrintWriter("VotingReport.txt");
       String[] queue1 = {carNumber, numOfVoters};
       for (String file : queue1) {
           writer.write(file);
       }
       writer.close();
       System.out.println("File processed. Look at VotingReport.txt to see the report.");
    }
}
