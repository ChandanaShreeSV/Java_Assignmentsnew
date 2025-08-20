public final class Pen {
   
        private static int penCounter = 0; 
        private final int penID;           
    
        private int inkLevel;
        private String inkColor;
        private String tipType;
        private final String brand = "Parker";
        private boolean isCapped;
    
        public Pen() {
            this(100, "blue", "ballpoint");
        }
    
        public Pen(int inkLevel, String inkColor, String tipType) {
            this.inkLevel = inkLevel;
            this.inkColor = inkColor;
            this.tipType = tipType;
            this.isCapped = true;
            penCounter++;
            this.penID = penCounter; 
            System.out.println("[A new '" + brand + "' Pen (ID: " + penID + ") has been created on the HEAP.]");
        }
    
        public static int getPenCount() {
            return penCounter;
        }
    
        public void write(String message) {
            capOff();
            if (isCapped) {
                System.out.println("Can't write. The cap is on!");
                return;
            }
            if (inkLevel <= 0) {
                System.out.println("Out of ink! Cannot write: '" + message + "'");
                return;
            }
            System.out.println("Writing: '" + message + "' with the " + inkColor + " pen.");
            inkLevel -= message.length();
            capOn();
        }
    
        public final void checkInkLevel() {
            System.out.println("Ink level is now: " + inkLevel + "%");
        }
    
        public void setInkLevel(int inkLevel) {
            if (inkLevel >= 0 && inkLevel <= 100) {
                this.inkLevel = inkLevel;
            } else {
                System.out.println("Invalid ink level! Must be between 0-100.");
            }
        }
    
        public void changeColor(String newColor) {
            System.out.println("Changing color from " + inkColor + " to " + newColor + ".");
            this.inkColor = newColor;
        }
    
        public void refillInk(int amount) {
            if (amount <= 0) {
                System.out.println("Invalid refill amount.");
                return;
            }
            inkLevel = Math.min(inkLevel + amount, 100);
            System.out.println("Pen refilled. Current ink level: " + inkLevel + "%");
        }
    
        public String getPenDetails() {
            return "Pen ID: " + penID + ", Brand: " + brand + ", Color: " + inkColor + ", Tip: " + tipType + ", Ink Level: " + inkLevel + "%, Capped: " + isCapped;
        }
    
        private void capOn() {
            System.out.println("Click! Capping the pen.");
            isCapped = true;
        }
    
        private void capOff() {
            System.out.println("Click! Uncapping the pen.");
            isCapped = false;
        }
    }
    

