import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import com.google.common.graph.*;

public class Xandor {
    public static void main(String[] args){
        
        //Game objects
        Location spaceship = new Location("Spaceship");
        Location forest = new Location("Forest");
        Location lake = new Location("Lake");
        Location mountain = new Location("Mountain");
        Location cave = new Location("Cave");
        Location field = new Location("Field");
        Player you = new Player(spaceship);
        Map map = new Map(spaceship, forest, lake, mountain, cave, field);
        Scanner reader = new Scanner(System.in);
        Random rand = new Random();
        
        //Game variables
        boolean running = true;
        boolean success = false;

        //Game intro
        System.out.println("\n\nThe year is 3086. You are a worker for the National Outer-Worldly Colonization Organization (NOWCO), a federal organization whose job it is to search for inhabitable planets to be colonized. While exploring one of the largest galaxies, IC 1011, you suddenly lose communication with base, your comms turning to static. You receive an error message on the control panel: an unknown issue in the reactor. Unable to receive remote help, you decide your best course of action is to send a distress signal and land on the nearest planet, whose conditions are unknown. Hoping the materials you have with you will be enough to keep you alive, you head toward the hazy blue planet and set course for an unplanned landing.\n\n You are now on planet Xandor. It is your job to stay alive until help arrives.");
        System.out.println("Enter a name: ");
        you.setName(reader.nextLine());
        System.out.println("\nIn your inventory, you currently have \n" + you.printInventory()+ "\n\n From your spaceship, you notice vegetation similar to earth. In one direction is a forest and in the other a field. \n\nHow would you like to proceed?");
        
        you.setLocation(spaceship);

        //Game
        while(running){

            //Commands in forest
            String answer = reader.nextLine();
            if(answer.contains("Go to forest")){
                if(map.canMove(you.getLocation(), forest)){
                    you.setLocation(forest);
                    System.out.println("You have entered the forest. There are many sticks on the ground. You can see that there is a large tree with climbable branches.");
                }
                else{System.out.println("You cannot access the forest from your current location.");}
            }

            else if(answer.contains("Climb tree") && you.getLocation().equals(forest)){
                System.out.println("You have climbed the tree. From your vantage point you can see your spaceship, a lake, and a mountain.");
            }

            else if(you.getLocation().equals(forest) && answer.contains("Pick up sticks")){
                you.inventory.add("Sticks");
                System.out.println("Sticks have been added to your inventory");
            }

            //Commands in field
            else if(answer.contains("Go to field")){
                if(map.canMove(you.getLocation(), field)){
                    you.setLocation(field);
                    System.out.println("You have entered the field. Far ahead you can see something move.");
                }
                else{System.out.println("You cannot access the field from your current location.");}
            }

            else if(answer.contains("Investigate") && you.getLocation().equals(field)){
                System.out.println("It's some sort of large alien animal! Do you approach it?");
            }        
                    
            else if(answer.contains("Yes") && you.getLocation().equals(field)){
                System.out.println("The animal attacks! Do you run or fight back?");
            }    
                
            else if(answer.contains("Run") && you.getLocation().equals(field)){
                System.out.println("Good choice. You successfully avoid the attack.");
            }
        
            else if(answer.contains("Fight back") && you.getLocation().equals(field)){
                int roll = rand.nextInt(10);
                if(roll%2 == 0){
                    System.out.println("You successfully defeated the animal, but you don't want to run into another one.");
                }
                else{
                    System.out.println("You try to fight, but are unsuccessful. You die from the wounds.");
                    success = false;
                    break;
                }    
            }
            
            //Commands in lake
            else if(answer.contains("Go to lake")){
                if(map.canMove(you.getLocation(), lake)){
                    you.setLocation(lake);
                    System.out.println("You have reached the lake. While looking in the water, you see several figures moving around.");
                }
                else{System.out.println("You cannot access the lake from your current location.");}
            }

            else if(you.getLocation().equals(lake) && answer.contains("Take water")){
                you.inventory.add("Water");
                System.out.println("You have taken water from the lake into your container. You are very thristy");
            }
                
            else if(answer.contains("Drink water") && you.getLocation().equals(lake) && !you.inventory.contains("Filtered water")){
                you.inventory.remove("Water");
                System.out.println("You drink the water, but there it contains bacteria that is incredibly foreign and deadly. You die from infection.");
                success = false;
                break;
            }

            else if(answer.contains("Filter water") && you.getLocation().equals(lake)){
                you.inventory.remove("Water");
                you.inventory.add("Filtered water");
                System.out.println("You successfully filtered the water using your filter. You now have drinkable water in your inventory.");
            }
              
            else if(answer.contains("Investigate") && you.getLocation().equals(lake)){
                System.out.println("You look closer and see that they share a resemblance to fish. You can feel your stomach rumble. Do you attempt to grab one?");
                if(reader.nextLine().contains("Yes")){
                    boolean tryAgain = true;
                    while(tryAgain == true){
                        int roll = rand.nextInt(10);
                        if(roll%2 == 0){
                            tryAgain = false;
                            you.pickUp("Fish");
                            System.out.println("You caught the fish! It has been added to your inventory.");
                        }
                        else{
                            System.out.println("You were unsuccessful. Would you like to try again?");
                            if(reader.nextLine().contains("No")){
                                tryAgain = false;
                                System.out.println("You leave the fish after unsuccessfully trying to fish for it.");
                            }
                            else{
                                System.out.println("You try to grab the fish again.");
                            }
                        }
                    }
                }
            }

            //Commands in mountain
            else if(answer.contains("Go to mountain")){
                if(map.canMove(you.getLocation(), mountain)){
                    you.setLocation(mountain);
                    System.out.println("You have reached the mountain. You see a rocky path. Do you want to cross it?");
                }
                else{System.out.println("You cannot access the mountain from your current location.");}
            }

            else if (you.getLocation().equals(mountain) && answer.contains("Yes")){
                int chance = rand.nextInt(10);
                if(chance%2 == 0){
                    System.out.println("You just barely made it across the path. Just ahead, you notice a a dark shadow. What do you do?");
                }
                else{
                    System.out.println("You fall on the rocky path. You die from the wounds.");
                    success = false;
                    break;
                }
            }

            else if (you.getLocation().equals(mountain) && answer.contains("Investigate")){
                System.out.println("You look closer and find out that it's a cave.");
            }

            //Commands in cave
            else if(answer.contains("Go to cave")){
                if(map.canMove(you.getLocation(), cave)){
                    you.setLocation(cave);
                    if(you.inventory.contains("Sticks")){
                        System.out.println("You find that the cave is a perfect place to seek shelter for the night, because you have wood and a lighter to keep you warm. You're feeling tired.");
                    }
                    else{System.out.println("You have reached the cave, and it's a perfect shelter, but without anything to keep you warm, you won't be able to last the night.");}
                }
                else{System.out.println("You cannot access the cave from your current location.");}
            }

            else if(answer.contains("Sleep") && you.getLocation().equals(cave) && you.inventory.contains("Sticks")){
                if(you.inventory.contains("Fish")){
                    if(you.inventory.contains("Filtered water")){
                        System.out.println("You have all the resources, including just enough oxygen, to survive just long enough for help to arrive. The next few days will be hard but with food, water, shelter, warmth you will be able to survive.");
                        success = true;
                        break;
                    }
                }
                else{
                    System.out.println("You are too hungry to sleep! You must find food before falling asleep.");
                }
            }

            //Commands in spaceship
            else if(answer.contains("Go to spaceship")){
                if(map.canMove(you.getLocation(), spaceship)){
                    you.setLocation(spaceship);
                    System.out.println("You're back at the spaceship.");
                }
                else{System.out.println("You cannot access the spaceship from your current location.");}
            }

            //List of available commands
            else if(answer.contains("HELP")){
                System.out.println("# SPOILER ALERT\n Avaiblable commands:\nGo to forest.\nClimb tree.\nPick up sticks.\nGo to field.\nRun.\nFight back.\nGo to lake.\nGo to mountain.\nGo to cave.\nGo to spaceship.\nClimb tree.\nTake water.\nDrink water.\nFilter water.\nInvestigate.\nYes/No.\nSleep.");
            }

            //What prints after invalid command
            else{
                System.out.println("That command is invalid. Please try again.");
            }
        
        }
        
        if(success){
            System.out.println("Congratulations! You survived long enough for help to arrive, and in the meantime discovered a new habitable planet!");
        }
        else{
            System.out.println("Unfortunately, you died before help could arrive.");
        }

        System.out.println("Thanks for playing!");

    }
}
