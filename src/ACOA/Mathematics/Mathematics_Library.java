//Class package signature.
package ACOA.Mathematics;

//List of library imports.
import java.lang.Math;
import java.util.Random;
import ACOA.Layout.AntTrip;
import ACOA.Layout.Area;
import ACOA.Layout.Level;
import ACOA.Layout.Node;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author Yeshan_Citenga
 *
 */
public class Mathematics_Library 
{
	//defining the initial number of ants.
	public static final int NUMBER_OF_ANTS = 400;
	//defining the initial pheromone on each path to node.
	public static final double INITIAL_PHEROMONES = 0.5;
	
	//Defining the minimum and maximum number of nodes. 
    public static final int MIN_NumNODES = 2;
    public static final int MAX_NumNODES = 7;
    
    //Defining the minimum and maximum number of levels. 
    public static final int MIN_NumLEVELS = 2;
    public static final int MAX_NumLEVELS = 9;
    
    //Defining the minimum and maximum distances to nodes. 
    public static final int MIN_DISTANCE = 20;
    public static final int MAX_DISTANCE = 80;
    
	//defining the both the alpha and beta parameters.
	//these parameters help to determine how each factor affects
	//the probability of a certain ant choosing a certain point.
	//setting them both to one in this case means that they affect
	//the probability equally.
	public static final double DISTANCE_PARAMETER_BETA = 0.5;
	public static final double PHEROMONE_PARAMETER_ALPHA = 0.8;
	
	//defining a function that finds the path with the highest amount of pheromone.
	/**
	 * @param path_array
	 * @return
	 */
	public static ArrayList<Node> find_shortestPheromonePath(Area optimisation_area)
	{
		//creating an array of nodes. 
		ArrayList<Node> shortest_path = new ArrayList<Node>();
		
		//looping through all the levels in the area. 
		for(int index = 0; index < optimisation_area.getNumber_Oflevels(); index++)
		{
			//assuming that choosing the first node has the highest amount of pheromone. 
			Node mostPheromone_node = optimisation_area.getLevel_atIndex(index).getNode_atIndex(0);
			
			//looping through all the nodes in the current level. 
			for(int count = 0; count < optimisation_area.getLevel_atIndex(index).getNumber_Ofnodes(); count++)
			{
				//now comparing the pheromone level on each path to each node. 
				if(optimisation_area.getLevel_atIndex(index).getNode_atIndex(count).getPheromone_value() > mostPheromone_node.getPheromone_value())
				{
					//assigning a new path that has a higher amount of pheromone on it's paths. 
					mostPheromone_node = optimisation_area.getLevel_atIndex(index).getNode_atIndex(count);
				}
			}
			
			//adding the node with the highest pheromone in this level to the array. 
			shortest_path.add(mostPheromone_node);
		}
		//returning the shortest path. 
		return shortest_path;
	}
	
	//defining a function that finds the shortest path in the entire area.
	/**
	 * @param optimisation_area
	 * @return
	 */
	public static ArrayList<Node> find_shortestDistancePath(Area optimisation_area)
	{
		//creating an array of nodes. 
		ArrayList<Node> shortest_path = new ArrayList<Node>();
		
		//looping through all the levels in the area. 
		for(int index = 0; index < optimisation_area.getNumber_Oflevels(); index++)
		{
			//assuming that choosing the first node has the highest amount of pheromone. 
			Node shortestDistance_node = optimisation_area.getLevel_atIndex(index).getNode_atIndex(0);
			
			//looping through all the nodes in the current level. 
			for(int count = 0; count < optimisation_area.getLevel_atIndex(index).getNumber_Ofnodes(); count++)
			{
				//now comparing the pheromone level on each path to each node. 
				if(optimisation_area.getLevel_atIndex(index).getNode_atIndex(count).getDistance_toNode() < shortestDistance_node.getDistance_toNode())
				{
					//assigning a new path that has a higher amount of pheromone on it's paths. 
					shortestDistance_node = optimisation_area.getLevel_atIndex(index).getNode_atIndex(count);
				}
			}
			
			//adding the node with the highest pheromone in this level to the array. 
			shortest_path.add(shortestDistance_node);
		}
		//returning the shortest path. 
		return shortest_path;
	}
	
	//defining a function that updates the amount of pheromone on a going path.
	/**
	 * @param present_pheromone
	 * @param newpath_distance
	 * @return
	 */
	public static Area update_goingNodePheromone(Area optimisation_area, AntTrip travelled_path)
	{
		//getting the total distance of the path. 
		int total_distance = travelled_path.getTotal_GoingDistance();
		
		//calculating the amount of pheromone to be deposited.
		double additional_pheromone = 1/((double)total_distance);
		
		//looping through all of the levels in the area. 
		for(int index = 0; index < optimisation_area.getNumber_Oflevels(); index++)
		{
			//looping through all the nodes in each level. 
			for(int count = 0; count < optimisation_area.getLevel_atIndex(index).getNumber_Ofnodes(); count++)
			{
				//comparing the id numbers of each node. 
				if(optimisation_area.getLevel_atIndex(index).getNode_atIndex(count).getId_Number().equals
				  (travelled_path.get_goingNodeAtIndex(index).getId_Number()))
				{
					//updating the pheromone levels on each node path in the area. 
					optimisation_area.getLevel_atIndex(index).getNode_atIndex(count).addPheremone_value(additional_pheromone);
					//breaking out of the loop. 
					break;
				}
			}
		}

		//returning the updated area.
		return optimisation_area;
	}
	
	//defining a function that updates the amount of pheromone on a return path.
	/**
	 * @param optimisation_area
	 * @param return_path
	 * @return
	 */
	public static Area update_returnNodePheromone(Area optimisation_area, AntTrip travelled_path)
	{
		//getting the total distance of the path. 
		int total_distance = travelled_path.getTotal_ReturnDistance();
		
		//calculating the amount of pheromone to be deposited.
		double additional_pheromone = 1/((double)total_distance);
		
		//looping through all of the levels in the area. 
		for(int index = optimisation_area.getNumber_Oflevels() - 1; index >= 0; index--)
		{
			//looping through all the nodes in each level. 
			for(int count = optimisation_area.getLevel_atIndex(index).getNumber_Ofnodes() - 1; count >= 0; count--)
			{
				//comparing the id numbers of each node. 
				if(optimisation_area.getLevel_atIndex(index).getNode_atIndex(count).getId_Number().equals
				  (travelled_path.get_returnNodeAtIndex(index).getId_Number()))
				{
					//updating the pheromone levels on each node path in the area. 
					optimisation_area.getLevel_atIndex(index).getNode_atIndex(count).addPheremone_value(additional_pheromone);
					//breaking out of the loop.
					break;
				}
			}
		}

		//returning the updated area.
		return optimisation_area;
	}
	
	//defining a function that generates a random integer between two bounds.
	/**
	 * @param lower_bound
	 * @param upper_bound
	 * @return
	 */
 	public static int generate_randomInt(int lower_bound, int upper_bound)
	{
		//creating a new random class instance.
		Random random_object = new Random();
		//creating and initialising return variable.
		int return_value = random_object.nextInt((upper_bound - lower_bound) + 1) + lower_bound;
		//returning the random value.
		return return_value;
	}

 	//defining a function that generates a random double.
 	/**
 	 * @return
 	 */
 	public static double generate_randomDouble()
	{
		//creating a new random class instance.
		Random random_object = new Random();
		//creating and initialising return variable.
		double return_value = random_object.nextDouble();
		//returning the random value.
		return return_value;
	}
 	
 	//function that generates a random identification number.
 	/**
 	 * @param id_length
 	 * @return
 	 */
 	public static String generate_idNumber(int id_length)
 	{
        //chose a Character random from this String 
        String AlphaNumericString = "0123456789" + "abcdefghijklmnopqrstuvxyz"; 
  
        //create StringBuffer size of AlphaNumericString 
        StringBuilder string_builder = new StringBuilder(id_length); 
  
        for (int i = 0; i < id_length; i++) 
        { 
            //generate a random number between 0 to AlphaNumericString variable length 
            int index = (int)(AlphaNumericString.length() * Math.random()); 
  
            //add Character one by one in end of the string builder.
            string_builder.append(AlphaNumericString.charAt(index)); 
        } 
 
        //returning the final string.
        return string_builder.toString(); 
 	}
 	
 	//function that writes information to a given file.
 	/**
 	 * @param information_writer
 	 * @param message
 	 */
 	public static void write_toFile(PrintWriter information_writer, String message)
 	{
 		//writing the message to the file.
 		information_writer.write(message + "\n");
 		//flushing the stream.
 		information_writer.flush();
 	}

 	//function that calculates the probability of choosing a given path. 
 	/**
 	 * @param next_level
 	 * @return
 	 */
 	public static int calculate_probability(Level next_level)
 	{
 		//defining an array of probabilities to be populated later.
 		ArrayList<Double> probability_array = new ArrayList<Double>();
 		
 		//looping through all the nodes in the given level.
 		for(int index = 0; index < next_level.getNumber_Ofnodes(); index++)
 		{
 			//calculating the multiplicands of the numerator of the probability. 
 			double mul_pheromone = Math.pow((double)(next_level.getNode_atIndex(index).getPheromone_value()), PHEROMONE_PARAMETER_ALPHA);
 			double mul_distance = Math.pow(1/(double)(next_level.getNode_atIndex(index).getDistance_toNode()), DISTANCE_PARAMETER_BETA);
 			
 			//calculating the numerator of the probability.
 			double prob_numerator = mul_pheromone * mul_distance;
 			//calculating the denominator of the probability.
 			double prob_denomenator = calculate_denomenator(next_level);
 			//calculating the probability of choosing the node. 
 			double node_probability = prob_numerator/prob_denomenator;
 			//adding the probability to the array of probabilities. 
 			probability_array.add(node_probability);
 		}
 		
 		//calling the function that generates the probability and returns next Node index.
 		int next_NodeIndex = generate_probability(probability_array);
 		
 		//returning the next index of the next node. 
 		return next_NodeIndex;
 	}
 	
 	//function that calculates the denominator of the probability.
 	/**
 	 * @param next_level
 	 * @return
 	 */
 	private static double calculate_denomenator(Level next_level)
 	{
 		//defining a variable to hold the sum of the products. 
 		double prob_denomenator = 0.00;
 		
 		//looping through all nodes of the given level.
 		for(int index = 0; index < next_level.getNumber_Ofnodes(); index++)
 		{
 			//calculating the multiplicands of the numerator of the probability. 
 			double mul_pheromone2 = Math.pow((double)(next_level.getNode_atIndex(index)).getPheromone_value(), PHEROMONE_PARAMETER_ALPHA);
 			double mul_distance2 = Math.pow(1/(double)(next_level.getNode_atIndex(index).getDistance_toNode()), DISTANCE_PARAMETER_BETA);
 			
 			//calculating the numerator of the probability.
 			double product = mul_pheromone2 * mul_distance2;
 			
 			//adding the product to the sum.
 			prob_denomenator = prob_denomenator + product;
 		}
 		
 		//returning the final value.
 		return prob_denomenator;
 	}
 	
 	//function that generates a weighted probability.
 	//this function makes use of the Rollete Wheel technique to generate a weighted probability.
 	/**
 	 * @param node_weights
 	 * @return
 	 */
 	public static int generate_probability(ArrayList<Double> node_weights)
 	{
 		//creating a variable to hold the cumulative probability sums.
 		ArrayList<Double> cumulative_sum = new ArrayList<Double>();
 		
 		//creating a temporary sum variable.
		double calm_sum = 0.00;
		int starting_point = 0;
		
 		//looping through all the weights
 		while(starting_point != node_weights.size() - 1)
 		{
 			//looping through the weight array.
 			for(int count = starting_point; count < node_weights.size(); count++)
 			{
 				calm_sum = calm_sum + node_weights.get(count);
 			}
 			
 			//adding the sum to the array. 
 			cumulative_sum.add(calm_sum);
 			
 			//changing the starting point and resetting the sum.
 			calm_sum = 0.00;
 			starting_point = starting_point + 1;
 		}
 	
		//adding the last value at the end of the array.
		cumulative_sum.add(node_weights.get(node_weights.size() - 1));

		//generating a random double from 0 -> 1. 
		double random_number = generate_randomDouble(); 
		//instantiating and initialising node index. 
		int Nextnode_index = 0;
		  
		//looping through the cumulative sum array. 
		for(int index = 0; index < cumulative_sum.size() - 1; index++) 
		{ 
			//determining index. 
			if(random_number <= cumulative_sum.get(index) && random_number > cumulative_sum.get(index +1))
			{ 
				Nextnode_index = index; 
			} 
		}
		  
		//testing the last index. 
		if(random_number <= cumulative_sum.get(cumulative_sum.size() - 1) && random_number > 0)
		{
			Nextnode_index = cumulative_sum.size() - 1; 
		}
		
 		//returning next node index.
 		return Nextnode_index;
 	}

}
