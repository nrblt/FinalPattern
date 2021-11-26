import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface {
    public UserInterface() throws IOException
    {
        FightFacade fightFacade = new FightFacade();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean checker = true;
        while(checker)
        {
            System.out.println("Choose what you wish to do by inputting the needed number: \n" +
                    "1. Watch a random fight \n" +
                    "2. Go to an arena (create a character first) \n" +
                    "3. Exit");
            String userInput = reader.readLine();
            int userInputInt;
            try {
                userInputInt = Integer.parseInt(userInput);
                switch (userInputInt) {
                    case 1: fightFacade.randomFight(); break;
                    case 2: fightFacade.arenaFight(fightFacade.createCharacter());
                    case 3: checker = false; break;
                    default:
                        System.out.println("Impossible choice.");
                }
            }
            catch (Exception e)
            {
                System.out.println("Please, enter just the number + \n");
            }
        }


    }
}
