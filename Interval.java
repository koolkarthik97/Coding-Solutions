public class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }


    public boolean equals(Interval obj) {
        return (this.start == obj.start && this.end == obj.end) || (this.start == obj.end && this.end == obj.start);
    }
}