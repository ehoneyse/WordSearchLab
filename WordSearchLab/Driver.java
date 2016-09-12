public class Driver
{
    public static void main(String[] args) {

	WordSearch ws = new WordSearch();

	//working horizontal words
	System.out.println(ws.addWordH(0, 0, "hello"));
	System.out.println(ws.addWordH(2, 4, "batman"));
	System.out.println(ws.addWordH(5, 1, "apple"));

	//Horizontal index error checking
	System.out.println(ws.addWordH(-2, 4, "joker"));
	System.out.println(ws.addWordH(10, 4, "unicorn"));	
	System.out.println(ws.addWordH(3, -1, "cowboys"));
	System.out.println(ws.addWordH(5, 8, "dogs"));

	//horizontal collision checking
	ws.addWordH(5, 3, "plow");
	ws.addWordH(2, 0, "neato");
	
	//working vertical words
	//ws.addWordV(1, 0, "nice");
	//ws.addWordV(4, 9, "yankee");
	//ws.addWordV(4, 4, "old");
	
	//Verical index error checking
	//ws.addWordV(-2, 4, "joker");
	//ws.addWordV(7, 4, "unicorn");	
	//ws.addWordV(3, -1, "cowboys");
	//ws.addWordV(5, 20, "dogs");
	
	//vertical collision checking
	//ws.addWordV(0, 4, "ores");
	//ws.addWordV(4, 9, "goober");
       
	//working diagonal words
	//ws.addWordD(7, 0,  "cat");
	//ws.addWordD(0, 0, "home");
	//ws.addWordD(0, 3, "loam");
	
	//Diagonal index error checking
	//ws.addWordD(-2, 0,  "cat");
	//ws.addWordD(3, -1,  "whelm");
	//ws.addWordD(7, 7,  "after");	

	//Diagonal collision checking
	//ws.addWordD(0, 4, "ores");
	//ws.addWordD(4, 4, "oats");

	System.out.println(ws);
	
	ws.fillGrid();
	System.out.println(ws);

	/*
	UNCOMMENT THIS TO TEST ADDWORDS

	ws = new WordSearch(15, 15);
	ws.loadDictionary();
	ws.addWords(10);
	System.out.println(ws);
	ws.fillGrid();
	System.out.println(ws);
	*/
    }

}