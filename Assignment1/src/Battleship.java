import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Battleship {
	String t_1,t_2,t_3;
	static int s = 1;
	int carr =  1; // Carrier
	int subM = 2; // Submarine
	int[][] grid_1 = new int[25][25];
	static int[][] grid_2 = new int[25][25];
	static int[][] grid_3 = new int[25][25];
	static int[][] grid_4 = new int[25][25];
	
	public void copyArray(int[][] initialGrid, int[][] finalGrid) {
		
	    for (int i = 0; i < initialGrid.length; ++i) {
	         System.arraycopy(initialGrid[i], 0, finalGrid[i], 0, finalGrid[i].length);
	      }
	     	
	    //System.out.println(Arrays.deepToString(finalGrid));
	}
	
	public void placingShips() {
		String path = "src/input.txt";
		try {
			FileReader inputFile = new FileReader(path);
			BufferedReader reader = new BufferedReader(inputFile);
			String line;

			while((line = reader.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, "()") ;
				for(int i =0;i<8;i++) {
					t_1 = tokenizer.nextToken();
					StringTokenizer tokenizer1 = new StringTokenizer(t_1, ",") ;
					t_2 = tokenizer1.nextToken();
					t_3 = tokenizer1.nextToken();
					//System.out.println(grid_1[Integer.parseInt(t_2)][Integer.parseInt(t_3)]);
					if(i<5) {
						grid_1[Integer.parseInt(t_2)][Integer.parseInt(t_3)] = carr;
						
					}
					else {
						grid_1[Integer.parseInt(t_2)][Integer.parseInt(t_3)] = subM;
					}
					
					}
				if (s == 1) {
					copyArray(grid_1,grid_2);
				}
				else if(s == 2) {
					copyArray(grid_1,grid_3);
				}
				else {
					copyArray(grid_1,grid_4);;
				}
				
				for (int row = 0; row < grid_1.length; row++) {
					   for (int col = 0; col < grid_1.length; col++) {
					      grid_1[row][col] = 0;
					   }
					}
				s++;
				
					
			 }
			reader.close();
			} catch (Exception e) {
			e.printStackTrace();
			
			}
		
	}

	public static void main(String[] args) {
		Battleship battleShip = new Battleship();
		battleShip.placingShips();	
		battleshipSearch shipSearch = new battleshipSearch ();
// Game 1 output
		System.out.println("Game 1");
	    shipSearch.horizontalSweepStrtegy(grid_2);
		shipSearch.randomSearch(grid_2);
		//shipSearch.strategicSearch(grid_2);
		System.out.println();
		//System.out.println();
		
		
// Game 2 output
		System.out.println("Game 2");
		shipSearch.horizontalSweepStrtegy(grid_3);
		shipSearch.randomSearch(grid_3);
		//System.out.println("Number of Cells Searched: ", shipSearch.randomSearch.c);
		//shipSearch.strategicSearch(grid_3); 
		System.out.println();
		//System.out.println();

// Game 3 output
		System.out.println("Game 3");
		shipSearch.horizontalSweepStrtegy(grid_4);
		shipSearch.randomSearch(grid_4);
		//shipSearch.strategicSearch(grid_4);
		System.out.println();
	}

}