
public class Config {

    /**
     * A set of caves to search through.  The first one is provided.
     * TODO add at least 2 more caves.
     */
    public static final char[][][] CAVES= new char[][][] {
        { 
            { ' ', ' ', ' ', ' ', ' ' }, 
            { ' ', 'b', ' ', 'p', ' ' }, 
            { ' ', 'p', 'w', ' ', ' ' },
            { ' ', ' ', 'b', ' ', ' ' }, 
            { ' ', ' ', ' ', 'b', 'p' } 
        },
        { 
            { ' ', 'p', ' ', ' ', ' ' }, 
            { ' ', 'w', ' ', 'p', ' ' }, 
            { ' ', 'p', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ' }, 
            { 'b', 'p', ' ', 'b', 'p' } 
        },
        { 
            { ' ', ' ', ' ', 'p', 'b' }, 
            { ' ', ' ', 'b', 'w', 'p' }, 
            { ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ' }, 
            { 'b', ' ', ' ', ' ', 'p' } 
        }
        
        
    };

    /**
     * The methods in WumpusCaves should refer to these constants,
     * e.g., Config.PIT, and not the literals themselves.
     */
    public static final char PIT = 'p';
    public static final char BAT = 'b';
    public static final char WUMPUS = 'w';
    public static final char RESCUE = 'r';
    public static final char HUNT = 'h';
    
    /**
     * The number of perceptions and the indexes in a perceptions
     * array.
     */
    public static final int numPerceptions = 3;
    public static final int PerceivePit = 0;
    public static final int PerceiveBat = 1;
    public static final int PerceiveWumpusOrChild = 2;
    
    /**
     * indices for location arrays
     */
    public static final int ROW = 0;
    public static final int COLUMN = 1;
    
    /**
     * Random number generator SEED. Passed to the random number generator
     * to get repeatable random numbers which can aid with debugging.
     */
    public static final int SEED = 123;
}
