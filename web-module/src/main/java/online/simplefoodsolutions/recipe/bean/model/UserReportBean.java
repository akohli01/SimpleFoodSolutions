package online.simplefoodsolutions.recipe.bean.model;

import utility.hibernate.entity.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class UserReportBean extends AbstractReport
{
    private List<User> users;

    public List<User> getUsers()
    {
        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }

    public void setColumns()
    {
        columns = new ArrayList<>();
        columns.add("ID");
        columns.add("First Name");
        columns.add("Last Name");
        columns.add("Username");
        columns.add("Email");
        columns.add("Member since");
    }

    public List<String> getColumns()
    {
        return columns;
    }
}
