//Class package signature.
package ACOA.Layout;

//List of library imports.
import java.util.ArrayList;
import ACOA.Layout.Node;
import ACOA.Mathematics.Mathematics_Library;

/**
 * @author Yeshan_Citenga
 *
 */
public class Level 
{
	//defining all class attributes/instances.
    private int number_Ofnodes;
    private ArrayList<Node> node_array = new ArrayList<Node>();
    
    //=======================================================================================//
    //defining first parameterised class constructor.
    /**
	 * @param node_vector
	 */
	public Level(ArrayList<Node> node_array) 
	{
		//setting class instances.
		this.number_Ofnodes = node_array.size();
		this.node_array = node_array;
	}
	
	//defining second parameterised class constructor.
	/**
	 * @param number_Ofnodes
	 */
	public Level(int number_Ofnodes) 
	{
		//setting class instances.
		this.number_Ofnodes = number_Ofnodes;
		
		//creating a set of default nodes and adding them to the array list.
		for(int index = 0; index < this.number_Ofnodes; index++)
		{
			//creating a temporary node.
			Node temp_node = new Node();
			//adding the node to the array list.
			this.node_array.add(temp_node);
		}
	}

	//defining class default constructor.
	/**
	 * 
	 */
	public Level()
	{
		//picking a random number of nodes.
		this.number_Ofnodes = Mathematics_Library.generate_randomInt(Mathematics_Library.MIN_NumNODES, Mathematics_Library.MAX_NumNODES);
		
		//creating a set of default nodes and adding them to the array list.
		for(int index = 0; index < this.number_Ofnodes; index++)
		{
			//creating a temporary node.
			Node temp_node = new Node();
			//adding the node to the array list.
			this.node_array.add(temp_node);
		}
	}

	//=======================================================================================//
	//setting up the accessor method for the number of nodes.
	/**
	 * @return the number_Ofnodes
	 */
	public int getNumber_Ofnodes() 
	{
		//setting the number of nodes from array.
		this.number_Ofnodes = node_array.size();
		//returning the number of nodes.
		return number_Ofnodes;
	}
	
	//setting up the accessor method for the array of nodes.
	/**
	 * @return the node_array
	 */
	public ArrayList<Node> getNode_array() 
	{
		//returning the array of nodes.
		return node_array;
	}
	
	//setting up the mutator method for the array of nodes.
	/**
	 * @param node_array the node_array to set
	 */
	public void setNode_array(ArrayList<Node> node_array) 
	{
		//setting the array of nodes.
		this.node_array = node_array;
		//setting up the new number of nodes.
		this.number_Ofnodes = node_array.size();
	}

	//setting up the accessor method for a specified node.
	/**
	 * @param node_index
	 * @return
	 */
	public Node getNode_atIndex(int node_index)
	{
		//getting the target node from the node array.
		Node target_node = this.node_array.get(node_index);
		//returning the node array.
		return target_node;
	}
	
	//setting up the mutator method for a specified node.
	/**
	 * @param node_index
	 * @param target_node
	 */
	public void setNode_atIndex(int node_index, Node target_node)
	{
		//setting the target node from the node array.
		this.node_array.set(node_index, target_node) ;
	}
	
	//setting up a function that adds another node to a level.
	/**
	 * @param new_node
	 */
	public void addNode_Tolevel(Node new_node)
	{
		//adding the new node to the array of nodes.
		this.node_array.add(new_node);
	}
}
