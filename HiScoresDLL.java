
/*
*This class utalizes a doubly linked list to achieve 3 different things: display all
*of the items in your list, add a GameEntry to the proper position, and remove
*a GameEntry object from a certain position.
*/

public class HiScoresDLL
{
	
	private DNode header;
	
	private DNode trailer; 
	
	private int size; 
		
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	*Constructor that creates an empty list 
	*/ 
	
	public HiScoresDLL()
	{
		size = 0; 		//intializes the size to be zero
		
		header = new DNode (null, null, null);		//initializes the header so that it doesn't point to anything previously or next, it also has no entry

		trailer = new DNode (header, null, null);		//initializes the trailer so that it points previously to the header but it has null as an entry and also it is
											//pointing to nothing next
		
		header.next = trailer; 			//have the header next point to the trailer
		
	}
	

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	*Prints out all the game entries in the linkied list
	*/ 
	
	public void display() 
	{
		DNode cur = header.next; 		//start at the node after the header
		
		while (cur.entry != null)		//while it is not at the tail
		{
			
			System.out.println (cur.entry);		//print out the game entry in the node
			
			cur= cur.next;		//move onto the next node
		
		}
		
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/** 
	*Assuming the list of game entries is in decreasing order by score, this method creates 
	*a Node with the given GameEntry e, and then inserts it in the appropriate spot
	*in the list. 
	*@param e 
	* the GameEntry object to be added to the list
	*/ 
	
	public void add(GameEntry e)
	{
		
		DNode v = new DNode (null,e,null); 		//create a new node with the gameEntry which waas just passed through
		
		DNode cur= header.next;		//set the cur to the next node after the headerr
		
		while (cur.entry != null && cur.entry.getScore() > e.getScore())	//while cur is not at the tail and while the node we are currently at has a higher score than the node we are trying to insert
		{
			
			cur = cur.next; 		//move cur onto the next node
			
		}
		
		v.prev = cur.prev;  	 //insert this new node to where it belongs by connecting all four connections
		
		v.next = cur; 
		
		cur.prev.next = v; 
		
		cur.prev = v; 
		
		size ++; 		//increase the size by one
	}
	

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	*Removes the node at position i in the list 
	*(emulating an array index)
	*@return 
	*the GameEntry of the removed node
	*or the null if position i is invalid
	*/
	
	
	public GameEntry remove(int i)
	{
		if (size == 0)		//if the size of the list is zero
		{
			return null;	//return null
			
		}
		
		int mid = size/2; 	//find the middle of the list
		
		int count; 		//declare the count
		
		DNode cur; 	//declare a variable called cur 
		
		if ( i < mid)	//if the node we are trying to remove is in the top half of the list 
		{
			cur= header.next;	//have cur be the next one after the header
			
			count = 0; 		//initilize the count to be zero
			
			while (cur.entry != null && count<i)		//while cur is not the tail and the node we are currently on is not the one we are trying to remove 
											//(count indicated the index it would have if this was an array)
			{
			
				cur = cur.next; 		//move cur onto the next node
			
				count = count +1; 	//increment the count 
			
			}
			
		}
		
		else 
		{
			
			cur = trailer.prev; 		//set the cur to be the one before the trailer
			
			count = size-1; 			//have the size be the size of the list minus one (indices start at 0)
			
			while (cur != null && count>i)			//while cur is not the tail and node we are currently on is not the one we are trying to remove 
											//(count indicated the index it would have if this was an array)
			{
			
				cur = cur.prev; 		//set cur to be the one before the node it is currently equal to 
			
				count = count -1; 	//decrement count by one
			
			}
		
		}
			
		
		DNode removed = cur; 		//save the node we are removing to a variable so we can return it later
		
		cur.prev.next = cur.next; 		//cut the connections the node we are trying to remove has by attaching the node previous to cur 
								//to the node after cur and setting the connections of cur to null 
		
		cur.next.prev = cur.prev; 
		
		cur.next = null; 
		
		cur.prev = null; 
		
		size --; 		//decrement the size by one
		
		return removed.entry; 		//return the removed node's entry
		
	}
		
		
}
