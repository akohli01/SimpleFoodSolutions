import net.sourceforge.jwebunit.util.TestingEngineRegistry;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class LoginTest
{
    @Before
    public void initialize()
    {
        setTestingEngineKey(TestingEngineRegistry.TESTING_ENGINE_HTMLUNIT);
    }

    @Test
    public void loginSuccessfulTest()
    {
        setBaseUrl("http://localhost:8080/recipe/pages/");
        setScriptingEnabled(false);
        beginAt("/login.xhtml");
        assertTitleEquals("Login");

        setTextField("loginForm:username", "epsoncloud1");
        setTextField("loginForm:password", "test");

        submit();

        assertTitleEquals("Profile");
    }

    @Test
    public void loginFailedTest()
    {
        setBaseUrl("http://localhost:8080/recipe/pages/");
        setScriptingEnabled(false);
        beginAt("login.xhtml");
        assertTitleEquals("Login");

        setTextField("loginForm:username", "incorrectUsername");
        setTextField("loginForm:password", "incorrectPassword");

        submit();

        assertTitleEquals("Login");
    }
}
