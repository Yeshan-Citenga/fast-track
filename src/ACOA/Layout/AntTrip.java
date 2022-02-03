//Package Signature.
package ACOA.Layout;

//List of library imports.
import java.util.ArrayList;

/**
 * @author Yeshan_Citenga
 *
 */
public class AntTrip 
{
	//defining all class attributes/instances.
    private int numberOf_GoingNodes;
    private int numberOf_ReturnNodes;
    private int total_goingDistance;
    private int total_returnDistance;
    private double total_goingPheromone;
    private double total_returnPheromone;
    private ArrayList<Node> going_NodeArray = new ArrayList<Node>();
    private ArrayList<Node> return_NodeArray = new ArrayList<Node>();
    
    //defining a default constructor with no implementation.
    /**
     * 
     */
    public AntTrip()
    {
    	//Initialising all the other instance variable in the class.
    	this.numberOf_GoingNodes = 0;
    	this.numberOf_ReturnNodes = 0;
    	this.total_goingDistance = 0;
    	this.total_returnDistance = 0;
    	this.total_goingPheromone = 0.00;
    	this.total_returnPheromone = 0.00;
    	//no arrays to initialise in the constructor. Nodes are added as we go along.
    }
    
	//=======================================================================================//
	
    //setting up the accessor method for the number of nodes in the array of going nodes.
	/**
	 * @return
	 */
	public int getNumber_OfGoingNodes()
	{
		//setting the number of nodes from array.
		this.numberOf_GoingNodes = going_NodeArray.size();
		//returning the number of nodes.
		return numberOf_GoingNodes;
	}
	
	//setting up the accessor method for the number of nodes in the array of return nodes.
	/**
	 * @return
	 */
	public int getNumber_OfReturnNodes()
	{
		//setting the number of nodes from array.
		this.numberOf_ReturnNodes = return_NodeArray.size();
		//returning the number of nodes.
		return numberOf_ReturnNodes;
	}
    
	
	//setting up the accessor method for the total going distance of the path. 
	/**
	 * @return
	 */
	public int getTotal_GoingDistance() 
	{
		//calling the function that calculates the total going distance.
		this.calc_totalGoingDistance();
		//now returning the total going distance of this path.
		return this.total_goingDistance;
	}
	
	//setting up the accessor method for the total return distance of the path. 
	/**
	 * @return
	 */
	public int getTotal_ReturnDistance() 
	{
		//calling the function that calculates the total return distance.
		this.calc_totalReturnDistance();
		//now returning the total return distance of this path.
		return this.total_returnDistance;
	}
	
	
	//setting up the function that calculates the total going distance.
	/**
	 * 
	 */
	private void calc_totalGoingDistance()
	{
		//setting the number of nodes from array.
		this.numberOf_GoingNodes = this.going_NodeArray.size();
		//defining a counter variable.
		int distance_sum = 0;
		//adding up all the distances to all nodes.
		for(int index = 0; index < numberOf_GoingNodes; index++)
		{
			//adding to the total distance.
			distance_sum = distance_sum + going_NodeArray.get(index).getDistance_toNode();
		}
		
		//setting the total.
		this.total_goingDistance = distance_sum;
	}
	
	//setting up the function that calculates the total going distance.
	/**
	 * 
	 */
	private void calc_totalReturnDistance()
	{
		//setting the number of nodes from array.
		this.numberOf_ReturnNodes = this.return_NodeArray.size();
		//defining a counter variable.
		int distance_sum = 0;
		//adding up all the distances to all nodes.
		for(int index = 0; index < numberOf_ReturnNodes; index++)
		{
			//adding to the total distance.
			distance_sum = distance_sum + return_NodeArray.get(index).getDistance_toNode();
		}
		
		//setting the total.
		this.total_returnDistance = distance_sum;
	}

	
	//setting up the accessor method for the total pheromone on the going path. 
	/**
	 * @return
	 */
	public double getTotal_GoingPheromone()
	{
		//calling the function that calculates the total pheromone.
		this.calc_totalGoingPheromone();
		//now returning the total pheromone on this path.
		return this.total_goingPheromone;
	}
	//setting up the accessor method for the total pheromone on the going path. 
	/**
	 * @return
	 */
	public double getTotal_ReturnPheromone()
	{
		//calling the function that calculates the total pheromone.
		this.calc_totalReturnPheromone();
		//now returning the total pheromone on this path.
		return this.total_returnPheromone;
	}
	
	
	//setting up the function that calculates the total pheromone amount (going).
	/**
	 * 
	 */
	private void calc_totalGoingPheromone()
	{
		//setting the number of nodes from array.
		this.numberOf_GoingNodes = this.going_NodeArray.size();
		//defining a counter variable.
		double pheromone_sum = 0;
		//adding up all the distances to all nodes.
		for(int index = 0; index < numberOf_GoingNodes; index++)
		{
			//adding to the total pheromone.
			pheromone_sum = pheromone_sum + going_NodeArray.get(index).getPheromone_value();
		}
		
		//setting the total.
		this.total_goingPheromone = pheromone_sum;
	}
	
	//setting up the function that calculates the total pheromone amount (return).
	/**
	 * 
	 */
	private void calc_totalReturnPheromone()
	{
		//setting the number of nodes from array.
		this.numberOf_ReturnNodes = this.return_NodeArray.size();
		//defining a counter variable.
		double pheromone_sum = 0.00;
		//adding up all the distances to all nodes.
		for(int index = 0; index < numberOf_ReturnNodes; index++)
		{
			//adding to the total pheromone.
			pheromone_sum = pheromone_sum + return_NodeArray.get(index).getPheromone_value();
		}
		//setting the total.
		this.total_returnPheromone = pheromone_sum;
	}
	
	
	//setting up a function that adds another node to a going path.
	/**
	 * @param new_node
	 */
	public void addNode_ToGoingPath(Node new_node)
	{
		//adding the new node to the array of nodes.
		this.going_NodeArray.add(new_node);
	}
	
	//setting up a function that adds another node to a return path.
	/**
	 * @param new_node
	 */
	public void addNode_ToReturnPath(Node new_node)
	{
		//adding the new node to the array of nodes.
		this.return_NodeArray.add(new_node);
	}
	
	
	//setting up the accessor method for the array of nodes in the going path.
	/**
	 * @return
	 */
	public ArrayList<Node> get_goingNodeArray()
	{
		//returning the array of nodes. 
		return this.going_NodeArray;
	}
	
	//setting up the accessor method for the array of nodes in the return path.
	public ArrayList<Node> get_returnNodeArray()
	{
		//returning the array of nodes. 
		return this.return_NodeArray;
	}

	
	//setting up the accessor method for a going node at index.
	/**
	 * @param index
	 * @return
	 */
	public Node get_goingNodeAtIndex(int index)
	{
		//returning the indexed nodes.
		return this.going_NodeArray.get(index);
	}
	
	//setting up the accessor method for a return node at index.
	public Node get_returnNodeAtIndex(int index)
	{
		//returning the indexed node.
		return this.return_NodeArray.get(index);
	}
}
