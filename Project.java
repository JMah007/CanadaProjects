//FILE: Project.java
//AUTHOR: Jaeden Mah
//USERNAME: jmah
//UNIT: COMP1007
//PURPOSE: makes a project obejct and manipulates its information
//
//REFERENCE: none
//COMMENTS: none
//
//REQUIRES: uses Location.java which contains methods to handles data to do with each projects location data 
//
//LAST MOD: 19/05/2023

import java.util.*;
import java.io.*;

public class Project 
{
	private String province;
	private String beneficiary;
	private String beneficiaryNum;
	private String assetClass;
	private String name;
	private String stage;
	private Location location;
	

	//NAME: Project
	//PURPOSE: a default constructor for the Project class sets values to empty values
	//IMPORTS: none
	//EXPORTS: none
	//ASSERTIONS:
		//PRE: none
		//POST: object is initialised
	public Project()
	{
		province = "No province given";
		beneficiary = "No beneficiary given";
		beneficiaryNum = "No beneficiary number given";
		assetClass = "No asset class given";
		name = "No name given";
		stage = "No stage given";
		location = new Location();
	}




	//NAME: Project
	//PURPOSE: a constructor that initalises the class fields of the object with values passed in 
	//IMPORTS: pProvince, a province the project is in, pBeneficiary, beneficiary of the project, pBeneficiaryNum, beneficiary number
	//pAssetClass, the asset class of the project, pNAme, the name of the project, pStage, stage the project is in, pLocation, coordinates
	//of project location 
	//EXPORTS: none
	//ASSERTIONS:
		//PRE: all parameters represent valid value
		//POST: object is initialised
	public Project(String pProvince, String pBeneficiary, String pBeneficiaryNum, String pAssetClass, String pName, String pStage, Location pLocation) 
	{
		province = pProvince;
		beneficiary = pBeneficiary;
		beneficiaryNum = pBeneficiaryNum;
		assetClass = pAssetClass;
		name = pName;
		stage = pStage;
		location = new Location(pLocation);
    }



	
	//NAME: Project
	//PURPOSE: a copy constructor to copy the class fields of an object into the new object
	//IMPORTS: otherProject, a object to copy to new object
	//EXPORTS: none
	//ASSERTIONS:
		//PRE: otherProject has valid values
		//POST: object is initialised
	public Project(Project otherProject)
	{
		province = otherProject.getProvince();
		beneficiary = otherProject.getBeneficiary();
		beneficiaryNum = otherProject.getBeneficiaryNum();
		assetClass = otherProject.getAssetClass();
		name = otherProject.getName();
		stage = otherProject.getStage();
		location = new Location(otherProject.getLocation());
	}



	
	//NAME: getProvince
	//PURPOSE: an accessor method to retrieve province
	//IMPORTS: none
	//EXPORTS: province (String)
	//ASSERTIONS:
		//PRE: 
		//POST: province is a valid value
	public String getProvince()
	{
		return province;
	}


	//NAME: getBeneficiary
	//PURPOSE: an accessor method to retrieve beneficiary
	//IMPORTS: none
	//EXPORTS: beneficiary (String)
	//ASSERTIONS:
		//PRE: 
		//POST: beneficiary is a valid value
	public String getBeneficiary()
	{
		return beneficiary;
	}


	//NAME: getBeneficiaryNum
	//PURPOSE: an accessor method to retrieve beneficiaryNum
	//IMPORTS: none
	//EXPORTS: beneficiaryNum (String)
	//ASSERTIONS:
		//PRE: 
		//POST: beneficiaryNum is a valid value
	public String getBeneficiaryNum()
	{
		return beneficiaryNum;
	}


	//NAME: getAssetClass
	//PURPOSE: an accessor method to retrieve assetClass
	//IMPORTS: none
	//EXPORTS: assetClass (String)
	//ASSERTIONS:
		//PRE: 
		//POST: assetClass is a valid value
	public String getAssetClass()
	{
		return assetClass;
	}


	//NAME: getName
	//PURPOSE: an accessor method to retrieve name
	//IMPORTS: none
	//EXPORTS: name (String)
	//ASSERTIONS:
		//PRE: 
		//POST: name is a valid value
	public String getName()
	{
		return name;
	}


	//NAME: getStage
	//PURPOSE: an accessor method to retrieve stage
	//IMPORTS: none
	//EXPORTS: stage (String)
	//ASSERTIONS:
		//PRE: 
		//POST: stage is a valid value
	public String getStage()
	{
		return stage;
	}


	//NAME: getLocation
	//PURPOSE: an accessor method to retrieve location
	//IMPORTS: none
	//EXPORTS: location (Location)
	//ASSERTIONS:
		//PRE: 
		//POST: location is a valid value
	public Location getLocation()
	{
		return location;
	}




	//NAME: setProvince
	//PURPOSE: a mutator method to modify province
	//IMPORTS: pProvince (String)
	//EXPORTS:  none
	//ASSERTIONS:
		//PRE: pProvince is a valid value
		//POST: 
	public void setProvince(String pProvince)
	{
		province = pProvince;
	}


	//NAME: setBeneficiary
	//PURPOSE: a mutator method to modify beneficiary
	//IMPORTS:  pBeneficiary (String)
	//EXPORTS:  none
	//ASSERTIONS:
		//PRE: pBeneficiary is a valid value
		//POST: 
	public void setBeneficiary(String pBeneficiary)
	{
		beneficiary = pBeneficiary;
	}


	//NAME: setBeneficiaryNum
	//PURPOSE: a mutator method to modify beneficiaryNum
	//IMPORTS:  pBeneficiaryNum (String)
	//EXPORTS:  none
	//ASSERTIONS:
		//PRE: pBeneficiaryNum is a valid value
		//POST: 
	public void setBeneficiaryNum(String pBeneficiaryNum)
	{
		beneficiaryNum = pBeneficiaryNum;
	}


	//NAME: setAssetClass
	//PURPOSE: a mutator method to modify assetClass
	//IMPORTS:  pAssetClass (String)
	//EXPORTS:  none
	//ASSERTIONS:
		//PRE: pAssetClass is a valid value
		//POST: 
	public void setAssetClass(String pAssetClass)
	{
		assetClass = pAssetClass;
	}


	//NAME: setName
	//PURPOSE: a mutator method to modify name
	//IMPORTS:  pName (String)
	//EXPORTS:  none
	//ASSERTIONS:
		//PRE: pName is a valid value
		//POST: 
	public void setName(String pName)
	{
		name = pName;
	}


	//NAME: setStage
	//PURPOSE: a mutator method to modify stage
	//IMPORTS:  pStage (String)
	//EXPORTS:  none
	//ASSERTIONS:
		//PRE: pStage is a valid value
		//POST: 
	public void setStage(String pStage)
	{
		stage = pStage;
	}


	//NAME: setLocation
	//PURPOSE: a mutator method to modify location
	//IMPORTS:  pLocation (Location)
	//EXPORTS:  none
	//ASSERTIONS:
		//PRE: pLocation is a valid value
		//POST: 
	public void setLocation(Location pLocation)
	{
		location = pLocation;
	}
	

	

	//NAME: valRegionOption
	//PURPOSE: makes sure region chosen by user exists 
	//IMPORTS: pOption, the option chosen by the user
	//EXPORTS: none
	//ASSERTIONS:
		//PRE: pOption is a valid value
		//POST: option exists in the menu or not
	//REMARKS: throws a InputMismatchException and IllegalArgumentException
	public static void valRegionOption(int pOption)throws InputMismatchException, IllegalArgumentException
	{
		int minOption = 1, maxOption = 15;

		try
		{
			if(pOption < minOption || pOption > maxOption)
			{
				throw new IllegalArgumentException();
			}
		}
		catch(InputMismatchException ime)
		{
			throw ime;
		}
	}




	//NAME: valStatisticOption
	//PURPOSE: makes sure chosen chosen by user exists 
	//IMPORTS: pOption, the option chosen by the user
	//EXPORTS: none
	//ASSERTIONS:
		//PRE: pOption is a valid value
		//POST: option exists in the menu or not
	//REMARKS: throws a InputMismatchException and IllegalArgumentException
	public static void valStatisticOption(int pOption) throws InputMismatchException, IllegalArgumentException
	{
		int minOption = 1, maxOption = 6;

		try
		{
			if(pOption < minOption || pOption > maxOption) 
			{
				throw new IllegalArgumentException();
			}
		}
		catch(InputMismatchException ime)
		{
			throw ime;
		}
	}




	//NAME: countProj
	//PURPOSE: takes a csv file and counts the number of rows containing  project data in the file 
	//IMPORTS: pFileName, contains the file name containing the project data
	//EXPORTS: the number of rows which represents the number of projects in the file
	//ASSERTIONS:
		//PRE: fileName is a String
		//POST: number of projects counted matches number of projects in file
	//REMARKS: handles IOException and displays a message
	public static int countProj(String pFileName) 
	{
		FileInputStream fileStream = null;
	    InputStreamReader isr;
		BufferedReader bufRdr;
		String line;
		int numProj = 0;	
		
		try 
		{   //open file 
			fileStream = new FileInputStream(pFileName);
			isr = new InputStreamReader(fileStream);
			bufRdr = new BufferedReader(isr);
			line = bufRdr.readLine();
			while(line != null) 
			{
				numProj++; //count number of projects
				line = bufRdr.readLine();
			}
			fileStream.close();
		}

		//if file cannot be processed
		catch(IOException errorDetails) 
		{
			if(fileStream != null)
			{
				try
				{
					fileStream.close();
				}
				catch(IOException ex2)
				{			
					System.out.println("IO Exception");
					System.out.println("Error in file processiong of " + pFileName);
				}
			}
		}
		numProj--;

		return numProj;
	}




	//NAME: storeFileData
	//PURPOSE: stores each row of data from a csv file into an index of array 
	//IMPORTS: pArray, an array of projects, pFileName, the file name containing the projects
	//EXPORTS: none
	//ASSERTIONS:
		//PRE: fileName is a string and pArray hasnt been initialised
		//POST: pArray has a been initialised with valid values
	//REMARKS: handles a IOException and IllegalArgumentException and displays message
	public static void storeFileData(Project[] pArray, String pFileName) 
	{
		FileInputStream fileStream = null;
	    InputStreamReader isr;
		BufferedReader bufRdr;
		String line;
		String[] splitLine;
		int projNum = 0;
		
		
		try
		{	//Open file
			fileStream = new FileInputStream(pFileName);
			isr = new InputStreamReader(fileStream);
			bufRdr = new BufferedReader(isr);
			line = bufRdr.readLine(); //Reads header row and throws it away
			line = bufRdr.readLine();
			while(line != null) //Reads file line by line and stores data from each line in project object in the array
			{
				splitLine = line.split(",");
				Project.createProject(splitLine, pArray, projNum);	
				line = bufRdr.readLine();
				
				projNum++;			
			}
			fileStream.close();
		}
		catch(IOException errorDetails) //if file cannot be processed
		{   
			if(fileStream != null)
			{
				try
				{
					fileStream.close();
				}
				catch(IOException ex2)
				{
					System.out.println("IO Exception");
					System.out.println("Error in file processiong of " + pFileName);
						
				}
			}
		}
		catch(IllegalArgumentException iae) //If a line is read with invalid coordinates
		{
			projNum++;
			System.out.println("\nProject " + projNum + " has incorrect coordinate values");
		}
	}




	//NAME: createProject
	//PURPOSE: creates an object of type Project initialising its class fields 
	//IMPORTS: pSplitLine, contains the row of data, pArray an array of Projects, pProjNum, project number to store
	//EXPORTS: none
	//ASSERTIONS:
		//PRE: pSplitLine, contains a row of data, pProjNum, is a valid value that exists in the data file
		//POST: Project object contains valid field values
	//REMARKS: throws an IllegalArgumentException
	public static void createProject(String[] pSplitLine, Project[] pArray, int pProjNum) throws IllegalArgumentException
	{
		Location location;

		try
		{	//tests Location object can be made successfully
			location = new Location(Location.createLocation(pSplitLine[7], pSplitLine[8], pSplitLine[9]));
			pArray[pProjNum] = new Project(pSplitLine[0], pSplitLine[1], pSplitLine[2], pSplitLine[3], pSplitLine[4], pSplitLine[6], location);
		}
		catch(IllegalArgumentException iae) //If Location object cannot be made due to incorrect coordinates
		{
			throw iae;
		}
	}




	//NAME: checkCompleted
	//PURPOSE: checks if project stage is completed
	//IMPORTS: none
	//EXPORTS: returns true if completed and false if otherwise
	//ASSERTIONS:
		//PRE: object being checked must have stage field initialised
		//POST: returns if object is completed or not
	public boolean checkCompleted()
	{
		boolean complete = false;

		if(getStage().equals("Completed"))
		{
			complete = true;
		}

		return complete;
	}




	//NAME: checkOngoing
	//PURPOSE: checks if project stage is ongoing 
	//IMPORTS: none
	//EXPORTS: returns true if completed and false if otherwise
	//ASSERTIONS:
		//PRE: object being checked must have stage field initialised
		//POST: returns if object is ongoing or not
	public boolean checkOngoing()
	{
		boolean ongoing = false;

		if(getStage().equals("Ongoing"))
		{
			ongoing = true;;
		}

		return ongoing;
	}




	//NAME: calcNumOngoingCountry
	//PURPOSE: goes through project array to see how many projects are ongoing in the country
	//IMPORTS: pProjectArray, an array containing projects
	//EXPORTS: returns the number of projects in the country still ongoing
	//ASSERTIONS:
		//PRE: pProjArray has valid values 
		//POST: number of projects will be valid
	public static int calcNumOngoingCountry(Project[] pProjArray)
	{
		int numOngoing = 0;
		int i;

		for(i = 0; i < pProjArray.length; i++)
		{
				if(pProjArray[i].checkOngoing())
				{
					numOngoing++;
				}
		}

		return numOngoing;
	}




	//NAME: calcNumOngoingProvince
	//PURPOSE: goes through project array to see how many projects are ongoing in the province selected
	//IMPORTS: pProvince, the province to look for projects ongoing in it, pProjectArray, an array containing projects
	//EXPORTS: returns the number of projects in the province still ongoing
	//ASSERTIONS:
		//PRE: pProjArray has valid values
		//POST: number of projects will be valid
	public static int calcNumOngoingProvince(String pProvince, Project[] pProjArray)
	{
		int numOngoing = 0;
		int i;

		for(i = 0; i < pProjArray.length; i++)
		{
			if(pProjArray[i].checkProvinceEqual(pProvince))
			{
				if(pProjArray[i].checkOngoing())
				{
					numOngoing++;
				}
			}
		}

		return numOngoing;
	}




	//NAME: calcNumCompletedCountry
	//PURPOSE: goes through project array to see how many projects are completed in the country
	//IMPORTS: pProjectArray, an array containing projects
	//EXPORTS: returns the number of projects in the country completed
	//ASSERTIONS:
		//PRE: pProjArray has valid values
		//POST: number of projects will be valid
	public static int calcNumCompletedCountry(Project[] pProjArray)
	{
		int numCompleted = 0;
		int i;

		for(i = 0; i < pProjArray.length; i++)
		{
				if(pProjArray[i].checkCompleted())
				{
					numCompleted++;
				}
		}

		return numCompleted;
	}




	//NAME: calcNumCompletedCountry
	//PURPOSE: goes through project array to see how many projects are completed in the province selected
	//IMPORTS: pProvince, the province to look for projects completed in it, pProjectArray, an array containing projects
	//EXPORTS: returns the number of projects in the province completed
	//ASSERTIONS:
		//PRE: pProjArray has valid values
		//POST: number of projects will be valid
	public static int calcNumCompletedProvince(String pProvince, Project[] pProjArray)
	{
		int numCompleted = 0;
		int i;

		for(i = 0; i < pProjArray.length; i++)
		{
			if(pProjArray[i].checkProvinceEqual(pProvince))
			{
				if(pProjArray[i].checkCompleted())
				{
					numCompleted++;
				}
			}
		}

		return numCompleted;
	}




	//NAME: calcNumProjectProvince
	//PURPOSE: calculates number of projects in the province passed in
	//IMPORTS: pProvince, the province count number of projects in it, pProjectArray, an array containing projects
	//EXPORTS: returns the number of projects in the province
	//ASSERTIONS:
		//PRE: pProjArray has valid values, pProvince is a valid value
		//POST: number of projects will be valid	
	public static int calcNumProjectProvince(String pProvince, Project[] pProjArray)
	{
		int numProjTotal = 0;
		int i;

		for(i = 0; i < pProjArray.length; i++)
		{
			if(pProjArray[i].checkProvinceEqual(pProvince))
			{
				numProjTotal++;
			}
		}

		return numProjTotal;
	}

	


	//NAME: calcPercent
	//PURPOSE: takes 2 values and calculates the percentage
	//IMPORTS: pNumerator, the dividend, pDenominator, the divisor
	//EXPORTS: returns the quotient representing the percentage
	//ASSERTIONS:
		//PRE: pNumerator and pDenominator are valid values
		//POST: quotient is a valid value	
	//REMARKS: does not return percentage with the percent sign
	public static double calcPercent(int pNumerator, int pDenominator)
	{
		double percentage = 0.00;

		percentage = ((double)pNumerator / (double)pDenominator) * 100;
		if(Double.isNaN(percentage))
		{
			percentage = 0.00;
		}

		return percentage;
	}


	

	//NAME: toString
	//PURPOSE: returns string representation of Project object
	//IMPORTS: none
	//EXPORTS: a string representation of Project object
	//ASSERTIONS:
		//PRE: none
		//POST: none	
	public String toString()
	{
		String projectString;

		projectString = "\nProvince is " + getProvince() + 
						"\nBeneficiary is " + getBeneficiary() + 
						"\nBeneficiary Number is " + getBeneficiaryNum() + 
						"\nAsset Class is " + getAssetClass() + 
						"\nName is " + getName() + 
						"\nStage is " + getStage() + 
						"\nLocation is " + getLocation();

		return projectString;
	}


 

	//NAME: equals
	//PURPOSE: compares equality of 2 Project objects
	//IMPORTS: inObject, the object to compare to
	//EXPORTS: returns true if objects are the same and false if otherwise
	//ASSERTIONS:
		//PRE: inObject has valid values
		//POST: obejcts are equal or not
	public boolean equals(Object inObject)
	{
		boolean isEqual = false;
		Project inProject = null;
		
		if(inObject instanceof Project)
		{
			inProject = (Project) inObject; 
			if(getProvince().equals(inProject.getProvince()))
			{
				if(getBeneficiary().equals(inProject.getBeneficiary()))
				{
					if(getBeneficiaryNum().equals(inProject.getBeneficiaryNum()))
					{
						if(getAssetClass().equals(inProject.getAssetClass()))
						{
							if(getName().equals(inProject.getName()))
							{
								if(getStage().equals(inProject.getStage()))
								{
									if(getLocation().equals(inProject.getLocation()))
									{
										isEqual = true;
									}
									
								}
							}
						}
					}	
				}
			}
		}
	
	return isEqual;
	}



	//NAME: checkProvinceEqual
	//PURPOSE: checks if province the project is is equal to province name passed into method
	//IMPORTS: pProvince, is a valid value
	//EXPORTS: returns true if the province is equal and false if otherwise
	//ASSERTIONS:
		//PRE: pProvince is a valid 
		//POST: returns if province is equal or not
	private boolean checkProvinceEqual(String pProvince)
	{
		boolean equal = false;

		if(getProvince().equals(pProvince))
		{
			equal = true;
		}
	
		return equal;
	}
}
