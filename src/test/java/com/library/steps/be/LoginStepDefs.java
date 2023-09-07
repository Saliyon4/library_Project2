package com.library.steps.be;

import com.library.utility.LibraryAPI_Util;
import io.cucumber.java.en.Given;

public class LoginStepDefs {
//static  String gloabalTokenForEachClass;
    @Given("I logged Library api as a {string}")
    public void i_logged_library_api_as_a(String userType) {
     String token=LibraryAPI_Util.getToken(userType);
  //   gloabalTokenForEachClass=token;

    }
}
