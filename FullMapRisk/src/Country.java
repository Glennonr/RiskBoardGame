import java.util.ArrayList;
import java.util.LinkedList;

public class Country {
    public int number;
    public String name;
    public String team;
    public int numTroops;



    public Country(int number, String name){
        this.number = number;
        this.name = name;
        team = "none";
        numTroops = 0;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getNumTroops() {
        return numTroops;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setNumTroops(int numTroops) {
        this.numTroops = numTroops;
    }


    public String print(){
        String out = "";
        out += "Name: " + name + "\n";
        out += "Team: " + team + "\n";
        out += "Number: " + number + "\n";
        out += "NumTroops: " + numTroops + "\n";
//        for(int i = 0; i < 9; i++)
//            if(adjacency.isConnected(number, i))

        return out;
    }

    public String printforplayer(){
        String out = "";
        out += "Name: " + name + "\n";
        out += "NumTroops: " + numTroops + "\n";
//        for(int i = 0; i < 9; i++)
//            if(adjacency.isConnected(number, i))
        System.out.println(out);
        return out;
    }

}
