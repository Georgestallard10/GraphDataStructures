import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GraphTest {
    @Test
    public void it_will_create_an_empty_graph(){
        Graph g = new Graph();


        assertTrue(g.getEdges().size() == 0);
    }
    @Test
    public void it_will_retrun_the_number_of_vertices(){
        Vertex v1 = new Vertex("Truro");
        Vertex v2 = new Vertex("Plymouth");
        Edge e1 = new Edge(v1,v2,65);
        Graph g1 = new Graph(e1);
        assertTrue(g1.getVertice().size()==2);

    }

    @Test
    public void it_can_Create_a_Graph_With_one_Edge(){
        Vertex v1 = new Vertex("Truro");
        Vertex v2 = new Vertex("Plymouth");
        Edge e1 = new Edge(v1,v2,65);
        Graph g1 = new Graph(e1);
        assertTrue(g1.containsEdge(e1));
    }
    @Test(expected = VertexDuplicateException.class)
    public void It_can_Check_if_a_duplicate_Vertex_is_added(){
        Vertex v1 = new Vertex("Truro");
        Vertex v2 = new Vertex("Plymouth");
        Edge e1 = new Edge(v1,v2,65);
        Graph g1 = new Graph(e1);
        g1.addVertex(v1);
    }
    @Test
    public void It_can_add_a_new_Vertex(){
        Graph g1 = new Graph();
        Vertex v1 = new Vertex("Truro");
        g1.addVertex(v1);
        assertTrue(g1.containsVertex(v1));
    }
    @Test
    public void It_can_remove_a_vertex(){
        Vertex v1 = new Vertex("Truro");
        Vertex v2 = new Vertex("Plymouth");
        Edge e1 = new Edge(v1,v2,65);
        Graph g1 = new Graph(e1);
        assertTrue(g1.containsVertex(v1));
        g1.removeVertex(v1);
        assertFalse(g1.containsVertex(v1));
    }
    @Test
    public void It_can_check_if_a_Vertex_is_not_present_in_a_graph(){
        Vertex v1 = new Vertex("Truro");
        Vertex v2 = new Vertex("Plymouth");
        Vertex v3 = new Vertex("Glasgow");
        Edge e1 = new Edge(v1,v2,65);
        Graph g1 = new Graph(e1);
        assertFalse(g1.containsVertex(v3));
    }
    @Test
    public void It_can_add_edges_directly_to_the_graph_from_vertexs(){
        Vertex v1 = new Vertex("Truro");
        Vertex v2 = new Vertex("Plymouth");
        Vertex v3 = new Vertex("Glasgow");
        Graph g1 =new Graph();
        Edge e1 = new Edge(v1,v2);
        Edge e2 = new Edge(v1,v3,15);
        g1.addEdge(v1,v2);
        assertTrue(g1.containsEdge(e1));
        g1.addEdge(v1,v3,15);
        assertTrue(g1.containsEdge(e2));

    }
    @Test
    public void it_can_add_an_edge(){
        Vertex v1 = new Vertex("Truro");
        Vertex v2 = new Vertex("Plymouth");
        Vertex v3 = new Vertex("Glasgow");
        Graph g1 =new Graph();
        Edge e1 = new Edge(v1,v2);
        g1.addEdge(e1);
        assertTrue(g1.containsEdge(e1));

    }
    @Test(expected = EdgeDuplicateException.class)
    public void it_can_Throw_a_edge_duplicate_eception(){
        Vertex v1 = new Vertex("Truro");
        Vertex v2 = new Vertex("Plymouth");
        Edge e1 = new Edge(v1,v2);
        Edge e2 = new Edge(v1,v2);
        Graph g1 = new Graph(e1);
        g1.addEdge(e2);
    }
    @Test
    public void it_can_see_a_check_if_a_edge_is_not_present(){
        Vertex v1 = new Vertex("Truro");
        Vertex v2 = new Vertex("Plymouth");
        Vertex v3 = new Vertex("Plymout");
        Edge e1 = new Edge(v1,v2);
        Edge e2 = new Edge(v2,v3);
        Graph g1 = new Graph(e1);
        assertFalse(g1.containsEdge(e2));

    }
    @Test
    public  void It_can_remove_a_Edge_from_2_Vertexes(){
        Vertex v1 = new Vertex("Truro");
        Vertex v2 = new Vertex("Plymouth");
        Edge e1 = new Edge(v1,v2);
        Graph g1 = new Graph(e1);
        assertTrue(g1.containsEdge(e1));
        g1.removeEdge(v1,v2);
        assertFalse(g1.containsEdge(e1));

    }
    @Test(expected = EdgeDuplicateException.class)
    public void it_can_add_an_edge_and_get_a_exeption(){
        Vertex v1 = new Vertex("Truro");
        Vertex v2 = new Vertex("Plymouth");
        Edge e1 = new Edge(v1,v2);
        Graph g1 = new Graph(e1);
        g1.addEdge(v1,v2);
    }
    @Test(expected = EdgeDuplicateException.class)
    public void Same_as_above_but_with_wieght(){
        Vertex v1 = new Vertex("Truro");
        Vertex v2 = new Vertex("Plymouth");
        Edge e1 = new Edge(v1,v2);
        Graph g1 = new Graph(e1);
        g1.addEdge(v1,v2,25);
    }
}



//http://www.dreamincode.net/forums/topic/377473-graph-data-structure-tutorial/