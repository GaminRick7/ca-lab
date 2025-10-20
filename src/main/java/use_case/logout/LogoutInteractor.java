package use_case.logout;

import entity.User;
import use_case.change_password.ChangePasswordOutputData;

/**
 * The Logout Interactor.
 */
public class LogoutInteractor implements LogoutInputBoundary {
    private LogoutUserDataAccessInterface userDataAccessObject;
    private LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutUserDataAccessInterface userDataAccessInterface,
                            LogoutOutputBoundary logoutOutputBoundary) {
        this.userDataAccessObject =  userDataAccessInterface;
        this.logoutPresenter = logoutOutputBoundary;
    }

    @Override
    public void execute() {



        final LogoutOutputData logoutOutputData = new LogoutOutputData(userDataAccessObject.getCurrentUsername());
        userDataAccessObject.setCurrentUsername(null);
        logoutPresenter.prepareSuccessView(logoutOutputData);
        // * set the current username to null in the DAO
        // * instantiate the `LogoutOutputData`, which needs to contain the username.
        // * tell the presenter to prepare a success view.
    }
}

