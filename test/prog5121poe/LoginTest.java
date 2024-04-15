package prog5121poe;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * @author ZENZO    
 */
public class LoginTest {
    
    public LoginTest() {
    }
    
    Login login= new Login("kyl_1", "Ch&&sec@ke99!", "Neji", "Hyuga");
    
    //Check if username entered is formatted correctly according to POE doc.
    @Test
    public void testCheckUserNameCorrectlyFormatted(){
        login.setUsername("kyl_1");
        boolean actual= login.checkUserName();
        assertTrue(actual);
    }
    
    //Check if username entered is formatted incorrectly according to POE doc.
    @Test
    public void testCheckUserNameIncorrectlyFormatted() {
        login.setUsername("kyle!!!!!!!");
        boolean actual= login.checkUserName();  
        assertFalse(actual);
    }
    
    //Check if password entered is formatted correctly according to POE doc.
    @Test
    public void testCheckPasswordComplexitySuccess() {
        login.setPassword("C&&sec@ke99!");
        boolean actual= login.checkPasswordComplexity();
        assertTrue(actual);
    }
    
    //Check if password entered is formatted incorrectly according to POE doc.
    @Test
    public void testCheckPasswordComplexityFailure() {
        login.setPassword("password");
        boolean actual= login.checkPasswordComplexity();
        assertFalse(actual);
    }
    
    //Check if username and password entered to login match the username and password stored
    @Test
    public void testLoginUserSuccessful() {
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec@ke99!");
        boolean actual= login.loginUser("kyl_1", "Ch&&sec@ke99!");
        assertTrue(actual);
    }
    
    //Check if username and password entered to login  doesn't match the username and password stored
    @Test
    public void testLoginUserUnsuccessful() {
        login.setUsername("kyl_1");
        login.setPassword("Ch&&sec@ke99!");
        boolean actual= login.loginUser("Tr_dy", "P@55w0rd");
        assertFalse(actual);
    }

}
