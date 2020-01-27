import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.StringTokenizer;

public class WorldPopulation {

static SortStrategy sortStrategy;
long[] population = new long[13484]; // Cheating because we know number of records!!
// Lab Exercise:  After creating some strategy classes -- set the default strategy here.
public WorldPopulation(){
//sortStrategy = new ; // Set the default strategy here.
}

public void readInputFile(){
population = readPopulationFile("src\\WorldPopulation.csv");

}

public void setStrategy(SortStrategy strategy){
sortStrategy = strategy;
}

// Lab Exercise:  Read in the WorldPopulation.csv
// Extract ONLY the numbers and store them into population[]
public long[] readPopulationFile(String csvFile){
final String delimiter = ",";
try {

       File file = new File(csvFile);
       FileReader fr = new FileReader(file);
       BufferedReader br = new BufferedReader(fr);

       String line = "";
       String [] tempArr;
       int i=0;
       while((line = br.readLine()) != null) {
       tempArr = line.split(delimiter);
           population[i] =  Long.parseLong(tempArr[tempArr.length - 1]);
        i++;
       }
       br.close();
       } catch(IOException ioe) {
          ioe.printStackTrace();
       }
return population;
}


public void sortPopulation(){

       bubblesort sort = new bubblesort();
sort.bubbleSort(population);

long totalTime = sort.getSortTime();
System.out.println("Total time for Bubble Sort : " +totalTime);



  }
public void computeTotalPopulation(){
System.out.println("dd");
}

// Experiment with various strategies.
// Create 3 strategies -- Bubble, insertion, and selection sort.
public static void main(String[] args) {
WorldPopulation worldPopulation = new WorldPopulation();
worldPopulation.readInputFile();
worldPopulation.setStrategy(sortStrategy); //  Currently no strategies.
worldPopulation.sortPopulation();
}

}
