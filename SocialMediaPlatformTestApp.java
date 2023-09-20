import socialmedia.*;
import socialmedia.*;
import socialmedia.AccountIDNotRecognisedException;
import socialmedia.BadSocialMedia;
import socialmedia.IllegalHandleException;
import socialmedia.InvalidHandleException;

import java.io.IOException;

/**
 * A short program to illustrate an app testing some minimal functionality of a
 * concrete implementation of the SocialMediaPlatform interface -- note you will
 * want to increase these checks, and run it on your SocialMedia class (not the
 * BadSocialMedia class).
 *
 * 
 * @author Diogo Pacheco
 * @version 1.0
 */
public class SocialMediaPlatformTestApp {

	/**
	 * Test method.
	 * 
	 * @param args not used
	 */
	public static void main(String[] args) {
		System.out.println("The system compiled and started the execution...");

		SocialMediaPlatform platform = new socialmedia.SocialMedia();

		assert (platform.getNumberOfAccounts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalOriginalPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalCommentPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";
		assert (platform.getTotalEndorsmentPosts() == 0) : "Innitial SocialMediaPlatform not empty as required.";

		Integer id;



		try {
			((socialmedia.SocialMedia) platform).checkAllAccounts();
			id = platform.createAccount("my_handle1", "DESCRIPTION1");
			assert (platform.getNumberOfAccounts() == 0) : "number of accounts registered in the system does not match";
			id = platform.createAccount("my_handle2");
			assert (platform.getNumberOfAccounts() == 1) : "number of accounts registered in the system does not match";
			id = platform.createAccount( "my_handle3", "DESCRIPTION3");
			assert (platform.getNumberOfAccounts() == 1): "number of accounts registered in the system does not match";
			id = platform.createAccount( "my_handle4","Description for Handle4");
			assert (platform.getNumberOfAccounts() == 2): "number of accounts registered in the system does not match";
			id = platform.createAccount( "my_handle5","Description for Handle5");
			assert (platform.getNumberOfAccounts() == 3): "number of accounts registered in the system does not match";
			id = platform.createAccount( "my_handle6", "DESCRIPTION6");
			assert (platform.getNumberOfAccounts() == 3): "number of accounts registered in the system does not match";
			id = platform.createAccount( "my_handle7","Description for Handle7");
			assert (platform.getNumberOfAccounts() == 4): "number of accounts registered in the system does not match";
			id = platform.createAccount( "my_handle8","Description for Handle8");
			assert (platform.getNumberOfAccounts() == 5): "number of accounts registered in the system does not match";

			((socialmedia.SocialMedia) platform).removeAccount(1);
			((socialmedia.SocialMedia) platform).showAccount("my_handle8");
			//assert ((socialmedia.SocialMedia) platform).checkAllAccounts() == 0): "accounts registered does not match to system";



			assert (platform.getNumberOfAccounts() == 3) : "number of accounts registered in the system does not match";

			platform.changeAccountHandle("my_handle5", "NEWHANDLE");
			platform.updateAccountDescription("my_handle8", "New Description for Handle8");
			platform.removeAccount("my_handle7");
			platform.removeAccount("my_handle4");
			((socialmedia.SocialMedia) platform).checkAllAccounts();
			//assert (platform.getNumberOfAccounts() == 1) : "number of accounts registered in the system does not match";

			((socialmedia.SocialMedia) platform).showAccount("my_handle2");
			assert (((socialmedia.SocialMedia) platform).showAccount("my_handle2") != null): "Stats have not been returned";

			((socialmedia.SocialMedia) platform).createPost("my_handle2", "MESSAGE");
			((socialmedia.SocialMedia) platform).createPost("NEWHANDLE", "MESSAGE2");
			((socialmedia.SocialMedia) platform).createPost("my_handle2", "MESSAGE3");
			((socialmedia.SocialMedia) platform).createPost("NEWHANDLE", "MESSAGE4");
			((socialmedia.SocialMedia) platform).createPost("my_handle2", "MESSAGE5"); //5

			//((socialmedia.SocialMedia) platform).showAccount("my_handle2");

			//((socialmedia.SocialMedia) platform).getNumberOfAccounts();


			((socialmedia.SocialMedia) platform).endorsePost("NEWHANDLE", 4);
			((socialmedia.SocialMedia) platform).endorsePost("my_handle2", 1);
			((socialmedia.SocialMedia) platform).endorsePost("NEWHANDLE", 4); // 8
			//((socialmedia.SocialMedia) platform).showAccount("NEWHANDLE");

			//((socialmedia.SocialMedia) platform).getNumberOfAccounts();
			((socialmedia.SocialMedia) platform).commentPost("my_handle2", 5, "comment post2"); // 9
			((socialmedia.SocialMedia) platform).commentPost("NEWHANDLE", 3,"comment post3"); // 10
			((socialmedia.SocialMedia) platform).commentPost("NEWHANDLE", 3,"comment post3  2"); // 11
			((socialmedia.SocialMedia) platform).commentPost("my_handle2", 10,"comment comment1"); // 12
			((socialmedia.SocialMedia) platform).commentPost("my_handle2", 12,"comment comment3"); //13
			((socialmedia.SocialMedia) platform).commentPost("my_handle2", 13,"comment comment4");// 14
			((socialmedia.SocialMedia) platform).commentPost("my_handle2", 10,"comment comment5"); // 15
			((socialmedia.SocialMedia) platform).commentPost("my_handle2", 15,"comment comment6"); // 16
			((socialmedia.SocialMedia) platform).commentPost("my_handle2", 3,"comment post3  3"); // 17
			((socialmedia.SocialMedia) platform).commentPost("my_handle2", 16,"comment comment17"); // 18
			((socialmedia.SocialMedia) platform).commentPost("my_handle2", 9,"comment comment 19 "); // 19
			((socialmedia.SocialMedia) platform).commentPost("my_handle2", 19,"comment comment 20 "); // 20
			//((socialmedia.SocialMedia) platform).showAccount("NEWHANDLE");
			//((socialmedia.SocialMedia) platform).checkAllAccounts();
			((socialmedia.SocialMedia) platform).deletePost(2);
			((socialmedia.SocialMedia) platform).EmptyPost();

			((socialmedia.SocialMedia) platform).endorsePost("NEWHANDLE", 1); // 21
			((socialmedia.SocialMedia) platform).endorsePost("NEWHANDLE", 1); // 22
			((socialmedia.SocialMedia) platform).endorsePost("NEWHANDLE", 5); // 23

			((socialmedia.SocialMedia) platform).showIndividualPost(9);
			//((socialmedia.SocialMedia) platform).showPostChildrenDetails(3);
			((socialmedia.SocialMedia) platform).showPostChildrenDetails(3);





			((socialmedia.SocialMedia) platform).getNumberOfAccounts();
			((socialmedia.SocialMedia) platform).getTotalOriginalPosts();
			((socialmedia.SocialMedia) platform).getTotalEndorsmentPosts();
			((socialmedia.SocialMedia) platform).getTotalCommentPosts();
			((socialmedia.SocialMedia) platform).getMostEndorsedPost();
			((socialmedia.SocialMedia) platform).getMostEndorsedAccount();

			((socialmedia.SocialMedia) platform).savePlatform("TestObject1.ser");


			((socialmedia.SocialMedia) platform).erasePlatform();
			platform.createAccount( "my_handle8","Description for Handle8");
			assert (platform.getNumberOfAccounts() == 1): "number of accounts registered in the system does not match";
			((socialmedia.SocialMedia) platform).createPost("my_handle8", "MESSAGE");
			((socialmedia.SocialMedia) platform).commentPost("my_handle8", 1, "comment");
			((socialmedia.SocialMedia) platform).showPostChildrenDetails(1);
			((socialmedia.SocialMedia) platform).getNumberOfAccounts();
			((socialmedia.SocialMedia) platform).getTotalOriginalPosts();
			((socialmedia.SocialMedia) platform).getTotalEndorsmentPosts();
			((socialmedia.SocialMedia) platform).getTotalCommentPosts();
			((socialmedia.SocialMedia) platform).getMostEndorsedPost();
			((socialmedia.SocialMedia) platform).getMostEndorsedAccount();
			((socialmedia.SocialMedia) platform).erasePlatform();
			((socialmedia.SocialMedia) platform).loadPlatform("TestObject1.ser");
			((socialmedia.SocialMedia) platform).createPost("my_handle2", "MESSAGE");
			((socialmedia.SocialMedia) platform).createPost("my_handle2", "MESSAGE");
			((socialmedia.SocialMedia) platform).createPost("my_handle2", "MESSAGE");
			((socialmedia.SocialMedia) platform).commentPost("my_handle2", 19,"comment comment 20 ");
			((socialmedia.SocialMedia) platform).commentPost("my_handle2", 19,"comment comment 20 ");
			((socialmedia.SocialMedia) platform).commentPost("my_handle2", 19,"comment comment 20 ");
			((socialmedia.SocialMedia) platform).commentPost("my_handle2", 19,"comment comment 20 ");




			((socialmedia.SocialMedia) platform).deletePost(3);
			((socialmedia.SocialMedia) platform).endorsePost("my_handle2", 20); // 21
			((socialmedia.SocialMedia) platform).endorsePost("my_handle2", 19); // 22
			((socialmedia.SocialMedia) platform).endorsePost("my_handle2", 19); // 23
			//((socialmedia.SocialMedia) platform).showIndividualPost(10);


			((socialmedia.SocialMedia) platform).showPostChildrenDetails(10);


			((socialmedia.SocialMedia) platform).getNumberOfAccounts();
			((socialmedia.SocialMedia) platform).getTotalOriginalPosts();
			((socialmedia.SocialMedia) platform).getTotalEndorsmentPosts();
			((socialmedia.SocialMedia) platform).getTotalCommentPosts();
			((socialmedia.SocialMedia) platform).getMostEndorsedPost();
			((socialmedia.SocialMedia) platform).getMostEndorsedAccount();



		} catch (IllegalHandleException e) {
			assert (false) : "IllegalHandleException thrown incorrectly";
		} catch (InvalidHandleException e) {
			assert (false) : "InvalidHandleException thrown incorrectly";
		} catch (AccountIDNotRecognisedException e) {
			assert (false) : "AccountIDNotRecognizedException thrown incorrectly";
		} catch (socialmedia.HandleNotRecognisedException e) {
			assert (false): "HANDLENOTRECOGNISED THROWN INCORRECTLY";
		} catch (socialmedia.InvalidPostException e) {
			assert (false): "INVALID POST THROWN INCORRECTLY";
		} catch (socialmedia.PostIDNotRecognisedException e) {
			assert (false) : "INVALID POST THROWN INCORRECTLY";
		} catch (socialmedia.NotActionablePostException e) {
			assert (false) : "INVALID POST THROWN INCORRECTLY";
		} catch (IOException e) {
			assert (false) : "IOEXCEPTION";
		} catch (ClassNotFoundException e) {
			assert (false) : "Classnotfoundexception";
		}
	}

}
