
public class WordInformation {
	
	public String word;
    public LinkedList<WordOccurrence> occList;
    public int size; 
    
    
    public WordInformation(){
        word = "";
        occList = new LinkedList<> ();
        size = 0;}

    public WordInformation(String word, int Line, int Position){
        this.word = word;
        occList = new LinkedList<> ();
        occList.insert(new WordOccurrence(Line, Position ));
        size = 1;
    }
        
    public void AddNewOccurrence(int Line, int Position)    
    {
        occList.insert(new WordOccurrence(Line, Position ));
        size++;
        
    }
        
    public String toString() {
        
        String str =  "Word{ " +  word + ", No. Occurrence= " + size + ", length= " + word.length() + ", locations= " ;
        occList.findFirst();
        while (!occList.last())
        {
            str = str + occList.retrieve().toString();
            occList.findNext();
        }
        str = str + occList.retrieve().toString();
        return str;
    }
        
       

}
