package Uninformed_search;


import searching_algorithms.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UCS
{
    ArrayList<Node> MyNodes = new ArrayList<>();
    String starting_node;
    String goal;
    String Path = "";
    ArrayList<Node> Explored = new ArrayList<>();
    ArrayList<Node.Node_Edge> Frontiers = new ArrayList<>();

    public UCS (String g,String sn)
    {
        this.goal = g;
        this.starting_node = sn;
    }

    public ArrayList<Node> getMyNodes()
    {
        return MyNodes;
    }

    public void setMyNodes(ArrayList<Node> myNodes)
    {
        MyNodes = myNodes;
    }

    public String getPath()
    {
        FindGoal(getNode(MyNodes,starting_node),Path,Frontiers);
        Path = goal;
        int node = Explored.size();
        Node n = getNode(MyNodes,goal);
        for (int j = Explored.size() - 1; j >= 0; j--)
        {
            for (int i = 0; i < n.getEdges().size(); i++)
            {
                if(Explored.get(j).equals(n.getEdges().get(i).getN()))
                {
                    n = n.getEdges().get(i).getN();
                    Path = n.getName() + "->" + Path;
                    break;
                }
            }
        }
        return Path;
    }

    public ArrayList<Node> getExplored()
    {
        return Explored;
    }

    public ArrayList<Node.Node_Edge> getFrontiers()
    {
        return Frontiers;
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

    public ArrayList<Node.Node_Edge> AddFrontiers(Node node, ArrayList<Node.Node_Edge> frontiers)
    {
        for (Node.Node_Edge edge: node.getEdges())
        {
            frontiers.add(edge);
        }
        insertion_sort_frontiers(frontiers);
        return frontiers;
    }

    public void insertion_sort_frontiers(ArrayList<Node.Node_Edge> frontiers)
    {
        for (int i = 2; i < frontiers.size(); i++)
        {
            Node.Node_Edge key = frontiers.get(i);
            int j = i - 1;
            while(j > 0 && frontiers.get(j).getEdge_cost() > key.getEdge_cost())
            {
                frontiers.set(j+1,frontiers.get(j));
                j = j - 1;
            }
            frontiers.set(j + 1, key);
        }
    }
    /*
       example:
       Your Path: A->B->F->S
    */
    public String FindGoal(Node start,String path, ArrayList<Node.Node_Edge> frontiers)
    {
        start.sortEdges_real_cost();
// without exploring new node
        // if the starting node is my goal
        if(start.getName()==goal)
        {
            // if the node is the initial state
            // the node is not the initial state
            path = start.getName();
            return path;
        }
        //if the goal is found on the frontiers of MyNode
        for (Node.Node_Edge i: start.getEdges())
        {
            if (i.getN().getName().equals(goal))
            {
                if(path.isEmpty())
                    path +=start.getName() + "->" + goal;
                else
                {
                    Explored.add(start);
                    path += "->" + start.getName() + "->" + goal;
                }
                return path;
            }
        }
        // the goal is not found in the frontiers
// exploring new node
        frontiers=AddFrontiers(start,frontiers);
        //exploring new node
        Explored.add(start);
        Node s = frontiers.get(0).getN();
        frontiers.remove(0);
        if(path.contains(start.getName()))
            path = FindGoal(s,path,frontiers);
        else
        {
            if (path.isEmpty())
                path += start.getName();
            else
                path += "->" + start.getName();
            path = FindGoal(s, path, frontiers);
        }
        return path;
    }



    public void getCost()
    {
        /*
        example:
        Your Cost: 345
         */
    }
}
