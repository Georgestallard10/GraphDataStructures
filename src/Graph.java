import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by George stallard on 14/04/2016.
 */
public class Graph {
    private HashMap<Integer, Vertex> Vertices;
    private HashMap<Integer, Edge> Edges;


    public Graph() {
        this.Edges = new HashMap<>();
        this.Vertices = new HashMap<>();
    }

    public Graph(Edge e) {
        this.Edges = new HashMap<>();
        this.Vertices = new HashMap<>();
        Edges.put(e.hashCode(e), e);
    }


    public void removeVertex(String k) {
        this.Vertices.remove(k);
    }

    public void addVertex(Vertex v) {
        if (this.Vertices.containsValue(v)) {
            throw new EdgeDuplicateException("Edge is duplicated");


        } else {
            int s = v.hashCode();
            this.Vertices.put(s, v);
        }
    }

    public void addVertex(int s, Vertex v) {
        if (this.Vertices.containsKey(s)) {
            throw new EdgeDuplicateException("Edge is duplicated");


        } else {
            this.Vertices.put(s, v);
        }
    }

    public HashMap getEdges(String c) {
        return this.Edges;
    }

    public HashMap getEdges() {
        return this.Edges;
    }

    public HashMap getVertice() {
        return this.Vertices;
    }

    public void addEdge(int key, Edge e) {
        if (this.Edges.containsValue(e)) {
            throw new EdgeDuplicateException("Edge is duplicated");

        } else {
            this.Edges.put(key, e);
        }

    }

    public void addEdge(Vertex Vertex1, Vertex Vertex2, int i) {

    }

    public void addEdge(Vertex vertex1, Vertex vertex2) {

    }

    public void removeEdge(Vertex Vertex1, Vertex Vertex2) {

    }

    public boolean containsVertex(Vertex V) {
        if (this.Vertices.containsValue(V)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean containsEdge(Edge e) {
        if (this.Edges.containsValue(e)) {
            return true;
        } else {
            return false;
        }
    }


}
