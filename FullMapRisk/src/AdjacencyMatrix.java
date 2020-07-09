import java.util.ArrayList;
import java.util.LinkedList;

public class AdjacencyMatrix {
    int numVertexes;
    public int matrix[][];

    public AdjacencyMatrix(int numVertexes) {
        this.numVertexes = numVertexes;
        matrix = new int[numVertexes][numVertexes];
    }

    public void addEdge(Country start, Country end) {
        matrix[start.getNumber()][end.getNumber()] = 1;
        matrix[end.getNumber()][start.getNumber()] = 1;
    }

    public void printMatrix() {
        Map map = new Map();
        System.out.println("Adjacency Matrix");
        for (int i = 0; i < numVertexes; i++) {
            for (int j = 0; j < numVertexes; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < numVertexes; i++) {
            System.out.print(map.countryList.get(i).name + " is connected to: ");
            for (int j = 0; j < numVertexes; j++) {
                if (matrix[i][j] == 1) {
                    System.out.print(map.countryList.get(j).name + ", ");
                }
            }
            System.out.println();
        }
    }

    public boolean isConnected(Country country1, Country country2){
        return matrix[country1.getNumber()][country2.getNumber()] == 1;
    }

    public LinkedList<Country> getAllConnected(Country country){
        Map map = new Map();
        LinkedList<Country> connectedCountries = new LinkedList<>();
        for(int i = 0; i < numVertexes; i++) {
            if (matrix[country.getNumber()][i] == 1) {
                connectedCountries.add(map.countryList.get(i));
            }
        }
        return connectedCountries;
    }

}
