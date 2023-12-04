import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class ProfileTools {
    public static String SESSION_LOGGEDIN_ATTRIBUTE_NAME = "user";

    public static boolean isLoggedIn(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        return session != null && session.getAttribute(SESSION_LOGGEDIN_ATTRIBUTE_NAME) != null;
    }
}
