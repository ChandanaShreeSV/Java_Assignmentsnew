enum Day {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5);
     private int number;
    Day(int number) {
        this.number = number;
    }
    public int getNumber() {
        return number;
    }
    public boolean isWeekend() {
        return false; 
    }
}
public class EnumDemo {
    public static void main(String[] args) {
        Day today = Day.WEDNESDAY;
        switch (today) {
            case MONDAY:
                System.out.println("Today is: MONDAY");
                break;
            case TUESDAY:
                System.out.println("Today is: TUESDAY");
                break;
            case WEDNESDAY:
                System.out.println("Today is: WEDNESDAY");
                break;
            case THURSDAY:
                System.out.println("Today is: THURSDAY");
                break;
            case FRIDAY:
                System.out.println("Today is: FRIDAY");
                break;
        }
        for (Day d : Day.values()) {
            System.out.println("Day: " + d + ", Number: " + d.getNumber());
        }
    }
}
