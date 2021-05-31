/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searching_algorithms;

import Informed_search.A_star;
import Informed_search.Greedy_BFS;
import Uninformed_search.BFS;
import Uninformed_search.DFS;
import Uninformed_search.UCS;

import java.util.ArrayList;

public class Searching_Algorithms
{
    public static void main(String[] args)
    {
        //Array that carries all the nodes
        ArrayList<Node> MapNodes = new ArrayList<Node>();

        //creating all Nodes
        Node Arad = new Node("A",366);
        Node Bucharest = new Node("B",0);
        Node Craiova = new Node("C",160);
        Node Dobreta = new Node("D",242);
        Node Eforie = new Node("E",161);
        Node Fagaras = new Node("F",178);
        Node Giurgiu = new Node("G",77);
        Node Hirsova = new Node("H",151);
        Node Iasi = new Node("I",226);
        Node Lugoj = new Node("L",244);
        Node Mehadia = new Node("M",241);
        Node Neamt = new Node("N",234);
        Node Oradea = new Node("O",380);
        Node Pitesti = new Node("P",98);
        Node Rimnicu_Vilcea = new Node("R",193);
        Node Sibiu = new Node("S",253);
        Node Timisoara = new Node("T",329);
        Node Urziceni = new Node("U",80);
        Node Vaslui = new Node("V",199);
        Node Zerind = new Node("Z",374);
//Creating The Frontiers for every node
        //Adding the edges of Arad
        Arad.addEdge(Sibiu,140);
        Arad.addEdge(Timisoara,118);
        Arad.addEdge(Zerind,75);
        //Adding the edges of Bucharest
        Bucharest.addEdge(Fagaras,211);
        Bucharest.addEdge(Giurgiu,90);
        Bucharest.addEdge(Urziceni,85);
        Bucharest.addEdge(Pitesti,101);
        //Adding the edges of Craiova
        Craiova.addEdge(Dobreta,120);
        Craiova.addEdge(Pitesti,138);
        Craiova.addEdge(Rimnicu_Vilcea,146);
        //Adding the edges of Dobreta
        Dobreta.addEdge(Craiova,120);
        Dobreta.addEdge(Mehadia,75);
        //Adding the edges of Eforie
        Eforie.addEdge(Hirsova,86);
        //Adding the edges of Fagaras
        Fagaras.addEdge(Bucharest,211);
        Fagaras.addEdge(Sibiu,99);
        //Adding the edges of Giurgiu
        Giurgiu.addEdge(Bucharest,90);
        //Adding the edges of Hirsova
        Hirsova.addEdge(Eforie,86);
        Hirsova.addEdge(Urziceni,98);
        //Adding the edges of Iasi
        Iasi.addEdge(Neamt,87);
        Iasi.addEdge(Vaslui,92);
        //Adding the edges of Lugoj
        Lugoj.addEdge(Mehadia,70);
        Lugoj.addEdge(Timisoara,111);
        //Adding the edges of Mehadia
        Mehadia.addEdge(Dobreta,75);
        Mehadia.addEdge(Lugoj,70);
        //Adding the edges of Neamt
        Neamt.addEdge(Iasi,87);
        //Adding the edges of Oradea
        Oradea.addEdge(Sibiu,151);
        Oradea.addEdge(Zerind,71);
        //Adding the edges of Pitesti
        Pitesti.addEdge(Bucharest,101);
        Pitesti.addEdge(Craiova,138);
        Pitesti.addEdge(Rimnicu_Vilcea,97);
        //Adding the edges of Rimnicu_Vilcea
        Rimnicu_Vilcea.addEdge(Craiova,146);
        Rimnicu_Vilcea.addEdge(Pitesti,97);
        Rimnicu_Vilcea.addEdge(Sibiu,80);
        //Adding the edges of Sibiu
        Sibiu.addEdge(Arad,140);
        Sibiu.addEdge(Fagaras,99);
        Sibiu.addEdge(Oradea,151);
        Sibiu.addEdge(Rimnicu_Vilcea,80);
        //Adding the edges of Timisoara
        Timisoara.addEdge(Arad,118);
        Timisoara.addEdge(Lugoj,111);
        //Adding the edges of Urziceni
        Urziceni.addEdge(Bucharest,85);
        Urziceni.addEdge(Hirsova,98);
        Urziceni.addEdge(Vaslui,142);
        //Adding the edges of Vaslui
        Vaslui.addEdge(Iasi,92);
        Vaslui.addEdge(Urziceni,142);
        //Adding the edges of Zerind
        Zerind.addEdge(Arad,75);
        Zerind.addEdge(Oradea,71);
//Adding the Nodes to the array
        MapNodes.add(Arad);
        MapNodes.add(Bucharest);
        MapNodes.add(Craiova);
        MapNodes.add(Dobreta);
        MapNodes.add(Eforie);
        MapNodes.add(Fagaras);
        MapNodes.add(Giurgiu);
        MapNodes.add(Hirsova);
        MapNodes.add(Iasi);
        MapNodes.add(Lugoj);
        MapNodes.add(Mehadia);
        MapNodes.add(Neamt);
        MapNodes.add(Oradea);
        MapNodes.add(Pitesti);
        MapNodes.add(Rimnicu_Vilcea);
        MapNodes.add(Sibiu);
        MapNodes.add(Timisoara);
        MapNodes.add(Urziceni);
        MapNodes.add(Vaslui);
        MapNodes.add(Zerind);
//Creating Object of every Algorithm class
        //BFS
        System.out.println("BFS");
        BFS bfs = new BFS("B","A");
        bfs.setMyNodes(MapNodes);
        System.out.print("Your Path : ");
        System.out.println(bfs.getPath());
        System.out.print("Explored Nodes : ");
        for (Node i: bfs.getExplored())
        {
            System.out.print(i.getName() + " ");
        }
        System.out.println("");
       //GBFS
        System.out.println("GBFS");
        Greedy_BFS gbfs = new Greedy_BFS("B","A");
        gbfs.setMyNodes(MapNodes);
        System.out.print("Your Path : ");
        System.out.println(gbfs.getPath());
        System.out.print("Explored Nodes : ");
        for (Node i: gbfs.getExplored())
        {
            System.out.print(i.getName() + " ");
        }
        System.out.println("");
        //DFS
        System.out.println("DFS");
        DFS dfs = new DFS("B","A");
        dfs.setMyNodes(MapNodes);
        System.out.print("Your Path : ");
        System.out.println(dfs.getPath());
        System.out.print("Explored Nodes : ");
        for (Node i: dfs.getExplored())
        {
            System.out.print(i.getName() + " ");
        }
        System.out.println("");
        System.out.print("Frontiers  : ");
        for (Node i: dfs.getFrontiers())
        {
            System.out.print(i.getName() + " ");
        }
        System.out.println("");
        //UCS
//        System.out.println("UCS");
//        UCS ucs = new UCS("B","A");
//        ucs.setMyNodes(MapNodes);
//        System.out.print("Your Path : ");
//        System.out.println(ucs.getPath());
//        System.out.print("Explored Nodes : ");
//        for (Node i: ucs.getExplored())
//        {
//            System.out.print(i.getName() + " ");
//        }
//        System.out.println("");
//        System.out.print("Frontiers  : ");
//        for (Node i: dfs.getFrontiers())
//        {
//            System.out.print(i.getName() + " ");
//        }
        //A*
        System.out.println("A*");
        A_star aStar = new A_star(MapNodes,"B");
    }
}
