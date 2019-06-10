package main;

import java.util.*;

public class TicTacToe{
public static int[][] ticbox;
	public static int win(int [][]tic) {
		//check all rows
		//loop through rows from 0 to 3 and check if all the 3 places have same marks
		int k=0;
 		for(int i=0;i<3;i++)
 		{
 			int j=0;
 				if(tic[i][j]==tic[i][j+1]&&tic[i][j]!=0)
 				{
 					if(tic[i][j]==tic[i][j+2])
 					{
 						k=1;
 					}
 				}
 		}
		//check all cols
		//loop through columns from 0 to 3 and check if all the 3 places have same marks
 		for(int i=0;i<3;i++)
 		{
 			int j=0;
 				if(tic[j][i]==tic[j+1][i]&&tic[j][1]!=0)
 				{
 					if(tic[j][i]==tic[j+2][i])
 					{
 						k=1;
 					}
 				}
 		}
		//check both diagonals 
 		for(int i=0;i<1;i++)
 		{
 				if(tic[i][i]==tic[i+1][i+1]&&tic[i][i]!=0)
 				{
 					if(tic[i][i]==tic[i+2][i+2])
 					{
 						k=1;
 					}
 				}
 		}
 		for(int i=2;i<3;i++)
 		{
 				if(tic[i][i]==tic[i-1][i-1]&&tic[i][i]!=0)
 				{
 					if(tic[i][i]==tic[i-2][i-2])
 					{
 						k=1;
 					}
 				}
 		}
		
		//write your code here !!!
		if(k==0)
		{
		    return 0;
		}
		else
		{
			return 1;
		}
		
	}
	
	public static void printBox(int [][]tic) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(tic[i][j]);
			}
			System.out.println("");
		}
	}
	public static boolean validate(int a1,int a2,int [][] tic) {
		//check if a1 is between 0 & 3
		if(a1>=0&&a1<3&&a2>=0&&a2<3)
		{
			if(tic[a1][a2]==0)
			{
				return true;
			}
		}
		//check if a2 is between 0 & 3
		//check if the selected box is empty ie, already not marked by other player
		//if all checks passed return true.
		return false;
				//Write your code here !!!
	}
	public static void main(String args[]) {
		
		ticbox = new int[3][3];
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				ticbox[i][j] = 0;
			}
		}
		
		 int chk = win(ticbox);

		boolean turn= true;
		int limit = 9;
		while(chk==0 && limit > 0) {
			//if true player 1	
			if(turn) {
				System.out.println("Player 1 Enter the box number");
				printBox(ticbox);
				Scanner sc = new Scanner(System.in);
				int a1 = sc.nextInt();
				int a2 = sc.nextInt();
				boolean valid = validate(a1,a2,ticbox);
				if(valid) {
					ticbox[a1][a2] = 1;
					chk = win(ticbox);
					turn = false;
					limit --;
				}
				else {
					System.out.println("Please enter a valid position!!");
				}
			}else {
				System.out.println("Player 2 Enter the box number");
				printBox(ticbox);
				Scanner sc = new Scanner(System.in);
				int a1 = sc.nextInt();
				int a2 = sc.nextInt();
				boolean valid = validate(a1,a2,ticbox);
				if(valid) {
				ticbox[a1][a2] = 2;
				chk = win(ticbox);
				turn = true;
				limit --;
				}
				else {
					System.out.println("Please enter a valid position!!");
				}
			}
			
			
			//if false player 2 
		}
		
		if(chk!=0) {
			System.out.println("The winner is Player "+chk);
		}else {
			System.out.println("Its a draw match!!");
		}
		
	}
}