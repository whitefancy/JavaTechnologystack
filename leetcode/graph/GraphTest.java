package leetcode.graph;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class GraphTest {

    public void testAMG(){
        int n =4,e=4;
        Graph graph = new ALGraph(n);
        for(int i =0;i<n;i++){
            graph.insertVertex("V"+i);
        }
        graph.insertEdge(0,3,2);
        graph.insertEdge(0,2,2);
        graph.insertEdge(1,3,2);
        graph.insertEdge(2,3,2);
        System.out.println("结点个数是："+graph.getNumOfVertex());
        System.out.println("边的个数是："+graph.getNumOfEdges());
        DFS1(graph);
        graph.deleteEdge(1,3);
        System.out.println("删除<V1,V2>边后...");
        System.out.println("结点个数是："+graph.getNumOfVertex());
        System.out.println("边的个数是："+graph.getNumOfEdges());
    }
    boolean visited[];
    public  void DFS1(Graph G){

        visited = new boolean[G.getNumOfVertex()];
        for(int v = 0;v<G.getNumOfVertex();v++){
            if(!visited[v]) recursiveDFS(G,v);
        }
    }

    private  void recursiveDFS(Graph G, int v) {
        visited[v]=true;
        System.out.println(G.getValueByIndex(v));
        for(int w =G.getFirstNeighbor(v);w>=0;w=G.getNextNeighbor(v,w) ){
            if(!visited[w])recursiveDFS( G,  w);
        }
    }
    public  void DFS2(Graph G){
        Stack stack = new Stack();
        visited = new boolean[G.getNumOfVertex()];
        for(int v = 0;v<G.getNumOfVertex();v++){
            if(!visited[v]){
                visited[v]=true;
                System.out.println(G.getValueByIndex(v));
                stack.push(v);
                while (!stack.isEmpty()){
                    int cur = (int)stack.peek();
                    boolean hasNeighbor = false;
                    for(int w = G.getFirstNeighbor(cur);w!=-1;w =G.getNextNeighbor(cur,w)) {
                        if (visited[w] == false) {
                            hasNeighbor = true;
                            visited[w] = true;
                            System.out.println(G.getValueByIndex(w));
                            stack.push(w);
                        }
                    }
                    if(hasNeighbor==false){
                            stack.pop();
                    }
                }
            }
        }
    }
}
