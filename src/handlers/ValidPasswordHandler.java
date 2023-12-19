package handlers;

import inmain.Database;

public class ValidPasswordHandler extends Handler {
    private final Database database;
    public ValidPasswordHandler(Database database) {
        this.database = database;
    }
    @Override
    public boolean handle(String username, String password) {
        if (!database.isValidPassword(username, password)) {
            System.out.println("Wrong Password!");
            return false;
        }
        return handleNext(username, password);
    }
}
