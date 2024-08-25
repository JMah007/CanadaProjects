//FILE: Location.java
//AUTHOR: Jaeden Mah
//USERNAME: jmah
//UNIT: COMP1007
//PURPOSE: makes a location object and manipulates its information
//
//REFERENCE: none
//COMMENTS: none
//
//REQUIRES: none
//
//LAST MOD: 19/05/2023

public class Location {
	
	
    private double latitude;
	private double longitude;
	private String coordinateSystem; 

	
	//NAME: Location
	//PURPOSE: a default constructor for the Location class sets values to empty values
	//IMPORTS: none
	//EXPORTS: none
	//ASSERTIONS:
		//PRE: none
		//POST: object is initialised
	public Location()
	{
		latitude = 0;
		longitude = 0;
		coordinateSystem = "No system given";
	}




	//NAME: Location
	//PURPOSE: a constructor that initalises the class fields of the object with values passed in 
	//IMPORTS: pLatitude, latitude of the project location, pLongtitudem longitude of the project location, pCoordinateSystem, coordinate system 
	//for the project
	//EXPORTS: none
	//ASSERTIONS:
		//PRE:  all parameters represent valid value
		//POST: object is initialised
	public Location(double pLatitude, double pLongitude, String pCoordinateSystem) 
	{
		latitude = pLatitude;
		longitude = pLongitude;
		coordinateSystem = pCoordinateSystem;
    }




	//NAME: Location
	//PURPOSE: a copy constructor to copy the class fields of an object into the new object
	//IMPORTS: otherLocation, a object to copy to new object
	//EXPORTS: none
	//ASSERTIONS:
		//PRE: otherLocation has valid values
		//POST: object is initialised
	public Location(Location otherLocation)
	{
		latitude = otherLocation.getLatitude();
		longitude = otherLocation.getLongitude();
		coordinateSystem = otherLocation.getCoordinateSystem();
	}


	

	//NAME: getLatitude
	//PURPOSE: an accessor method to retrieve latitude
	//IMPORTS: none
	//EXPORTS: latitude (double)
	//ASSERTIONS:
		//PRE: 
		//POST: latitude is a valid value
	public double getLatitude()
	{
		return latitude;
	}


	//NAME: getLongitude
	//PURPOSE: an accessor method to retrieve longitude
	//IMPORTS: none
	//EXPORTS: longitude (double)
	//ASSERTIONS:
		//PRE: 
		//POST: longitude is a valid value
	public double getLongitude()
	{
		return longitude;
	}


	//NAME: getCoordinateSystem
	//PURPOSE: an accessor method to retrieve coordinateSystem
	//IMPORTS: none
	//EXPORTS: coordinateSystem (String)
	//ASSERTIONS:
		//PRE: 
		//POST: coordinateSystem is a valid value
	public String getCoordinateSystem()
	{
		return coordinateSystem;
	}



	
	//NAME: setLatitude
	//PURPOSE: a mutator method to modify latitude
	//IMPORTS: pLatitude (double)
	//EXPORTS:  none
	//ASSERTIONS:
		//PRE: pLatitude is a valid value
		//POST: 
	public void setLatitude(double pLatitude)
	{
		latitude = pLatitude;
	}


	//NAME: setLongitude
	//PURPOSE: a mutator method to modify longitude
	//IMPORTS: pLongitude (double)
	//EXPORTS:  none
	//ASSERTIONS:
		//PRE: pLongitude is a valid value
		//POST: 
	public void setLongitude(double pLongitude)
	{
		longitude = pLongitude;
	}

	
	//NAME: setCoordinateSystem
	//PURPOSE: a mutator method to modify coordinateSystem
	//IMPORTS: pCoordinateSystem (String)
	//EXPORTS:  none
	//ASSERTIONS:
		//PRE: pCoordinateSystem is a valid value
		//POST: 
	public void setCoordinateSystem(String pCoordinateSystem)
	{
		coordinateSystem = pCoordinateSystem;
	}


	

	//NAME: stringToDouble
	//PURPOSE: converts a string value into its double value
	//IMPORTS: pString, a string to convert
	//EXPORTS: returns the double version of the string
	//ASSERTIONS:
		//PRE: pString is a valid value
		//POST: the double value will be a valid value of the original string
	public static double stringToDouble(String pString)
	{
		double newDouble;

		newDouble = Double.parseDouble(pString);
		
		return newDouble;
	}




	//NAME: valLatitude
	//PURPOSE:  checks to see if latitude value passed in is valid
	//IMPORTS: pLatitude, latitude value of location
	//EXPORTS: returns true if latitude is valid and false if otherwise
		//PRE: pLatitude is valid
		//POST: validity of latitude is confirmed
	//REMARKS: throws a IllegalArgumentException
	public static void valLatitude(double pLatitude) throws IllegalArgumentException
	{
		if(pLatitude < -90 || pLatitude > 90) //if out of range
		{
			throw new IllegalArgumentException();
		}
	}




	//NAME: valLongitude
	//PURPOSE:  checks to see if longitude value passed in is valid
	//IMPORTS: pLongitude, longitude value of location
	//EXPORTS: returns true if longitude is valid an false if otherwise
	//ASSERTIONS:
		//PRE: pLongitude is valid
		//POST: validity of longitude is confirmed
	//REMARKS: throws a IllegalArgumentException
	public static void valLongitude(double pLongitude) throws IllegalArgumentException
	{
		if(pLongitude < -180 || pLongitude > 180 ) //if out of range 
		{
			throw new IllegalArgumentException();
		}
	}




	//NAME: createLocation
	//PURPOSE:  creates an object of type Location initialising its class fields. Also makes sure coordinate values passed in are of type double
	//IMPORTS: pLatitude, latitude of location, pLongitude, longitude of location, pCoordinateSystem, coordinate system used
	//EXPORTS: none
	//ASSERTIONS:
		//PRE: argumements are valid
		//POST: Location object contains valid field values
	//REMARKS: throws a IllegalArgumentException	
	public static Location createLocation(String pLatitude, String pLongitude, String pCoordinateSystem ) throws IllegalArgumentException
	{
		double doubleLatitude = 0.00, doubleLongitude = 0.00;
		Location location;

		doubleLatitude = Location.stringToDouble(pLatitude); //converts latitude string to double
		doubleLongitude = Location.stringToDouble(pLongitude); //converts longitude string to double

		try
		{ //Tests if latitude and longitude are correct values before storing them in object
			valLatitude(doubleLatitude);
			valLongitude(doubleLongitude);
			location = new Location(doubleLatitude, doubleLongitude, pCoordinateSystem);
		}
		catch(IllegalArgumentException iae) //If latitude or longitude are invalid
		{
			throw iae;
		}
		
		return location;
	}



	
	//NAME: toString
	//PURPOSE:  returns string representation of Location object
	//IMPORTS: none
	//EXPORTS: a string representation of Location object
	//ASSERTIONS:
		//PRE: none
		//POST: none
	public String toString()
	{
		String locationString;

		locationString = "\nLatitude is " + getLatitude() + 
						 "\nLongitude is " + getLongitude() +
						 "\nCoordinate System is " + getCoordinateSystem();

		return locationString;
	}
		
	

	
	//NAME: equals
	//PURPOSE:  compares equality of 2 Location objects
	//IMPORTS: inObject, the object to compare to
	//EXPORTS: returns true if objects are the same and false if otherwise
	//ASSERTIONS:
		//PRE: inObject has valid values
		//POST: obejcts are equal or not
	public boolean equals(Object inObject)
	{
		boolean isEqual = false;
		Location inLocation = null;

		if(inObject instanceof Location)
		{
			inLocation = (Location)inObject; 
			if(getLatitude() == inLocation.getLatitude())
			{
				if(getLongitude() == inLocation.getLongitude())
				{
					if(getCoordinateSystem().equals(inLocation.getCoordinateSystem()))
					{
						isEqual = true;
					}
				}
			}
		}

		return isEqual;
	}
	
	


}