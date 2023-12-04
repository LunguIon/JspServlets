import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticatorImpl implements Authenticator{
    private String username = "vasea";
    private String password = "vasea123";
    private  String email = "test@test.com";
    @Override
    public boolean authenticateByUserName(String username, String password) {
        //TODO In case if the program doesn't work I may need to add here some parenthesis
        if(getUsername().equalsIgnoreCase(username) && getPassword().equalsIgnoreCase(password)){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public boolean authenticateByUserEmail(String email, String password) {
        if(getEmail().equalsIgnoreCase(email) && getPassword().equalsIgnoreCase(password)){
            return true;
        }else {
            return false;
        }

    }
}
