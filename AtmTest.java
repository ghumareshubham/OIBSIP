
public class AtmTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Account account1 = new Account(123, 10000, 101, 1111);
        Account account2 = new Account(234, 20000, 102, 2222);

        ATM atm = new ATM();
        atm.addAccount(account1);
        atm.addAccount(account2);

        atm.start();

	}
}
