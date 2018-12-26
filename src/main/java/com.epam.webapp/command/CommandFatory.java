package com.epam.webapp.command;

import com.epam.webapp.command.admin.BlockCommand;
import com.epam.webapp.command.admin.ShowUsersComand;

import com.epam.webapp.command.admin.UnblockUserCommand;
import com.epam.webapp.command.client.AddRideCommand;
import com.epam.webapp.command.client.ChooseAimCommand;
import com.epam.webapp.command.client.CancelRideCommand;
import com.epam.webapp.command.client.ChooseCarCommand;
import com.epam.webapp.command.client.ShowClientTripsCommand;
import com.epam.webapp.command.common.ComeToMainComand;
import com.epam.webapp.command.common.LogOutCommand;
import com.epam.webapp.command.common.LoginComand;
import com.epam.webapp.command.driver.AcceptPaymentCommand;
import com.epam.webapp.command.driver.AcceptRideCommand;
import com.epam.webapp.command.driver.ChooseClientCommand;
import com.epam.webapp.command.driver.FinishRideCommand;

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
            case "cancelRide":
                return new CancelRideCommand();
            case "chooseClient":
                return new ChooseClientCommand();
            case "accepRide":
                return new AcceptRideCommand();
            case "acceptPayment":
                return new AcceptPaymentCommand();
            case "finishRide":
                return new FinishRideCommand();
            case "logOut":
                return new LogOutCommand();
            case "unblockUser":
                return new UnblockUserCommand();
            case "blockUser":
                return new BlockCommand();
            case "changeUserDiscount":
                throw new UnsupportedOperationException();

            default:
                throw new UnsupportedOperationException();
        }
    }
}
