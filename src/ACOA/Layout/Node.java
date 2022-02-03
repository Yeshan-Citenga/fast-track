//Class package signature.
package ACOA.Layout;

//List of library imports.
import ACOA.Mathematics.Mathematics_Library;

/**
 * @author Yeshan_Citenga
 *
 */
public class Node 
{
    //defining all the class attributes.
    private int distance_toNode;
    private String node_IdNumber = null;
    private double pheromone_level = 0.00;	//setting initial pheromone to null on each node path
	
    //=======================================================================================//
    
    //defining class parameterised constructor.
    /**
	 * @param distance_toNode
	 */
	public Node(int distance_toNode, double initial_pheromone) 
	{	
		//setting class instances.
		this.distance_toNode = distance_toNode;
		//setting the initial amount of pheromone.
		this.pheromone_level = initial_pheromone;
		//setting the node id number.
		this.node_IdNumber = new String(Mathematics_Library.generate_idNumber(10));
	}
	
	//defining class default constructor.
	public Node()
	{	
		//setting class instances by generating a random distance to the node.
		this.distance_toNode = Mathematics_Library.generate_randomInt(Mathematics_Library.MIN_DISTANCE, Mathematics_Library.MAX_DISTANCE);
		//setting the default initial amount of pheromone.
		this.pheromone_level = Mathematics_Library.INITIAL_PHEROMONES;
		//setting the node id number.
		this.node_IdNumber = new String(Mathematics_Library.generate_idNumber(10));
	}

	//=======================================================================================//
	//accessor method for distance to node.
	/**
	 * @return the distance_toNode
	 */
	public int getDistance_toNode() 
	{
		//returning the value of the distance.
		return distance_toNode;
	}
	
	//mutator method for distance to node.
	/**
	 * @param distance_toNode the distance_toNode to set
	 */
	public void setDistance_toNode(int distance_toNode) 
	{
		//setting the value of the distance.
		this.distance_toNode = distance_toNode;
	}

	//accessor method for pheromone value on the path to the node.
	/**
	 * @return the pheremone_value
	 */
	public double getPheromone_value() 
	{	
		//returning the pheromone value.
		return this.pheromone_level;
	}
	
	//accessor method for the id number of the node.
	/**
	 * @return
	 */
	public String getId_Number()
	{
		//returning the id number. 
		return this.node_IdNumber;
	}
	
	//mutator method for pheromone value on the path to the node.
	/**
	 * @param pheremone_value the pheremone_value to set
	 */
	public void setPheremone_value(double pheremone_value) 
	{
		//setting the pheromone value.
		this.pheromone_level = pheremone_value;
	}
	
	//function that adds pheromone value on the path to the node.
	/**
	 * @param additional_value
	 */
	public void addPheremone_value(double additional_value)
	{
		//adding the pheromone value.
		pheromone_level = pheromone_level + additional_value;
	}
}
