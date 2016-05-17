import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GraphTest {
    @Test
    public void it_will_create_an_empty_graph(){
        Graph g = new Graph();


        assertTrue(g.getEdges().size() == 0);
    }}



//http://www.dreamincode.net/forums/topic/377473-graph-data-structure-tutorial/