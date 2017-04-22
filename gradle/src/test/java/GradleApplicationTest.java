import com.epam.jmp.GradleApplication;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Aleksei_Okhrimenko on 22.04.2017.
 */
public class GradleApplicationTest {
    @Test
    public void test() {
        GradleApplication application = new GradleApplication();
        assertNotNull("application should print a message", application.printMessage());
    }
}
