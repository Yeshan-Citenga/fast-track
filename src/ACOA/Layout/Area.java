//Package Signature.
package ACOA.Layout;

//List of library imports.
import java.io.File;
import ACOA.Layout.Level;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import ACOA.Mathematics.Mathematics_Library;

/**
 * @author Yeshan_Citenga
 *
 */
public class Area 
{
	//defining all class attributes/instances.
    private int number_Oflevels = 0;
    private int path_permutations = 0;
    
    //defining all the set of array list for the class. 
    private ArrayList<Level> level_array = new ArrayList<Level>();
    private ArrayList<AntTrip> antTrips_array = new ArrayList<AntTrip>();
    
    //creating a file connection to the area and path information text files.
	private File area_information = null;
	private File path_information = null;
	
	//creating a print writer connection to the area and path information file objects.
	private PrintWriter area_infoWriter = null;
	private PrintWriter path_infoWriter = null;
    
	//=======================================================================================//
	
    //defining first parameterised class constructor.
    /**
	 * @param level_array
	 */
	public Area(ArrayList<Level> level_array) 
	{
		//setting up class instance variables.
		this.number_Oflevels = level_array.size();
		this.level_array = level_array;
		
		//calling the function to set up file handling.
		setup_fileHandling();
	}
	
	//defining second parameterised class constructor.
	/**
	 * @param number_Oflevels
	 */
	public Area(int number_Oflevels) 
	{
		//setting up class instance variables.
		this.number_Oflevels = number_Oflevels;
		
		//creating a set of default levels and adding them to the array list.
		for(int index = 0; index < this.number_Oflevels; index++)
		{
			//creating a temporary level.
			Level temp_Level = new Level();
			//adding the node to the array list.
			this.level_array.add(temp_Level);
		}
		
		//calling the function to set up file handling.
		setup_fileHandling();
	}

	//defining class default constructor.
	/**
	 * 
	 */
	public Area()
	{
		//picking a random number of nodes.
		this.number_Oflevels = Mathematics_Library.generate_randomInt(Mathematics_Library.MIN_NumLEVELS, Mathematics_Library.MAX_NumLEVELS);
		
		//creating a set of default nodes and adding them to the array list.
		for(int index = 0; index < this.number_Oflevels; index++)
		{
			//creating a temporary level.
			Level temp_level = new Level();
			//adding the node to the array list.
			this.level_array.add(temp_level);
		}
		
		//calling the function to set up file handling.
		setup_fileHandling();
	}

	//=======================================================================================//
	
	//setting up the accessor method for the number of levels.
	/**
	 * @return the number_Oflevels
	 */
	public int getNumber_Oflevels() 
	{
		//setting the number of nodes from array.
		this.number_Oflevels = level_array.size();
		//returning the number of levels.
		return number_Oflevels;
	}
	
	//setting up the mutator method for the number of levels.
	/**
	 * @param number_Oflevels the number_Oflevels to set
	 */
	public void setNumber_Oflevels(int number_Oflevels) 
	{
		//increasing the number of levels in the area.
		this.number_Oflevels = number_Oflevels;
		//creating a new default level.
		Level new_level = new Level();
		//adding the new level to the array.
		level_array.add(new_level);
	}
	
	//setting up the accessor method for the array of levels.
	/**
	 * @return the level_array
	 */
	public ArrayList<Level> getLevel_array() 
	{
		//returning the level array.
		return level_array;
	}

	//setting up the mutator method for the array of levels.
	/**
	 * @param level_array
	 */
	public void setLevel_array(ArrayList<Level> level_array) 
	{
		//setting the new level array.
		this.level_array = level_array;
		//setting up the new number of levels.
		this.number_Oflevels = level_array.size();
	}

	//setting up the accessor method for a specified level.
	/**
	 * @param level_index
	 * @return
	 */
	public Level getLevel_atIndex(int level_index)
	{
		//getting the target node from the node array.
		Level target_level = this.level_array.get(level_index);
		//returning the node array.
		return target_level;
	}
	
	//setting up the mutator method for a specified level.
	/**
	 * @param level_index
	 * @param target_level
	 */
	public void setLevel_atIndex(int level_index, Level target_level)
	{
		//setting the target node from the node array.
		this.level_array.set(level_index, target_level) ;
	}

	//setting up a function that appends a new level to the array.
	/**
	 * @param new_level
	 */
	public void addLevel_ToArea(Level new_level)
	{
		//adding a new level to the area.
		this.level_array.add(new_level);
	}

	//setting up the accessor method for the array of trips.
	/**
	 * @return the path_array
	 */
	public ArrayList<AntTrip> getTrips_array()
	{
		//returning path array.
		return antTrips_array;
	}
	
	//setting up the accessor method for a specified level.
	/**
	 * @param path_index
	 * @return
	 */
	public AntTrip getTrip_atIndex(int trip_index)
	{
		//getting the target path from the array.
		AntTrip target_trip = this.antTrips_array.get(trip_index);
		//returning the path object at the given index.
		return target_trip;
	}
	
	//setting up the mutator method for the array of trips.
	/**
	 * @param path_array the path_array to set
	 */
	public void setTrip_array(ArrayList<AntTrip> antTrips_array) 
	{
		//setting path array.
		this.antTrips_array = antTrips_array;
	}
	
	//setting up the mutator method for a specified trip.
	/**
	 * @param path_index
	 * @param target_path
	 */
	public void setTrip_atIndex(int trip_index, AntTrip target_trip)
	{
		//setting the target path from the node array.
		this.antTrips_array.set(trip_index, target_trip);
	}

	//setting up a function that adds another trips to the array of trips.
	/**
	 * @param new_pathrecord
	 */
	public void record_newTrip(AntTrip new_tripRecord)
	{
		//adding the new path to the array of paths.
		this.antTrips_array.add(new_tripRecord);
	}
	
	//setting up accessor method for the path permutations.
	/**
	 * @return
	 */
	public int get_pathPermutations()
	{
		//initialising the return variable.
		this.path_permutations = 1;
		
		//looping through all the levels.
		for(int index = 0; index < this.number_Oflevels; index++)
		{
			//multiplying it so the number of nodes.
			path_permutations = path_permutations * this.level_array.get(index).getNumber_Ofnodes(); 
		}
		//returning the total number of paths.
		return path_permutations;
	}
	
	//function that sets up all file handling attributes.
	/**
	 * 
	 */
	private void setup_fileHandling()
	{	
		//instantiating file objects. 
		try 
		{	//now setting the file objects to an instance.
			area_information = new File("data/Area And Layout Information.txt");
			path_information = new File("data/All Paths Travelled Information.txt");
			
			//now setting the print writer objects to an instance.
			area_infoWriter = new PrintWriter(area_information);
			path_infoWriter = new PrintWriter(path_information);
		} 
		catch(IOException e) 
		{	
			//printing out an error message to the console. 
			System.err.println("One of the files that you are linking to does not exist.\n");
			// TODO Auto-generated catch block.
			e.printStackTrace();
		}
		
		//printing out all the file linking feedback information to the console.
		System.out.println("Area file object has been linked to: " + area_information.getName());
		System.out.println("Path file object has been linked to: " + path_information.getName());
		
		//adding a new line to the console.
		System.out.println("\n");
		
		//adding the information about the area to the respective text file.
		Mathematics_Library.write_toFile(area_infoWriter, "A new area has been created.\n");
		Mathematics_Library.write_toFile(area_infoWriter, "The number of Levels: " + this.number_Oflevels + "\n");
		Mathematics_Library.write_toFile(area_infoWriter, "The number of Nodes per level:\n");
		
		//looping through all the levels and writing the number of nodes to file.
		for(int index = 0; index < this.number_Oflevels; index++)
		{
			//generating string to write to file.
			String string_parameter = "";
			string_parameter += "	- Level " + (index + 1) + ": ";
			string_parameter += this.level_array.get(index).getNumber_Ofnodes() + " Nodes.";
			
			//writing the number of nodes to file.
			Mathematics_Library.write_toFile(area_infoWriter, string_parameter);
		}
		
		//printing the distance to all the nodes.
		Mathematics_Library.write_toFile(area_infoWriter, "\nDistance to each Node of each Level:\n");
		
		//looping through all the levels and writing the number of nodes to file.
		for(int index = 0; index < this.number_Oflevels; index++)
		{
			//generating string to write to file.
			String string_parameter = "";
			string_parameter += "	- Level " + (index + 1) + ":\n\n";
			
			//looping through all the nodes in the current level.
			for(int count = 0; count < this.level_array.get(index).getNumber_Ofnodes(); count++)
			{	//adding to the string parameter.
				string_parameter += "		* Distance to Node " + (count + 1) + ": ";
				string_parameter += this.level_array.get(index).getNode_atIndex(count).getDistance_toNode();
				string_parameter += " meters\n";
			}
			
			//writing the number of nodes to file.
			Mathematics_Library.write_toFile(area_infoWriter, string_parameter);
		}
		
		//printing the total number of paths.
		Mathematics_Library.write_toFile(area_infoWriter, "\nTotal number of paths: " + this.get_pathPermutations() + " paths.");  
	}
	
	//defining a function that displays results to the text file. 
 	public void display_pheromonePathResults(ArrayList<Node> short_pheromonePath)
 	{
 		//creating the string parameter to be written to file.
 		String string_parameter = "This is the information of the path that contains the highest amount of pheromone.\n";
 		string_parameter = string_parameter + "To travel the path with the most pheromone, one would have to pick:\n\n\t";
 		
 		//now looping through the nodes in the array list. 
 		for(int index = 0; index < short_pheromonePath.size(); index++)
 		{
 			//pulling the current node from the array of nodes. 
 			Node current_node = short_pheromonePath.get(index);
 			
 			//defining the variable to hold the node position of the target node.
 			int node_position = 1;
 			
 			//finding the position of the node in the node array of this level. 
 			for(int count = 0; count < level_array.get(index).getNumber_Ofnodes(); count++)
 			{
 				//comparing node id numbers. 
 				if(current_node.getId_Number().equals(level_array.get(index).getNode_atIndex(count).getId_Number()));
 				{
 					//setting the position of the node. 
 					node_position = node_position + count;
 				}
 			}
 			//adding node information to the output text file. 
 			string_parameter = string_parameter + "Node number: " + node_position + " in Level: " + (index + 1);
 			string_parameter = string_parameter + "\t- The distance to the node is: " + current_node.getDistance_toNode() + "\n\t";
 		}
 		
 		//printing out the shortest path by pheromone information. 
 		Mathematics_Library.write_toFile(path_infoWriter, string_parameter);
 	}
}
