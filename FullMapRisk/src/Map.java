import java.util.ArrayList;

public class Map {
    AdjacencyMatrix adjacencyMatrix;
    public ArrayList<Country> countryList = new ArrayList<>(42);


    public Map(){
        adjacencyMatrix = new AdjacencyMatrix(42);
        Country Western_United_States = new Country(0, "Western United States");
        countryList.add(0, Western_United_States);
        Country Eastern_United_States = new Country(1, "Eastern United States");
        countryList.add(1, Eastern_United_States);
        Country Central_America = new Country(2, "Central America");
        countryList.add(2, Central_America);
        Country Quebec = new Country(3, "Quebec");
        countryList.add(3, Quebec);
        Country Ontario = new Country(4, "Ontario");
        countryList.add(4, Ontario);
        Country Alberta = new Country(5, "Alberta");
        countryList.add(5, Alberta);
        Country Northwest_territory = new Country(6, "Northwest Territory");
        countryList.add(6, Northwest_territory);
        Country Alaska = new Country(7, "Alaska");
        countryList.add(7, Alaska);
        Country Greenland = new Country(8, "Greenland");
        countryList.add(8, Greenland);

        Country Argentina = new Country(9, "Argentina");
        countryList.add(9, Argentina);

        Country Brazil = new Country(10, "Brazil");
        countryList.add(10, Brazil);

        Country Peru = new Country(11, "Peru");
        countryList.add(11, Peru);

        Country Venezuela = new Country(12, "Venezuela");
        countryList.add(12, Venezuela);

        Country Great_Britain = new Country(13, "Great Britain");
        countryList.add(13, Great_Britain);

        Country Iceland = new Country(14, "Iceland");
        countryList.add(14, Iceland);

        Country Northern_Europe = new Country(15, "Northern Europe");
        countryList.add(15, Northern_Europe);

        Country Scandinavia = new Country(16, "Scandinavia");
        countryList.add(16, Northern_Europe);

        Country Southern_Europe = new Country(17, "Southern Europe");
        countryList.add(17, Southern_Europe);

        Country Ukraine = new Country(18, "Ukraine");
        countryList.add(18, Ukraine);

        Country Western_Europe = new Country(19, "Western Europe");
        countryList.add(19, Western_Europe);

        Country Congo = new Country(20, "Congo");
        countryList.add(20, Congo);

        Country East_Africa = new Country(21, "East Africa");
        countryList.add(21, East_Africa);

        Country Egypt = new Country(22, "Egypt");
        countryList.add(22, Egypt);

        Country Madagascar = new Country(23, "Madagascar");
        countryList.add(23, Madagascar);

        Country North_Africa = new Country(24, "North Africa");
        countryList.add(24, North_Africa);

        Country South_Africa = new Country(25, "South Africa");
        countryList.add(25, South_Africa);

        Country Afghanistan = new Country(26, "Afghanistan");
        countryList.add(26, Afghanistan);

        Country China = new Country(27, "China");
        countryList.add(27, China);

        Country India = new Country(28, "India");
        countryList.add(28, India);

        Country Irkutsk = new Country(29, "Irkutsk");
        countryList.add(29, Irkutsk);

        Country Japan = new Country(30, "Japan");
        countryList.add(30, Japan);

        Country Kamchatka = new Country(31, "Kamchatka");
        countryList.add(31, Kamchatka);

        Country Middle_East = new Country(32, "Middle East");
        countryList.add(32, Middle_East);

        Country Mongolia = new Country(33, "Mongolia");
        countryList.add(33, Mongolia);

        Country Siam = new Country(34, "Siam");
        countryList.add(34, Siam);

        Country Siberia = new Country(35, "Siberia");
        countryList.add(35, Siberia);

        Country Ural = new Country(36, "Ural");
        countryList.add(36, Ural);

        Country Yakutsk = new Country(37, "Yakutsk");
        countryList.add(37, Yakutsk);

        Country Eastern_Australia = new Country(38, "Eastern Australia");
        countryList.add(38, Eastern_Australia);

        Country Indonesia = new Country(39, "Indonesia");
        countryList.add(39, Indonesia);

        Country New_Guinea = new Country(40, "New Guinea");
        countryList.add(40, New_Guinea);

        Country Western_Australia = new Country(41, "Western Australia");
        countryList.add(41, Western_Australia);



        adjacencyMatrix.addEdge(Western_United_States, Eastern_United_States);
        adjacencyMatrix.addEdge(Western_United_States, Central_America);
        adjacencyMatrix.addEdge(Western_United_States, Ontario);
        adjacencyMatrix.addEdge(Western_United_States, Alberta);
        adjacencyMatrix.addEdge(Eastern_United_States, Quebec);
        adjacencyMatrix.addEdge(Eastern_United_States, Ontario);
        adjacencyMatrix.addEdge(Eastern_United_States, Central_America);
        adjacencyMatrix.addEdge(Quebec, Greenland);
        adjacencyMatrix.addEdge(Quebec, Ontario);
        adjacencyMatrix.addEdge(Alberta, Alaska);
        adjacencyMatrix.addEdge(Alberta, Northwest_territory);
        adjacencyMatrix.addEdge(Alberta, Ontario);
        adjacencyMatrix.addEdge(Ontario, Greenland);
        adjacencyMatrix.addEdge(Venezuela, Central_America);
        adjacencyMatrix.addEdge(Venezuela, Brazil);
        adjacencyMatrix.addEdge(Venezuela, Peru);
        adjacencyMatrix.addEdge(Peru, Brazil);
        adjacencyMatrix.addEdge(Argentina, Brazil);
        adjacencyMatrix.addEdge(Argentina, Peru);
        adjacencyMatrix.addEdge(North_Africa, Brazil);
        adjacencyMatrix.addEdge(North_Africa, Congo);
        adjacencyMatrix.addEdge(North_Africa, Egypt);
        adjacencyMatrix.addEdge(North_Africa, East_Africa);
        adjacencyMatrix.addEdge(North_Africa, Western_Europe);
        adjacencyMatrix.addEdge(North_Africa, Southern_Europe);
        adjacencyMatrix.addEdge(Egypt, East_Africa);
        adjacencyMatrix.addEdge(Egypt, Middle_East);
        adjacencyMatrix.addEdge(Egypt, Southern_Europe);
        adjacencyMatrix.addEdge(Congo, East_Africa);
        adjacencyMatrix.addEdge(Congo, South_Africa);
        adjacencyMatrix.addEdge(East_Africa, South_Africa);
        adjacencyMatrix.addEdge(East_Africa, Madagascar);
        adjacencyMatrix.addEdge(South_Africa, Madagascar);
        adjacencyMatrix.addEdge(Iceland, Greenland);
        adjacencyMatrix.addEdge(Iceland, Great_Britain);
        adjacencyMatrix.addEdge(Iceland, Scandinavia);
        adjacencyMatrix.addEdge(Great_Britain, Scandinavia);
        adjacencyMatrix.addEdge(Great_Britain, Northern_Europe);
        adjacencyMatrix.addEdge(Great_Britain, Western_Europe);
        adjacencyMatrix.addEdge(Western_Europe, Northern_Europe);
        adjacencyMatrix.addEdge(Western_Europe, Southern_Europe);
        adjacencyMatrix.addEdge(Northern_Europe, Southern_Europe);
        adjacencyMatrix.addEdge(Northern_Europe, Scandinavia);
        adjacencyMatrix.addEdge(Northern_Europe, Ukraine);
        adjacencyMatrix.addEdge(Scandinavia, Ukraine);
        adjacencyMatrix.addEdge(Southern_Europe, Ukraine);
        adjacencyMatrix.addEdge(Southern_Europe, Middle_East);
        adjacencyMatrix.addEdge(Ukraine, Middle_East);
        adjacencyMatrix.addEdge(Ukraine, Afghanistan);
        adjacencyMatrix.addEdge(Ukraine, Ural);
        adjacencyMatrix.addEdge(Middle_East, India);
        adjacencyMatrix.addEdge(Middle_East, Afghanistan);
        adjacencyMatrix.addEdge(Afghanistan, India);
        adjacencyMatrix.addEdge(Afghanistan, China);
        adjacencyMatrix.addEdge(Afghanistan, Ural);
        adjacencyMatrix.addEdge(Ural, China);
        adjacencyMatrix.addEdge(Ural, Siberia);
        adjacencyMatrix.addEdge(China, India);
        adjacencyMatrix.addEdge(China, Siam);
        adjacencyMatrix.addEdge(China, Mongolia);
        adjacencyMatrix.addEdge(China, Siberia);
        adjacencyMatrix.addEdge(Mongolia, Siberia);
        adjacencyMatrix.addEdge(Mongolia, Japan);
        adjacencyMatrix.addEdge(Mongolia, Irkutsk);
        adjacencyMatrix.addEdge(Mongolia, Kamchatka);
        adjacencyMatrix.addEdge(Irkutsk, Siberia);
        adjacencyMatrix.addEdge(Irkutsk, Yakutsk);
        adjacencyMatrix.addEdge(Irkutsk, Kamchatka);
        adjacencyMatrix.addEdge(Yakutsk, Kamchatka);
        adjacencyMatrix.addEdge(Yakutsk, Siberia);
        adjacencyMatrix.addEdge(Kamchatka, Alaska);
        adjacencyMatrix.addEdge(Siam, India);
        adjacencyMatrix.addEdge(Siam, Indonesia);
        adjacencyMatrix.addEdge(Indonesia, New_Guinea);
        adjacencyMatrix.addEdge(Indonesia, New_Guinea);
        adjacencyMatrix.addEdge(Indonesia, Western_Australia);
        adjacencyMatrix.addEdge(New_Guinea, Western_Australia);
        adjacencyMatrix.addEdge(New_Guinea, Eastern_Australia);
        adjacencyMatrix.addEdge(Eastern_Australia, Western_Australia);

    }

    public boolean gameWon(Map map){
        for(int i = 0; i < map.countryList.size() - 1; i++)
            if(!map.countryList.get(i).getTeam().equals(map.countryList.get(i+1).getTeam()))
                return false;
        return true;
    }

    public void printGameStatus(Map map) {
        System.out.println( "\u001B[0m" + "This is the current game status");
        for (int i = 0; i < countryList.size(); i++) {
            if (map.countryList.get(i).getTeam().equals("red")) {
                System.out.println("\u001B[31m");
                map.countryList.get(i).printforplayer();
            }
            else if (map.countryList.get(i).getTeam().equals("blue")) {
                System.out.println("\u001B[34m");
                map.countryList.get(i).printforplayer();
            }
            else if (map.countryList.get(i).getTeam().equals("green")) {
                System.out.println("\u001B[32m");
                map.countryList.get(i).printforplayer();
            }
            else if (map.countryList.get(i).getTeam().equals("purple")) {
                System.out.println("\u001B[35m");
                map.countryList.get(i).printforplayer();
            }
        }
        System.out.println("\u001B[0m");
    }

    public int rollDie(){
        return (int) (Math.random() * 6) + 1;
    }




}
