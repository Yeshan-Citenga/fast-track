//Class package signature.
package ACOA.Main;

//List of library imports.
import ACOA.Layout.Area;
import ACOA.Layout.Level;
import ACOA.Layout.Node;

import java.util.ArrayList;

import ACOA.Layout.AntTrip;
import ACOA.Mathematics.Mathematics_Library;

/**
 * @author Yeshan_Citenga
 *
 */
public class Main 
{
	//defining the main function.
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//setting the number of levels in the area. 
		int number_ofLevels = 10;
		//setting the number of nodes for each level. 
		int level_1Nodes = 10;

		//creating a new area. A default area with a random number of levels. 
		Area optimisation_area = new Area();
		
		//looping through the number of ants and starting a each ants journey. 
		for(int ant_index = 0; ant_index < Mathematics_Library.NUMBER_OF_ANTS; ant_index++)
		{
			//creating a new default ant trip. 
			AntTrip current_AntTrip = new AntTrip();
			
			//looping through all the levels of the area going from ant-hill to food source.
			for(int level_index = 0; level_index < optimisation_area.getNumber_Oflevels(); level_index++)
			{
				//getting the current level from the array in  the area. 
				Level current_level = optimisation_area.getLevel_atIndex(level_index);
				//choosing a random node in this level by call the math function. 
				int nextNode_index = Mathematics_Library.calculate_probability(current_level);
				//adding the node to the going path array of the trip. 
				current_AntTrip.addNode_ToGoingPath(optimisation_area.getLevel_atIndex(level_index).getNode_atIndex(nextNode_index));
			}
			
			//updating the pheromone levels on the path travelled by this ant from the ant-hill to food source.
			optimisation_area = Mathematics_Library.update_goingNodePheromone(optimisation_area, current_AntTrip);
			
			//looping through all the levels of the area going from food source to ant-hill. 
			for(int level_index = optimisation_area.getNumber_Oflevels() - 1; level_index >= 0 ; level_index--)
			{
				//getting the current level from the array in  the area. 
				Level current_level = optimisation_area.getLevel_atIndex(level_index);
				//choosing a random node in this level by call the math function. 
				int nextNode_index = Mathematics_Library.calculate_probability(current_level);
				//adding the node to the going path array of the trip. 
				current_AntTrip.addNode_ToReturnPath(optimisation_area.getLevel_atIndex(level_index).getNode_atIndex(nextNode_index));
			}
			
			//updating the pheromone levels on the path travelled by this ant from the food source to ant-hill.
			optimisation_area = Mathematics_Library.update_returnNodePheromone(optimisation_area, current_AntTrip);
			//adding the current ant trip to the end of the array of trips. 
			optimisation_area.record_newTrip(current_AntTrip);
		}
		
		//should the algorithm work well, the path with the highest amount of pheromone, i.e the 
		//most travelled path should be the shortest path.
		
		//now finding the shortest path based on the shortest distance.
		ArrayList<Node> shortestPath_byDistance = Mathematics_Library.find_shortestDistancePath(optimisation_area);
		//now finding the shortest path based on the amount of pheromone.
		ArrayList<Node> shortestPath_byPheromone = Mathematics_Library.find_shortestPheromonePath(optimisation_area);
		//now outputting the results to a text file. 
		optimisation_area.display_pheromonePathResults(shortestPath_byPheromone);
	}
}
