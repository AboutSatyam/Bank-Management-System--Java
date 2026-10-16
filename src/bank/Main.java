package bank;

import bank.model.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Account> acc = new ArrayList<>();

        // Sample customers
        acc.add(new Account(1000, "Hit Satyam", 1000.0));
        acc.add(new Account(1001, "Harivansh Mahaphabu", 1000.0));
        acc.add(new Account(1002, "Sevak Ju", 1000.0));
        while (true) {
            System.out.println("\n===== HIT BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. New Customer");
            System.out.println("2. Display All Customers");
            System.out.println("3. Search Customer");
            System.out.println("4. Display Balance");
            System.out.println("5. Deposit Money");
            System.out.println("6. Withdraw Money");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            String choice = input.nextLine();

            switch (choice) {

                case "1": {
                    System.out.print("Enter Account Number: ");
                    long number = Long.parseLong(input.nextLine());

                    if (findAccount(acc, number) != null) {
                        System.out.println("Account number already exists.");
                        break;
                    }

                    System.out.print("Enter Customer Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Opening Balance: ");
                    double balance =
                            Double.parseDouble(input.nextLine());

                    if (balance < 0) {
                        System.out.println(
                                "Opening balance cannot be negative.");
                        break;
                    }

                    Account newAccount =
                            new Account(number, name, balance);

                    acc.add(newAccount);

                    System.out.println(
                            "Customer created successfully!");
                    break;
                }

                case "2":
                    if (acc.isEmpty()) {
                        System.out.println("No customers found.");
                    } else {
                        for (Account elem : acc) {
                            elem.displayAccountDetails();
                        }
                    }
                    break;

                case "3": {
                    Account selected = searchAccount(acc, input);

                    if (selected != null) {
                        selected.displayAccountDetails();
                    }
                    break;
                }

                case "4": {
                    Account selected = searchAccount(acc, input);

                    if (selected != null) {
                        System.out.println(
                                "Current Balance: "
                                        + selected.getAccountBalance());
                    }
                    break;
                }

                case "5": {
                    Account selected = searchAccount(acc, input);

                    if (selected != null) {
                        System.out.print("Enter deposit amount: ");
                        int amount =
                                Integer.parseInt(input.nextLine());

                        selected.deposit(amount);
                    }
                    break;
                }

                case "6": {
                    Account selected = searchAccount(acc, input);

                    if (selected != null) {
                        System.out.print("Enter withdrawal amount: ");
                        int amount =
                                Integer.parseInt(input.nextLine());

                        selected.withdrawal(amount);
                    }
                    break;
                }

                case "7":
                    System.out.println(
                            "Thank you for using Hit Bank System.");
                    input.close();
                    return;

                default:
                    System.out.println(
                            "Invalid choice. Please try again.");
            }
        }
    }

    static Account findAccount(
            ArrayList<Account> accounts, long number) {

        for (Account elem : accounts) {
            if (elem.getAccountNumber() == number) {
                return elem;
            }
        }

        return null;
    }

    static Account searchAccount(
            ArrayList<Account> accounts, Scanner input) {

        System.out.print("Enter Account Number: ");
        long number = Long.parseLong(input.nextLine());

        Account selected = findAccount(accounts, number);

        if (selected == null) {
            System.out.println("Account not found.");
        }

        return selected;
    }
}
