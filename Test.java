/*
Name:		Noah Jones
Date:		1/7/2022
Course:		CSC 220 - Data Structures
*/

import java.util.Scanner;

public class Test {
	//variables to hold scanner obj to make test more readable
	static Scanner sc = new Scanner (System.in);
	public static void main(String[] args) {
		NEXT();
		testNode();
		/*NEXT();
		testAdd();
		NEXT();
		testAddAdd();
		NEXT();
		testIteration();
		NEXT();
		ReverseIterationTest();		
		NEXT();
		testRemove();
		NEXT();
		testRemoveContinued();
		NEXT();
		testRemoveFinal();
		NEXT();
		testCopy();*/
	}
	public static void HEADER(){
		String str = "#";
		System.out.println("\n###Noah Jones Circular Doubley Linked List###\n");
		System.out.println(str.repeat(30));
	}
	public static void NEXT(){
		//Menu
		HEADER();
		System.out.print("Press Enter for next Test:");
		String enter = sc.nextLine();	
	}
	//Method to cleany print out list to save me time on typing out System.out.println
	public static void CleanPrint(LinkedList<Integer> Llist){
		System.out.println("[ " + Llist + "]\n");
	}
	//Test the index add method
	public static void testAddAdd(){
		System.out.println("\n###TEST ADD FUNCTION WITH INDEX VALUE###");
		LinkedList<Integer> l = new LinkedList<Integer>();
		System.out.println("First We Again Print Out The Empty List");
		CleanPrint(l);
		System.out.println("Next We Will Add A Value At Index 0 By Passing It The Index");
		l.add(0, 8);
		CleanPrint(l);
		System.out.println("We Will Now Add Some Simple Values Using a for Loop With The Indicies");
		for(int i=1; i<6; i++){
			l.add(i, i*13);
		}
		CleanPrint(l);
		System.out.println("For Our Next Trick We will Add A Value Between Two indicies (99 Between Indicies 2 & 4)");
		l.add(3, 99);
		CleanPrint(l);
		System.out.println("Finally We will enter another for loop adding values to the last location on each iteration until we hit the end");
		for(int i=7; i<15; i++){
			l.add(i, i);
		}
		CleanPrint(l);
	}
	//Test Remove Function
	public static void testRemove(){
		System.out.println("###TESTING THE REMOVE OPERATION###");
		LinkedList<Integer> l = new LinkedList<Integer>();
		System.out.println("For The First Test We Will Remove One Element From A List With Only One Element");
		l.add(220);
		CleanPrint(l);
		l.remove(0);
		CleanPrint(l);
		System.out.println("Next We Will Remove An Element From A List With More Than One Element");
		l.add(789); l.add(56); l.add(99); l.add(88); l.add(22);
		CleanPrint(l);
		System.out.println("Removing Index 2 (99)");
		l.remove(2);
		CleanPrint(l);
		System.out.println("Next To Show That the Under The Hood Stuff Is Working I will Iterate Through the List");
		System.out.println("FORWARD ITERAION");
		for(int i=1; i<((2*l.size())+1); i++){
			System.out.println("Iteration #"+i+": Current Value is " + l.getCurrent());
			l.next();
		}
		System.out.println();
		System.out.println("REVERSE ITERATION");
		for(int i=1; i<((2*l.size())+1); i++){
			System.out.println("Iteration #"+i+": Current Value is " + l.getCurrent());
			l.prev();
		}
	}
	//Continuation of Test Remove to make the program more readable
	public static void testRemoveContinued(){
		System.out.println("###CONTINUATION OF TEST REMOVE OPERATION");
		LinkedList<Integer> l = new LinkedList<Integer>();
		System.out.println("Now We Will See What Happens When We Keep Trying to Remove Elements When The List Is Empty");
		l.add(0); l.add(4); l.add(88); l.add(5); l.add(90);
		CleanPrint(l);
		for(int i=0; i<10; i++){
			l.remove(0);
			CleanPrint(l);
		}
	}
	public static void testRemoveFinal(){
		int index;
		Scanner input = new Scanner (System.in);
		LinkedList<Integer> l = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		for(int i=0; i<10; i++){l.add(i*4+5-2);}
		for(int i=0; i<10; i++){l2.add(2+i*4-1);}
		System.out.println("For the Final Remove Demonstration I Need A Volunteer (You)");
		System.out.println("If I Did Not Go Over A Case You Were Curious About You Now Get To Try It Out for Yourself");
		System.out.println("YOU WILL HAVE 2 LIST TO PLAY WITH");
		System.out.println("FOR THIS FIRST LIST YOU WILL BE ABLE TO REMOVE INDICIES UNTIL THE LIST IS EMPTY");
		while(l.size() > 0){
			CleanPrint(l);
			System.out.print("Enter an index to remove:");
			index=sc.nextInt();
			l.remove(index);
		}
		System.out.println("Here Is One More List For You To Play With");
		System.out.println("FOR THIS LIST YOU WILL HAVE A CERTAIN AMOUNT OF REMOVE OPERATIONS AVAILABLE");
		System.out.println("ONCE YOU RUN OUT OF OPERATIONS THE PROGRAM WILL GO TO THE NEXT TEST");
		for(int j=15; j>0; j--){
			CleanPrint(l2);
			System.out.println("Operations Remaining: "+ j);
			System.out.print("Enter an index to remove: ");
			index=sc.nextInt();
			l2.remove(index);
		}
	}
	//Test set function
	public static void testSet(){
		System.out.println("Testing our set method");
		LinkedList<Integer> l = new LinkedList<Integer>();
		for(int i=34; i<42; i++){
			l.add(i);
		}
		System.out.println(l);
		l.set(3, 777);
		System.out.println("After set method\n" + l);
	}
	//Test copy
	public static void testCopy(){
		System.out.println("Testing the copy constructor:\n");
		LinkedList<Integer> l = new LinkedList<Integer>();
		for(int i = 0; i < 20; i++){
			l.add(i * 2);
		}
		System.out.println("##ORIGINAL LIST##");
		CleanPrint(l);
		System.out.println();
		LinkedList<Integer> NewList = new LinkedList<Integer>(l);
		System.out.println("Our copied List:");
		CleanPrint(NewList);
		NewList.remove(0); NewList.remove(4); NewList.remove(3);
		CleanPrint(NewList);
	}
	// Demonstrate how to access node data, link nodes together, and 
	// traverse a series of linked nodes
	public static void testNode() {
		System.out.println("###NODE TEST###");

		//create some nodes
		Node<String> n1 = new Node<String>();
		Node<String> n2 = new Node<String>();
		Node<String> n3 = new Node<String>();
		Node<String> n4 = new Node<String>();

		// Put some data into the nodes
		n1.setData("java");
		n2.setData("python");
		n3.setData("kotlin");
		n4.setData("R");


		// Acess data stored in a node
		System.out.println("Node 1 contains " + n1.getData());
		System.out.println("Node 2 contains " + n2.getData());
		System.out.println("Node 3 contains " + n3.getData());
		System.out.println("Node 4 contains " + n4.getData());
		System.out.println("Nodes Are Stored In their Respective numerical order");
		System.out.println("That Includes Circularly & Doubley Linked");

		//setting appropriate links
		n1.setLink(n2); //Node 1 now knows the location of the data of Node 2
		n1.setPrev(n4); //Node 1 also knows the location of the data of Node 4
		n2.setLink(n3);
		n2.setPrev(n1);
		n3.setLink(n4);
		n3.setPrev(n2);
		n4.setLink(n1);
		n4.setPrev(n3);

		//setting current node to be used in demosntration(s)
		Node<String> current = n1;

		System.out.println();
		System.out.println("Node in front of node 1 contains "+current.getLink().getData());
		System.out.println("Node behind Node 1 contains " + current.getPrev().getData());
		// Start at n1 and print all data values stored in the nodes
		//Node<String> currentNode = n1;	//shallow copy
		//for (int i = 1; i <= 4; i++){
		//	System.out.println("Node " + i + " contains " + currentNode.getData());
		//	currentNode = currentNode.getLink();
		//}
		System.out.println();
	}
	public static void testAdd() {
		System.out.println("###ADD SECTION###");
		LinkedList<Integer> l = new LinkedList<Integer>();
		System.out.println("First we see what happens when we print out an empty list");

		//Test printing an empty list
		CleanPrint(l);

		//Test adding a single element to the list
		System.out.println("Now we Test adding a single integer (777) my favorite number");
		l.add(777);
		CleanPrint(l);

		System.out.println("Now we will run a for loop to fill in the rest of the indicies");

		//Test that the method wont add more when full
		for(int i=0; i<10; i++){
			l.add(i*8);
		}
		CleanPrint(l);
		System.out.println("Finally for the basic Add method we will try to add one more number to an alreay full list (343)");
		l.add(343);
		CleanPrint(l);
	}
	public static void testIteration() {
		System.out.println("###FORWARD ITERATION TEST###");
		System.out.println("For This Test I Will Show that my list can be traversed more than once");
		LinkedList<Integer> l = new LinkedList<Integer>();
		//add some values to the list
		for(int i=0; i<10; i++){
			l.add(i*4);
		}
		CleanPrint(l);
		System.out.println("Forward Traversal:");
		for(int i = 1; i < ((2*l.size())+1); i++){
			System.out.println("Iteration #"+i+": Current Value is " + l.getCurrent());
			l.next();
		}
	}
	public static void ReverseIterationTest(){
		System.out.println("###REVERSE ITERATION TEST###");
		System.out.println("For This Test I Will Show that my list can be traversed in reverse more than once");
		System.out.println("This Is Done By Setting The Current node to the Current Nodes previous linked node");
		LinkedList<Integer> l = new LinkedList<Integer>();
		//add some values to the list
		for(int i=0; i<10; i++){
			l.add(i*6+2);
		}
		CleanPrint(l);
		System.out.println("Reverse Traversal:");
		for(int i = 1; i < ((2*l.size())-4); i++){
			System.out.println("Iteration #"+i+": Current Value is " + l.getCurrent());
			l.prev();
		}
		System.out.println("For The Next Demonstration I Will Show That My Linked List Can Transerve A List That Is Not Full");
		LinkedList<Integer> f = new LinkedList<Integer>();
		f.add(777); f.add(710); f.add(1001); f.add(45); f.add(556);
		CleanPrint(f);
		for(int i=1; i<(2*f.size()+3); i++){
			System.out.println("Iteration #"+i+": Current Value is " + f.getCurrent());
			f.prev();
		}
	}
}