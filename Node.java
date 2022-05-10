/*
Name:		[Your Name Here]
Date:		[Current Date Here]
Course:		CSC 220 - Data Structures
*/

public class Node<Type> {	//<Type> place holder tells java
							//that it can use different types(more on that later)
	private Type data;
	private Node<Type> link;
	private Node<Type> prev;
	/**
	 * Default constructor - Newly constructed nodes have no data or link
	 */
	public Node() {
		data = null;	//no info stored
		link = null;	//not pointing anywhere
		prev = null; 	//not pointing anywhere

	}
 
	/**
	 * Accessor for the node's data
	 * @return 			data
	 */
	public Type getData() {
		return data;
	}

	/**
	 * Mutator for the node's data
	 * @param 			data - data to store in the node
	 */
	public void setData(Type data) {
		this.data = data;	//this.data refers to data that belongs to OBJ
							//data is equal to the given parameter
	}

	/**
	 * Accessor for the node's link
	 * @return 			link
	 */
	public Node<Type> getLink() {
		return link;
	}


	/**
	 * Accessor for the node's previous link
	 * @return 			link
	 */
	public Node<Type> getPrev(){
		return prev;
	}



	/**
	 * Mutator for the node's link
	 * @param 			link - node to link to
	 */
	public void setLink(Node<Type> link) {
		this.link = link;

	}
	/**
	 * Mutator for the node's previous link
	 * @param 			link - node to link to
	 */
	public void setPrev(Node<Type> link){
		this.prev = link;
	}
}