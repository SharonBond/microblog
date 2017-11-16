import static java.lang.System.out;
import java.util.Scanner;
import java.util.ArrayList; 

public class Main
{

    public static void printAllPosts (ArrayList <Post> p)
    { for (int i=0; i<p.size(); i++) 
        {
            p.get(i).printPost(); 
        }

    }

    public static void printUserNames (ArrayList <User> u)
    {for (int i = 0; i < u.size(); i++)
        {
            out.println((i+1) + ":" + u.get(i).getUserName()); 
            

        }
    } 

    public static Boolean  examineUserName(ArrayList <User> u, String name)
    { 

        for (int i = 0; i < u.size(); i++) 

        { 
            if(name.equals(u.get(i).getUserName()))
            { 
                return true; 
            } 

        }
        return false; 
    }

    public static void mainMenu (String person)
    { 
        out.println(""); 
        out.println("Main Menu for Mike Rowe Blog (aka MicroBlog)");
        out.println("It's a dirty job making jokes but someone's gotta do it"); 
        out.println("1) Create a new user"); 
        out.println("2) Become an existing user"); 
        out.println("3) Create a post as the current user"); 
        out.println("4) Print all posts"); 
        out.println("5) Print all users"); 
        out.println("6) Gracefully exit since you were looking for MySpace\n"); 
    } 

    public static void findMemberPost (String memberName, ArrayList <Post> p)
    {
        for (int i=(p.size()-1); i>0; i--) 

            if (memberName.equals(p.get(i).getName()))
            { 
                p.get(i).printPost(); 
                break;

            } 

    }

    public static void printSomeStuff (ArrayList <User> u)
    {
        for (int i = 0; i < u.size(); i++) 
        { 
            u.get(i).printUser(); 

        }
    }

    public static void main (String [] args)
    {  
        boolean goBacktoMain = true; 
        boolean checkUser = true; 
        boolean wantAWebsite = true; 

        String currentUser = "AnnaBanana";
        String userName = ""; 
        String name = "";   

        User ab = new User ("AnnaBanana", "https://encrypted-tbn0.gstatic.com/images?q=tbn//:ANd9GcStog6FUxuYG9Zj09gXrOoF2fnj8oVxMUa3vM-B9QYPjShqdrxG", "Bell", "Anna", "Ms.Anna.Bell@gmail.com" );
        User msp = new User("MsSparklePrincess89","https://encrypted-tbn0.gstatic.com/images?q=tb:ANd9GcTZyfw8enoTuJy9TRg1dPr6YptIxYmbkL4NvFO3EX98eilrN2rwXg", "Tanner", "Jeff","BurgersbyJeff@gmail.com" );
        User wwcs = new User ("whereintheworldiscarmensandiego", "https://encrypted-tbn0.gstatic.comimages?q=tbn:ANd9GcRcYSwcEX8nHOne-YDQ_-vUY0UgOfB9XLPKHAFgSTbII27CO9FIgw", "Biggerstaff", "Jamie", "Jamie@Biggerstaff.com"); 

        ArrayList <User> userInfo = new ArrayList <User> ();
        userInfo.add(ab); 
        userInfo.add(msp);
        userInfo.add(wwcs);

        Post abOne = new Post (ab.getUserName(), "Vegas is amazing! Can't wait to post pics!",  "");
        Post abTwo = new Post (ab.getUserName(), "Had to pawn my camera. And my phone. And my husband. Craps is way too fun.",  ""); 
        Post mspThree = new Post (msp.getUserName(), "Of COURSE it rains on my wedding day. Sing it Alanis.",  ""); 
        Post mspFour = new Post (msp.getUserName(), "I'm telling you, weather IS controlled by the government.",  "www.weather.gov"); 
        Post wwcsFive = new Post (wwcs.getUserName(), "Weird Al 2018 tour dates have been announced!!", "www.weirdal.com" ); 

        ArrayList <Post> postInfo = new ArrayList <Post> (); 
        postInfo.add(abOne);
        postInfo.add(abTwo);
        postInfo.add(mspThree);
        postInfo.add(mspFour);
        postInfo.add(wwcsFive);

        do
        {

            mainMenu (currentUser);
            out.println("You are currently user " + currentUser +  ". What would you like to do?");
            Scanner keyboard = new Scanner (System.in); 
            int option = keyboard.nextInt(); 
            keyboard.nextLine(); 
            if (option ==1)
            {    
                out.println("Awesome! Welcome aboard!\n"); 
                do
                {  out.println("What username would you like to go by?"); 
                    name = keyboard.nextLine();

                    if (examineUserName(userInfo, name) )
                    { out.println("I'm sorry, that username has been taken. Try again.\n"); 
                        checkUser = true; 
                    }
                    else 
                    {
                        checkUser = false;
                    } 

                }while (checkUser); 

                out.println("What is your email address?"); 
                String email = keyboard.nextLine(); 
                out.println("What is your first name?"); 
                String firstName = keyboard.nextLine(); 
                out.println("What is your last name?"); 
                String lastName = keyboard.nextLine(); 
                out.println("Paste a URL containing a picture you want to user as your avatar"); 
                String avatar = keyboard.nextLine(); 

                User newUser = new User (name, avatar ,  lastName,  firstName,  email);
                userInfo.add(newUser);
                out.println("Thanks, you've been added as "+ name) ;
                out.println("Do you want to switch to be that user? y or n?"); 
                String swap = keyboard.nextLine(); 
                if (swap.equals("y"))
                { 
                    currentUser = name; 
                    goBacktoMain= true;
                } 
                else 
                { 

                    goBacktoMain = true; 
                }
            } 
            if (option == 2)
            {
                out.println("Which user are you?");
                out.println("Pick the number associated with your username"); 

                printUserNames (userInfo);
                int userOption = keyboard.nextInt(); 
                for (int i=0; i<userInfo.size(); i++ )
                    if (userOption ==(i+1))
                    { 
                        currentUser = userInfo.get(i).getUserName();
                    } 

            } 
            if (option == 3)
            {

                findMemberPost (currentUser, postInfo);
                String website="";
                out.println("What is on your mind?"); 
                String musings = keyboard.nextLine(); 

                do{ 
                    out.println("Do you want to add a website to that? y or n?");
                    String yesOrNo = keyboard.nextLine(); 
                    if (yesOrNo.equals("y"))
                    { 
                        out.println ("What is that website?"); 
                        website = keyboard.nextLine();
                        wantAWebsite = false;
                    } 
                    else  if (yesOrNo.equals("n"))
                    { 
                        out.println("No worries. We don't require one\n"); 
                        website = ""; 
                        wantAWebsite = false; 
                    } 
                    else 

                    {
                        out.println("What? Try again.");
                        wantAWebsite =true;
                    }
                } while (wantAWebsite);
                Post inputPost = new Post (currentUser, musings, website);
                postInfo.add(inputPost);

            } 
            if (option == 4)
            {
                printAllPosts (postInfo); 
            } 
            if (option ==5)
            {
                printSomeStuff (userInfo) ;   
            } 

            if (option == 6) 
            { out.println("Enjoy MySpace!");
                goBacktoMain = false; 
            } 

        } while (goBacktoMain);

    }
}