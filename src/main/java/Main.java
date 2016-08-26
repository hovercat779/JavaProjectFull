import crud.UserCrud;
import entities.UsersEntity;
import utils.UserUtils;

public class Main {

    public static void main(String[] args) {

        System.out.println(UserUtils.loginCheck("user1"));
    }
}
