import org.example.fileOperations.SaveTasks;
import org.junit.jupiter.api.Test;

public class createTasksFileTest {
    @Test
    void createTasksFileTest() throws InterruptedException {
        Thread st = new Thread(new SaveTasks());
        st.start();
        st.join();
    }
}
