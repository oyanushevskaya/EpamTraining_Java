package classes;

import java.math.BigInteger;
import java.util.Objects;

public class Customer implements Comparable<Customer> {
    private long customerId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private long numberCreditCard;
    private BigInteger numberBankAccount;

    public Customer() {
        super();
    }

    public Customer(long customerId, String lastName, String firstName, String middleName, String address, long numberCreditCard, BigInteger numberBankAccount) {
        this.customerId = customerId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.numberCreditCard = numberCreditCard;
        this.numberBankAccount = numberBankAccount;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setNumberCreditCard(long numberCreditCard) {
        this.numberCreditCard = numberCreditCard;
    }

    public long getNumberCreditCard() {
        return numberCreditCard;
    }

    public void setNumberBankAccount(BigInteger numberBankAccount) {
        this.numberBankAccount = numberBankAccount;
    }

    public BigInteger getNumberBankAccount() {
        return numberBankAccount;
    }

    @Override
    public int compareTo(Customer o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId &&
                numberCreditCard == customer.numberCreditCard &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(middleName, customer.middleName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(address, customer.address) &&
                Objects.equals(numberBankAccount, customer.numberBankAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, middleName, lastName, address, numberCreditCard, numberBankAccount);
    }

    @Override
    public String toString() {
        return customerId + ": " + lastName + " " + firstName + " " + middleName +
                "    Address: " + address + "    Credit card number:  " + numberCreditCard +
                "   Bank account number: " + getNumberBankAccount().toString();
    }


}
