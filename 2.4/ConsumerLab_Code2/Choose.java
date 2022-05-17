/*
 Project Title: Choose Your Own Adventure
 Group: Jordan Morris, Justin Zhou
 Period 4
 Precondition(s): User must type in a valid response.
 Postcondition(s): Story will be presented to the user. The user will most likely be prompted to put in another input.
 */
import java.util.Scanner; //Import the scanner class

public class Choose
{
static Scanner jc = new Scanner(System.in);
//new scanner object
public static String getUserInput(String a, String b) {
   Scanner sc = new Scanner(System.in);
  
   //asks user for the user to input a string
   System.out.println("Enter either " + a + " or " + b);

   //records what the user types
   String userInput = sc.nextLine();

   //closes scanner just kidding lol
  

   //returns the user's input as a string
   return userInput;
}  

public static int poseQuestion(String question, String possibleResponseA, String possibleResponseB) {
  System.out.println(question);
  String userChoice = getUserInput(possibleResponseA, possibleResponseB);
  if (userChoice.equalsIgnoreCase(possibleResponseA)) {
    return 1;
  }
  else if (userChoice.equalsIgnoreCase(possibleResponseB)) {
    return 2;
  }
  else { 
    System.out.println("You must type in one of the two options!");
    return 3;
  }
}

public static void main(String[] args) 
  {
    /* TO DO: 
    9 Possible paths (need more paths)
    Print statements depending on current and previous choices
    Else if
    */

    //Create answer variable
    String answer;
    //which inital path is taken
    boolean penguinPath = false;
    //See if answer is valid
    boolean isValid = false;
    System.out.println("You enter the sacred igloo and immediately black out after experiencing a penetrating headache.");
    System.out.println("You wake up and look down to see that your hands have turned to flippers");
    //String test = sc.nextLine();
    //System.out.println(test);
    /*
    while (!isValid) {
      System.out.println("Do you accept your new life as a small adorable penguin (Y) or do you try to change back into a human (N)?");
      answer = jc.nextLine().toUpperCase();
      //Compound boolean expression
      if (answer.equals("Y") || answer.equals("N")) {
        isValid = true;       
        //Nested if #1   
        if (answer.equalsIgnoreCase("Y")) { 
          System.out.println("Hooray! Welcome to a life of fish, feathers, and flippers!");
          penguinPath = true;
        }
        //Nested if #2
        if (answer.equalsIgnoreCase("N")) {
          System.out.println("Yeah penguins to smell pretty bad, understandable.");
          penguinPath = false;
        }
      }
    }
    */
    //more legible code starts
    int userResult = 3;
  
    while (userResult == 3) {
      userResult = poseQuestion("Do you want to stay a penguin (1) or try to become human again (2)?", "1", "2");
    }

    //Path of the Penguin-Embracer
    if (userResult == 1) {
      userResult = 3;
      while (userResult == 3) {
        userResult = poseQuestion("Your first big decision as an adorable itty bitty penguin is to either grab some food from the fish pile (1) or go talk with a chattering group of penguins (2)?", "1", "2");
      }
      //1-1
      if (userResult == 1) {
        userResult = 3;
        System.out.print("Feeling a bit 'peckish', you waddle over to the massive fish pile, grab yourself a mackerel");
        System.out.println(" and make small talk with some other hungry penguins.");
        System.out.println("They are talking about either going for a swim or maybe going to the Snow Ampitheater.");
        while (userResult == 3) {
          userResult = poseQuestion("Do you decide to go for a relaxing swim (1) or go catch a show at the Ampitheater (2)?", "1", "2");
        }

        //1-1-1 Ending 
        if (userResult == 1) {
          userResult = 3;
          System.out.print("You find that immediately your choice to stay as a penguin has paid off because ");
          System.out.print("the cool water under your wings is complimented by the feeling of gliding underwat- aaaaaaaaand a sea lion");
          System.out.println(" just ate you...");
        }
        //1-1-2 Ending
        else if (userResult == 2) {
          userResult = 3;
          System.out.print("The water looks a little too cold for you and so you go watch Happy Feet at the Ampitheater, going on");
          System.out.print(" to become a renowned penguin actor after the inspiring performance. Who could have guessed your");
          System.out.println(" life would turn out this way?");
        }
      }
      //1-2
      else if (userResult == 2) {
        userResult = 3;
        System.out.print("You roll on over to the cool looking group of penguins, they seem to be talking about going to the ice");
        System.out.println(" rink or possibly do some cool penguin tricks.");
        while (userResult == 3) {
          userResult = poseQuestion("Do you go to the ice rink (1) or do some cool penguin tricks (2)", "1", "2");
        }

        //1-2-1 Ending
        if (userResult == 1) {
          userResult = 3;
          System.out.println("You impress all the penguins with your epic fails at ice skating.");
        }
        //1-2-2 Ending
        else if (userResult == 2) {
          userResult = 3;
          System.out.println("Your cool backlip is overshadowed by Timothy the Cool Penguin breakdancing while the rest of the penguins do flipper handstands.");
        }
      }
    }

    //Path back to Humanity
    else if (userResult == 2) {
      userResult = 3;
      System.out.println("Starting your journey back to having opposable thumbs, you see a group of chattering penguins and the cool, deep waters of the ocean");
      
      //2 Decider
      while (userResult == 3) {
        userResult = poseQuestion("Walk to the group of penguins (1) or search for a solution in the ocean (2)?", "1", "2");
      }

      //2-1
      if (userResult == 1) {
        userResult = 3;
        System.out.println("You walk over to the group of penguins, skeptical in your squawks as you only Minored in Penglish while in college.");
        System.out.println("To your surprise, they seem to be speaking fluent English (very convenient). As you are a no nonsense once-human-penguin, you ask the most important looking penguin why you were forced to changed species.");
        System.out.println("Jerold the Penguin tells you that the Bluish Orb of Penguins was accidentally left in the igloo you walked in to, which turned you into a penguin.");
        
        //2-1 Decider
        while (userResult == 3) {
          userResult = poseQuestion("Do you go back and search the igloo for the orb (1) or do you search for another possible way to turn back into a human (2)?", "1", "2");
        }

        //2-1-1 Ending
        if (userResult == 1) {
          userResult = 3;
          System.out.println("You waddle back to your igloo and start digging through a very suspicious mound of snow with a cool looking glow.");
          System.out.println("After an agonizing amount of flipper-shoveling, you finally recover the amazing blue orb and in a blinding flash of light....nothing happens!");
          System.out.println("But fear not because Jerold, now aged and dying (because you took so long digging alone, maybe if you weren't so focused on becoming human again you would have made some cool and helpful penguin friends).");
          System.out.println("He sacrifices the small amount of life force in his body to activate the orb, finally turning you back into a grateful and enlightened human.");
        }
        //2-1-2 Ending
        else if (userResult == 2) {
          userResult = 3;
          System.out.println("You gather up a group of helpful and chivalrous penguins to help you find Jerold's Potion of Plucking.");
          System.out.println("After 15 min of dutiful searching, a purple potion is presented to you and you tearfully wave goodbye to your new friends, forever grateful for this experience as a penguin...now a human once again.");
        }
      }

      //2-2
      else if (userResult == 2) {
        userResult = 3;
        System.out.println("Readying your feathers for a dive into the frigid waters, you give out a squawk and plunge into the ocean.");
        System.out.println("To your surprise, you have not immediately gone into shock. You eagerly search for some sort of underwater clue back to humanity.");

        //2-2 Decider
        while (userResult == 3) {
          userResult = poseQuestion("Do you search the nearby Underwater Temple (1) or do you investigate the Ancient Sea Lion Graveyard (2)?", "1", "2");
        }

        //2-2-1 Ending
        if (userResult == 1) {
          userResult = 3;
          System.out.println("You swim rather quickly to the temple to find it decorated with penguin offerings of fish carvings and wooden flippers.");
          System.out.println("On the altar you see a smiling (what you assume to be) statue of a penguin god. You float over to the altar and get hit by a flash of blue light.");
          System.out.println("You wake up and see that you are once again human. You look back on your experience and realize that you were a penguin. You are now crazy.");
        }
        //2-2-2 Ending
        else if (userResult == 2) {
          System.out.print("After sneaking into the middle of the Sea Lion Graveyard (you were a ninja marine biologist as a human)");
          System.out.println(" you feel your penguin muscles bulge and your flippers be replaced by fingersas the penguin gods have smiled upon your feat and choose to restore your humanity . Hooray!");
        }
      }
    }
  }
}