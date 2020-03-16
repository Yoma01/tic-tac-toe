//Akoni Ogheneyoma
//oxa180001
package exercise_2;
import java.util.Scanner;

public class Exercise_2 
{
   
    public static void main(String[] args)
    {
      char [][] tic_tac = new char [3][3];
      Scanner user = new Scanner(System.in);
      Empty_board();
      int row, col;
      boolean win_check;
      boolean draw;
     //assigns spaces to the board
      for(int j = 0; j < 3; j++)
      {
          for(int k = 0; k < 3; k++)
          {
              tic_tac[j][k] = ' ';
          }
      }
      // the loop calls alll the respective functions until the board is full or a winner emerges
      do
      {
        System.out.println("Enter a row(0,1, or 2 ) for player x:");
        row= user. nextInt();
        System.out.println("Enter a col(0,1, or 2 ) for player x:");
        col= user.nextInt();
        boolean double_checker = check_double(tic_tac, row, col);
        while(double_checker == false)
        {
            System.out.println("Enter a row(0,1, or 2 ) for player x:");
            row= user. nextInt();
            System.out.println("Enter a col(0,1, or 2 ) for player x:");
            col= user.nextInt();
            double_checker = check_double(tic_tac, row, col);
        }
        tic_tac[row][col] = 'x';
        display_board(tic_tac);
        win_check = winner(tic_tac);
        draw = A_draw(tic_tac);
        if(draw == true)
        {
            System.out.println("IT IS A DRAW");
            System.out.println("GAME OVER");
            break;
        }
        if(win_check == true)
        {
            System.out.println("X Player won");
            break;
        }
        System.out.println("Enter a row(0,1, or 2 ) for player o:");
        row= user. nextInt();
        System.out.println("Enter a col(0,1, or 2 ) for player o:");
        col= user.nextInt();
        boolean double_o_check= check_double(tic_tac, row, col);
        while(double_o_check == false)
        {
            System.out.println("Enter a row(0,1, or 2 ) for player o:");
            row= user. nextInt();
            System.out.println("Enter a col(0,1, or 2 ) for player o:");
            col= user.nextInt();
            double_o_check = check_double(tic_tac, row, col); 
        }
        tic_tac[row][col] = 'o';
        display_board(tic_tac);
        win_check = winner(tic_tac);
        draw = A_draw(tic_tac);
        if(win_check == true)
        {
            System.out.println("O Player won");
        }
        if(draw == true)
        {
            System.out.println("IT IS A DRAW");
            System.out.println("GAME OVER");
            break;
        }
      }while( win_check == false);
      
      System.out.println("You won");
    }
    //displays the empty board
    public static void Empty_board()
    {
        System.out.println("____________________");
       
        for(int i = 0; i < 3; i++)
        {
            System.out.println("|     |     |     |");
            System.out.println("____________________");
        }
    }
    //updates and displays the board
    public static void display_board( char [][] tic_tac)
    {
       System.out.println("____________________");
       for(int i = 0; i < 3; i++)
       {
            for(int j = 0; j < 3; j++)
            {
                System.out.print("|  " + tic_tac[i][j]+"  ");
            }
            System.out.println("|");
            System.out.println("____________________");
       }
    }
    // checks if the three arrays are the same and is called in the other functions
    public static boolean check( char p_1, char p_2, char p_3)
    {
        
        if((p_1 != ' ') &&(p_1==p_2) && (p_2 == p_3))
        {
           
            return true;
        }
        else
        {
            return false;
        }
    }
         // this checks if it is the same horizontaly and returns true
    public static boolean horizontal(char [][] tic_tac)
    {
       
        for(int i =0; i <3; i++)
        {
            if(check(tic_tac[i][0], tic_tac[i][1], tic_tac[i][2]) == true)
            {
                System.out.println("hor");
                return true;
            }
           
        }
        return false;
    }
     // this checks if it is the same vertically and returns true
    public static boolean vertical(char[][] tic_tac)
    {
        
        for(int i= 0; i < 3; i++)
        {
            if(check(tic_tac[0][i], tic_tac[1][i], tic_tac[2][i]) == true)
            {
                return true;
            }
        }
        return false;
    }
     // this checks if one of the diagonals is the same and returns true
    public static boolean diagonal1(char[][] tic_tac)
    {
       
        if(check(tic_tac[0][0], tic_tac[1][1], tic_tac[2][2])== true)
        {
            return true;
        }
        return false;
    }
    // this checks if one of the diagonals is the same and returns true
    public static boolean diagonal2(char[][] tic_tac)
    {
        
        if(check(tic_tac[0][2], tic_tac[1][1], tic_tac[2][0])== true)
        {
            return true;
        }
        return false;
    }
    // this checks for diagonal1, diagonal2, vertical and horizontal, if any is true, a winner has emerged
    public static boolean winner(char[][] tic_tac)
    {
        if(vertical(tic_tac) || horizontal(tic_tac) || diagonal1(tic_tac)|| diagonal2(tic_tac) == true)
        {
            return true;
        }
        return false;
    }
    // this checks if the array is ful with x and o that is if there is no more space in the array.
    //if there is none it returns false meaning it is full
    public static boolean A_draw(char[][] tic_tac)
    {
        boolean tie = true;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                if(tic_tac[i][j] == ' ')
                {
                    tie = false;
                }
            }
        }
        return tie;
    }
    // this function checks if there is already a value of x or o in the array and returns false or true
    public static boolean check_double(char [][] tic_tac, int row, int col)
    {
        boolean checker = true;
        if(tic_tac[row][col] == 'x' || tic_tac[row][col] == 'o')
        {
            checker = false;
        }
        return checker;
    }
}
