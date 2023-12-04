import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;


import java.io.IOException;

public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String authAction = req.getParameter("authAction");
        if(authAction.equals("login")){
            login(req, resp);
        }else if(authAction.equals("logout")){
            logout(req, resp);
        }else{

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }

     protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
         HttpSession session = request.getSession(false);
         if(session != null){
             session.invalidate();
         }
         response.sendRedirect("login.jsp");
     }
     private void login(
             HttpServletRequest request,
             HttpServletResponse response
     )throws ServletException, IOException{
        String authTypeParam = request.getParameter("authType");
         Authenticator authenticator = new AuthenticatorImpl();
         boolean isAuthenticated = false;
         String password = request.getParameter("psw");
         String authValue = request.getParameter("loginValue");
         if(authTypeParam.equals("email")){
             isAuthenticated = authenticator.authenticateByUserEmail(authValue, password);

         }else{
             isAuthenticated = authenticator.authenticateByUserName(authValue, password);
         }
         if(isAuthenticated){
             HttpSession session = request.getSession();
             session.setAttribute(ProfileTools.SESSION_LOGGEDIN_ATTRIBUTE_NAME, authValue);
             response.sendRedirect("home.jsp");
         }else {
             response.sendRedirect("error-login.jsp");
         }
     }
}


