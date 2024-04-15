package prog5121poe;
import javax.swing.*;
/**
 *
 * @author ZENZO
 */
public class PROG5121POE 
{
    public static void main(String[] args) 
    {
        JOptionPane.showMessageDialog(null, "Enter your details to create an account");
        String username= JOptionPane.showInputDialog("Create a username");
        String password= JOptionPane.showInputDialog("Create a password");
        String firstName= JOptionPane.showInputDialog("Enter your First Name");
        String surname= JOptionPane.showInputDialog("Enter your Surname");
        
        Login myAccount= new Login(username, password, firstName, surname);
        do{
            myAccount.checkUserName();
            myAccount.checkPasswordComplexity();
            JOptionPane.showMessageDialog(null, myAccount.registerUser());
            if (!myAccount.checkUserName() && !myAccount.checkPasswordComplexity()){
                JOptionPane.showMessageDialog(null, "Please create a new username and password");
                username= JOptionPane.showInputDialog("Create a username");
                password= JOptionPane.showInputDialog("Create a password");
            }
            else if(!myAccount.checkPasswordComplexity()){
                JOptionPane.showMessageDialog(null, "Please create a new password");
                password= JOptionPane.showInputDialog("Create a password");
            }
            else if(!myAccount.checkUserName()){
                JOptionPane.showMessageDialog(null, "Please create a new username");
                username= JOptionPane.showInputDialog("Enter a username");
            }
            
        }while(!myAccount.checkUserName() || !myAccount.checkPasswordComplexity());
        
        boolean successfulLogin;
        do{
            String usernameLogin=JOptionPane.showInputDialog("Enter your username");
            String passwordLogin=JOptionPane.showInputDialog("Enter your password");
            successfulLogin= myAccount.loginUser(usernameLogin, passwordLogin);
            JOptionPane.showMessageDialog(null, myAccount.returnLoginStatus());
        }while(!successfulLogin);
    }
}
