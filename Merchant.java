/*
∗ CSCI3180 Principles of Programming Languages
∗
∗ --- Declaration ---
∗
∗ I declare that the assignment here submitted is original except for source
∗ material explicitly acknowledged. I also acknowledge that I am aware of
∗ University policy and regulations on honesty in academic work, and of the
∗ disciplinary guidelines and procedures applicable to breaches of such policy
∗ and regulations, as contained in the website
∗ http://www.cuhk.edu.hk/policy/academichonesty/
∗
∗ Assignment 2
∗ Name : Byun Jiyeon
∗ Student ID : 1155086596
∗ Email Addr : ivjiyeon@link.cuhk.edu.hk
*/
import java.util.Scanner;

public class Merchant {
  private int elixirPrice;
  private int shieldPrice;
  private Pos pos;

  public Merchant() {
    // TODO: Initialization.
    this.elixirPrice = 1;
    this.shieldPrice = 2;
    this.pos = new Pos();
  }

  public int getElixirPrice(){
    return this.elixirPrice;
  }

  public int getShieldPrice(){
    return this.shieldPrice;
  }

  public Pos getPos() {
    return this.pos;
  }

  public void setPos(int row, int column) {
    this.pos.setPos(row, column);
  }

  public void actionOnSoldier(Task4Soldier soldier) {
    
    // TODO: Main logic.
    boolean dealEnabled = true;

    while(dealEnabled){
      // If the soldier doesn't have enough coins to buy what (s)he wants, the merchant will say "You don't have enough coins.%n%n".
      // Then, the soldier will automatically leave.
      if(soldier.getCoin()<=0){
        this.talk("You don't have enough coins.%n%n");
        dealEnabled = false;
        break;
      }
      this.talk("Do you want to buy something? (1. Elixir, 2. Shield, 3. Leave.) Input: ");

      // After the soldier successfully buys an item from the merchant, (s)he will also automatically leave.
      
      Scanner sc = new Scanner(System.in);
      String choice = sc.nextLine();

      if (choice.equalsIgnoreCase("1")) {
        soldier.getElixir(this);
        dealEnabled = false;
      } else if (choice.equalsIgnoreCase("2")) {
        if (soldier.getCoin()<2){
          this.talk("You don't have enough coins.%n%n");
          dealEnabled = false;
        } else{
          soldier.getShield(this);
          dealEnabled = false;
        }        
      } else if (choice.equalsIgnoreCase("3")) {
        dealEnabled = false;
      } else {
        System.out.printf("=> Illegal choice!%n%n");
      }      
    }
  }

  public void talk(String text) {
    System.out.printf("Merchant$: " + text);
  }

  // TODO: Other functions.
  public void displaySymbol(){
    System.out.printf("$");
  }
}