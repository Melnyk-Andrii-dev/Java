package ua.intita.qa;

public class TestStudent {
    public static void main(String[] args) {
        Student[] students = Student.createMas();

        System.out.println("YOUR INPUT:");
        for (Student student :
                students) {
            System.out.println(student.toString());
        }

        Student.printByFaculty(students);
        Student.printByFacultyAndYear(students);
        Student.printAfterDobYear(students);
        Student.printByGroup(students);

    }
}
