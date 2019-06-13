package report.ejb;

import utility.hibernate.entity.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ReportService
{
    List<User> getAllUsers();

    int getNumberOfRecipesCurrentlyInDatabase();
}
