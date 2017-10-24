public class User 
{ 
  private String userName;
  private String email ;
  private String lastName;
  private String firstName;
  private String avatar;
  
  public User (String userName,String avatar , String lastName, String firstName, String email)
  { 
    this.userName = userName; 
    this.email = email; 
    this.lastName = lastName; 
    this.firstName = firstName; 
    this.avatar = avatar; 
    
  } 
  
  public String getUserName()
  { return userName; } 
  
  public String getEmail ()
  {return email;} 
  
  public String getLastName()
  {return lastName;} 
  
  public String getFirstName()
  { return firstName;}
  
  public String getAvatar()
  {return avatar;} 
  
   public void printUser() {
      System.out.println("User:"+ userName);
      System.out.println("Name:" + firstName + " " + lastName);
      System.out.println("Avatar:" + avatar);
      System.out.println("Email:" + email);
      System.out.println(""); 
   }
   public void printUserName() {
      System.out.println("User:"+ userName);
      
   }
   
}