import java.util.ArrayList;

public class PenBox {
    private ArrayList<Pen> pens = new ArrayList<>();

    public void addPen(Pen pen) {
        pens.add(pen);
        System.out.println("Pen added to the box.");
    }

    public void removePen(int index) {
        if (index >= 0 && index < pens.size()) {
            pens.remove(index);
            System.out.println("Pen removed from the box.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void listAllPens() {
        for (Pen pen : pens) {
            System.out.println(pen.getPenDetails());
        }
    }

    public Pen findPenByColor(String color) {
        for (Pen pen : pens) {
            if (pen.getPenDetails().toLowerCase().contains(color.toLowerCase())) {
                System.out.println("Pen found: " + pen.getPenDetails());
                return pen;
            }
        }
        System.out.println("No pen found with color: " + color);
        return null;
    }
}
    

