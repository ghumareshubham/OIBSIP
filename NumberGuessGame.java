import java.util.Scanner;

public class NumberGuessGame {

	public static void main(String[] args) {
		int count=1; //count for round
		gussingNumberGame(count);

	}
	
	
	private static void gussingNumberGame(int count) {
		
		Scanner sc =new Scanner(System.in);
//		int numFind=1+(int)(100*Math.random());
		int numFind=50;
		
//		System.out.println(numFind);
		
		int k=5; //trial for user
		
		int i, guess;
		
		
		System.out.println("******************************GAME STARTED*******************************");
		System.out.println("Choose the Number Between 1-100:");
		
		System.out.println("*****************************ROUND "+count+"******************************");

		
		for( i=0; i<k ; i++) {
			
			System.out.println("You have "+(k-i)+" attempts left....");
			System.out.print("Guess the Number :");
			guess=sc.nextInt();
			
			if(numFind==guess) {
				System.out.println("_____________________________________________________________________________");
				System.out.println(">>>>>>>>>>>>Congratulation..! You Cleared Round "+count+">>>>>>>>>>>>>>>");
				scoreCard(i,k,count);
				if(count<3) {
					count++;
					gussingNumberGame(count);
				}
				else {
					System.out.println(">>>>>>>>>>>>>>>>>>>>>..>>>>>Congrats......!You Cleared All Round.>>>>>>>>>>>>>>>>>>>>>>>>>>");
					break;
				}
				
			
				

			break;
			}
			else if(numFind<guess){
				System.out.println("The Number is Less than "+ guess);
				System.out.println("_______________________________________________");

				
			}
			else if(numFind>guess) {
				System.out.println("The Number is Greater than "+ guess);
				System.out.println("________________________________________________");

			}
			
		}
		
		if(i==k) {
			System.out.println("You Exhausted Your "+k+" trails.");
			System.out.println(">>>>>>>>>>GAME OVER >>>>>>>>>>>>>>");
			scoreCard(i,k,count);
			System.out.println("To restart Game press y or to exit press n : ");
			Scanner sc1=new Scanner(System.in);
			String endOrNot=sc1.nextLine();	//user have to press y to continue game or press n to exit game		
			if(endOrNot.equalsIgnoreCase("y")) {
				count=1;
				gussingNumberGame(count
						);
				
			}else {
				System.out.println("Thank you for Visiting...");
			}
			
		}
		
		
	}
	
	
	private static void scoreCard(int attempt, int k, int count) {
		
		int score=(k-attempt)*20;
		int points=(k-attempt)*10;
		
		System.out.println("Your Score I"
				+ "n Round "+count+" Is :"+score);
		System.out.println("Your Point In Round "+count+" Is :"+points);
	}
	
}
