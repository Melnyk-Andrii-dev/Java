package ua.intita.qa;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Student {

    static private int idGlobal = 1;
    private final int id;
    private String surname;
    private String name;
    private String patronymic;
    private String dob;
    private String address;
    private String phone;
    private String faculty;
    private int courseYear;
    private String group;

    public Student(String surname, String name, String patronymic, String dob, String address, String phone, String faculty, int courseYear, String group) {
        idGlobal++;
        this.id = idGlobal;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dob = setValidDob();
        this.address = address;
        this.phone = phone;
        this.faculty = faculty;
        this.courseYear = courseYear;
        this.group = group;
    }

    public Student() {
        idGlobal++;
        this.id = idGlobal;
    }


    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = setValidDob();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(int courseYear) {
        this.courseYear = courseYear;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", faculty='" + faculty + '\'' +
                ", courseYear=" + courseYear +
                ", group='" + group + '\'' +
                '}';
    }

    public static Student[] createMas() {

        int studentsAmount;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter amount of students to input:");

        while (true) {

            if (scanner.hasNextInt())
                studentsAmount = scanner.nextInt();
            else {
                System.out.println("Error, enter correct number!");
                scanner.nextLine();
                continue;
            }
            if (studentsAmount > 0) {
                break;
            } else {
                System.out.println("Error, enter correct number!");
                scanner.nextLine();
                continue;
            }
        }

        Student[] students = new Student[studentsAmount];

        for (int i = 0; i < studentsAmount; i++) {
            System.out.println("STUDENT # " + i);
            System.out.println("Enter surname:");
            scanner.next();
            String surname = scanner.nextLine();
            System.out.println("Enter name:");
            String name = scanner.nextLine();
            System.out.println("Enter patronymic:");
            String patronymic = scanner.nextLine();
            String dob = setValidDob();
            System.out.println("Enter address:");
            String address = scanner.nextLine();
            System.out.println("Enter phone:");
            String phone = scanner.nextLine();
            System.out.println("Enter faculty:");
            String faculty = scanner.nextLine();
            int courseYear;
            while (true) {
                System.out.println("Enter year of study:");
                if (scanner.hasNextInt()) {
                    courseYear = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Error, enter correct year of study");
                }
            }
            scanner.nextLine();
            System.out.println("Enter group:");
            String group = scanner.nextLine();

            // students[i] = new Student(surname, name,patronymic,dob,address, phone, faculty, courseYear, group);
            students[i] = new Student();
            students[i].surname = surname;
            students[i].name = name;
            students[i].patronymic = patronymic;
            students[i].dob = dob;
            students[i].address = address;
            students[i].phone = phone;
            students[i].faculty = faculty;
            students[i].courseYear = courseYear;
            students[i].group = group;
        }

        return students;
    }


    public static boolean isDateValid(String date) {
        final String DATE_FORMAT = "dd.MM.yyyy";
        try {
            DateFormat df = new SimpleDateFormat(DATE_FORMAT);
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static String setValidDob() {
        System.out.println("Enter date of birth (dd.mm.yyyy)");
        String validDob;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            validDob = scanner.nextLine();
            if (isDateValid(validDob)) {
                break;
            } else {
                System.out.println("Error, enter correct date of birth");
 /*               if (scanner.hasNextLine()) {
                    scanner.next();
                    validDob = scanner.nextLine();
                }*/
            }
        }
        return validDob;
    }

    public static void printByFaculty(Student[] students) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter faculty to search:");
        String faculty = scanner.nextLine();
        for (Student student : students) {
            if (student.faculty.toString().equals(faculty)) {
                System.out.println(student.toString());
            }
        }
    }


    public static void printByFacultyAndYear(Student[] students) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter faculty to search:");
        String faculty = scanner.nextLine();
        System.out.println("Enter year to search (among given faculty):");
        int year;
        while (true) {
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year < 0) {
                    System.out.println("Error, enter correct year");
                    scanner.next();
                    continue;
                }
                break;
            } else {
                System.out.println("Error, enter correct year");
                scanner.next();
            }
        }
        for (Student student : students) {
            if (student.faculty.toString().equals(faculty) && student.courseYear == year) {
                System.out.println(student.toString());
            }
        }
    }

    public static void printAfterDobYear(Student[] students) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter year to search (born after given year):");
        int year;
        while (true) {
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                year++;
                if (year < 0) {
                    System.out.println("Error, enter correct year");
                    scanner.next();
                    continue;
                }
                break;
            } else {
                System.out.println("Error, enter correct year");
                scanner.next();
            }
        }
        String givenYear = String.valueOf(year);
        String dobYear;
        int dobYearInt;


        for (Student student : students) {
            dobYear = student.dob.substring(6, 10);
            dobYearInt = Integer.parseInt(dobYear);

            if (year <= dobYearInt) {
                System.out.println(student.toString());
            }
        }
    }

    public static void printByGroup(Student[] students) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter group to search:");
        String group = scanner.nextLine();
        for (Student student : students) {
            if (student.group.toString().equals(group)) {
                System.out.println(student.toString());
            }
        }
    }


}