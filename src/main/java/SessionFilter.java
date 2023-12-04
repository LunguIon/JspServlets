import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class SessionFilter implements Filter {
    private ArrayList<String> ignoredUrlList;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ignoredUrlList = new ArrayList<String>();
        String urls = filterConfig.getInitParameter("ignore-urls");
        StringTokenizer token  = new StringTokenizer(urls, ",");
        while (token.hasMoreTokens()){
            ignoredUrlList.add(token.nextToken());
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp  = (HttpServletResponse) servletResponse;

        String requestUri = req.getRequestURI();
        boolean shouldBeIgnored = isIgnoredUrl(requestUri);
        if(!shouldBeIgnored && !ProfileTools.isLoggedIn(req)){
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    private boolean isIgnoredUrl(String requestUri) {
        for(String ignoredUrl : getIgnoredUrlList()){
            if(requestUri.startsWith(ignoredUrl)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getIgnoredUrlList(){
        return ignoredUrlList;
    }

    public void setIgnoredUrlList(ArrayList<String> ignoredUrlList) {
        this.ignoredUrlList = ignoredUrlList;
    }

    @Override
    public void destroy() {
    }
}
