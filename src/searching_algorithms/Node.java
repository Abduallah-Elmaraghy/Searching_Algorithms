package searching_algorithms;

import java.util.ArrayList;
import java.util.HashMap;

public class Node
{
    public class Node_Edge
    {
        Node N;
        int edge_cost;

        public Node_Edge(Node node, int cost)
        {
            this.edge_cost = cost;
            this.N = node;
        }

        public int getEdge_cost()
        {
            return edge_cost;
        }

        public Node getN()
        {
            return N;
        }

        public void setEdge_cost(int edge_cost)
        {
            this.edge_cost = edge_cost;
        }

        public void setN(Node n)
        {
            N = n;
        }
    }
    String name;
    //carries the value of the heuristic cost of the path from it to the goal state
    int heuristic_cost;
    //carries the Frontiers and the cost to reach them
    ArrayList<Node_Edge> edges = new ArrayList<>();

    public Node(String name, int heuristic_cost)
    {
        this.name = name;
        this.heuristic_cost = heuristic_cost;
    }

    public void addEdge(Node node,int cost)
    {
        Node_Edge N_edge = new Node_Edge(node, cost);
        edges.add(N_edge);
    }

    public void setEdges(ArrayList<Node_Edge> edges)
    {
        this.edges = edges;
    }

    public ArrayList<Node_Edge> getEdges()
    {
        return edges;
    }

    public void sortEdges_heuristic_cost()
    {
        for (int i = 0; i < edges.size(); i++)
        {
            for (int j = i + 1; j < edges.size(); j++)
            {
                if(edges.get(i).getN().getHeuristic_cost() > edges.get(j).getN().getHeuristic_cost() )
                {
                    Node.Node_Edge min = edges.get(i);
                    //set(index, node_edge)
                    edges.set(i, edges.get(j));
                    edges.set(j,min);
                }
            }
        }
    }
    public void sortEdges_real_cost()
    {
        for (int i = 0; i < edges.size(); i++)
        {
            for (int j = i + 1; j < edges.size(); j++)
            {
                if(edges.get(i).getEdge_cost() > edges.get(j).getEdge_cost())
                {
                    Node.Node_Edge min = edges.get(i);
                    //set(index, node_edge)
                    edges.set(i, edges.get(j));
                    edges.set(j,min);
                }
            }
        }
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setHeuristic_cost(int heuristic_cost)
    {
        this.heuristic_cost = heuristic_cost;
    }

    public int getHeuristic_cost()
    {
        return heuristic_cost;
    }
}
