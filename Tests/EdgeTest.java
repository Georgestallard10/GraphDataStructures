import org.junit.Test;

import static org.junit.Assert.*;

public class EdgeTest {
    @Test
    public void it_can_create_a_simple_edge() {
        Vertex v1 = new Vertex("Manchester");
        Vertex v2 = new Vertex("Liverpool");

        Edge e = new Edge(v1, v2);

        assertEquals("Liverpool", e.getOne().getLabel());
        assertEquals("Manchester", e.getTwo().getLabel());
    }

    @Test
    public void it_defaults_unspecified_weights_to_zero() {
        Vertex v1 = new Vertex("Manchester");
        Vertex v2 = new Vertex("Liverpool");

        Edge e = new Edge(v1, v2);

        assertEquals(1, e.getWeight());
    }

    @Test
    public void it_can_create_a_weighted_edge() {
        Vertex v1 = new Vertex("Manchester");
        Vertex v2 = new Vertex("Liverpool");

        Edge e = new Edge(v1, v2, 5);

        assertEquals("Liverpool", e.getOne().getLabel());
        assertEquals("Manchester", e.getTwo().getLabel());
        assertEquals(5, e.getWeight());
    }

    @Test
    public void it_can_provide_the_neighbour_of_a_vertex_on_an_edge() {
        Vertex v1 = new Vertex("Manchester");
        Vertex v2 = new Vertex("Swansea");

        Edge e = new Edge(v1, v2);

        Vertex opposite1 = e.getNeighbour(v1);
        assertEquals("Swansea", opposite1.getLabel());

        Vertex opposite2 = e.getNeighbour(v2);
        assertEquals("Manchester", opposite2.getLabel());
    }
    @Test(expected = LoopingEdgeException.class)

    public void Throwing_EdgeDupe_Exception(){
        Vertex v1 = new Vertex("Two Chains");
        Edge e = new Edge(v1,v1,5);

    }
    @Test
    public void it_doesnt_return_the_neighbour_on_an_edge_if_we_dont_give_a_valid_vertex() {
        Vertex v1 = new Vertex("Manchester");
        Vertex v2 = new Vertex("Swansea");
        Vertex v3 = new Vertex("London");

        Edge e = new Edge(v1, v2);

        Vertex nullOpposite = e.getNeighbour(v3);
        assertNull(nullOpposite);
    }

    @Test
    public void it_will_correctly_compare_the_weights_of_edges() {
        Vertex v1 = new Vertex("London");
        Vertex v2 = new Vertex("Manchester");
        Vertex v3 = new Vertex("Liverpool");

        Edge e1 = new Edge(v1, v2, 5);
        Edge e2 = new Edge(v1, v3, 3);

        assertTrue(e1.compareTo(e2) > 0);
        assertTrue(e2.compareTo(e1) < 0);
    }

    @Test
    public void it_will_correctly_compare_the_weights_of_equal_edges() {
        Vertex v1 = new Vertex("London");
        Vertex v2 = new Vertex("Manchester");
        Vertex v3 = new Vertex("Liverpool");

        Edge e1 = new Edge(v1, v2);
        Edge e2 = new Edge(v1, v3);

        assertTrue((e1.compareTo(e2) == 0));
        assertTrue((e2.compareTo(e1) == 0));
    }

    @Test
    public void it_will_confirm_equivalence_of_edges() {
        Vertex v1 = new Vertex("London");
        Vertex v2 = new Vertex("Manchester");

        Edge e1 = new Edge(v1, v2, 5);
        Edge e2 = new Edge(v1, v2, 5);

        assertTrue((e1.equals(e2)));
    }

    @Test
    public void to_String() {
        Vertex v1 = new Vertex("London");
        Vertex v2 = new Vertex("Manchester");
        int weight = 5;

        Edge e1 = new Edge(v1, v2, weight);
        String s = e1.toString(e1);
        assertTrue(e1.getVertex1().getLabel().equals("London"));
        assertTrue(e1.getVertex2().getLabel().equals("Manchester"));
        assertTrue(e1.getWeight() == weight);
        assertTrue((s.equals("{{London,Manchester},<5>}")));

    }

    @Test
    public void test_dem_Setters() {
        Vertex v1 = new Vertex("Manchester");
        Vertex v2 = new Vertex("Liverpool");
        Vertex v3 = new Vertex("Gold chainz");
        Vertex v4 = new Vertex("Banterbry");

        Edge e = new Edge(v1, v2);

        assertEquals("Liverpool", e.getOne().getLabel());
        assertEquals("Manchester", e.getTwo().getLabel());
        e.setWeight(99);
        e.setVertex1(v3);
        e.setVertex2(v4);
        assertTrue(e.getWeight() == 99);
        assertTrue(e.getVertex1() == v3);
        assertTrue(e.getVertex2() == v4);
    }
}