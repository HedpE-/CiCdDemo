package jfsd.assessments.phase5.CiCdDemo.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import jfsd.assessments.phase5.CiCdDemo.controller.LoginController;
import jfsd.assessments.phase5.CiCdDemo.entity.User;

public class UnitTests {
	@Test
	public void testLoginSuccess() {
		final User user = new User("rui.g", "Rui", "G", "rui@mail.com", "root");
		
		LoginController controller = new LoginController();
		
		assertEquals("redirect:congrats", controller.loginUser(user, null, null));
	}
	
	@Test
	public void testLoginFail() {
		final User user = new User("invalid", null, null, null, "invalid");
		
		LoginController controller = new LoginController();
		
		assertEquals("redirect:signin", controller.loginUser(user, null, null));
	}
}
