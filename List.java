
public interface List<T> {
	
	 public void findFirst( );
	    
	    public void findNext( );
	    
	    public T retrieve( );
	    
	    public void update(T e);
	    
	    public void insert(T e);
	    
	    public void remove( );
	        
	    public boolean last( );
	 
	    public boolean full( );
	    
	    public boolean empty( );
	

}
