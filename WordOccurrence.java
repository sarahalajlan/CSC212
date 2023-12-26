
public class WordOccurrence {

	int lineNo;
	int position;
	
	
	public WordOccurrence() {
		
		lineNo = 0;
		position = 0;
		
	}

	public WordOccurrence(int lineNo , int position) {
		
		this.lineNo = lineNo;
		this.position = position;
		
	}

	
	public String toString() {
		return "WordOccurrence [lineNo=" + lineNo + ", position=" + position + "]";
	}
	
	
}
