package leetcode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ALGraph implements Graph {
    // Adjacency matrix graph
    private List vertexList;
    private List<Arc> [] edges;
    private int numOfEdges;
    public ALGraph(int n){
        edges = new LinkedList[n];
        for(int i=0;i<n;i++){
            edges[i] = new LinkedList<Arc>();
        }
        vertexList = new ArrayList<>(n);
        numOfEdges =0;
    }

    public int getNumOfVertex(){
        return vertexList.size();
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public Object getValueByIndex(int i){
        return vertexList.get(i);
    }
    public int getWeight(int v1,int v2){
        for(int i =0;i<edges[v1].size();i++)
        {
            if(edges[v1].get(i).getTail()==v2)
                return edges[v1].get(i).getWeight();
        }
        return 0;
    }
    public void insertVertex(Object vertex){
        vertexList.add(vertexList.size(),vertex);
    }
    public void insertEdge(int v1,int v2,int weight){
        edges[v1].add(new Arc(v2,weight));
        numOfEdges++;
    }
    public void deleteEdge(int v1,int v2){
        for(int i =0;i<edges[v1].size();i++)
        {
            if(edges[v1].get(i).getTail()==v2)
            {
                edges[v1].remove(i);
                numOfEdges--;
            }
        }

    }
    public int getFirstNeighbor(int index){
        if(edges[index].size()>0)
            return edges[index].get(0).getTail();
        return -1;
    }
    public int getNextNeighbor(int v1,int v2){
        for(int i =0;i<edges[v1].size()-1;i++)
        {
            if(edges[v1].get(i).getTail()==v2)
            {
                return edges[v1].get(i+1).getTail();
            }
        }
        return -1;
    }
}
