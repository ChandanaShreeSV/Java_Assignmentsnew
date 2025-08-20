class Pen {
    private int inkLevel;
    private String color;
    private String type;

    public Pen(int inkLevel, String color, String type) {
        this.inkLevel = inkLevel;
        this.color = color;
        this.type = type;
    }

    public void setInkLevel(int inkLevel) { this.inkLevel = inkLevel; }
    public void setColor(String color) { this.color = color; }

    public String toString() {
        return "Pen[InkLevel=" + inkLevel + "%, Color=" + color + ", Type=" + type + "]";
    }
}

public class Part1_PassByValueAndReference {
    public static void modifyInt(int num) {
        num += 10;
        System.out.println("Inside modifyInt: " + num);
    }
    public static void toggleBoolean(boolean flag) {
        flag = !flag;
        System.out.println("Inside toggleBoolean: " + flag);
    }
    public static void modifyPen(Pen pen) {
        pen.setInkLevel(50);
        pen.setColor("Red");
    }
    public static void modifyPenArray(Pen[] pens) {
        pens[0].setInkLevel(30);
        pens[0] = new Pen(100, "Black", "Ballpoint");
    }

    public static void main(String[] args) {
        int x = 5;
        boolean isOn = true;
        modifyInt(x);
        System.out.println("After modifyInt: " + x);
        toggleBoolean(isOn);
        System.out.println("After toggleBoolean: " + isOn);

        Pen p1 = new Pen(80, "Blue", "Gel");
        System.out.println("Before Pen modify: " + p1);
        modifyPen(p1);
        System.out.println("After Pen modify: " + p1);

        Pen[] pens = { new Pen(80, "Blue", "Gel"), new Pen(70, "Green", "Fountain") };
        System.out.println("Before array modify: " + pens[0]);
        modifyPenArray(pens);
        System.out.println("After array modify: " + pens[0]);
    }
}