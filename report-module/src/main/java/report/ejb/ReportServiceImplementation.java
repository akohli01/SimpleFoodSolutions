package report.ejb;

import report.dao.ReportDAO;
import utility.hibernate.entity.User;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

@Stateless
public class ReportServiceImplementation implements ReportService
{
    @Inject
    private ReportDAO reportDAO;

    @Override
    public List<User> getAllUsers()
    {
        return reportDAO.getAllUsers();
    }

    @Override
    public int getNumberOfRecipesCurrentlyInDatabase()
    {
        return reportDAO.getNumberOfRecipesCurrentlyInDatabase();
    }
}
