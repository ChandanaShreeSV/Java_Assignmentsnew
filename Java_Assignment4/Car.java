class Car {
    private String brand;
    private String model;
    private int year;

    private Car(Builder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.year = builder.year;
    }
    public String toString() {
        return "Car{brand='" + brand + "', model='" + model + "', year=" + year + "}";
    }
    public static class Builder {
        private String brand;
        private String model;
        private int year;

        public Builder brand(String brand) {
            this.brand = brand;
            return this;
        }
        public Builder model(String model) {
            this.model = model;
            return this;
        }
        public Builder year(int year) {
            this.year = year;
            return this;
        }
        public Car build() {
            if (brand == null || brand.isEmpty()) {
                throw new IllegalArgumentException("Brand cannot be null or empty");
            }
            if (year <= 1900) {
                throw new IllegalArgumentException("Year must be > 1900");
            }
            return new Car(this);
        }
    }
    public static void main(String[] args) {
        try {
            Car car1 = new Car.Builder()
                    .brand("Toyota")
                    .model("maruthi")
                    .year(2023)
                    .build();
            System.out.println(car1);

            Car car2 = new Car.Builder()
                    .model("Unknown")
                    .year(1800)
                    .build(); 
            System.out.println(car2);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
