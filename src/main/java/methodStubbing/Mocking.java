package methodStubbing;

import dao.ApplicationDAO;
import entity.User;

public class Mocking {

    User user;

    public void setUser(User user){
        this.user = user;
    }
    public int assignPermission() {
        if(user.getRole().equals("admin")) {
            String username = user.getUsername();
            System.out.println("Assign special permissions for user " + username);
            return 1;
        } else {
            System.out.println("Cannot assign permission");
            return -1;
        }
    }

    public int updateUserDetails(String userId, String userName) throws Exception{
        ApplicationDAO applicationDAO = new ApplicationDAO();
        User user = applicationDAO.getUserById(userId);
        System.out.println("Updating details for "+user.getUsername());
        if(user.getUsername()!=null)
            user.setUsername(userName);
        applicationDAO.save(user);

        return 1;

    }
}
