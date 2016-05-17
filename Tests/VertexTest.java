import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class VertexTest {
    @Test
    public void it_can_create_an_empty_node() {
        Vertex v = new Vertex();

        assertNull(v.getLabel());
    }

    @Test
    public void it_should_store_its_label() {
        Vertex v = new Vertex("Manchester");

        assertEquals("Manchester", v.getLabel());
    }

    @Test
    public void hashTest() {
        Vertex v = new Vertex("Gold Chain");
        assertTrue(v.hashCode() == -1049325823);
    }

    @Test
    public void Test_setLabel() {
        Vertex v = new Vertex("Gold Chain");
        assertTrue(Objects.equals(v.getLabel(), "Gold Chain"));
        v.setLabel("Two Chains");
        assertTrue(Objects.equals(v.getLabel(), "Two Chains"));
    }

    @Test
    public void it_can_add_a_neighbour() {
        Vertex v1 = new Vertex("London");
        Vertex v2 = new Vertex("Penzance");

        Edge e = new Edge(v1, v2);

    }

    @Test
    public void it_can_verify_that_two_vertices_are_equal() {
        Vertex v1 = new Vertex("Manchester");
        Vertex v2 = new Vertex("Manchester");

        assertTrue(v1.equals(v2));
    }

    @Test
    public void it_outputs_the_correct_toString_representation() {
        Vertex v1 = new Vertex("London");

        assertEquals("Vertex: London", v1.toString());
    }

    @Test
    public void it_can_add_and_check_if_a_edge_has_been_added() {
        Vertex v1 = new Vertex("Manchester");
        Vertex v2 = new Vertex("London");
        Edge e1 = new Edge(v1, v2);
        v1.addNeighbour(e1);
        assertTrue(v1.containsNeighbour(e1));
    }

    @Test(expected = EdgeNeighbourException.class)
    public void It_will_throw_an_exception_if_a_duplicate_edge_is_added() {
        Vertex v1 = new Vertex("Manchester");
        Vertex v2 = new Vertex("London");
        Edge e1 = new Edge(v1, v2);
        v1.addNeighbour(e1);
        v1.addNeighbour(e1);

    }
    @Test
    public void it_can_remove_a_neighbour() {
        Vertex v1 = new Vertex("Manchester");
        Vertex v2 = new Vertex("London");
        Edge e1 = new Edge(v1, v2);
        v1.addNeighbour(e1);
        assertTrue(v1.containsNeighbour(e1));
        v1.removeNeighbour(0);
        assertFalse(v1.containsNeighbour(e1));
    }
}