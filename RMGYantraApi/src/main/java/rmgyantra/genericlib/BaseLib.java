package rmgyantra.genericlib;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import static io.restassured.RestAssured.*;

import java.sql.SQLException;
public class BaseLib {

	@BeforeSuite
	public void config() {
		DbUtilities.connectToDB();
		baseURI="http://studentapp";
		port=8084;
		basic("username","password");
	}
	
	@AfterSuite
	public void afterSuite() throws SQLException {
		DbUtilities.closeDb();
	}
}
