public class TestDemo {

    public static void main(String[] args) {
        Pen myPen = new Pen(100, "green", "ballpoint");
        myPen.write("Hello");
        myPen.checkInkLevel();
        myPen.changeColor("red");
        myPen.write("Writing in red");
        myPen.refillInk(20);
        System.out.println(myPen.getPenDetails());

        PenBox box = new PenBox();
        box.addPen(myPen);
        box.addPen(new Pen(80, "blue", "gel"));
        box.listAllPens();
        box.findPenByColor("blue");
    }
    
}
