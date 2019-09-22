package com.mock.test;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.mock.User;
import com.mock.controller.UserController;
import com.mock.db.DBUtil;
import com.mock.service.DefaultUserService;

import junit.framework.Assert;

/**
 * Test class for UserController
 *
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserController.class,DBUtil.class})
@SpringBootTest
public class UserControllerTest {
	
	
	@InjectMocks
	UserController userController;
	
	@Mock
	private DefaultUserService mockDefaultUserService;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	 
	
	/** mocking a method */
	@Test
	public void testGetUserCount() {
		Mockito.when(mockDefaultUserService.getUserCount()).thenReturn(100L);
		assertEquals(100L, userController.getUserCount().longValue());
	}
	
	
	/** mocking private method */ 
	@Test
	public void testMockPrivateMethod() throws Exception {
		UserController userSpy = PowerMockito.spy(userController);
		PowerMockito.doReturn("Hello %s %s").when(userSpy,"getGreetingFormat");
		User user = getNewUser();
		assertEquals("Hello Narayana pvv", userSpy.getGreetingText(user));
	}
	
	
	/** mocking a static static method */
	@Test
	public void testMockStatic()  {
		
			PowerMockito.mockStatic(UserController.class);
			PowerMockito.when(UserController.callStatic()).thenReturn("Hello");
			assertEquals("Hello", userController.getStatic());
			assertEquals("Hello", userController.getStatic());
			PowerMockito.verifyStatic(UserController.class,Mockito.atLeast(2));
			UserController.callStatic();
	}
//	
//	/** mocking a static static method with params*/
//	@Test
//	public void testMockStaticWithParams() {
//		
//			PowerMockito.mockStatic(UserController.class);
//			PowerMockito.when(UserController.callStaticWithParams(1,"A")).thenReturn("Hello");
//			assertEquals("Hello", UserController.callStaticWithParams(1,"A"));
//	}
//	
//	
//	/** mocking a static static method with params with stub & any*/
//	@Test
//	public void testMockStaticWithParamsWithStub() {
//		
//			PowerMockito.mockStatic(UserController.class);
//			
//			PowerMockito.when(UserController.callStaticWithParams(Mockito.anyInt(),Mockito.anyString())).thenReturn("HelloAny");
//			assertEquals("HelloAny", UserController.callStaticWithParams(1,"A"));
//			
//			PowerMockito.stub(PowerMockito.method(UserController.class, "callStaticWithParams", int.class,String.class)).toReturn("HelloStaticStub");
//			assertEquals("HelloStaticStub", UserController.callStaticWithParams(1,"A"));
//	}

	@Test
	public void testMockNew() throws Exception {
		DBUtil dbUtil  = Mockito.mock(DBUtil.class);
		PowerMockito.whenNew(DBUtil.class).withNoArguments().thenReturn(dbUtil);
		Assert.assertSame(dbUtil, userController.getDB());
	}
	
	
	private User getNewUser() {
		User user = new User();
		user.setFirstName("Narayana");
		user.setSurname("pvv");
		return user;
	}
	
}
