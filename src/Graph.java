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
        Edges.put(e.hashCode(), e);
        Vertices.put(e.getVertex1().hashCode(), e.getVertex1());
        Vertices.put(e.getVertex2().hashCode(), e.getVertex2());
    }


    public void removeVertex(Vertex v) {
        this.Vertices.remove(v.hashCode());
    }

    public void addVertex(Vertex v) {
        if (this.Vertices.containsValue(v)) {
            throw new VertexDuplicateException("Vertex is duplicated");


        } else {
            int s = v.hashCode();
            this.Vertices.put(s, v);
        }
    }

    public HashMap getEdges() {
        return this.Edges;
    }

    public HashMap getVertice() {
        return this.Vertices;
    }

    public void addEdge(Edge e) {
        if (this.Edges.containsKey(e.hashCode())) {
            throw new EdgeDuplicateException("Edge is duplicated");

        } else {
            this.Edges.put(e.hashCode(), e);
        }

    }

    public void addEdge(Vertex Vertex1, Vertex Vertex2, int i) {
        Edge edge = new Edge(Vertex1, Vertex2, i);
        if (this.Edges.containsKey(edge.hashCode())) {
            throw new EdgeDuplicateException("Edge is duplicated");

        } else {
            Edges.put(edge.hashCode(), edge);
        }

    }

    public void addEdge(Vertex vertex1, Vertex vertex2) {
        Edge edge = new Edge(vertex1, vertex2);
        if (this.Edges.containsKey(edge.hashCode())) {
            throw new EdgeDuplicateException("Edge is duplicated");

        } else {
            Edges.put(edge.hashCode(), edge);
        }
    }

    public void removeEdge(Vertex Vertex1, Vertex Vertex2) {
        Edge edge = new Edge(Vertex1, Vertex2);
        this.Edges.remove(edge.hashCode());


    }

    public boolean containsVertex(Vertex V) {
        if (this.Vertices.containsKey(V.hashCode())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean containsEdge(Edge e) {
        if (this.Edges.containsKey(e.hashCode())) {
            return true;
        } else {
            return false;
        }
    }


}
