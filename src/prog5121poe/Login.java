package prog5121poe;
/**
 *
 * @author ZENZO
 */
public class Login {
    private String username;
    private String password;
    private String firstName;
    private String surname;
    private String usernameLogin;
    private String passwordLogin;

    public Login(String username, String password, String firstName, String surname) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.surname = surname;
    }
    
    public boolean checkUserName(){
        boolean usernameFlag=false;

        if (username.contains("_")&& username.length()<=5){
            usernameFlag=true;
        }
        return usernameFlag;
    }
    
    public boolean checkPasswordComplexity(){
        boolean lengthFlag=false;
        boolean capitalFlag=false;
        boolean numberFlag=false;
        boolean characterFlag=false;
                    
        if(password.length()>=8){
            lengthFlag=true;
        }
            
        int i=0;
        while(!capitalFlag&&i<=password.length()-1){
            capitalFlag= Character.isUpperCase(password.charAt(i)); //capitalFlag true if character is an upper case letter
            i++;
        }
            
        int j=0;
        while(!numberFlag&&j<=password.length()-1){
            numberFlag= Character.isDigit(password.charAt(j)); //capitalFlag true if character is an upper case letter
            j++;
        }

        int k=0;
        while(!characterFlag&&k<=password.length()-1){
            characterFlag= !Character.isLetterOrDigit(password.charAt(k)) && !Character.isWhitespace(password.charAt(k)); //Will only make characterFlag true if it finds a charcter that is not a number, digit or blank space(symbol)
            k++;
        }
        return lengthFlag && capitalFlag && numberFlag && characterFlag; //only returns true if all flag are true
    }
    
    public String registerUser(){
        if (checkUserName() && checkPasswordComplexity()){
            return "Both the username and password have met their "
                    + "respective conditions and the user has been successfully registered.";
        }
        else if(!checkUserName() && !checkPasswordComplexity()){
            return "Both the username and password have not been formatted correctly, "
                    + "please ensure that your username contains an underscore "
                    + "and is no more than 5 characters in length, "
                    + "please also ensure that the password contains at least 8 characters, "
                    + "a capital letter, a number and a special character.";
        }
        else if(!checkPasswordComplexity()){
            return "Password is not correctly formatted, "
                    + "please ensure that the password contains at least 8 characters, "
                    + "a capital letter, a number and a special character.";  
        }
        else{
            return "Username is not correctly formatted, "
                    + "please ensure that your username contains an underscore "
                    + "and is no more than 5 characters in length.";              
        }
    }       
    
    /*private String getUsername(){
        return username;
    }
    
    private String getPassword(){
        return password;
    }*/
           
    public boolean loginUser(String usernameLogin, String passwordLogin){
        this.usernameLogin=usernameLogin;
        this.passwordLogin=passwordLogin;
        
        boolean login=false;   
        
        if (usernameLogin.equals(username)&& passwordLogin.equals(password)){ //if username and password entered matched the username and password stores EXACTLY, login will be successful
            login=true;
        }
        return (login);
    }       
    
    public String returnLoginStatus(){
        
        if (loginUser(usernameLogin, passwordLogin)){
            return "Welcome "+ firstName+", "+ surname+ " it is great to see you.";
        }
        else{
            return "The username or password you entered was incorrect";
            }
    }  
    
    //Methods used for unit testing
    public void setUsername(String newUsername){
        this.username= newUsername;
    }

    public void setPassword(String newPassword) {
        this.password = newPassword;
    }
    
    /*
    Site: Stack Overflow
    Title: How do I check if a Java String contains at least one capital, lowercase letter, and number?
    Author: CyprUS
    Date: 31 Oct 2016
    Availibility: https://stackoverflow.com/questions/40336374/how-do-i-check-if-a-java-string-contains-at-least-one-capital-letter-lowercase
    */
    
}

