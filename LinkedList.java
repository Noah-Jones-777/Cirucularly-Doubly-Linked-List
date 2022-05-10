/*
Name:	 	Noah Jones
Date:		1/7/2022
Course:		CSC 220 - Data Structures
*/

public class LinkedList<Type> extends AbstractLinkedList<Type> {
	/**
	 * Default Constructor - Newly constructed lists have no nodes,
	 * so head and tail point to null.
	 */
	public LinkedList() {
		head = null;
		current = null;
		tail = null;
		numElements = 0;

	}

	/**
	 * Copy constructor - copies each element from the given linked list
	 * into the one being constructed.
	 * @param 			l - the linked list being copied from
	 */
	public LinkedList(LinkedList<Type> l) {
		head = null;
		current = null;
		tail = null;
		numElements = 0;
		for(int i=0; i<l.size(); i++){
			if(i==0){
				head = new Node<Type>();
				head.setData(l.get(i));
				current = head;
				tail = head;

				//setting head pre links
				head.setPrev(tail);
				tail.setPrev(head);
			}
			else{
				Node<Type> temp = new Node<Type>();

				head.setPrev(temp);
				temp.setData(l.get(i));
				temp.setPrev(tail);
				temp.setLink(head);
				tail.setLink(temp);

				tail = temp;

				//here is where the CIRCULAR linking takes place
			
			}
			numElements++;
		}
	}

	/**
	 * Returns a String representation of the list ("NULL" if empty)
	 * @return 			String representation of the linked list
	 */
	public String toString() {
		String s = "";
		int count = numElements;
		//return null if the list is empty
		if (head == null){
			return "NULL";
		}
		else{
			//start traversing at the head
			Node<Type>  temp = head;
			while(temp != null && count > 0){
				s += temp.getData() + " ";
				temp = temp.getLink();
				count--;
			}

		}
	return s;
	}



	/**
	 * Returns the number of elements in the list (not the max capacity)
	 * @return 			number of elements in the linked list
	 */
	public int size() {
		return numElements;
	}

	/**
	 * Returns true if there are no elements in the list
	 * @return 			true if list is empty, false otherwise
	 */
	public boolean isEmpty() {
		return (numElements == 0);
	}

	/**
	 * Returns true if the number of elements in the list is equal to MAX_SIZE
	 * @return 			true if list is full, false otherwise
	 */
	public boolean isFull() {
		return (numElements == MAX_SIZE);
	}

	/**
	 * Set the current Node reference to the head node
	 */
	public void first() {
		current = head;
		
	}

	/**
	 * Set current to the next node in the list
	 */
	public void next() {
		current = (current != null) ? current.getLink() : current;
		
	}

	public void prev(){
		current = current.getPrev();
	}

	/**
	 * Return the element at the current node
	 * @return 			element stored at the current node
	 */
	public Type getCurrent() {
		return (current != null) ? current.getData() : null;
	}

	//Function to set current to head
	public void Reset(){
		current = head;
	}
	/**
	 * Adds the specified element to the end of the list.
	 * Not possible for a full list.
	 * @param 			element - element to add to the linked list
	 */
	public void add(Type element){
		//Don't add anything if the list is full
		if (!isFull()){
			//if the head list empty the new node becomes the head
			if(isEmpty()){
				head = new Node<Type>();
				head.setData(element);
				current = head;
				tail = head;

				//setting head pre links
				head.setPrev(tail);
				tail.setPrev(head);
			}
			//if the list is not empty, the new node is added to the end
			else{
				Node<Type> temp = new Node<Type>();

				temp.setPrev(tail);
				tail.setLink(temp);

				tail = temp;
				tail.setData(element);

				//here is where the CIRCULAR linking takes place
				tail.setLink(head);
				head.setPrev(tail);
			}
			//Increment the number of elements
			numElements++;
		}
		
	}
	/**
	 * Adds the specified element to the list at the given index
	 * Not possible for a full list
	 * @param			index - the position in the list to add the element
	 * @param			element - the element to be added to the list
	 */
	public void add(int index, Type element){
		//Don't do anything if full
		if(!isFull()){
			//if the list is empty add to the start of the list
			if(isEmpty()){
				head = new Node<Type>();
				head.setData(element);
				current = head;
				tail = head;

				//setting prelinks
				head.setPrev(tail);
				tail.setPrev(head);

				numElements++;
			}
			else{
				//first we check if we are adding to the begging of the lsit
				if(index == 0){
					//check if the list is empty
					if(isEmpty()){
						head = new Node<Type>();
						head.setData(element);
						current = head;
						tail = head;

						//setting prelinks
						head.setPrev(tail);
						tail.setPrev(head);

						numElements++;}

					//if we add at begging and list is not empty
					else{
						//creating new node
						Node<Type> nn = new Node<Type>();
						nn.setData(element);

						//assinging head to a dummy variable
						Node temp = head;
						temp.setLink(head.getLink());
						temp.setPrev(nn);

						//heads previous node will point to new node
						head.setPrev(nn);

						//temp node will point to tail as it will become the new head node
						nn.setPrev(tail);
						nn.setLink(head);


						head = nn;
						numElements++;
					}
				}
				//if we are adding at an index thats not 0
				if(index > 0 && index < size()){
					int IndexCount = 0;

					//new node that will added later
					Node<Type> nn = new Node<Type>();
					nn.setData(element);

					//Traverse list up to one node before desired index
					while(IndexCount < index-1){
						current = current.getLink();
						IndexCount++;
					}
					//node that is desired index + 1
					Node forwardNode = current.getLink();

					//adjusting node ahead of index we want to add to
					forwardNode.setPrev(nn);

					//setting links to our node to add
					nn.setLink(forwardNode);
					nn.setPrev(current);

					//adjusting current node (index-1)
					current.setLink(nn);

					//increment size
					numElements++;
				}

				//if we are adding to the end of the list
				if(index == size()){
					Node<Type> nn = new Node<Type>();
					nn.setData(element);

					//dummy variable to hold our tail node
					Node temp = tail;
					temp.setLink(nn);
					temp.setPrev(tail.getPrev());

					//adding in new node
					nn.setLink(head);
					nn.setPrev(temp);

					//adjusting tail as temp
					tail = nn;
					head.setPrev(tail);
					numElements++;

				}

			}
			
		}
	}

	/**
	 * Returns the value in the node at the given index
	 * @param 			index - the position in the list to get the element from
	 * @return 			the element at index
	 */
	public Type get(int index) {
		//Dont traverse the list if the index is out of bounds
		if(!(index < 0 || index >= numElements)){
			Node<Type> temp = head;
			int i = 0;

			//Traverse the list starting at the head until index is reached
			while (i < index){
				temp = temp.getLink();
				i++;
			}
			return temp.getData();
		}
		//in case of out of bound index
		else return null;
	}

	/**
	 * Returns the value in the head node
	 * @return 			the value in the head node
	 */
	public Type getFirst() {
		return (head != null) ? head.getData() : null;
	}

	/**
	 * Returns the value in the tail node
	 * @return 			the value in the tail node
	 */
	public Type getLast() {
		return (tail != null) ? tail.getData() : null;
	}

	/**
	 * Removes the element at the specified index.
	 * Not possible for an empty list
	 * @param			index - the position in the list of the element to be removed
	 */
	public void remove(int index) {
		Node current = head;
		int IndexCount = 0;
		boolean hasBeenRemoved = false;
		//Don't Do anything if its empty
		if(!isEmpty()){
			//out of bounds index (do nothing)
			if(index == MAX_SIZE || index == numElements || index < 0 || index > numElements){
				System.out.println("Out Of Bounds");
			}

			//If there is only one element to remove
			if(index == 0 && size() == 1){
				current=null;
				head=null;
				tail=null;
				numElements--;
			}

			//if there are exactly two elements
			if(size() == 2 && index < 2){
				//if we're remvoing the head node
				if(index == 0){
						head.setData(tail.getData());
						tail = head;
						current = head;

						tail.setPrev(head);
						tail.setLink(head);
						head.setPrev(tail);
						tail.setLink(head);
				}
				//if we're removing the tail ndoe
				if(index == 1){
					tail = head;
				}
				numElements--;
			}

			//index is 0 and size is more than 2
			if(index == 0 && size() > 2){
				if(size() == 3){
					head = tail.getPrev();
					head.setPrev(tail);
					tail.setLink(head);
					current = head;
				} 
				else if(size() > 3){
				Node temp = head.getLink();
				temp.setPrev(tail);
				head = temp;
				tail.setLink(head);
			
				current = head;
				}
				
			numElements--;

			}
			//if we are removing the tail node
			if(index == numElements-1 && size() > 2){
				//dummy node that will hold the node before the tail node
				Node temp = tail.getPrev();
				temp.setLink(head);
				head.setPrev(head);
				numElements--;
			}

			//if we are removing a node that is not the head or tail
			if(index > 0 && index < numElements){
				//Traverse list up to one node before desired index
				while(IndexCount < index-1){
					current = current.getLink();
					IndexCount++;
				}
				Node forwardNode = current.getLink().getLink();
				forwardNode.setPrev(current);
				current.setLink(forwardNode);
				numElements--;
			}

			

			
		}
	}

	/**
	 * Replaces the element at the specified index with the given element
	 * @param			index - the position in the list of the element to replace
	 * @param			element - the element to replace the current element at index
	 */
	public void set(int index, Type element) {
		// set counter for index
		int IndexCount = 0;
		Node current = head;
		//Do do anything is list is full
		if(!isFull()){
			while(IndexCount < index){
				current = current.getLink();
				IndexCount++;
			}
			current.setData(element);
		}
	}

	/**
	 * Returns the index of the first occurrence of the specified element.
	 * Returns -1 if the list does not contain the element.
	 * @param			element - the element whose index is being searched for
	 * @return 			the index of element, or -1 if it doesn't exist
	 */
	public int indexOf(Type element) {
		//set counter for index
		int IndexCount = 0;
		Node current = head;
		//Don't do anything if empty
		if(!isEmpty()){
			while(IndexCount < 10){
				if(current.getData() == element){
					return IndexCount;

				}
				else{
				current = current.getLink();
				IndexCount++;
				}
			}
		}
		//return -1 if not found
		return -1;
	}


}