import java.util.Random;
public class battleshipSearch {
	
	// Horizontal Sweep Search Strategy	
	public void horizontalSweepStrtegy(int[][] grid) {	
		System.out.println("Strategy: Horizontal Sweep");
		int total_searches = 1;				// number of searches
		int a = 0;							
		int b = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid.length;j++) {
				if (grid[i][j] != 0) {
	                if (grid[i][j] == 1 & grid[i][j+4] ==1) {		// condition to find carrier coordinates
	                	b = j+4;
	                	// print carrier coordinates
	                	System.out.println("Found Carrier at "+ "("+i +","+ j+") to ("+i +","+ b+")");
	                	a++;					// increment counter
	                }
	                else if(grid[i][j] == 2 & grid[i][j+2] ==2) {	// condition to find submarine coordinates
	                	b =j+2;
	                	// print submarine coordinate
	                	System.out.println("Found Submarine at "+ "("+i +","+ j+") to ("+i +","+ b+")");
	                	a++;					// increment counter
	                }
				}
				total_searches++;		// increment number after each search
				
				// print number of cells searched
				if (a==2) {
					System.out.println("Number of cells searched "+ total_searches);
					a++;
					j = 50;
					i = 50;
				}
				
			}
		}
		if(a==1) {
			total_searches--;
			
			System.out.println("Number of cells searched "+ total_searches);
		}
	}

	// Random Search Strategy
	public void randomSearch(int[][] grid) {
		System.out.println("Strategy: Random Search");
		int total_searches_1 = 1;			// total number of searches
		int c =0;							// count
		int carr = 0;						// carrier
		int subM =0;						// submarine
		Random rand =  new Random();
		while(c!=2) {
		int r1 = rand.nextInt(24);			// assign x coordinate randomly 
		int r2 = rand.nextInt(24);			// assign y coordinate randomly 
		int i = r1+4;
		int j =r2+4;
		if ((i <25) & (j <25)&(carr==0)) {	// condition to find carrier coordinates
			if((grid[r1][r2]==1 & grid[r1][r2+4]==1)|(grid[r1][r2]==1 & grid[r1+4][r2]==1)) {
				c++;
				int k =0;
				k =r2+4;
				// print carrier coordinates
				System.out.println("Found carrier at "+ "("+r1 +","+ r2+") to ("+r1 +","+ k+")");
				carr++;	
			}
		}
		i = r1+2;
		j =r2+2;
		if ((i <25) & (j <25)&(subM==0)) {	// condition to find submarine coordinates
			if((grid[r1][r2]==2 & grid[r1][r2+2]==2)|(grid[r1][r2]==2 & grid[r1+2][r2]==2)) {
				c++;
				int k = 0;
				k =r2+2;
				// print submarine coordinates
				System.out.println("Found submarine at "+ "("+r1 +","+ r2+") to ("+r1 +","+ k+")");
				subM++;
			}
		}
		total_searches_1++;				// increment number of searches
	}
	// print number of cells searched
	System.out.println("Number of cells searched "+ total_searches_1);
}
	
// Strategic Search Strategy
public void strategicSearch(int[][] grid) {
	System.out.println("Strategy: Strategic Search");
	

	
    int c = 1;
	int cells = 1;
	for(int i=0;i<25;i++) {
	for(int j=0;j<25;j++) {
	if(grid[i][j] != 0) {
	c = shipSearch(i,j,grid,c);
	c++;
	System.out.println("Found carrier at "+ "("+i +","+ j+") to ("+ i +","+ j+")"); //carrier
	System.out.println("Found submarine at "+ "("+i +","+ j+") to ("+i +","+ j+")"); // submarine
	}
	if(c==8)
		break;
	cells++;
	}
	}
	System.out.println("Number of searches: "+ cells);
	//return cells;
	}
public static int shipSearch(int i,int j,int[][] grid,int c) {
	
	if( i>=2 && j>=2 && i<24 && j<24) {
	

		if(grid[i-1][j-1] != 0) {
			c++;
			grid[i-1][j-1] = 0;
		}
		if(grid[i-1][j] != 0) {
			c++;
			grid[i-1][j] = 0;
		}
		if(grid[i-1][j+1] != 0) {
			c++;
			grid[i-1][j+1] = 0;
		}
		if(grid[i][j-1] != 0) {
			c++;
			grid[i][j-1] = 0;
		}
		if(grid[i][j+1] != 0) {
			c++;
			grid[i][j+1] = 0;
		}
		if(grid[i+1][j-1] != 0) {
			c++;
			grid[i+1][j-1] = 0;
		}
		if(grid[i+1][j] != 0) {
			c++;
			grid[i+1][j] = 0;
		}
		if(grid[i+1][j+1] != 0) {
			c++; 
			grid[i+1][j+1] = 0;
		}
			
		}
			else if (i<2 && j<2) {
				if(grid[i][j+1] != 0) {
					c++;
					grid[i][j+1] = 0;
				}
				if(grid[i+1][j] != 0) {
					c++;
					grid[i+1][j] = 0;
				}
				if(grid[i+1][j+1] != 0) {
					c++; 
					grid[i+1][j+1] = 0;
				}
				
			}
	return c;
	}
		
}