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
public class Task4Soldier extends Soldier {
    private int coin;
    private int numShield;
    private int defence;

    public Task4Soldier(){
        super();
        this.coin = 0;
        this.numShield = 0;
        this.defence = 0;
    }

    public int getCoin(){
        return this.coin;
    }
    public void addCoin(){
        this.coin += 1;
    }

    public void getElixir(Merchant merchant){
        this.coin -= merchant.getElixirPrice();
        this.addElixir();
    }

    public void getShield(Merchant merchant){
        this.coin -= merchant.getShieldPrice();
        this.addShield();
        this.setDefence();
    }

    public void setDefence(){
        this.defence = this.numShield * 5;
    }

    public void addShield(){
        this.numShield += 1;
    }

    public boolean loseHealth(){
        if(this.defence<=10){
            this.health -= (10-this.defence);
        } else{
            this.health -= 0;
        }
        
        return this.health<=0;
    }

    public void displayInformation(){
        super.displayInformation();
        System.out.printf("Defence: %d.%n", this.defence);
        System.out.printf("Coin: %d.%n", this.coin);
    }
}
