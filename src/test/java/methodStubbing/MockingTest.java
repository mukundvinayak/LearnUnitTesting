package methodStubbing;

import dao.ApplicationDAO;
import entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class MockingTest {
//both ways of mocking is shown below using mockito framework
    @Mock
    User user;
    @Mock
    ApplicationDAO applicationDAO;// = mock(ApplicationDAO.class);

    @Test
    @DisplayName("Permission assigned successfully")
    void assignPermission() {
        Mocking mocking = new Mocking();
        mocking.setUser(user);

        //method stubbing using when().thenReturn()
        when(user.getRole()).thenReturn("admin");
        when(user.getUsername()).thenReturn("Mukund");
        //we can simply use user.setRole("admin") and user.setUsername("Mukund")
        //in place of method stubbing
        List<String> filteredList = Arrays.asList("this place is awesome", "awesome day it is");//new ArrayList<>();

        when(user.getAllPostsContainingWord("awesome")).thenReturn(filteredList);

        Assertions.assertEquals(1, mocking.assignPermission());

    }

    @Test
    @DisplayName("Successfully username updated!")
    public void testUpdateUserName() throws Exception{
        User user = new User();
        user.setUsername("Mukund");

        Mocking mocking = new Mocking();
        mocking.setUser(user);
        lenient().when(applicationDAO.getUserById(Mockito.anyString())).thenReturn(user);

        assertEquals(1, mocking.updateUserDetails("3211", "Gopala"));
    }


    @Test
    @DisplayName("Exccpetion thrown!")
    public void testUpdateUserName2() throws Exception{
        User user = new User();
        user.setUsername("Mukund");

        Mocking mocking = new Mocking();
        mocking.setUser(user);
        lenient().when(applicationDAO.getUserById(Mockito.anyString())).thenReturn(null);

        Assertions.assertThrows(Exception.class, () -> {
            mocking.updateUserDetails("3412","allan");
        });
    }
}