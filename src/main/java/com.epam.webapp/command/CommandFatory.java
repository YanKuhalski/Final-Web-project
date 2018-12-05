package com.epam.webapp.command;

public class CommandFatory {
    public static Command create(String comand) {
        switch (comand) {
            case "login":
                return new LoginComand();
            case "comeToMain":
                return new ComeToMainComand();
            case "showUsers":
                return new ShowUsersComand();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
