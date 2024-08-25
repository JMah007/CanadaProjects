//FILE: CanadaPRojects.java
//AUTHOR: Jaeden Mah
//USERNAME: jmah
//UNIT: COMP1007
//PURPOSE: to take data from a csv file containing projects in Canada and perform calculations on them
//
//REFERENCE: none
//COMMENTS:
//
//REQUIRES: uses Project.java and Location.java which contains methods to handles data to do with each project
//
//LAST MOD: 19/05/2023

import java.util.*;
import java.io.*;

public class CanadaProjects 
{
	public static void main(String[] args) 
	{
		int statistic = 0;
		int arraySize = 0;
		String inputFileName = "First_Nation_Infrastructure_Investment.csv";
		String outputFileName = "log.txt";
		String region = "empty";
		Project[] project;
		PrintWriter pw;


		Scanner kb = new Scanner(System.in);
		
		arraySize = Project.countProj(inputFileName); //get number of projects in file
		project = new Project[arraySize]; //create project array using calculated size 
		Project.storeFileData(project, inputFileName); //fill the array with file values
		
		pw = openFileWrite(outputFileName); //opens file to write to
		
		//Determine whether to use program
		dispRegionsMenu(arraySize, pw);
		region = getRegionOption(kb, pw);
	

		while(!region.equals("Exit Program")) //Keep looping until Exit Program is selected 
		{ 
			if(!region.equals("All of Canada")) //If a province is chosen
			{
				dispStatisticsMenu(region, pw);
				statistic = getStatisticOption(kb, pw);
				dispProvinceStat(project, statistic, region, pw);
			}
			else //If "All of Canada" is chosen 
			{
					dispCanadaStat(project, pw);
			}
			
			//Determine if user wants to continue program
			dispRegionsMenu(arraySize, pw);
			region = getRegionOption(kb, pw);
		}

		//Program exit and cleanup
		dispAndWrite(pw, "\nYou exit the program");
		pw.close(); //close PrintWriter
		kb.close(); //close Scanner
	}
	



	//NAME: openFileWrite
	//PURPOSE: opens a file to write to and creates a PrintWriter object 
	//IMPORTS: pFileName, the name of the file to write to
	//EXPORTS: the PrintWriter object 
	//ASSERTIONS:
		//PRE: file name is given in string form
		//POST: the file name passed through will be valid
	//REMARKS: handles a IOException with a messasge
	public static PrintWriter openFileWrite(String pFileName)
	{
		FileOutputStream fileStream = null;
		PrintWriter pw = null;

		try
		{
			fileStream = new FileOutputStream(pFileName);
			pw = new PrintWriter(fileStream);
		}
		catch(IOException errorDetails)
		{
			System.out.println("Error in processing file " + pFileName);
		}
		return pw;
	}



	
	//NAME: writeToFile
	//PURPOSE: writes a String passed in to a file and appends it
	//IMPORTS: pw, the PrintWriter object, msg, the String to write to file
	//EXPORTS: none
	//ASSERTIONS:
		//PRE: msg is given in string form
		//POST: message is written to file
	public static void writeToFile(PrintWriter pw, String msg)
	{
		pw.append(msg);
	}




	//NAME: dispAndWrite
	//PURPOSE: prints a String to the console and writes and appends it to a file
	//IMPORTS: pw, the PrintWriter object, msg, the String to write to file
	//EXPORTS: none
	//ASSERTIONS:
		//PRE:msg is given in string form
		//POST: message is displayed to console and written to file
	public static void dispAndWrite(PrintWriter pw, String msg)
	{
		writeToFile(pw, msg);
		System.out.println(msg);
	}


	

	//NAME: intToStringOpt
	//PURPOSE: converts option in the form of an int into corresponding region as a string
	//IMPORTS: pOption, the int option chosen by user 
	//EXPORTS: the region name corresponding to the int value passed in
	//ASSERTIONS:
		//PRE: value passed in is one of the options to choose from
		//POST: region will be a valid region
	public static String intToStringOpt(int pOption)
	{
		String stringOption = null;

		switch(pOption)
		{
			case 1:
				stringOption = "All of Canada";
			break;

			case 2: 
				stringOption = "Alberta";
			break;

			case 3: 
				stringOption = "British Columbia";
			break;

			case 4:
				stringOption = "Manitoba";
			break;

			case 5:
				stringOption = "New Brunswick";
			break;

			case 6:
				stringOption = "Newfoundland and Labrador";
			break;

			case 7:
				stringOption = "Nova Scotia";
			break;

			case 8:
				stringOption = "Ontario";
			break;

			case 9:
				stringOption = "Prince Edward Island";
			break;

			case 10:
				stringOption = "Quebec";
			break;

			case 11:
				stringOption = "Saskatchewan";
			break;

			case 12:
				stringOption = "Northwest Territories";
			break;

			case 13: 
				stringOption = "Nunavut";
			break;

			case 14:
				stringOption = "Yukon";
			break;

			default: 
				stringOption = "Exit Program";
		}

		return stringOption;
	}		




	//NAME: getRegionOption
	//PURPOSE: gets user input for selection of region 
	//IMPORTS: input, a Scanner object, pw, a PrintWriter object
	//EXPORTS: the region option chosen by user 
	//ASSERTIONS:
		//PRE: none
		//POST: region chosen by user is valid
	//REMARKS: handles a IllegalArgumentException and InputMismatchException with a message
	public static String getRegionOption(Scanner input, PrintWriter pw) 
	{
		int option = 0;
		String stringOption = null;
		boolean repeat = true;

		while(repeat)
		{
			try
			{
				option = input.nextInt();
				Project.valRegionOption(option);
				dispAndWrite(pw, "\nYou entered: " + option);
				stringOption = intToStringOpt(option);
				repeat = false;
			}
			catch(IllegalArgumentException iae)
			{	
				dispAndWrite(pw, "\nYou entered: " + option);
				dispAndWrite(pw, "\nInvalid input given. Enter a number between 1 and 15 inclusive");
				input.nextLine(); //clears garbage characters
				repeat = true;
			}
			catch(InputMismatchException ime)
			{	
				dispAndWrite(pw, "\nInvalid input given. Enter a number only");
				input.nextLine(); //clears garbage characters
				repeat = true;
			}
		}

		return stringOption;
	}
	


	
	//NAME: getStatisticOption
	//PURPOSE: gets user input for selection of statistic 
	//IMPORTS: input, a Scanner object, pw, a PrintWriter object
	//EXPORTS: the statistic option chosen by user
	//ASSERTIONS:
		//PRE: none
		//POST: statistic chosen by user is valid
	//REMARKS: handles a IllegalArgumentException and InputMismatchException with a message
	public static int getStatisticOption(Scanner input, PrintWriter pw) 
	{
		int option = 0;
		boolean repeat = true;

		while(repeat)
		{
			try
			{	
				option = input.nextInt();
				Project.valStatisticOption(option);
				dispAndWrite(pw, "\nYou entered: " + option);
				repeat = false;
			}
			catch(IllegalArgumentException iae)
			{
				dispAndWrite(pw, "\nYou entered: " + option);
				dispAndWrite(pw, "\nInvalid input given. Enter a number between 1 and 6 inclusive");
				input.nextLine(); //clears garbage characters
				repeat = true;
			}
			catch(InputMismatchException ime)
			{
				dispAndWrite(pw, "\nInvalid input given. Enter a number");
				input.nextLine(); //clears garbage characters
				repeat = true;
			}
		}

		return option;
	}
	

	

	//NAME: dispRegionsMenu
	//PURPOSE: displays a menu with regions throughout Canada
	//IMPORTS: pw, the PrintWriter object, pNumProj, the number of projects in Canada
	//EXPORTS: none
	//ASSERTIONS:
		//PRE: pNumProj is valid 
		//POST: menu is displayed
	public static void dispRegionsMenu(int pNumProj, PrintWriter pw) 
	{
		String msg = "\n\nWelcome to the Investments in Indigenous community infrastructure Program. There are a total of " 
				+ pNumProj
				+ " projects throughout Canada. Please make a selection from the Menu below." +
				"\n\n 1. All of Canada\n"
							+ " 2. Alberta\n"
							+ " 3. British Columbia\n" 
							+ " 4. Manitoba\n"
							+ " 5. New Brunswick\n"
							+ " 6. Newfoundland and Labrador\n"
							+ " 7. Nova Scotia\n"
							+ " 8. Ontario\n"
							+ " 9. Prince Edward Island\n"
							+ "10. Quebec\n"
							+ "11. Saskatchewan\n"
							+ "12. Northwest Territories\n"
							+ "13. Nunavut\n"
							+ "14. Yukon\n"
							+ "15. Exit Program\n";
		dispAndWrite(pw, msg);
	}
	
	


	//NAME: dispStatisticsMenu
	//PURPOSE: displays a menu showing statistics the user can select to be calculated
	//IMPORTS: pw, the PrintWriter object, region, a region the user wants to perform the calculations on
	//EXPORTS: none
	//ASSERTIONS:
		//PRE: region is valid 
		//POST:menu is displayed
	public static void dispStatisticsMenu(String region, PrintWriter pw) 
	{
		String msg = "\n\nPlease make a choice from the statistics below for " + region + 
		"\n\n1. Number of projects\n"
		+ "2. Percentage of all projects located in this province/territory\n"
		+ "3. Total number and percentage of Ongoing projects\n"
		+ "4. Total number and percentage of Completed Projects\n"
		+ "5. All of the above statistics\n"
		+ "6. Return to main menu\n";

		dispAndWrite(pw, msg);
	}
	

	
	
	//NAME: dispCanadaStat
	//PURPOSE: displays and writes to file the results of calculations done on Canada
	//IMPORTS: pw, the PrintWriter object, projArray, an array that stores all the projects in Canada
	//EXPORTS: none
	//ASSERTIONS:
		//PRE: projArray contains all valid values
		//POST: statistics for projects in Canada is displayed
	public static void dispCanadaStat(Project[] projArray, PrintWriter pw) 
	{
		int numProjTotal = 0, numProjOngoing = 0, numProjComplete = 0;
		double percProjComplete = 0.00;
		String msg = null;

		numProjTotal = projArray.length;
		numProjOngoing = Project.calcNumOngoingCountry(projArray);
		numProjComplete = Project.calcNumCompletedCountry(projArray);
		percProjComplete = Project.calcPercent(numProjComplete, numProjTotal);

		msg = "\nTotal number of projects in Canada: " +  numProjTotal +
			  "\nThe total number of Ongoing projects: " + numProjOngoing +
			  "\nThe total number of projects Completed: " + numProjComplete +
			  "\nThe percentage of Completed Projects: " + Math.round(percProjComplete) + "%";

		dispAndWrite(pw, msg);
	}
	

	

	//NAME: dispProvinceStat
	//PURPOSE: displays and writes to file the results of calculations chosen for a province
	//IMPORTS: pw, the PrintWriter object, projArray, an array that stores all projects in Canada, stat is the option 
	//corresponding to the calculation the user wants to perform, province, is a province the user chose to perform the 
	//calculations on
	//EXPORTS: none
	//ASSERTIONS:
		//PRE: projArray contains all valid values, stat is a valid value, province is a valid value
		//POST: statistics for province in Canada is displayed
	public static void dispProvinceStat(Project[] projArray, int stat, String province, PrintWriter pw) 
	{
		int numProjTotal = 0, numProjOngoing = 0, numProjCompleted = 0; 
		double percProjTotal = 0.0, percProjOngoing = 0.0, percProjCompleted = 0.0;
		String msg = null;

		numProjTotal = Project.calcNumProjectProvince(province, projArray);
		percProjTotal = Project.calcPercent(numProjTotal, projArray.length);
		numProjOngoing = Project.calcNumOngoingProvince(province, projArray);
		percProjOngoing = Project.calcPercent(numProjOngoing, numProjTotal);
		numProjCompleted = Project.calcNumCompletedProvince(province, projArray);
		percProjCompleted = Project.calcPercent(numProjCompleted, numProjTotal);

		switch(stat)
		{
		case 1:
			msg = "\nNumber of Projects: " + numProjTotal;
			dispAndWrite(pw, msg);
		break;

		case 2: 
			msg = "\nPercentage of all projects in this territory: " + Math.round(percProjTotal) + "%";
			dispAndWrite(pw, msg);
		break;
		
		case 3: 
			msg = "\nTotal number of ongoing projects: " + numProjOngoing +
				  "\nPercentage of ongoing projects: " + Math.round(percProjOngoing) + "%";
			dispAndWrite(pw, msg);
		break;
		
		case 4:
			msg = "\nTotal number of completed projects: " + numProjCompleted +
				  "\nPercentage of completed projects: " + Math.round(percProjCompleted) + "%";
			dispAndWrite(pw, msg);
		break;
		
		case 5:
			msg = "\n\nNumber of Projects: " + numProjTotal +
				  "\nPercentage of all projects in this territory: " + Math.round(percProjTotal) + "%" +
				  "\nTotal number of ongoing projects: " + numProjOngoing + 
				  "\nPercentage of ongoing projects: " + Math.round(percProjOngoing) + "%" + 
				  "\nTotal number of completed projects: " + numProjCompleted +
				  "\nPercentage of completed projects: " + Math.round(percProjOngoing) + "%";
			dispAndWrite(pw, msg);
		break;
		
		default:
		msg = "\nReturned to main menu";
			dispAndWrite(pw, msg);
		}
	}
}
