/*
* Class definition for a Node of a singly linked list of Game Entries. 
 */
 
public class DNode 
{

	/* Note: these fields are public so that they can be directly accessed
	 * from outside this class.  For example, if v is a Node object, 
	 * then v.entry and v.next can be used to access these fields. */
	
	 
	public GameEntry entry;	//the high score entry 
	
	public DNode next;		//refers to the next node in the list
	
	public DNode prev; 		//refers to the previous node in the list

	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/** 
	 * Constructor: creates a node with the given entry and next Node. 
	 */
	
	public DNode(DNode p, GameEntry e, DNode n) 
	{
		entry = e;
		
		next = n;
		
		prev = p;	
		
		
	}
	
}
