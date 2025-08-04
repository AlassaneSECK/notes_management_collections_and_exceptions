import org.example.FileManagement;
import org.example.Student;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileManagementTest {
    @Test
    void testSaveAndRestore() {
        // Arrange : Create data and save
        Map<Student, ArrayList<Double>> notesMap = new HashMap<>();
        Student alice = new Student("Alice", "Dupont");
        Student bob = new Student("Bob", "Martin");
        notesMap.put(alice, new ArrayList<>(Arrays.asList(12.5, 15.0)));
        notesMap.put(bob, new ArrayList<>(Collections.singletonList(10.0)));

        String fileName = "test-notes.txt";

        // Act : save and restore
        FileManagement.saveToFile(notesMap, fileName);
        Map<Student, ArrayList<Double>> loadedMap = FileManagement.restoreFromFile(fileName);

        // Assert : Verify that the restored data is identical
        assertEquals(notesMap.size(), loadedMap.size());
        for (Student s : notesMap.keySet()) {
            assertTrue(loadedMap.containsKey(s));
            assertEquals(notesMap.get(s), loadedMap.get(s));
        }

        // Cleaning : Delete file test after the test
        new File(fileName).delete();
    }
}
