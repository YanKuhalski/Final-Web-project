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
            case "chooseAim":
                return new ChooseAimCommand();
            case "chooseCar":
                return new ChooseCarCommand();
            case "showClientTrips":
                return new ShowClientTripsCommand();
            case "addRide":
                return new AddRideCommand();
            default:
                throw new UnsupportedOperationException();
        }
    }
}
