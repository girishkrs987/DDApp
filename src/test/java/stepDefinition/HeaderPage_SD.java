package stepDefinition;


import java.io.IOException;
import org.apache.commons.configuration.ConfigurationException;
import com.photon.library.CommonLibrary;

import cucumber.api.java.en.Then;


public class HeaderPage_SD extends CommonLibrary {

	public HeaderPage_SD() throws ConfigurationException, IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	
	@Then("user should able to not login1")
	public void user_should_able_to_login1() throws Exception {
		Thread.sleep(3000);
		
		System.out.println("INSIDE STEP1");
		
		CommonLibrary.Assert(true, "test");
	}


	}

