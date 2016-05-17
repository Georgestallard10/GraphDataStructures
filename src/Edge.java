/**
 * Created by Georgestallard10 on 14/04/2016.
 */
public class Edge {
    private Vertex Vertex1;
    private Vertex Vertex2;
    private int weight;

    public Edge(Vertex a, Vertex b, int weight) {
        boolean dupe = VertexCheck(a, b);
        if (!dupe) {
            this.weight = weight;
            SortinAlpha(a,b);

        } else {
            throw new LoopingEdgeException("Vertexs are the same.");
        }

    }


    private void SortinAlpha(Vertex a, Vertex b) {
        int result = a.getLabel().compareTo(b.getLabel());
        if (result == 0) {
            throw new LoopingEdgeException("Vertex's the same");
        } else if (result > 0) {
            this.Vertex2 = a;
            this.Vertex1 = b;
            this.weight = weight;

        } else {
            this.Vertex2 = b;
            this.Vertex1 = a;
            this.weight = weight;

        }
    }
    public boolean equals (Edge e){
        if (compareTo(e) == 0){
            return true;
        }
        else{
            return false;
        }


    }
    public Vertex getOne() {
        return this.Vertex1;
    }

    public Vertex getTwo() {
        return this.Vertex2;
    }

    public int compareTo(Edge e) {
        if (this.weight - e.weight > 0) {
            return 1;
        } else if (this.weight - e.weight == 0) {
            return 0;
        } else {
            return -1;
        }

    }
    public String toString (Edge e){
        return"{{"+ this.Vertex1.getLabel() +","+ this.Vertex2.getLabel()+"},<"+ this.weight+">}";
    }

    protected boolean VertexCheck(Vertex a, Vertex b) {
        if (a == b) {
            return true;
        } else {
            return false;
        }
    }


    public Edge(Vertex a, Vertex b) {
        this.weight = 1;
        SortinAlpha(a,b);
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setVertex1(Vertex v) {
        this.Vertex1 = v;
    }

    public void setVertex2(Vertex v) {
        this.Vertex2 = v;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex getVertex1() {
        return Vertex1;
    }

    public Vertex getVertex2() {
        return Vertex2;
    }

    public Vertex getNeighbour(Vertex v) {
        if (v == Vertex1) {
            return Vertex2;
        } if (v == Vertex2){
            return Vertex1;
        } else{ return null;}
    }
    public int hashCode(Edge e){
        String rehash = e.getVertex1().getLabel() +e.getVertex2().getLabel();
        return rehash.hashCode();

    }
    public int hashCode() {
        String unhash = this.getVertex1().getLabel() + this.getVertex2().getLabel();
        return unhash.hashCode();
    }


}
