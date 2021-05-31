package Uninformed_search;

import searching_algorithms.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS
{
    ArrayList<Node> MyNodes = new ArrayList<>();
    String starting_node;
    String goal;
    String Path = "";
    ArrayList<Node> Explored = new ArrayList<>();//visited
    Stack<Node> Frontiers = new Stack<>();

    public DFS (String g,String sn)
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
        Path=FindGoal(getNode(MyNodes,starting_node),Path,Frontiers);
        if (Path.contains("LOOP"))
            return "There is no solution there is a loop";
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

    public Stack<Node> getFrontiers()
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

    public Stack<Node> AddFrontiers(Node node, Stack<Node> frontiers)
    {
        int size = node.getEdges().size()-1;
        for (int i = size; i >= 0; i--)
        {
            frontiers.push(node.getEdges().get(i).getN());
        }
        return frontiers;
    }

    /*
       example:
       Your Path: A->B->F->S
    */
    public String FindGoal(Node start,String path, Stack<Node> frontiers)
    {
        if (path.contains("LOOP"))
            return "LOOP";
// without exploring new node
        // if the starting node is my goal
        if(start.getName()==goal)
        {
            path = start.getName();
            return path;
        }
        //Check if the goal is found on the frontiers of MyNode
        for (Node.Node_Edge edges: start.getEdges())
        {
            //The goal is found on the frontiers
            if (edges.getN().getName().equals(goal))
            {
                Explored.add(start);
                //if the path is empty which means it's on the frontiers of the starting node
                if(path.isEmpty())
                    path += start.getName() + "->" + goal;
                // it's on the frontiers of the starting node
                else
                    path += "->" + start.getName() + "->" + goal;
                return path;
            }
        }
        // the goal is not found in the frontiers
// exploring new node
        // if there is a loop
        if(!Explored.isEmpty())
        {
            int count = 0;
            for (Node i : Explored)
            {
                if (i.equals(start))
                {
                    count++;
                }
            }
            if (count != 0 && (Explored.size() / count) < count)
                return "LOOP";
        }
        //exploring new node
        Explored.add(start);
        frontiers=AddFrontiers(start,frontiers);
        Node s = frontiers.peek();
        frontiers.pop();
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
