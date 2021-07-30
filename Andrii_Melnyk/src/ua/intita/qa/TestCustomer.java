package ua.intita.qa;

public class TestCustomer {
    public static void main(String[] args) {
        Customer[] customers = new Customer[5];
        customers[0] = new Customer();
        customers[0].setName("abc");
        customers[0].setSurname("aaa");
        customers[0].setPatronymic("baa");
        customers[0].setCardNumber(105);
        customers[1] = new Customer();
        customers[1].setName("abb");
        customers[1].setSurname("baa");
        customers[1].setPatronymic("caa");
        customers[1].setCardNumber(1055);
        customers[2] = new Customer();
        customers[2].setName("aac");
        customers[2].setSurname("aba");
        customers[2].setPatronymic("bba");
        customers[2].setCardNumber(1057777);
        customers[3] = new Customer();
        customers[3].setName("acc");
        customers[3].setSurname("caa");
        customers[3].setPatronymic("caa");
        customers[3].setCardNumber(10);
        customers[4] = new Customer();
        customers[4].setName("cbc");
        customers[4].setSurname("cca");
        customers[4].setPatronymic("caa");
        customers[4].setCardNumber(10574);

        Customer.printByAlphabet(customers);
        Customer.printByCardRange(customers);
    }
}
