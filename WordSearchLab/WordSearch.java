import java.io.*;
import java.util.*;

public class WordSearch {

    // A random number generator for us to use
    Random r = new Random();

    //This default size should be kept, it will make
    //all the error checking in main work out.
    private final int SIZE = 10;

    //grid containing all the charaters
    private char[][] grid;

    //ArrayList of words that have been added to the grid
    private ArrayList<String> words;

    /*
    ArrayList containing an entire dictionary of words
    only needed for the AddWords method
    can be populated using the loadDictionary method
     */
    private ArrayList<String> dictionary;

    /*======== public WordSearch()) ==========
    Inputs:   
    Returns: 

    Initializes the grid to be SIZE x SIZE
    Sets every character to a default value of 
    your choosing (like '-').

    Initializes words as an empty ArrayList<String>
    Initializes dictionary as an empty ArrayList<String>
    ====================*/
    public WordSearch() 
    {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                grid[i][j] = '-';
            }
        }
        //loadDictionary();
    }

    /*======== public WordSearch() ==========
    Inputs:  int rows
    int cols 
    Returns: 

    Initializes the grid to be rows x cols
    Sets every character to a default value of 
    your choosing (like '-').

    Initializes words as an empty ArrayList<String>
    Initializes dictionary as an empty ArrayList<String>
    ====================*/
    public WordSearch(int rows, int cols) 
    {
        grid = new char[rows][cols];
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                grid[i][j] = '-';
            }
        }
        //loadDictionary();
    }

    /*======== public String toString()) ==========
    Inputs:   
    Returns: A string representation of the letter grid 

    The string should display the letter grid and then the list
    of the words in the grid underneath.
    ====================*/
    public String toString() {
        String ourGrid = "";
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                ourGrid += (grid[i][j] + " ");
            }
            ourGrid += "\n";
        }
        return ourGrid; 
    }

    private boolean fillGridH(int r, int c, String s)
    {
        int wordLength = s.length();
        int counterVerify = 0;

        if ( r < 0 || r > grid[0].length || c < 0 || c > grid[0].length || grid[0].length - c < s.length())
        {
            return false;
        }
        
        for (int i = 0; i < wordLength; i++)
        {
            if (r+i < grid[0].length && c+i< grid[0].length)
            {
                if (grid[r][c+i] == '-' || grid[r][c+i] == s.charAt(i))
                {
                    grid[r][c+i] = s.charAt(i);
                    counterVerify++;
                }
                else
                {
                    return false ;
                }
            }
        }

        if (counterVerify == wordLength)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    /*======== public boolean addWordH() ==========
    Inputs:  int r
    int c
    String s 
    Returns: boolean as to whether the method completed

    Attempts to add String s to the grid, horizontally, 
    starting at row r and column c.

    If the String was added, true is returned.

    The String cannot be added, and false is returned, if:
    The starting indecies are out of bounds
    The String cannot fit in the grid with the given
    starting coordinates.
    The String replacing an existing character on the
    grid (aside from the default character) with a 
    different letter.
    ====================*/
    public boolean addWordH(int r, int c, String s) 
    {
        boolean doFill = fillGridH(r,c,s);

        if (doFill)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean fillGridV(int r, int c, String s)
    {
        int wordLength = s.length();
        int counterVerify = 0;
        for (int i = 0; i < wordLength; i++)
        {
            grid[r+i][c] = s.charAt(i);
            counterVerify++;
        }

        if (counterVerify == wordLength)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    /*======== public boolean addWordV() ==========
    Inputs:  int r
    int c
    String s 
    Returns: boolean as to whether the method completed

    Attempts to add String s to the grid, Vertically, 
    starting at row r and column c.

    If the String was added, true is returned.

    The String cannot be added, and false is returned, if:
    The starting indecies are out of bounds
    The String cannot fit in the grid with the given
    starting coordinates.
    The String replacing an existing character on the
    grid (aside from the default character) with a 
    different letter.
    ====================*/
    public boolean addWordV(int r, int c, String s) 
    {
        boolean doFill = fillGridV(r,c,s);

        if (doFill)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private boolean fillGridD(int r, int c, String s)
    {
        int wordLength = s.length();
        int counterVerify = 0;
        for (int i = 0; i < wordLength; i++)
        {
            grid[r+i][c+i] = s.charAt(i);
            counterVerify++;
        }

        if (counterVerify == wordLength)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }

    /*======== public boolean addWordD() ==========
    Inputs:  int r
    int c
    String s 
    Returns: boolean as to whether the method completed

    Attempts to add String s to the grid, Diagonally, 
    starting at row r and column c.

    If the String was added, true is returned.

    The String cannot be added, and false is returned, if:
    The starting indecies are out of bounds
    The String cannot fit in the grid with the given
    starting coordinates.
    The String replacing an existing character on the
    grid (aside from the default character) with a 
    different letter.
    ====================*/
    public boolean addWordD(int r, int c, String s) 
    {
        boolean doFill = fillGridD(r,c,s);

        if (doFill)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private char randomLetter()
    {
        char l = (char) ( (int)'a' + r.nextInt(26));
        return l;
    }

    /*======== public void fillGrid()) ==========
    Inputs:   
    Returns: 

    Goes through the grid and fills every non-letter space 
    with a random letter.
    ====================*/
    public void fillGrid() 
    {
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                if (grid[i][j] == '-')
                {
                    grid[i][j] = randomLetter();
                }
            }
        }
    }

    private String randomWord()
    {
        int randomNum = r.nextInt(dictionary.size()+1);
        return dictionary.get(randomNum);
    }

    /*======== public String getWordFromDictionary()) ==========
    Inputs:   
    Returns: A random string from the dictionary ArrayList

    The dictionary ArrayList will contain a large number
    of words. You must call loadDictionary() in order to use it.
    If you look in the main method, loadDictionary is already
    called for you.

    You must have downloaded wordlist.txt and put it in
    the same directory as this java file.
    ====================*/
    public String getWordFromDictionary() 
    {
        String word = randomWord();
        return word;
    }

    private boolean placeOrientation(int n1, int n2, int n3, String s)
    {
        if (n1 == 0)
        {
            boolean wordAdded = addWordH(n2,n3,s);
            return wordAdded;
        }
        else if (n1 == 1)
        {
            boolean wordAdded = addWordH(n2,n3,s);
            return wordAdded;
        }
        else
        {
            boolean wordAdded = addWordH(n2,n3,s);
            return wordAdded;
        }

    }

    /*======== public void addWords() ==========
    Inputs:   int numWords  
    Returns: 

    This method should add numWords random words into
    the grid. Use the following algorithm:

    For each word to be added:
    1. Get a random word (see above method)
    2. Make a random int in the range [0, 2]
    3. Make a random int in the range [0, grid.lenght]
    4. Make a random int in the range [0, grid[0].length]
    5. Add the word to the random coordinates from steps
    3 and 4. Use the first random number to determine
    orientation (horizontal, vertical, diagonal)
    6. If the word was added successfully to the grid, add it to the words ArrayList
    You can assume that this method is always used with a
    reasonable value for numWords (i.e. You wouldn't try to
    put 100 words into a 5x8 grid...)

    ====================*/
    public void addWords( int numWords ) 
    {
        String randomWord = randomWord();
        int numberOne = r.nextInt(3);
        int numberTwo = r.nextInt(grid.length+1);
        int numberThree = r.nextInt(grid[0].length+1);
        boolean isDone = placeOrientation(numberOne,numberTwo,numberThree,randomWord);
        if (isDone)
        {
            words.add(randomWord);
        }
    }

    /*======== public static void main() ==========
    This main function performs multiple calls to the addWord
    methods to ensure that they work correctly.

    If your functions are correct, the output should look
    something like this:
    H E L L O - - - - - 
    N O - - O - - - - - 
    I - M - B A T M A N 
    C - - E - - M - - - 
    E - - - O - - - - Y 
    - A P P L E - - - A 
    - - - - D - - - - N 
    C - - - - - - - - K 
    - A - - - - - - - E 
    - - T - - - - - - E 

    H E L L O C I R M B 
    N O P T O L Z L T M 
    I D M U B A T M A N 
    C Z G E F C M K X C 
    E G H N O V I E Z Y 
    C A P P L E F R R A 
    H X B P D V J R V N 
    C B F V M G S D O K 
    K A R Q V M S U M E 
    X H T M L K X U C E 

    There may be differences in spacing (depending on your toString), 
    default character, and letter case (capital vs lower). But all
    the words should be there and then the grid should be filled.
    ====================*/

    /*======== public void loadDictionary()) ==========
    Inputs:   
    Returns: 

    DO NOT MODIFY THIS METHOD AT ALL
    Calling this method will load all the words from
    the textfile "wordlist.txt" into the dictionary ArrayList

    11/21/11 17:17:47
    jdyrlandweaver
    ====================*/
    public void loadDictionary() {
        String s = "zzz";

        if ( dictionary.size() == 0 ) 
        {
            try {
                FileReader f = new FileReader("wordlist.txt");
                BufferedReader b = new BufferedReader(f);

                while( s != null ) {
                    s = b.readLine();
                    if ( s != null )
                        dictionary.add(s);
                }
            }
            catch (IOException e) {}
        }
    }

}