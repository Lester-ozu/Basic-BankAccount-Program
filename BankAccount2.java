public class BankAccount2 {

   private String accountNumber, accountName;
   private double balance;
   private static double interestRate;

   private Transaction[] logHistory = new Transaction[50];
   private int logCount = 0;

   public BankAccount2(String accountName, String accountNumber) {

      this.accountNumber = accountNumber;
      this.accountName = accountName;
      balance = 0.0;
   }

   public String getAccountNumber() {

      return accountNumber;
   }

   public String getAccountName() {

      return accountName;
   }

   public Transaction[] getList() {

      return logHistory;
   }

   public int getListSize() {

      int size = 0;

      for (Transaction log : logHistory) {

         if (log != null) {

            size++;
         }
      }

      return size;
   }

   public void setAccountNumber(String accountNumber) {

      this.accountNumber = accountNumber;
   }

   public void setAccountName(String accountName) {

      this.accountName = accountName;
   }

   public void setBalance(double balance) {

      this.balance = balance;
   }

   public double getBalance() {

      return balance;
   }

   public void deposit(double amount) {

      balance += amount;

      Transaction log = new Transaction("Deposit", String.valueOf(amount));
      this.addLog(log);
   }

   public boolean withdraw(double amount) {

      if (amount <= balance) {

         balance -= amount;

         Transaction log = new Transaction("Withdraw", "-" + String.valueOf(amount));
         this.addLog(log);

         return true;
      }

      else {

         return false;
      }
   }

   public static void setInterestRate(double rate) {

      interestRate = rate / 100;
   }

   public static double getInterestRate() {

      return interestRate;
   }

   public void addInterest() {

      double anotherAmount = balance * interestRate;
      balance += anotherAmount;

      Transaction log = new Transaction("Interest Earned", String.format("%.1f", anotherAmount));
      this.addLog(log);
   }

   public void addLog(Transaction log) {

      logHistory[logCount] = log;
      logCount++;
   }

   @Override
   public String toString() {

      return "Account Number: " + accountNumber +
            "\nAccount Name: " + accountName +
            "\nAccount balance: " + balance;
   }
}