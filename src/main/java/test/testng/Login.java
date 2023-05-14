package test.testng;

import org.testng.annotations.Test;

public class Login {
    @Test(groups = {"smoke", "regression"})

    public  void loginWithCorrectCreds(){
        System.out.println(this.getClass().getSimpleName() + " | Login Successful");
    }

    @Test(groups = {"regression"})
    public  void checkGeneralUi(){
        System.out.println(this.getClass().getSimpleName() + " | Check General UI");
    }
}
