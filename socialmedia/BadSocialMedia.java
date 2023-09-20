package socialmedia;

import src.socialmedia.Account;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

/**
 * BadSocialMedia is a minimally compiling, but non-functioning implementor of
 * the SocialMediaPlatform interface.
 * 
 * @author Jayant Chawla, Pui Kin Chan
 * @version 1.0
 */
public class BadSocialMedia implements SocialMediaPlatform {

	/**
	 * id will hold num of accounts in social media
	 * LIST is a Array list to hold all names of users and can be easily accessed
	 */

	Integer id = 1;
	List<String> LIST = new ArrayList<>();



	@Override
	public int createAccount(String handle) throws socialmedia.IllegalHandleException, socialmedia.InvalidHandleException {
		/**
		 * Accounts will have unique ID and unique string handle to be more easily accessed and easily identifiable
		 */




			System.out.println("Test");


			int count = handle.length();
			if (count > 30) {
				System.out.println("Character limit broken, reduce length of handle ");
			} else if (count < 1) {
				System.out.println("Handle cannot be empty");
			} else {
				System.out.println("Count is " + count);
			}

			// id
			for (int i = 1; i <= 1; i++) {


				// if handle already in list, change handle
				boolean CheckHandle = LIST.contains(handle);
				if (CheckHandle) {
					System.out.println("Please choose different handle");



				} else {

					LIST.add(handle);
					System.out.println("Your account id is:"+ id++);
					System.out.println("Handle accepted");
				}


			}
			//System.out.println(LIST);


		return 0;
	}

	@Override
	public int createAccount(String handle, String description) throws IllegalHandleException, InvalidHandleException {
		int count = description.length();
		if (count > 100) {
			//System.out.println("Character limit broken, reduce length of handle ");
		} else if (count < 1) {
			//String createAccount;description = "";
		} else {
			//System.out.println(description);
		}

		return 0;
	}

	@Override
	public void removeAccount(int id) throws AccountIDNotRecognisedException {
		// TODO Auto-generated method stub
		//System.out.println("initial list"+LIST);
		boolean RemoveAcc = LIST.remove("my_handle2");
		if (RemoveAcc){
			//System.out.println("Account is removed");
		} else{
			//System.out.println("Account NOT removed");
		}
		//System.out.println(LIST);
		//System.out.println(RemoveAcc);


	}

	@Override
	public void removeAccount(String handle) throws HandleNotRecognisedException {
		// TODO Auto-generated method stub
		//System.out.println("Start List"+LIST); //////not working
		boolean RemoveAcc = LIST.remove(handle);
			if (RemoveAcc){
				//System.out.println("Account is removed");
			} else{
				//System.out.println("Account NOT removed");
			}
		//System.out.println(LIST);
		//System.out.println(RemoveAcc);
	}

	@Override
	public void changeAccountHandle(String oldHandle, String newHandle)
			throws HandleNotRecognisedException, IllegalHandleException, InvalidHandleException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAccountDescription(String handle, String description) throws HandleNotRecognisedException {
		// TODO Auto-generated method stub

	}

	@Override
	public String showAccount(String handle) throws HandleNotRecognisedException {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public int createPost(String handle, String message) throws HandleNotRecognisedException, InvalidPostException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int endorsePost(String handle, int id)
			throws HandleNotRecognisedException, PostIDNotRecognisedException, NotActionablePostException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentPost(String handle, int id, String message) throws HandleNotRecognisedException,
			PostIDNotRecognisedException, NotActionablePostException, InvalidPostException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deletePost(int id) throws PostIDNotRecognisedException {
		// TODO Auto-generated method stub

	}

	@Override
	public String showIndividualPost(int id) throws PostIDNotRecognisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StringBuilder showPostChildrenDetails(int id)
			throws PostIDNotRecognisedException, NotActionablePostException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfAccounts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalOriginalPosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalEndorsmentPosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalCommentPosts() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMostEndorsedPost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMostEndorsedAccount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void erasePlatform() {
		// TODO Auto-generated method stub

	}

	@Override
	public void savePlatform(String filename) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadPlatform(String filename) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

	}

}
