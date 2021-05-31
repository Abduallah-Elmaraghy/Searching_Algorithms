package Informed_search;

import searching_algorithms.Node;
import java.util.ArrayList;
import java.util.Collections;


public class A_star
{

    ArrayList<Node> MyNodes = new ArrayList<>();
    String goal;
    String startingNode;
    ArrayList<Node> Explored = new ArrayList<>();
    ArrayList<String> path = new ArrayList<>();
    ArrayList<Integer> SUMLIST = new ArrayList<>();//kol el sm bta3 kol edge w el Heuristic cost

    public A_star(ArrayList<Node> Nodes, String g)
    {
        this.MyNodes = Nodes;
        this.goal = g;
        // T : starting node
        Node T = getNode(MyNodes,"A");
        int sum ,min = 0 , next, oldpath =0;

        for (int i = 0; i < MyNodes.size(); i++)
        {
            Explored.add(T);
            path.add(T.getName());
            if(T.getName().equals(g))
            {
                break;
            }
            for (int j = 0; j < T.getEdges().size(); j++)
            {
                if(Explored.contains(T.getEdges().get(j).getN()))
                {
                    SUMLIST.add(1000000000);
                    continue;
                }
                // sum = real cost + heuristic cost
                sum = 0;
                sum =   (T.getEdges().get(j).getEdge_cost() + oldpath) + (T.getEdges().get(j).getN().getHeuristic_cost());

                SUMLIST.add(sum);
                min = Collections.min(SUMLIST);

            }
            next =  SUMLIST.indexOf(min);
            oldpath+= T.getEdges().get(next).getEdge_cost();
            T = T.getEdges().get(next).getN();


            SUMLIST.clear();


        }
        getPath(path);
        getCost(oldpath);

    }

    public Node getNode(ArrayList<Node>MyNodes, String name)
    {
        for (Node node: MyNodes)
        {
            if(node.getName().equals(name))
                return node;
        }
        return MyNodes.get(0);
    }

    public void setStartingNode(String s)
    {
        this.startingNode = s;
    }

    public String getStartingNode()
    {
        return startingNode;
    }

    public void getPath(ArrayList<String> path)
    {

        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            System.out.print(" -> ");

        }
        /*
        example:
        Your Path: A->B->F->S
         */
    }

    public void getCost(int cost)
    {
        System.out.println("Final Cost =  " + cost);
        /*
        example:
        Your Cost: 345
         */
    }
}