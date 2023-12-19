package inmain;

import handlers.*;

public class MainApp {
    public static void main(String[] args) {
        Database database = new Database();
        Handler handler = new UserExistsHandler(database);
        handler.setNextHandler(new ValidPasswordHandler(database)).setNextHandler(new RoleCheckHandler());
        AuthService service = new AuthService(handler);
        System.out.println("==========================================");
        System.out.println(service.logIn("jadir", "password"));
        System.out.println("==========================================");
        System.out.println(service.logIn("user_username", "user_password"));
        System.out.println("==========================================");
        System.out.println(service.logIn("admin_username", "admin_password"));
        System.out.println("==========================================");
    }
}
