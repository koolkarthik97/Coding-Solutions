public class Display {
    String mode;
    String company;
    String type;
    int val;

    public Display(String mode, String company, String type, int val) {
        this.mode = mode;
        this.company = company;
        this.type = type;
        this.val = val;
    }

    @Override
    public String toString() {
        return mode + "," + company + "," + type + "," + val;
    }
}
