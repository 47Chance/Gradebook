/*
 * Chanslor Green
 * COMP 163 04
 * 3/28/2021
 * Program gathers input from user and computes 
 * a summary of students grades and assigns a letter grade
 */
package programming.project;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Gradebook {

	 public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#.##"); 
		df.setRoundingMode(RoundingMode.DOWN);
		System.out.println("Welcome to the interactive grade book. what is the student's name?"); //first question prompted to user
		String name = scan.nextLine(); // gets the user's input
	double midterm = 0, total = 0; // variables for midterm grade and total score
	System.out.println("Did student recieve participation credit? (yes/no)"); // this statement determines if total score is calculated with participation credit or not
	String option = scan.nextLine();
	System.out.println("Enter grade for project 1.");
	double p1 = scan.nextDouble();
	System.out.println("Enter grade for project 2.");
	double p2 = scan.nextDouble();
	System.out.println("Enter grade for Midterm 1.");
	double m1 = scan.nextDouble();
	System.out.println("Enter grade for Midterm 2.");
	double m2 = scan.nextDouble();
	System.out.println("Enter grade for Midterm 3.");
	double m3 = scan.nextDouble();
	System.out.println("Enter grade for Final Exam.");
	double f = scan.nextDouble();
	System.out.println("* * * * *");
	System.out.println("Here is the grade summary for"+" "+name); 
	if(option.equals("yes"))
	{
			System.out.println("Participation score: 100");
	}
	if(option.equals("no"))
	{
			System.out.println("Participation score: 0");
	}
	System.out.println("Project score:"+df.format((p1+p2)/2));
	if(m1 < f && m1 <= m2 && m1 <= m3) // loop statement that runs if midterm grade 1 is the lowest 
	{
		midterm = (f + m2 + m3)/3; 
		System.out.println("Midterm score: "+df.format(midterm));
		System.out.println("A midterm grade was replaced by a final exam grade."); 
	}
	if(m2 < f && m2 <= m1 && m2 <= m3) // loop statement that runs if midterm grade 2 is the lowest
	{
		midterm = (f + m1 + m3)/3;
		System.out.println("Midterm Score: "+df.format(midterm));
	    System.out.println("A midterm grade was replaced by a final exam grade.");
	}
	if(m3 < f && m3 <= m1 && m3 <= m2) // loop statement that runs if midterm grade 3 is the lowest
	{
		midterm = (f + m1 + m2)/3;
		System.out.println("Midterms score: "+df.format(midterm));
		System.out.println("A midterm grade was replaced by a final exam grade.");
	}
	if (m1 > f && m2 > f && m3 > f)  // loop statement that runs if all midterm grades are higher than the final 
	{
		midterm = (m1 + m2 + m3)/3;
		System.out.println("Midterms score: "+df.format(midterm));
	}
	System.out.println("Final Exam score: "+df.format(f));
	if(option.equals("yes"))  // computes grades with participation credit 
	{
		total = ((0.1 * 100) + (0.35 * (p1+p2)/2)+(0.3 * midterm)+(0.25 * f));
		System.out.println("Total score: "+df.format(total)); 
	}
	if(option.equals("no")) // computes grades without participation credit 
	{
			total= ((0.1 * 0)+(0.35 * (p1+p2)/2)+(0.3 * midterm)+(0.25 * f)); 
			System.out.println("Total score:"+df.format(total));
	}
	if(total > 90)  
	{
		System.out.println("Final Grade: A"); 
	}
	else if(total > 80 && total <= 90)
	{
		 System.out.println("Final Grade: B");
	}
	else if(total > 70 && total <= 80)
	{
		System.out.println("Final Grade: C");
	}
	else if(total > 60 && total <= 70)
	{
		System.out.println("Final Grade: D");
	}
	else  // if grade is lower than 60 "Final Grade: F" is printed
	{
			System.out.println("Final Grade: F");
	}
	System.out.println("* * * * *");
	scan.close();
	 }	
}
