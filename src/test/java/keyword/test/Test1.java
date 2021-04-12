package keyword.test;

import keyword.engine.KeywordEngine;
import org.testng.annotations.*;
public class Test1 {

	public KeywordEngine engine;
	
	@Test(priority=0,enabled=true)
	public void loginTest() throws Exception{
		engine=new KeywordEngine();
		engine.Start("Login");
	}
	@Test(priority=1)
	public void Dashboard(){
		engine=new KeywordEngine();
		engine.Start("Dashboard");
	}
	
}
