package stepDefinition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.configuration.ConfigurationException;
import com.photon.library.CommonLibrary;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.Scenario;

public class GenericSteps extends CommonLibrary {

	static boolean StartAftermethod = false;
	public int i = 1;
	public static String Username;
	public static String Password;

	public static String Scenario;

	public GenericSteps() throws ConfigurationException, IOException {
		super();

	}

	@Given("^User Launches the browser$")
	public void user_Launches_the_Application() throws Throwable {

		CommonLibrary.App_Launch();
		System.out.println("Browser launched Successfully");
		CommonLibrary.driver.manage().window().maximize();

	}
	
	@Given("^User Launches the browser for pdp pages$")
	public void user_Launches_the_for_pdp() throws Throwable {

		CommonLibrary.App_Launch1();
		System.out.println("Browser launched Successfully - Product List temporary page");
		CommonLibrary.driver.manage().window().maximize();

	}

	@Before
	public void Scenario_started(Scenario s) throws Throwable {

		Scenario = s.getName();
		System.out.println("<=========== Scenario:" + Scenario + " Started ===========>");

		System.out.println("<=========== Tag name:" + s.getSourceTagNames() + " Started ===========>");

	}

	@After
	public void embedScreenshotOnFail(Scenario s) throws Exception {
		if (s.isFailed()) {
			CommonLibrary.takeScreenShot(s);
			System.out.println("<=========== Scenario:" + Scenario + " Failed ===========>\n");
			 driver.quit();
		} else {
			System.out.println("<=========== Scenario:" + Scenario + " Completed Successfully ===========>\n");
			driver.quit();
		}
	}

	@Then("^user kill chrome session$")
	public void user_kill_chrome_session() throws Throwable {

		String target = "Killdriver/Killchrome2.sh";
		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec(target);
		proc.waitFor();
		StringBuffer output = new StringBuffer();
		BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		String line = "";
		while ((line = reader.readLine()) != null) {
			output.append(line + "\t");
		}
		System.out.println("### " + output);

	}

}
