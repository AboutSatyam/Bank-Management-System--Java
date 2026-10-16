package bank.model;


public class Account {
    private long accountNumber;
    private String holderName;
    private double accountBalance;

    public Account(long accountNumber, String holderName, double accountBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.accountBalance = accountBalance;
    }

    public void displayAccountDetails() {
        System.out.println("");
        System.out.println("--------------------      Customer Details      --------------------");
        System.out.println(" Account Number: " + accountNumber);
        System.out.println(" Account Balance: " + accountBalance);
        System.out.println(" Holder Name: " + holderName);

    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public double deposit(int amount) {
        if (amount >= 100) {
            accountBalance += amount;
            System.out.println("Deposit Sucuessful  " + amount);
            System.out.println("Updated Balance Is  " + accountBalance);
        } else {
            System.out.println("Deposit Failed. Minimum deposit amount is 100");
        }
        return accountBalance;
    }

    public double withdrawal(int amount) {

        if (accountBalance >= amount && amount >= 100) {
            accountBalance -= amount;
            System.out.println("Withdrawal Sucuessful  " + amount);
            System.out.println("Updated Balance Is  " + accountBalance);
        } else {
            System.out.println("Withdrawal Failed. Minimum Withdrawal amount is 100" + ", Because Sufficient Balance Required  ");
        }
        return accountBalance;
    }

}
