class GradeValidator {
    public void checkGrade(int grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Invalid grade:" +grade);
        }
        System.out.println("Valid grade: " +grade);
    }
public static void main(String[] args) {
        GradeValidator gv = new GradeValidator();
        gv.checkGrade(85);   
        gv.checkGrade(200);  
    }
}
