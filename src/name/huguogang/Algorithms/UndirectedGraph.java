package name.huguogang.Algorithms;

import java.util.LinkedList;

public class UndirectedGraph {
    private LinkedList<Integer>[] adj; //adjacency lists
    private int V; //number of vertices
    private int E;
    
    /**
     * Create graph with V number of vertices
     * 
     * @param V
     */
    public UndirectedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Integer>[])new LinkedList[V];
        for(int v =0; v < this.V; v++) {
            adj[v] = new LinkedList<Integer>();
        }
    }
    
    /**
     * Array of 2E + 2, V, E, E pair of v, w edges
     * @param data
     */
    public UndirectedGraph(int[] data) {
        this(data[0]); //V
        int E = data[1];
        for(int i = 0; i < E; i++) {
            addEdge(data[i * 2 + 2], data[i * 2 + 3]);
        }
    }
    
    /**
     * Get number of vertexes
     * 
     * @return
     */
    public int V() {
        return V;
    }
    /**
     * Get number of edges
     * 
     * @return
     */
    public int E() {
        return E;
    }
    /**
     * Add an edge to v and w.
     * 
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    /**
     * Get all vertexes adjacent to V
     * @param v
     * @return
     */
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
    
    /**
     * String representation of the graph.
     * 
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V).append(" vertices, ")
            .append(E).append(" edges\n");
        for(int v = 0; v < V(); v++) {
            sb.append(v).append(": ");
            for(int w : adj(v)) {
                sb.append(w).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
    public int degree(int v) {
        int degree = 0;
        for(int w : adj(v)) {
            degree++;
        }
        return degree;
    }
    
    public int maxDegree() {
        int max = 0;
        for(int v = 0; v < V(); v++) {
            int d = degree(v);
            if(d > max) {
                max = d; 
            }
        }
        return max;
    }
}
