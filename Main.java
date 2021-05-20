import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        // system objects 

        Scanner inp = new Scanner(System.in);
        Random rand = new Random();

        // GAme Variable

        String[] enemies = {"Warrior MAgadenaus" ,"Queen NATASHA","King Crypus" ,"Princess Naila" } ;
        int maxEnemyHealth = 75 ;
        int enemyAttackDamage = 25 ; 

        // play variables

        int health = 100 ;
        int attackDamage = 30 ;
        int numHealthPotions = 3;
        int healthpotionHealAmount = 30 ;
        

        boolean running = true ;

        System.out.println("Welcome to the BladeX");
        Game:
        while(running){
         System.out.println("----------------------------------------------------");
            
         int enemyHealth = rand.nextInt(maxEnemyHealth);
         String  enemy = enemies[rand.nextInt(enemies.length)];

         System.out.println("\t#"+ enemy + "\t appeared! # \n" );

            while(enemyHealth > 0){
                System.out.println("\t Your HP:"+ health);
                System.out.println("\t"+ enemy + "'s HP:"+ enemyHealth);
                System.out.println("\n What would You like to do ?");
                System.out.println("\t 1 ATTACK");
                System.out.println("\t 2 Drink Health Potion");
                System.out.println("\t 3 RUN !");

                String input = inp.nextLine();

                if(input.equals("1")){

                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);
                    enemyHealth -= damageDealt ;
                    health -= damageTaken ;
                    System.out.println("\t You Striked the "+ enemy +" for"+ damageDealt+" damage");
                    System.out.println("\t You retaliated the "+ enemy + " by" +damageTaken +" Damage  in retaliation");
                    
                    if(health < 1){
                        System.out.println("\t> You cannot fight more ! you have been Defeated by the King !");
                        break;
                    } 


                }
                else if (input.equals("2")){
                    if(numHealthPotions > 0 ){
                        health += healthpotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t> You drinked a health potion , healing yourself for " + healthpotionHealAmount
                        +"\n \t>You now have "+health +"HP"
                        +"\n \t>You have now "+ numHealthPotions + " HealthPotions left.\n");
                    }
                }
                else if(input.equals("3")){
                    System.out.println("\t> You have choosen to RUN from the"+ enemy +" your fate is in the Mystery Box");
                    continue Game;

                }
                else{
                    System.out.println("You did not pick the option we gave you !");
                }
            }

            if(health < 1){
                System.out.println("the"+enemy+ "defeated you");
                break;
            }

            System.out.println("----------------------------------------------------");
            System.out.println("#"+enemy+" was defeated #");
        }
            inp.close(); 
        System.out.println("You have succesfully completed the game uptil the current version hold !");
    }
}
