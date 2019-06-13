package report.dao;

import utility.hibernate.entity.User;

import java.util.List;

public interface ReportDAO
{
    List<User> getAllUsers();

    int getNumberOfRecipesCurrentlyInDatabase();
}
