
public class Main {


    public static void main(String[] args) {
        // write your code here

        Student avais=new Student("L154289","Avais Muhib Ur Rasool");
        Student talha=new Student("L154166","Talha Zubair Butt");

        avais.printInfo();
        System.out.println();
        System.out.println();

        Teacher shahwaiz=new Teacher("Shahwaiz Awais");

        shahwaiz.printInfo();
        System.out.println();
        System.out.println();

        avais.setWarningCount(1);
        avais.setWarningReasons("LowGPA");
        avais.printInfo();

        avais.gpa.computeCGPA();

        System.out.println();
        System.out.println();

        talha.printInfo();
        System.out.println();
        System.out.println();
        talha.completeClass.getClassCount();

    }
    public static abstract class Person {
        protected String name;
        protected int warningCount;
        protected String warningReasons;
        public abstract void printInfo();

        public Person() {
        }

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public interface Warning {

        public int getWarningCount();

        public void setWarningCount(int warningCount) ;


        public String getWarningReasons() ;


        public void setWarningReasons(String warningReasons) ;
    }

    public static class Student extends Person  implements Warning{

        private String rollNo;
        GPA gpa;
        Class completeClass;

        public Student(String rollNo, String name) {
            super(name);
            this.rollNo = rollNo;
            completeClass=new Student.Class();
            gpa = new GPA();
            gpa.setSemester1(1.2);


        }

        public Student() {
            super();
        }

        public String getRollNo() {
            return rollNo;
        }

        public void setRollNo(String rollNo) {
            this.rollNo = rollNo;
        }

        public int getWarningCount() {
            return warningCount;
        }

        public void setWarningCount(int warningCount) {
            this.warningCount = warningCount;
        }

        public String getWarningReasons() {
            return warningReasons;
        }

        public void setWarningReasons(String warningReasons) {
            this.warningReasons = warningReasons;
        }

        public void printInfo(){
            System.out.println("Student Info");
            System.out.println("Name : "+this.name);
            System.out.println("Roll No : "+getRollNo());
           try{
                System.out.println("Warning Count : " + getWarningCount());
                System.out.println("Warning Reasons : " + getWarningReasons());
            }  catch (Exception e){
               System.out.println("Exception Handled");
           }
        }

        public class GPA{
            private double semester1,semester2,semester3,semester4,semester5,semester6,semester7,semester8;

            public double getSemester1() {
                return semester1;
            }

            public void setSemester1(double semester1) {
                this.semester1 = semester1;
            }

            public double getSemester2() {
                return semester2;
            }

            public void setSemester2(double semester2) {
                this.semester2 = semester2;
            }

            public double getSemester3() {
                return semester3;
            }

            public void setSemester3(double semester3) {
                this.semester3 = semester3;
            }

            public double getSemester4() {
                return semester4;
            }

            public void setSemester4(double semester4) {
                this.semester4 = semester4;
            }

            public double getSemester5() {
                return semester5;
            }

            public void setSemester5(double semester5) {
                this.semester5 = semester5;
            }

            public double getSemester6() {
                return semester6;
            }

            public void setSemester6(double semester6) {
                this.semester6 = semester6;
            }

            public double getSemester7() {
                return semester7;
            }

            public void setSemester7(double semester7) {
                this.semester7 = semester7;
            }

            public double getSemester8() {
                return semester8;
            }

            public void setSemester8(double semester8) {
                this.semester8 = semester8;
            }

            public GPA() {
                semester1=0; semester2=0; semester3=0; semester4=0; semester5=0; semester6=0; semester7=0; semester8=0;
            }

            public void computeCGPA(){
                double sum=semester1+semester2+semester3+semester4+semester5+semester6+semester7+semester8;
                sum=sum/8;
                System.out.println("CGPA of "+getRollNo()+" : " +sum);
            }
        }
        public static class Class{
            public static int count=0;

            public Class() {
                count++;
            }
            public void getClassCount(){
                System.out.println("Class Count: "+count);
            }
        }
    }

    public static class Teacher extends Person implements Warning {

        public Teacher(){
            super();
        }
        public Teacher(String name){
            super(name);
        }

        public int getWarningCount() {
            return warningCount;
        }

        public void setWarningCount(int warningCount) {
            this.warningCount = warningCount;
        }

        public String getWarningReasons() {
            return warningReasons;
        }

        public void setWarningReasons(String warningReasons) {
            this.warningReasons = warningReasons;
        }

        public void printInfo(){
            System.out.println("Teacher Info");
            System.out.println("Name : "+this.name);
           try {
                System.out.println("Warning Count : " + getWarningCount());
                System.out.println("Warning Reasons : " + getWarningReasons());
            }
            catch (Exception e){
                    System.out.println("Exception Handled");
            }
        }
    }


}

