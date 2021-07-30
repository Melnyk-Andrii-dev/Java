package ua.intita.qa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Customer {

    static private int idGlobal;
    private final int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private int cardNumber;
    private int accountNumber;


    public Customer(int id, String surname, String name, String patronymic, String address, int cardNumber, int accountNumber) {
        idGlobal++;
        this.id = idGlobal;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
    }

    public Customer() {
        idGlobal++;
        this.id = idGlobal;
    }

    public int getId() {
        return id;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", cardNumber=" + cardNumber +
                ", accountNumber=" + accountNumber +
                '}';
    }


    public static void printByAlphabet(Customer[] customers) {

        class fullName {
            String fullName;
            int idInFull;

            public fullName(String fullName, int idInFull) {
                this.fullName = fullName;
                this.idInFull = idInFull;
            }

            public String getFullName() {
                return fullName;
            }

            public void setFullName(String fullName) {
                this.fullName = fullName;
            }

            public int getIdInFull() {
                return idInFull;
            }

            public void setIdInFull(int idInFull) {
                this.idInFull = idInFull;
            }
        }

        fullName[] fullNames = new fullName[customers.length];

        int i = 0;
        for (Customer customer :
                customers) {
            fullNames[i] = new fullName(customer.getSurname() + customer.getName() + customer.getPatronymic(), customer.getId()); // customer.getSurname() + customer.getName() + customer.getPatronymic();
            i++;
        }

        System.out.println(fullNames[0].idInFull);
        System.out.println(fullNames[2].idInFull);

        Comparator<fullName> fullNameComparator
                = Comparator.comparing(fullName::getFullName);

        Arrays.sort(fullNames, fullNameComparator);

        int j = 0;
        int l = 0;
        while (true) {
            if (fullNames[l].getIdInFull() == customers[j].getId()) {
                System.out.println(customers[j].toString());
                j = 0;
                l++;
            }
            if (l == customers.length) {
                break;
            }
            j++;
        }


    }

    public static void printByCardRange(Customer[] customers) {
        Scanner scanner = new Scanner(System.in);
        int beginRange = 0;
        int endRange = 0;

        while (true) {
            System.out.println("Enter card range beginning");
            if (scanner.hasNextInt()) {
                beginRange = scanner.nextInt();
            } else {
                System.out.println("Error, enter correct number");
            }
            System.out.println("Enter card range end");
            if (scanner.hasNextInt()) {
                endRange = scanner.nextInt();
            } else {
                System.out.println("Error, enter correct number");
            }

            if (beginRange <= endRange) {
                break;
            } else {
                System.out.println("Error, enter correct number");
            }
        }

        for (Customer customer :
                customers) {
            if (customer.getCardNumber() >= beginRange && customer.getCardNumber() <= endRange) {
                System.out.println(customer.toString());
            }
        }
    }

}
