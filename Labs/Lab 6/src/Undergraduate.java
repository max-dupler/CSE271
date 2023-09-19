import java.util.ArrayList;

public class Undergraduate extends Student {

    /**
     * . constructor that calls the parent constructor
     * 
     * @param name a String type
     */
    public Undergraduate(String name) {
        super(name);
    }

    public Undergraduate(Undergraduate src) {
        this(src.name);
        super.scores = new ArrayList<Integer>(src.scores);
    }

    public boolean equals(Undergraduate check) {
        if (this.name.equals(check.name)) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Student o) {
        if (this.name.equals(o.name)) {
            if (this.getAverageScore() > o.getAverageScore()) {
                return 1;
            } else if (this.getAverageScore() < o.getAverageScore()) {
                return -1;
            } else {
                return 0;
            }
        } else {
            return this.name.compareTo(o.name);
        }
    }

    public Undergraduate clone() {
        return new Undergraduate(this);
    }
}
