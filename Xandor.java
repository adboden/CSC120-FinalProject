import java.util.Scanner;
public class Xandor {
    public static void main(String[] args){
        Player you = new Player();
        Scanner reader = new Scanner(System.in);
        System.out.println("The year is 3086. You are a worker for the National Outer-Worldly Colonization Organization (NOWCO), a federal organization whose job it is to search for inhabitable planets to be colonized. While exploring one of the largest galaxies, IC 1011, you suddenly lose communication with base, your comms turning to static. You receive an error message on the control panel: an unknown issue in the reactor. Unable to receive remote help, you decide your best course of action is to land on the nearest planet, whose conditions are unknown. Hoping the materials you have with you will be enough to keep you alive, you head toward the hazy blue planet and set course for an unplanned landing.\n\n You are now on planet Xandor.");
        System.out.println("Enter a name: ");
        you.setName(reader.nextLine());
        System.out.println("How would you like to proceed?");

        if(you.getLocation().equals("spaceship")){

        }

        if(you.getLocation().equals("forest")){

        }

        if(you.getLocation().equals("lake")){

        }

        if(you.getLocation().equals("mountain")){

        }

        if(you.getLocation().equals("cave")){

        }

        if(you.getLocation().equals("field")){
            
        }

    }
}
