import java.util.Objects;

public class Market {
    String company;
    String type;
    int start;
    int end;

    Market() {
        company = "";
        type = "";
        start = 0;
        end = 0;
    }

    public Market(String company, String type, int start, int end) {
        this.company = company;
        this.type = type;
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Market market = (Market) o;
        return Objects.equals(company, market.company) &&
                Objects.equals(type, market.type);
    }

    @Override
    public String toString() {
        return "Market{" +
                "company='" + company + '\'' +
                ", type='" + type + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
