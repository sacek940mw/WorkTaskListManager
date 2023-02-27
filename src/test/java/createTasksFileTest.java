import org.example.fileOperations.SaveTasks;
import org.example.tasks.AllTasksList;
import org.junit.jupiter.api.Test;

public class createTasksFileTest {
    @Test
    void createTasksFileTestMethod() throws InterruptedException {
        Thread st = new Thread(new SaveTasks("files\\tasks.ser", AllTasksList.getInstance()));
        st.start();
        st.join();
    }
}
