import java.io.*;

public class WordAnalysis_ADT {
	
   int n; int m ; int k ;
   LinkedList<WordInformation> [] arrayOfDifferentLengths ;
   WordInformation [] sortedArray;
	    
   public WordAnalysis_ADT() {
	   
	   
	   
   }
	    
   public WordAnalysis_ADT(String filename ){ 
	    	
	countk(filename);
	arrayOfDifferentLengths =  new LinkedList [k];
	readFileAndAnalyse(filename);}

	  
   public void countk(String filename){
	    	
	 k = 0;
	 try{
		 
    BufferedReader reader = new BufferedReader(new FileReader(filename));
	String line = reader.readLine();
	while (line != null){
		                
    String [] str = line.split("[;, . ]");  
    for (int i = 0; i < str.length; i++) 
	  if (k < str[i].trim().length())
        k = str[i].trim().length();
		     line = reader.readLine();}
       k++;
     reader.close();
     
	 }catch (Exception e){System.out.println(e.getMessage());}
}
	    
	public void readFileAndAnalyse (String f){
	    	
	  String AllLines = "" ;
		      
	try{
      BufferedReader reader = new BufferedReader(new FileReader(f));
	  String line = reader.readLine();
	  while (line != null){
		                
		while (line.contains("\\n")){
		line = line.replace("\\n" ,  System.lineSeparator());}
		  
		 line = line.replace("”", " ");
         line = line.replace("!", " ");
         line = line.replace("“", " ");
         line = line.replace("?", " ");
         line = line.replace("\"", " ");
		      
		              
		System.out.println(line);
		AllLines += line + System.lineSeparator() ; 
		line = reader.readLine();}
		           
	   reader.close();
		            
}catch (Exception e){System.out.println(e.getMessage());}
		         
	    	
	    	
	    	
	for ( int i = 0 ; i< arrayOfDifferentLengths.length ; i ++)
	 arrayOfDifferentLengths[i] = new LinkedList<WordInformation> ();

	n =0; m =0;
	        
	String[] lines = AllLines.split(System.lineSeparator());
	String str[] = null;
	int LineNum = 0 ;        
	       
	while (LineNum < lines.length){
	 
    int position =0;
	str = lines[LineNum].split("[;, . ]");   
	                
	for (int i = 0; i < str.length; i++){
	               
	String word = str[i].trim();
	                 
	if (word.equalsIgnoreCase("") != true){
	 position++; 
	 n++; 
	 
	 boolean flag = false;
	                    
  if (arrayOfDifferentLengths[word.length()].empty())
  arrayOfDifferentLengths[word.length()].insert(new WordInformation (word , LineNum+1, position));

  else{

  arrayOfDifferentLengths[word.length()].findFirst();
	                        
  while (! arrayOfDifferentLengths[word.length()].last() && ! flag){
	 
   WordInformation data = arrayOfDifferentLengths[word.length()].retrieve();
   
   if (data.word.equalsIgnoreCase(word) == true){
	                                
	data.AddNewOccurrence(LineNum+1, position);
	arrayOfDifferentLengths[word.length()].update(data);
	flag = true;}
	    
   else
   arrayOfDifferentLengths[word.length()].findNext(); }
	                        
   if (!flag){
   
    WordInformation data = arrayOfDifferentLengths[word.length()].retrieve();
   
    if (data.word.equalsIgnoreCase(word) == true){
	  
       data.AddNewOccurrence(LineNum+1, position);
	   arrayOfDifferentLengths[word.length()].update(data);
	   flag = true;}}

	
    if (!flag )
	arrayOfDifferentLengths[word.length()].insert(new WordInformation (word , LineNum+1, position));
}
	                    
	if (!flag ){ 
	
		m++;}
	    }

         }
	LineNum++;
	
}
	sortedArray = new WordInformation [m];
	 
	sortarray();}



public void sortarray() {
	
    int j = 0 ;
    for ( int i = 0 ;  i < arrayOfDifferentLengths.length ; i++)
    {   if (! arrayOfDifferentLengths[i].empty())
        {
            arrayOfDifferentLengths[i].findFirst();
            while ( ! arrayOfDifferentLengths[i].last())
            {
                sortedArray[j++] = arrayOfDifferentLengths[i].retrieve();
                arrayOfDifferentLengths[i].findNext();
            }
                sortedArray[j++] = arrayOfDifferentLengths[i].retrieve();
       }
    }
    mergesort ( 0, m-1);
}
	    
	public int documentLength(){ return n;}
	    
	    
	public int uniqueWords(){return m;}
	    
	    
	public int totalWord (String s){
	        
	int t = 0;
	
	if ( arrayOfDifferentLengths[s.length()].size() > 0){   
	            
		arrayOfDifferentLengths[s.length()].findFirst();
	            
    while (!arrayOfDifferentLengths[s.length()].last()){
	     
     if ( arrayOfDifferentLengths[s.length()].retrieve().word.equalsIgnoreCase(s)== true)
	    t = arrayOfDifferentLengths[s.length()].retrieve().size;
	        
    	 arrayOfDifferentLengths[s.length()].findNext();}
	            
      if ( arrayOfDifferentLengths[s.length()].retrieve().word.equalsIgnoreCase(s)== true)
	      t = arrayOfDifferentLengths[s.length()].retrieve().size;}
	        
	return t;}
	    
	   
    public int totalWordsForLength(int l){
	    	
    int t = 0;
	    	
	if (  l <=  0 || l >= arrayOfDifferentLengths.length )
	  return t;
	        
	t = arrayOfDifferentLengths[l].size();
	  return t;}
	    
	    
	public void displayUniqueWords(){
	        
	for ( int i = 0 ; i <m ;  i++)
	  System.out.println("(" + sortedArray[i].word + " , " + sortedArray[i].size + ")");}    
	    
	    
	public  LinkedList<WordOccurrence> occurrences(String w){
	        
	 LinkedList<WordOccurrence> l = null;
	        
    if ( arrayOfDifferentLengths[w.length()].size() > 0){   
	       
     arrayOfDifferentLengths[w.length()].findFirst();
	        
     while (! arrayOfDifferentLengths[w.length()].last()){
	  
      if ( arrayOfDifferentLengths[w.length()].retrieve().word.equalsIgnoreCase(w)== true)
	    l = arrayOfDifferentLengths[w.length()].retrieve().occList;
	                
	  arrayOfDifferentLengths[w.length()].findNext();}
	            
      if ( arrayOfDifferentLengths[w.length()].retrieve().word.equalsIgnoreCase(w)== true)
	     l = arrayOfDifferentLengths[w.length()].retrieve().occList;}
	        
	return l;}

	   
	 
	public boolean checkAdjacent(String w1, String w2){
		   
	    boolean res = false;
				   
	    if((arrayOfDifferentLengths[ w1.length() ].size() == 0)||(arrayOfDifferentLengths[ w2.length() ].size() == 0))
			return res;
	      
	       if (w1.equalsIgnoreCase(w2))
	            {
	               LinkedList<WordOccurrence> w = occurrences(w1);     
	               if (w!= null  && !w.empty() )
	               {
	                   if (w.size() > 1)
	                   {
	                        w.findFirst();
	                        WordOccurrence Posw1 = w.retrieve();
	                        for ( int i = 1; i < w.size() ; i++)
	                        {
	                            w.findNext();
	                            WordOccurrence Posw2 = w.retrieve();
	                             if ( Posw1.lineNo == Posw2.lineNo && (Math.abs(Posw2.position - Posw1.position) == 1 ))
	                                 res = true;
	                              Posw1=Posw2;   
	                        }
	                   }
	               }
	                return res;
	            }
	 
	     LinkedList<WordOccurrence> Word1 = occurrences(w1);
	     LinkedList<WordOccurrence> Word2 = occurrences(w2);
				           
		if( Word1 != null && Word2 != null ){
			Word1.findFirst();
			Word2.findFirst();
				                      
		while(!Word1.last() && !Word2.last()){
				                       
			int linew1 = Word1.retrieve().lineNo;
			int linew2 = Word2.retrieve().lineNo;
				                       
		if(linew1 == linew2){
		
			int Posw1 = Word1.retrieve().position;
			int Posw2 = Word2.retrieve().position;
				                         
		  if(Math.abs(Posw2 - Posw1) == 1)
			res = true; 
		
		 else 
		   if(Math.abs(Posw2 - Posw1) > 1)
			
			Word1.findNext();
	       
		 else
			Word2.findNext();}
				                       
		else 
		  if(linew1 > linew2){
		   
		   Word2.findNext();}
				                       
		  else{
			Word1.findNext();}
	}
				               
				               
	while(Word1.last() && !Word2.last()){
		
		 int linew1 = Word1.retrieve().lineNo;
		 int linew2 = Word2.retrieve().lineNo;
				                       
				                       
		if(linew1 == linew2 ){
		  
			int Posw1 = Word1.retrieve().position;
	        int Posw2 = Word2.retrieve().position;
				                           
		if(Math.abs(Posw2 - Posw1) == 1)
			res = true;}
				                      
		 Word2.findNext();}
				               
		while(!Word1.last() && Word2.last()){
				                       
			int linew1 = Word1.retrieve().lineNo;
		    int linew2 = Word2.retrieve().lineNo;
				                       
				                       
		if(linew1 == linew2){
				                           
		   int Posw1 = Word1.retrieve().position;
		   int Posw2 = Word2.retrieve().position;
	    
		if (Math.abs(Posw2 - Posw1) == 1)
		    res = true;}
				                       
		Word1.findNext();}

				               
		if(Word1.last() && Word2.last()){
				                   
			int linew1 = Word1.retrieve().lineNo;
			int linew2 = Word2.retrieve().lineNo;
				                   
				                   
	    if(linew1 == linew2){
				                       
	    	int Posw1 = Word1.retrieve().position;
		    int Posw2 = Word2.retrieve().position;
				                       
				                       
		    if(Math.abs(Posw2 - Posw1) == 1)
			   res = true;}
			}
		} 
			return res;            
	}
	 

    public void mergesort ( int l , int r ) {
	        
    if ( l >= r )
	  return;
	int m = ( l + r ) / 2;
	mergesort (l , m );          
	mergesort (m + 1 , r );    
	merge (l , m , r ); }

	public void merge ( int l , int m , int r ){
		
	WordInformation [] B = new WordInformation [ r - l + 1];
	  int i = l , j = m + 1 , k = 0;
	    
	        
	  while ( i <= m && j <= r ){
	   if ( sortedArray[ i ].size >= sortedArray [ j ].size)
	    B [ k ++] = sortedArray[ i ++];
       else
	   B [ k ++] = sortedArray[ j ++]; }
	        
	        
	  if ( i > m )
	   while ( j <= r )
	     B [ k ++] = sortedArray[j++];
	      else
	   while ( i <= m )
	     B [ k ++] = sortedArray[i++];
	        
	    for ( k = 0; k < B.length ; k++)
	      sortedArray[k+l] = B [k];}
}

