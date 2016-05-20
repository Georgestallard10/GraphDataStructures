import java.util.ArrayList;

/**
 * Created by Georgestallard10 on 14/04/2016.
 */
public class Vertex {
    private ArrayList<Edge> Neighbourhood;
    private String Label;

    public Vertex(String Label) {
        this.Label = Label;
        this.Neighbourhood = new ArrayList<>();
    }

    public String getLabel() {
        return this.Label;
    }

    public int hashCode() {
        return this.Label.hashCode();
    }

    public Vertex() {
        this.Neighbourhood = new ArrayList<>();
    }

    public void setLabel(String L) {
        this.Label = L;
    }

    public String toString() {
        return "Vertex: " + this.Label;
    }


    public void addNeighbour(Edge e) {
        if (this.Neighbourhood.contains(e)) {
            throw new EdgeNeighbourException("Neighbour has already been added");
        } else {
            this.Neighbourhood.add(e);
        }
    }

    public boolean containsNeighbour(Edge edge) {
        return this.Neighbourhood.contains(edge);
    }

    public ArrayList getNeighbourhood() {
        return this.Neighbourhood;
    }

    public Edge getNeighbour(int a) {
        return Neighbourhood.get(a);
    }

    public int getNeighbourCount() {
        return Neighbourhood.size();
    }


    public void removeNeighbour(Edge e) {
        if (Neighbourhood.contains(e)) {
            Neighbourhood.remove(Neighbourhood.indexOf(e));
        } else {
            throw new EdgeNeighbourMissingException("Neighbour is not present");
        }

    }

    public boolean equals(Vertex v) {
        if (this.Label == v.getLabel()) {
            return true;
        } else return false;
    }

    public void removeNeighbour(int i) {
        Neighbourhood.remove(i);
    }
}
