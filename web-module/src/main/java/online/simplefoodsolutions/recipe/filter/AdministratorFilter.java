package online.simplefoodsolutions.recipe.filter;

import online.simplefoodsolutions.recipe.utility.RoleSetHandler;
import utility.hibernate.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdministratorFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);

        String loginURI = request.getContextPath() + "/pages/login.xhtml";

        User user = (User) session.getAttribute("user");

        if (user != null)
        {
            if (RoleSetHandler.convertRoleSetToString(user.getRoles()).contains("Administrator"))
                filterChain.doFilter(request, response);
        } else
        {
            response.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy()
    {

    }
}
