package socialmedia;

import src.socialmedia.Account;
import src.socialmedia.Comment;
import src.socialmedia.Post;
import src.src.socialmedia.Endorsement;
import java.io.*;
import javax.lang.model.util.Elements;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * SocialMedia is a compiling implementor of
 * the SocialMediaPlatform interface.
 *
 * @author Jayant Chawla, Pui Kin Chan
 * @version 1.0
 */
public class SocialMedia implements SocialMediaPlatform {

    Integer id = 0; // ID counter
    Integer Postid = 0; // Post ID counter
    List<String> LIST = new ArrayList<>(); // List containing all handles

    List<Integer> listOfPostID = new ArrayList<>(); // List containing all Post IDs
    List<Integer> listOfEndID = new ArrayList<>(); // List containing all Endorsement IDs
    List<Integer> listOfCommID = new ArrayList<>(); // List containing all Comment IDs
    List<Account> accountsList = new ArrayList<>(); // List containing all accounts
    List<Post> postsList = new ArrayList<>(); // List containing all posts
    List<Comment> commentsList = new ArrayList<>(); // List containing all comments
    List<Endorsement> EndorsementsList = new ArrayList<>(); // List containing all endorsements

    /**
     * This will check for all account's
     * Accounts will have unique ID and unique string handle
     * to be more easily accessed and easily identifiable
     *
     * @param handle given handle to create account
     * @throws socialmedia.IllegalHandleException thrown when Handle has already been assigned
     * @throws socialmedia.InvalidHandleException thrown when Handle is empty, contains white space or is above character limit
     * @return id of account
     */

    @Override
    public int createAccount(String handle) throws socialmedia.IllegalHandleException, socialmedia.InvalidHandleException {
        int HanLength = handle.length();
        // THIS CHECKS FOR CHAR LIMIT
        try {
            if (HanLength > 31 || HanLength < 1)
                throw new socialmedia.InvalidHandleException("Character limit broken, Must be between 1 and 30 characters ");
        } catch (socialmedia.InvalidHandleException e) {
            System.out.println(handle + " has broken character limit, Must be between 1 and 30 characters ");
            throw new socialmedia.InvalidHandleException();
        }
        // THIS CHECKS FOR WHITE SPACE
        try {
            if (handle.matches(".*\\s+.*"))
                throw new socialmedia.InvalidHandleException("Handle includes whitespace, must be removed");
        } catch (socialmedia.InvalidHandleException e) {
            System.out.println("Handle, " + handle + " includes whitespace, must be removed");
            throw new socialmedia.InvalidHandleException();
        }


        if (HanLength > 1 && HanLength < 31) {
            //System.out.println("Count is " + HanLength);
        }

        // THIS CHECKS IF HANDLE ALREADY GIVEN AND GIVES ID TO USER
        for (int i = 1; i <= 1; i++) {

            try {
                // if handle already in list, change handle
                boolean CheckHandle = LIST.contains(handle);
                if (CheckHandle) {
                    //System.out.println("Please choose different handle");
                    throw new socialmedia.IllegalHandleException("Please choose different handle, This handle is already taken");
                } else {

                    LIST.add(handle);
                    //System.out.println("Your account id is:" + id++);
                    //System.out.println("Handle accepted");
                }
            } catch (socialmedia.IllegalHandleException e) {
                System.out.println("Please choose different handle, This handle is already taken");
                throw new socialmedia.IllegalHandleException();
            }

        }
        //TO TEST: System.out.println(LIST);


        id++;
        Account myAccount = new Account(id, handle, "Default Description", 0, 0);
        //System.out.println(myAccount.getUserID());
        System.out.println(myAccount.getUserHandle());
        //System.out.println(myAccount.getUserDescription());
        myAccount.StartCount();


        Account[] accounts = {myAccount};

        // Loop through the array and print out the information for each account
        for (Account Account : accounts) {
            accountsList.add(myAccount);
        }
        return id;
    }

    /**
     * This will check for all account's
     * Accounts will have unique ID and unique string handle
     * to be more easily accessed and easily identifiable.
     * Will also contain description already added to account
     *
     * @param handle given handle to create account
     * @param description given description to link to account
     * @throws socialmedia.IllegalHandleException thrown when Handle has already been assigned
     * @throws socialmedia.InvalidHandleException thrown when Handle is empty, contains white space or is above character limit
     * @return id of account
     */
    @Override
    public int createAccount(String handle, String description) throws socialmedia.IllegalHandleException, socialmedia.InvalidHandleException {


        int HanLength = handle.length();
        // THIS CHECKS FOR CHAR LIMIT
        try {
            if (HanLength > 31 || HanLength < 1)
                throw new socialmedia.InvalidHandleException("Character limit broken, Must be between 1 and 30 characters ");
        } catch (socialmedia.InvalidHandleException e) {
            System.out.println(handle + " has broken character limit, Must be between 1 and 30 characters ");
            throw new socialmedia.InvalidHandleException();
        }
        // THIS CHECKS FOR WHITE SPACE
        try {
            if (handle.matches(".*\\s+.*"))
                throw new socialmedia.InvalidHandleException("Handle includes whitespace, must be removed");
        } catch (socialmedia.InvalidHandleException e) {
            System.out.println("Handle, " + handle + " includes whitespace, must be removed");
            throw new socialmedia.InvalidHandleException();
        }


        if (HanLength > 1 && HanLength < 31) {
            //System.out.println("Count is " + HanLength);
        }

        // THIS CHECKS IF HANDLE ALREADY GIVEN AND GIVES ID TO USER
        for (int i = 1; i <= 1; i++) {

            try {
                // if handle already in list, change handle
                boolean CheckHandle = LIST.contains(handle);
                if (CheckHandle) {
                    //System.out.println("Please choose different handle");
                    throw new socialmedia.IllegalHandleException("Please choose different handle, This handle is already taken");
                } else {

                    LIST.add(handle);
                    //System.out.println("Your account id is:" + id++);
                    //System.out.println("Handle accepted");
                }
            } catch (socialmedia.IllegalHandleException e) {
                System.out.println("Please choose different handle, This handle is already taken");
                throw new socialmedia.IllegalHandleException();
            }

        }
        //TO TEST: System.out.println(LIST);

        int DescLength = description.length();

        try {
            if (DescLength > 100)
                throw new socialmedia.InvalidDescriptionException("Description has broken character limit, Must be between 1 and 100 characters ");
        } catch (socialmedia.InvalidDescriptionException e) {
            System.out.println("Description has broken character limit, Must be between 1 and 100 characters ");
            throw new RuntimeException();
        }


        if (DescLength < 1) {
            String createAccount;
            description = "";
        } else {
            //System.out.println("Description is: " + description);
        }

        id++;
        Account myAccount = new Account(id, handle, description, 0, 0);
        //System.out.println(myAccount.getUserID());
        System.out.println(myAccount.getUserHandle());
        //System.out.println(myAccount.getUserDescription());
        myAccount.StartCount();


        Account[] accounts = {myAccount};

        // Loop through the array and print out the information for each account
        for (Account Account : accounts) {
            accountsList.add(myAccount);
        }
        //System.out.println(accountsList);
        //System.out.println(LIST);


        return id;
    }

    /**
     * Used to check for all accounts created
     * Will be used to contain list of all users for further testing and use
     *
     */

    public void checkAllAccounts() {
        System.out.println("******");
        int numberOfAccounts = getNumberOfAccounts();
        assert numberOfAccounts != 0 : "must have atleast 1 account registered in the system";
        // FIND TARGET ACCOUNT BY USING HANDLE
        for (Account account : accountsList) {
            System.out.println("Account Name: " + account.getUserHandle());
            System.out.println("Account ID: " + account.getUserID());
            System.out.println("Account Description: " + account.getUserDescription());
            System.out.println("******");
        }
    }

    /**
     * Used to remove all accounts using each person's id
     *
     * @param id id of account to remove
     * @throws socialmedia.AccountIDNotRecognisedException thrown when id is not recognised
     */
    @Override
    public void removeAccount(int id) throws socialmedia.AccountIDNotRecognisedException {
        // TODO Auto-generated method stub

        for (int i = 1; i <= 1; i++) {
            try {
                // check if id already in list
                boolean CheckHandle = accountsList.get(i).getUserID().equals(id);
                if (CheckHandle) {
                    //System.out.println("Please choose different handle");
                    throw new socialmedia.AccountIDNotRecognisedException("ID not recognised");
                }
            } catch (socialmedia.AccountIDNotRecognisedException e) {
                System.out.println("ID not recognised");
                throw new socialmedia.AccountIDNotRecognisedException();
            }
        }

        //System.out.println(accountsList);
        for (Account Account : accountsList) {
            if (Account.getUserID() == id) {
                accountsList.remove(Account.getUserID());
                LIST.remove(Account.getUserID());
                break;
            }
        }


        for (int i = 0; i < accountsList.size(); i++) {
            if (accountsList.get(i).getUserID().equals(id)) {
                accountsList.remove(i);
                LIST.remove(i);
                break; // Exit the loop once an account has been removed
            }}



        int idToCheck = id;
        boolean accountExists = false;
        for (Account Account : accountsList) {
            if (Account.getUserID().equals(idToCheck)) {
                accountExists = true;
                break; // Exit the loop once an account has been found
            }
        }

        // Print the result of the check
        if (accountExists) {
            System.out.println("An account with id " + idToCheck + " exists in the list.");
        } else {
            System.out.println("An account with id " + idToCheck + " does not exist in the list.");
        }


    }

    /**
     * Used to remove all accounts using each person's handle, can be used in the platform
     *
     * @param handle given handle of account
     * @throws socialmedia.HandleNotRecognisedException thrown when Handle is not recognised by platform
     */

    @Override
    public void removeAccount(String handle) throws socialmedia.HandleNotRecognisedException {
        // THIS CHECKS IF HANDLE IN USE OR NOT
        for (int i = 1; i <= 1; i++) {
            try {
                // check if handle already in list
                boolean CheckHandle = LIST.contains(handle);
                if (CheckHandle) {
                    break;
                } else {

                    throw new socialmedia.HandleNotRecognisedException("Handle " + handle + " not recognised");
                }
            } catch (socialmedia.HandleNotRecognisedException e) {
                System.out.println("Handle " + handle + " not recognised");
                throw new socialmedia.HandleNotRecognisedException();
            }
        }





        for (int i = 0; i < accountsList.size(); i++) {
            if (accountsList.get(i).getUserHandle().equals(handle)) {
                accountsList.remove(i);
                LIST.remove(i);
                break; // Exit the loop once an account has been removed
            }
        }
        String nameToCheck = handle;
        boolean accountExists = false;
        for (Account Account : accountsList) {
            if (Account.getUserHandle().equals(nameToCheck)) {
                accountExists = true;
                break; // Exit the loop once an account has been found
            }
        }

        // Print the result of the check
        if (accountExists) {
            System.out.println("An account with the name " + nameToCheck + " exists in the list.");
        } else {
            System.out.println("An account with the name " + nameToCheck + " does not exist in the list.");
        }

    }

    /**
     * Changes handle of user when requested
     *
     * @param oldHandle given handle that account wants to change
     * @param newHandle new handle for account
     * @throws socialmedia.HandleNotRecognisedException thrown when Handle is not recognised by platform
     * @throws socialmedia.IllegalHandleException thrown when Handle has already been assigned
     * @throws socialmedia.InvalidHandleException thrown when Handle is empty, contains white space or is above character limit
     */

    @Override
    public void changeAccountHandle(String oldHandle, String newHandle)
            throws socialmedia.HandleNotRecognisedException, socialmedia.IllegalHandleException, socialmedia.InvalidHandleException {
        // TODO Auto-generated method stub

        // THIS CHECKS IF OLD HANDLE IN USE OR NOT
        for (int i = 1; i <= 1; i++) {
            try {
                // check if handle already in list
                boolean CheckHandle = LIST.contains(oldHandle);
                if (CheckHandle) {
                    break;
                } else {

                    throw new socialmedia.HandleNotRecognisedException("Handle " + oldHandle + " not recognised");
                }
            } catch (socialmedia.HandleNotRecognisedException e) {
                System.out.println("Handle " + oldHandle + " not recognised");
                throw new socialmedia.HandleNotRecognisedException();
            }
        }


        // THIS CHECKS IF NEW HANDLE ALREADY USED
        for (int i = 1; i <= 1; i++) {
            try {
                // check if handle already in list
                boolean CheckHandle = LIST.contains(newHandle);
                if (CheckHandle) {
                    //System.out.println("Please choose different handle");
                    throw new socialmedia.IllegalHandleException("Please choose different handle, This handle is already taken");
                } else {

                    //System.out.println("Handle accepted");
                }
            } catch (socialmedia.IllegalHandleException e) {
                System.out.println("Please choose different handle, This handle is already taken");
                throw new socialmedia.IllegalHandleException();
            }
        }

        int HanLength = newHandle.length();
        // THIS CHECKS FOR CHAR LIMIT
        try {
            if (HanLength > 31 || HanLength < 1)
                throw new socialmedia.InvalidHandleException("Character limit broken, Must be between 1 and 30 characters ");
        } catch (socialmedia.InvalidHandleException e) {
            System.out.println(newHandle + " has broken character limit, Must be between 1 and 30 characters ");
            throw new socialmedia.InvalidHandleException();
        }
        // THIS CHECKS FOR WHITE SPACE
        try {
            if (newHandle.matches(".*\\s+.*"))
                throw new socialmedia.InvalidHandleException("Handle includes whitespace, must be removed");
        } catch (socialmedia.InvalidHandleException e) {
            System.out.println("Handle, " + newHandle + " includes whitespace, must be removed");
            throw new socialmedia.InvalidHandleException();
        }


        if (HanLength > 1 && HanLength < 31) {
            //System.out.println("Count is " + HanLength);
        }


        // FIND TARGET ACCOUNT BY USING OLD HANDLE
        String targetAccountHandle = oldHandle;
        Account targetAccount = null;

        for (Account account : accountsList) {
            //System.out.println("Account Name: " + account.getUserHandle());
            if (account.getUserHandle() == targetAccountHandle) {
                targetAccount = account;

            }
        }

        if (targetAccount != null) {
            targetAccount.changeUserHandle(newHandle);
            System.out.println("Updated name of account to " + targetAccount.getNewHandle());
        }


        int targetIndex = LIST.indexOf(oldHandle);

        // GET INDEX OF TARGET HANDLE
        if (targetIndex != -1) {
            //System.out.println(oldHandle + " found at index " + targetIndex);
        } else {
            System.out.println(oldHandle + " not found in the list");
        }
        LIST.set(targetIndex, newHandle);


        //System.out.println(accountsList);
        //System.out.println(LIST);
    }

    /**
     * Changes description of Account when requested
     *
     * @param handle gicen handle of account
     * @param description given new description of account
     * @throws socialmedia.HandleNotRecognisedException thrown when Handle is not recognised by platform
     */

    @Override
    public void updateAccountDescription(String handle, String description) throws socialmedia.HandleNotRecognisedException {
        // TODO Auto-generated method stub


        // THIS CHECKS IF HANDLE IN USE OR NOT
        for (int i = 1; i <= 1; i++) {
            try {
                // check if handle already in list
                boolean CheckHandle = LIST.contains(handle);
                if (CheckHandle) {
                    break;
                } else {

                    throw new socialmedia.HandleNotRecognisedException("Handle " + handle + " not recognised");
                }
            } catch (socialmedia.HandleNotRecognisedException e) {
                System.out.println("Handle " + handle + " not recognised");
                throw new socialmedia.HandleNotRecognisedException();
            }
        }

        // Make Sure description length isn't above 100
        int DescLength = description.length();
        if (DescLength > 100) {
            System.out.println("Description has broken character limit, Must be between 1 and 100 characters ");
        }

        // FIND TARGET ACCOUNT BY USING HANDLE
        String targetAccountHandle = handle;
        Account targetAccount = null;

        for (Account account : accountsList) {
            //System.out.println("Account Name: " + account.getUserHandle());
            if (account.getUserHandle() == targetAccountHandle) {
                targetAccount = account;

            }
        }

        if (targetAccount != null) {
            targetAccount.changeUserDescription(description);
            System.out.println("Updated description of account to " + targetAccount.getNewDescription());
        }


    }

    /**
     * Shows stats of Account when requested, including stats for their posts, comments, and endorses
     *
     * @param handle given handle of account
     * @throws socialmedia.HandleNotRecognisedException thrown when Handle is not recognised by platform
     * @return Statement showing all stats of account chosen
     */

    @Override
    public String showAccount(String handle) throws socialmedia.HandleNotRecognisedException {
        // TODO Auto-generated method stub

        // THIS CHECKS IF HANDLE IN USE OR NOT
        for (int i = 1; i <= 1; i++) {
            try {
                // check if handle already in list
                boolean CheckHandle = LIST.contains(handle);
                if (CheckHandle) {
                    break;
                } else {

                    throw new socialmedia.HandleNotRecognisedException("Handle " + handle + " not recognised");
                }
            } catch (socialmedia.HandleNotRecognisedException e) {
                System.out.println("Handle " + handle + " not recognised");
                throw new socialmedia.HandleNotRecognisedException();
            }
        }

        // FIND TARGET ACCOUNT BY USING HANDLE
        String targetAccountHandle = handle;
        Account targetAccount = null;

        for (Account account : accountsList) {
            if (account.getUserHandle() == handle) {
                targetAccount = account;

            }
        }
        String ReturnedStatement = "";
        if (targetAccount != null) {
            String[] arr = {"ID: " + targetAccount.getUserID(), "Handle: " + targetAccount.getUserHandle(), "Description: " + targetAccount.getUserDescription(), "Post Count: " + targetAccount.getPostCount(), "Endorse Count: " + targetAccount.getEndorseCount()};
            //System.out.println("ID: " + targetAccount.getUserID());
            //System.out.println("Handle: " + targetAccount.getUserHandle());
            //System.out.println("Description: " + targetAccount.getUserDescription());
            ReturnedStatement = (String.join(System.lineSeparator(), arr));

            System.out.println(ReturnedStatement);
        }


        return ReturnedStatement;
    }

    /**
     * Creates a post which includes post id, message and can be altered
     *
     * @param handle  to identify account
     * @param message to display for account
     * @throws socialmedia.HandleNotRecognisedException thrown when Handle is not recognised by platform
     * @throws socialmedia.InvalidPostException thrown when Post is empty or is above character limit
     * @return ID of post
     */

    @Override
    public int createPost(String handle, String message) throws socialmedia.HandleNotRecognisedException, socialmedia.InvalidPostException {
        // TODO Auto-generated method stub

        // THIS CHECKS IF HANDLE IN USE OR NOT
        for (int i = 1; i <= 1; i++) {
            try {
                // check if handle already in list
                boolean CheckHandle = LIST.contains(handle);
                if (CheckHandle) {
                    break;
                } else {

                    throw new socialmedia.HandleNotRecognisedException("Handle " + handle + " not recognised");
                }
            } catch (socialmedia.HandleNotRecognisedException e) {
                System.out.println("Handle " + handle + " not recognised");
                throw new socialmedia.HandleNotRecognisedException();
            }
        }

        // FIND TARGET ACCOUNT BY USING HANDLE
        Account targetAccount = null;

        for (Account account : accountsList) {
            if (account.getUserHandle() == handle) {
                targetAccount = account;
            }
        }


        // CHECK IF MESSAGE IS > 0 AND < 100 CHARS
        int MessLength = message.length();

        try {
            if (MessLength > 100 || MessLength < 1)
                throw new socialmedia.InvalidPostException("Message has broken character limit, Must be between 1 and 100 characters ");
        } catch (socialmedia.InvalidPostException e) {
            System.out.println("Message has broken character limit, Must be between 1 and 100 characters ");
            throw new RuntimeException();
        }

        //System.out.println("Message is: " + message);

        Postid++;
        // THEN ADD POST TO PLATFORM + ADD POST TO ACCOUNT POST COUNT
        Post myPost = new Post(handle, Postid, message, Postid, 0, 0);
        //System.out.println("---------------");
        //System.out.println(myPost.getPostID());
        //System.out.println(myPost.getUserHandle());
        //System.out.println(myPost.getPostMessage());
        //System.out.println(myPost.getOriginalPostID());
        //System.out.println(myPost.getEndorsementCount());
        //System.out.println(myPost.getCommentCount());
        //System.out.println("---------------");
        listOfPostID.add(Postid);
        myPost.StartCount();
        Post[] posts = {myPost};
        for (Post Account : posts) {
            postsList.add(myPost);
        }

        if (targetAccount != null) {
            targetAccount.IncreasePostCount();
            targetAccount.AddToList(Postid);
            List<Integer> testList = targetAccount.getPostIdForAccount();
            // To Test the List of Post IDs for current Account
            //System.out.println(targetAccount.getUserHandle() + testList);
        }

        //System.out.println(postsList);
        //System.out.println(listOfPostID);

        // To test post
        //System.out.println("POST: " + handle + Postid + message + "******************");

        return Postid;
    }

    /**
     * Creates a post which includes post id, message and can be altered
     *
     * @param handle to identify account that wants to endorse message
     * @param id     of original post
     * @throws socialmedia.HandleNotRecognisedException thrown when Handle is not recognised by platform
     * @throws socialmedia.PostIDNotRecognisedException thrown when ID of post is not recognised by platform
     * @throws socialmedia.NotActionablePostException thrown when trying to endorse a not actionable post
     * @return ID of post
     */

    @Override
    public int endorsePost(String handle, int id)
            throws socialmedia.HandleNotRecognisedException, socialmedia.PostIDNotRecognisedException, socialmedia.NotActionablePostException {
        // TODO Auto-generated method stub
        //id = Postid;
        // THIS CHECKS IF HANDLE IN USE OR NOT
        for (int i = 1; i <= 1; i++) {
            try {
                // check if handle already in list
                boolean CheckHandle = LIST.contains(handle);
                if (CheckHandle) {
                    break;
                } else {

                    throw new socialmedia.HandleNotRecognisedException("Handle " + handle + " not recognised");
                }
            } catch (socialmedia.HandleNotRecognisedException e) {
                System.out.println("Handle " + handle + " not recognised");
                throw new socialmedia.HandleNotRecognisedException();
            }
        }


        // CHECK IF POST ID IS STILL WORKING
        for (int i = 1; i <= 1; i++) {
            try {
                // check if handle already in list
                boolean CheckPostID = listOfPostID.contains(id);
                if (CheckPostID) {
                    break;
                } else {

                    throw new socialmedia.PostIDNotRecognisedException("Post ID " + id + " not recognised");
                }
            } catch (socialmedia.PostIDNotRecognisedException e) {
                System.out.println("Post ID " + id + " not recognised");
                throw new socialmedia.PostIDNotRecognisedException();
            }
        }

        // ENDORSE POST BY FINDING POST MESSAGE
        Integer OriginalID = id; // original id

        if (listOfPostID.contains(OriginalID) && !listOfEndID.contains(OriginalID) && !listOfCommID.contains(OriginalID)) {
            Post targetPost = null;

            for (Post post : postsList) {
                if (post.getPostID() == id) { // match original id
                    targetPost = post; // find original post
                }
            }
            targetPost.IncreaseEndorsementCount();
            String OriginalHandle = targetPost.getUserHandle(); // original handle
            Account targetAccount = null;
            for (Account account : accountsList) {
                if (account.getUserHandle() == OriginalHandle) {
                    targetAccount = account; // find account of original post

                }
            }


            String EndorseHandle = handle; // new handle
            Account CurrentAccount = null;
            for (Account account : accountsList) {
                if (account.getUserHandle() == handle) {
                    CurrentAccount = account; // find account of current user
                }
            }


            Postid++;
            // add post to original handle
            //Post endorsement = new Post(handle, Postid++, targetPost.getPostMessage(), targetPost.getOriginalPostID());
            Endorsement endorsement = new Endorsement(handle, targetPost.getPostMessage(), targetPost.getOriginalPostID(), Postid);
            listOfEndID.add(Postid);
            //targetPost.IncreaseEndorsementCount();
            //targetAccount.IncreaseEndorseCount();
            listOfPostID.add(Postid);
            Endorsement[] endorses = {endorsement};
            for (Endorsement endorse : endorses) {
                EndorsementsList.add(endorsement);
            }

            if (CurrentAccount != null) {
                targetAccount.IncreaseEndorseCount();
                targetAccount.getEndorseCount();

                // increase endorsement number for original
                CurrentAccount.AddToList(Postid);

                List<Integer> testList = CurrentAccount.getPostIdForAccount();
                // To Test the List of Post IDs for current Account
                //System.out.println(CurrentAccount.getUserHandle() + testList);
            }

            String ReturnedEndorsement;
            if (targetPost != null) {
                String[] arr = {"Id: " + endorsement.getPostID() + ": " + handle + " Endorsed: " + targetPost.getUserHandle() + ": " + targetPost.getPostMessage()};
                ReturnedEndorsement = (String.join(System.lineSeparator(), arr));

                System.out.println(ReturnedEndorsement);
            }
        }

        if ( listOfCommID.contains(OriginalID)) {
            Comment targetComment = null;

            for (Comment Comment : commentsList) {
                if (Comment.getPostID() == id) { // match original id
                    targetComment = Comment; // find original post
                }
            }

            String OriginalHandle = targetComment.getUserHandle(); // original handle
            Account targetAccount = null;
            for (Account account : accountsList) {
                if (account.getUserHandle() == OriginalHandle) {
                    targetAccount = account; // find account of original post
                }
            }
            //targetAccount.IncreaseEndorseCount();

            String EndorseHandle = handle; // new handle
            Account CurrentAccount = null;
            for (Account account : accountsList) {
                if (account.getUserHandle() == handle) {
                    CurrentAccount = account; // find account of current user
                }
            }


            Postid++;
            // add post to original handle
            //Post endorsement = new Post(handle, Postid++, targetPost.getPostMessage(), targetPost.getOriginalPostID());
            Endorsement endorsement = new Endorsement(handle, targetComment.getPostComment(), targetComment.getOriginalPostID(), Postid);
            listOfEndID.add(Postid);
            targetComment.IncreaseEndorseCount();
            listOfPostID.add(Postid);
            Endorsement[] endorses = {endorsement};
            for (Endorsement endorse : endorses) {
                EndorsementsList.add(endorsement);
            }

            if (CurrentAccount != null) {
                targetAccount.IncreaseEndorseCount();
                targetAccount.getEndorseCount();

                // increase endorsement number for original
                CurrentAccount.AddToList(Postid);

                List<Integer> testList = CurrentAccount.getPostIdForAccount();
                // To Test the List of Post IDs for current Account
                System.out.println(CurrentAccount.getUserHandle() + testList);
            }

            String ReturnedEndorsement;
            if (targetComment != null) {
                String[] arr = {"Id: " + endorsement.getPostID() + ": " + handle + " Endorsed: " + targetComment.getUserHandle() + ": " + targetComment.getPostComment()};
                ReturnedEndorsement = (String.join(System.lineSeparator(), arr));

                System.out.println(ReturnedEndorsement);
            }
        }


        return Postid;


    }


    /**
     * Comments on Post, by gathering id of previous post
     *
     * @param handle  given handle to identify account that wants to comment message
     * @param id      id of original post
     * @param message new message of comment
     * @throws socialmedia.HandleNotRecognisedException thrown when Handle is not recognised by platform
     * @throws socialmedia.PostIDNotRecognisedException thrown when ID of post is not recognised by platform
     * @throws socialmedia.NotActionablePostException thrown when trying to endorse a not actionable post
     * @throws socialmedia.InvalidPostException thrown when Post message is empty or has too many characters
     * @return ID of post
     */

    @Override
    public int commentPost(String handle, int id, String message) throws socialmedia.HandleNotRecognisedException,
            socialmedia.PostIDNotRecognisedException, socialmedia.NotActionablePostException, socialmedia.InvalidPostException {
        // TODO Auto-generated method stub
        // check if handle already in list
        boolean checkHandle = false;
        for (Account account : accountsList) {
            if (account.getUserHandle().equals(handle)) {
                checkHandle = true;
                break;
            }
        }
        if (!checkHandle) {
            throw new socialmedia.HandleNotRecognisedException("Handle " + handle + " not recognised");
        }

        // check if post id is valid
        boolean checkPostID = false;
        boolean PostOrComment = false; // If false: it is Post else Comment
        Post OriginalPost = null;
        Comment OriginalComment = null;
        for (Post post : postsList) {
            if (post.getPostID() == id) {
                checkPostID = true;
                OriginalPost = post;


            }
        }
        for (Comment comment : commentsList) {
            if (comment.getPostID() == id) {
                checkPostID = true;
                OriginalComment = comment;

                PostOrComment = true;


            }
        }


        int CommLength = message.length();

        try {
            if (CommLength > 100 || CommLength < 1)
                throw new socialmedia.InvalidPostException("Message has broken character limit, Must be between 1 and 100 characters ");
        } catch (socialmedia.InvalidPostException e) {
            System.out.println("Message has broken character limit, Must be between 1 and 100 characters ");
            throw new RuntimeException();
        }


        if (!checkPostID) {
            throw new socialmedia.PostIDNotRecognisedException("Post ID " + id + " not recognised");
        }


        Account currentAccount = null;
        for (Account account : accountsList) {
            if (account.getUserHandle().equals(handle)) {
                currentAccount = account;
                break;
            }
        }
        // create new comment

        if (!PostOrComment) {
            Postid++;
            Comment newComment = new Comment(handle, message, OriginalPost.getPostID(), Postid, 0, 0);
            listOfPostID.add(Postid);
            listOfCommID.add(Postid);
            OriginalPost.StartCount();
            OriginalPost.IncreaseCommentCount();

            Comment[] comments = {newComment};
            for (Comment Account : comments) {
                commentsList.add(newComment);

            }

            if (currentAccount != null) {
                currentAccount.IncreaseCommentCount();
                currentAccount.AddToList(newComment.getPostID());
            }

            String ReturnedEndorsement;
            if (currentAccount != null) {
                String[] arr = {"Id: " + Postid + ": " + newComment.getUserHandle() + " Commented: " + newComment.getPostComment()};
                ReturnedEndorsement = (String.join(System.lineSeparator(), arr));

                System.out.println(ReturnedEndorsement);

            }
        } else {
            Postid++;
            Comment newComment = new Comment(handle, message, OriginalComment.getPostID(), Postid, 0, 0);
            OriginalComment.StartCount();
            OriginalComment.IncreaseCommentCount();
            OriginalComment.getCommentCount();
            listOfPostID.add(Postid);
            listOfCommID.add(Postid);
            Comment[] comments = {newComment};
            for (Comment Account : comments) {
                commentsList.add(newComment);
            }

            if (currentAccount != null) {
                currentAccount.IncreaseCommentCount();
                currentAccount.AddToList(newComment.getPostID());
            }

            String ReturnedEndorsement;
            if (currentAccount != null) {
                String[] arr = {"Id: " + Postid + ": " + newComment.getUserHandle() + " Commented: " + newComment.getPostComment()};
                ReturnedEndorsement = (String.join(System.lineSeparator(), arr));

                System.out.println(ReturnedEndorsement);

            }
        }
        return Postid;
    }

    /**
     * The method removes the post from the platform. When a post is removed, all
     * its endorsements should be removed as well.
     *
     * @param id ID of post to be removed.
     * @throws socialmedia.PostIDNotRecognisedException thrown when ID of post is not recognised by platform
     */


    @Override
    public void deletePost(int id) throws socialmedia.PostIDNotRecognisedException {
        // TODO Auto-generated method stub
        // CHECK IF POST ID IS STILL WORKING
        for (int i = 1; i <= 1; i++) {
            try {
                // check if handle already in list
                boolean CheckPostID = listOfPostID.contains(id);
                if (CheckPostID) {
                    break;
                } else {

                    throw new socialmedia.PostIDNotRecognisedException("Post ID " + id + " not recognised");
                }
            } catch (socialmedia.PostIDNotRecognisedException e) {
                System.out.println("Post ID " + id + " not recognised");
                throw new socialmedia.PostIDNotRecognisedException();
            }
        }
        //System.out.println(listOfPostID);
        //System.out.println(listOfEndID);
        //System.out.println(listOfCommID);

        Integer OriginalID = id;
        if (listOfPostID.contains(OriginalID) && !listOfEndID.contains(OriginalID) && !listOfCommID.contains(OriginalID)) {

            Post targetPost = null;
            for (Post post : postsList) {

                if (post.getPostID() == id) {// match original id
                    targetPost = post; // find original post

                }
            }

            Endorsement endorsementPost = null;
            for (Endorsement endorsement : EndorsementsList) {
                if (endorsement.getOriginalPostID() == targetPost.getPostID()) { // match original id
                    endorsementPost = endorsement;
                    int index2 = listOfPostID.indexOf(endorsementPost.getPostID());// find original post

                    listOfPostID.remove(index2);
                }
            }

            Integer a = targetPost.getEndorsementCount();
            Integer b = targetPost.getCommentCount();
            //System.out.println(listOfPostID);
            int index1 = listOfPostID.indexOf(id);
            listOfPostID.remove(index1);
            postsList.remove(index1);
            //System.out.println(listOfPostID);

            Comment commentPost = null;
            for (Comment comment : commentsList) {
                if (comment.getOriginalPostID() == targetPost.getPostID()) { // match original id
                    commentPost = comment; // find original post
                    Post myPost = new Post("", -1, "The original content was removed from the system and is no longer available.", -1, 0, 0);
                    commentPost.ChangeOriginalID(-1);
                    commentPost.getOriginalPostID();
                }
            }


            String OriginalHandle = targetPost.getUserHandle(); // original handle
            Account targetAccount = null;
            for (Account account : accountsList) {
                if (account.getUserHandle() == OriginalHandle) {
                    targetAccount = account; // find account of original post
                }
            }

            targetAccount.DecreasePostCount();
            targetAccount.DecreaseEndorseCount(a);
            targetAccount.DecreaseCommentCount(b);


            int idToCheck = id;
            boolean postExists = false;
            for (Post Post : postsList) {
                if (Post.getOriginalPostID().equals(idToCheck)) {
                    postExists = true;
                    break; // Exit the loop once a post has been found
                }
            }
            //System.out.println(postsList);
            // Print the result of the check
            if (postExists) {
                System.out.println("A post with id " + idToCheck + " exists in the list.");
            } else {
                System.out.println("A post with id " + idToCheck + " does not exist in the list.");
            }

        }

        if (listOfEndID.contains(OriginalID) && !listOfCommID.contains(OriginalID)) {


            Endorsement endorsementPost = null;
            for (Endorsement endorsement : EndorsementsList) {
                if (endorsement.getPostID() == OriginalID) { // match original id
                    endorsementPost = endorsement; // find original post
                }
            }

            System.out.println(listOfPostID);
            System.out.println(EndorsementsList);


            int index1 = listOfPostID.indexOf(id);
            listOfPostID.remove(index1);
            System.out.println(listOfPostID);
            int index = listOfEndID.indexOf(id);
            listOfEndID.remove(index);
            EndorsementsList.remove(index);


            String OriginalHandle = endorsementPost.getUserHandle(); // original handle
            Account targetAccount = null;
            for (Account account : accountsList) {
                if (account.getUserHandle() == OriginalHandle) {
                    targetAccount = account; // find account of original post
                }
            }

            targetAccount.DecreasePostCount();


            int idToCheck = id;
            boolean postExists = false;
            for (Endorsement Endorsement : EndorsementsList) {
                if (Endorsement.getPostID().equals(idToCheck)) {
                    postExists = true;
                    break; // Exit the loop once a post has been found
                }
            }

            // Print the result of the check
            if (postExists) {
                System.out.println("An account with id " + idToCheck + " exists in the list.");
            } else {
                System.out.println("An account with id " + idToCheck + " does not exist in the list.");
            }


        } else if (!listOfEndID.contains(OriginalID) && listOfCommID.contains(OriginalID)) {


            Comment commentPost = null;
            for (Comment comment : commentsList) {
                if (comment.getPostID() == OriginalID) { // match original id
                    commentPost = comment; // find original post
                }
            }

            System.out.println(listOfPostID);
            System.out.println(commentsList);


            int commentindex = listOfPostID.indexOf(id);
            listOfPostID.remove(commentindex);
            System.out.println(listOfPostID);
            int index3 = listOfCommID.indexOf(id);
            listOfCommID.remove(index3);
            commentsList.remove(index3);


            Account targetAccount2 = null;
            for (Account account : accountsList) {
                if (account.getUserHandle() == commentPost.getUserHandle()) {
                    targetAccount2 = account; // find account of original post
                }
            }

            targetAccount2.DecreasePostCount();

            // Change Comment that links to deleted comment
            Comment commentPost2 = null;
            for (Comment comment : commentsList) {
                if (comment.getOriginalPostID() == OriginalID) { // match original id
                    commentPost2 = comment; // find original post
                    Comment myPost = new Comment("", "The original content was removed from the system and is no longer available.", -1, -1, 0, 0);
                    commentPost2.ChangeOriginalID(-1);
                    commentPost2.getOriginalPostID();
                }
            }


            int CheckID = id;
            boolean PostExists = false;
            for (Comment Comment : commentsList) {
                if (Comment.getPostID().equals(CheckID)) {
                    PostExists = true;
                    break; // Exit the loop once a post has been found
                }
            }

            // Print the result of the check
            if (PostExists) {
                System.out.println("An account with id " + CheckID + " exists in the list.");
            } else {
                System.out.println("An account with id " + CheckID + " does not exist in the list.");
            }

        }


    }


    /**
     * Create an empty Post to be used when a post is removed but the comment should still be seen
     */


    public void EmptyPost() {
        Post myPost = new Post("", -1, "The original content was removed from the system and is no longer available.", -1, 0, 0);

    }


    /**
     * The method generates a formated string containing the details of a single
     * post.
     *
     * @param id of the post to be shown.
     * @return a formatted string containing post's details.
     * @throws socialmedia.PostIDNotRecognisedException if the ID does not match to any post in
     *                                      the system.
     */


    @Override
    public String showIndividualPost(int id) throws socialmedia.PostIDNotRecognisedException {
        // TODO Auto-generated method stub

        // Checks if id is in use or not
        for (int i = 1; i <= 1; i++) {
            try {
                // check if handle already in list
                boolean CheckPostID = listOfPostID.contains(id);
                if (CheckPostID) {
                    break;
                } else {

                    throw new socialmedia.PostIDNotRecognisedException("Post ID " + id + " not recognised");
                }
            } catch (socialmedia.PostIDNotRecognisedException e) {
                System.out.println("Post ID " + id + " not recognised");
                throw new socialmedia.PostIDNotRecognisedException();
            }
        }


        Integer OriginalID = id;
        String ReturnedEndorsement = null;
        String newline = System.getProperty("line.separator");

        if (listOfPostID.contains(OriginalID) && !listOfEndID.contains(OriginalID) && !listOfCommID.contains(OriginalID)) {

            Post targetPost = null;

            for (Post post : postsList) {
                if (post.getPostID() == id) { // match original id
                    targetPost = post; // find original post
                }
            }


            if (targetPost != null) {
                String[] arr = {"\nId: " + targetPost.getPostID() + "\nAccount: " + targetPost.getUserHandle()
                        + " \nNo. endorsements: " + targetPost.getEndorsementCount() + " | " + "No. comments: " + targetPost.getCommentCount()
                        + newline + targetPost.getPostMessage()};
                ReturnedEndorsement = (String.join(System.lineSeparator(), arr));

                System.out.println(ReturnedEndorsement);
            }
        }

        if (listOfEndID.contains(OriginalID) && !listOfCommID.contains(OriginalID)) {


            Endorsement endorsementPost = null;
            for (Endorsement endorsement : EndorsementsList) {
                if (endorsement.getPostID() == id) { // match original id
                    endorsementPost = endorsement; // find original post
                }
            }
            if (endorsementPost != null) {
                String[] arr = {"\nId: " + endorsementPost.getPostID() + "\nAccount: " + endorsementPost.getUserHandle()
                        + newline + endorsementPost.getPostComment()};
                ReturnedEndorsement = (String.join(System.lineSeparator(), arr));

                System.out.println(ReturnedEndorsement);
            }


        } else {


            Comment commentPost = null;
            for (Comment comment : commentsList) {
                if (comment.getPostID() == id) { // match original id
                    commentPost = comment; // find original post
                }
            }
            if (commentPost != null) {
                String[] arr = {"\nId: " + commentPost.getPostID() + "\nAccount: " + commentPost.getUserHandle()
                        + " \nNo. endorsements: " + commentPost.getEndorseCount() + " | " + "No. comments: " + commentPost.getCommentCount()
                        + newline + commentPost.getPostComment()};
                ReturnedEndorsement = (String.join(System.lineSeparator(), arr));

                System.out.println(ReturnedEndorsement);
            }


        }


        return ReturnedEndorsement;
    }


    /**
     * The method builds a StringBuilder showing the details of the current post and
     * all its children posts.
     * This is sorted by ID and order of when Post/comment was created
     *
     * @param id of the post to be shown.
     * @return a formatted StringBuilder containing the details of the post and its
     * children.
     * @throws socialmedia.PostIDNotRecognisedException if the ID does not match to any post in
     *                                      the system.
     * @throws socialmedia.NotActionablePostException   if the ID refers to an endorsement post.
     * Endorsement posts do not have children since they are not endorsable nor commented.
     */


    @Override
    public StringBuilder showPostChildrenDetails(int id)
            throws socialmedia.PostIDNotRecognisedException, socialmedia.NotActionablePostException {
        // TODO Auto-generated method stub

        // Checks if id is in use or not
        for (int i = 1; i <= 1; i++) {
            try {
                // check if handle already in list
                boolean CheckPostID = listOfPostID.contains(id);
                if (CheckPostID) {
                    break;
                } else {

                    throw new socialmedia.PostIDNotRecognisedException("Post ID " + id + " not recognised");
                }
            } catch (socialmedia.PostIDNotRecognisedException e) {
                System.out.println("Post ID " + id + " not recognised");
                throw new socialmedia.PostIDNotRecognisedException();
            }
        }
        Integer OriginalID = id;

        if (listOfEndID.contains(OriginalID)) {
            System.out.println("Cannot show Endorsement Post");
            throw new socialmedia.NotActionablePostException("Cannot show Endorsement Post");
        }
        StringBuilder ReturnStringBuilder = new StringBuilder();
        String ReturnedEndorsement = null;
        String ReturnedEndorsement1 = null;
        String newline = System.getProperty("line.separator");


        if (listOfPostID.contains(OriginalID) & !listOfCommID.contains(OriginalID)) {

            Post targetPost = null;

            for (Post post : postsList) {
                if (post.getPostID() == id) { // match original id
                    targetPost = post; // find original post
                }
            }


            if (targetPost != null) {
                String[] arr = {"\nId: " + targetPost.getPostID() + "\nAccount: " + targetPost.getUserHandle()
                        + " \nNo. endorsements: " + targetPost.getEndorsementCount() + " | " + "No. comments: " + targetPost.getCommentCount()
                        + newline + targetPost.getPostMessage()};
                ReturnedEndorsement = (String.join(System.lineSeparator(), arr));

                ReturnStringBuilder.append(ReturnedEndorsement);
                //System.out.println(ReturnStringBuilder);
            }


            List<Comment> commentsToProcess = new ArrayList<>();
            String indentation = "";

            // Find comments with original post ID matching OriginalID and add them to the list of comments to process
            for (Comment comment : commentsList) {
                if (comment.getOriginalPostID() == id) {
                    commentsToProcess.add(comment);
                    while (!commentsToProcess.isEmpty()) {
                        List<Comment> childComments = new ArrayList<>();
                        ReturnStringBuilder.append("\n");
                        for (Comment recursivecomment : commentsToProcess) {
                            ReturnStringBuilder.append((indentation) + "|" + "\n");
                            ReturnStringBuilder.append((indentation) + "| > Id: " + recursivecomment.getPostID() + "\n");
                            ReturnStringBuilder.append((indentation) + "    Account: " + recursivecomment.getUserHandle() + "\n");
                            ReturnStringBuilder.append((indentation) + "    No. endorsements: " + recursivecomment.getEndorseCount() + " | No. comments: " + recursivecomment.getCommentCount() + "\n");
                            ReturnStringBuilder.append((indentation) + "    " + recursivecomment.getPostComment() + "\n");

                            // Find child comments and add them to the list of child comments to process
                            for (Comment childComment : commentsList) {
                                if (childComment.getOriginalPostID() == recursivecomment.getPostID()) {
                                    childComments.add(childComment);
                                }
                            }
                        }
                        indentation = indentation + "\t";
                        commentsToProcess = childComments;
                    }
                }
                indentation = "";
            }
        }

        if (listOfCommID.contains(OriginalID)) {


            Comment targetComment = null;
            for (Comment comment : commentsList) {
                if (comment.getPostID() == id) { // match original id
                    targetComment = comment; // find original post
                }
            }

            String indentation = "";
            boolean Addindentation = false;

            if (targetComment.getOriginalPostID() == -1) {
                //System.out.println(targetComment.getOriginalPostID());
                String[] arr = {"The original content was removed from the system and is no longer available."};
                ReturnedEndorsement = (String.join(System.lineSeparator(), arr));

                ReturnStringBuilder.append(ReturnedEndorsement);
                ReturnStringBuilder.append("\n" + (indentation) + "|" + "\n" + "| > ");

                String[] arrr = {"Id: " + targetComment.getPostID() + indentation + "\n\tAccount: " + targetComment.getUserHandle()
                        + indentation + " \n\tNo. endorsements: " + targetComment.getEndorseCount() + " | " + "No. comments: " + targetComment.getCommentCount()
                        + indentation + newline + "\t" + targetComment.getPostComment()};
                ReturnedEndorsement = (String.join(System.lineSeparator(), arrr));
                ReturnStringBuilder.append(ReturnedEndorsement);
                Addindentation = true;


            }


            // Test if original comment or post has been deleted for comment
            if (targetComment != null & targetComment.getOriginalPostID() != -1) {
                String[] arr = {(indentation) + "\nId: " + targetComment.getPostID() + indentation + "\nAccount: " + targetComment.getUserHandle()
                        + indentation + " \nNo. endorsements: " + targetComment.getEndorseCount() + " | " + "No. comments: " + targetComment.getCommentCount()
                        + indentation + newline + targetComment.getPostComment()};
                ReturnedEndorsement = (String.join(System.lineSeparator(), arr));
                ReturnStringBuilder.append(ReturnedEndorsement);
                //System.out.println(ReturnStringBuilder);
            }


            List<Comment> commentsToProcess = new ArrayList<>();


            // Find comments with original post ID matching OriginalID and add them to the list of comments to process
            for (Comment comment : commentsList) {
                if (comment.getOriginalPostID() == id) {
                    commentsToProcess.add(comment);
                    while (!commentsToProcess.isEmpty()) {
                        List<Comment> childComments = new ArrayList<>();
                        ReturnStringBuilder.append("\n");
                        if (Addindentation == true) {
                            indentation = indentation + "\t";
                        }

                        for (Comment recursivecomment : commentsToProcess) {
                            ReturnStringBuilder.append((indentation) + "|" + "\n");
                            ReturnStringBuilder.append((indentation) + "| > Id: " + recursivecomment.getPostID() + "\n");
                            ReturnStringBuilder.append((indentation) + "    Account: " + recursivecomment.getUserHandle() + "\n");
                            ReturnStringBuilder.append((indentation) + "    No. endorsements: " + recursivecomment.getEndorseCount() + " | No. comments: " + recursivecomment.getCommentCount() + "\n");
                            ReturnStringBuilder.append((indentation) + "    " + recursivecomment.getPostComment() + "\n");

                            // Find child comments and add them to the list of child comments to process
                            for (Comment childComment : commentsList) {
                                if (childComment.getOriginalPostID() == recursivecomment.getPostID()) {
                                    childComments.add(childComment);
                                }
                            }
                        }
                        indentation = indentation + "\t";
                        commentsToProcess = childComments;
                    }
                }
                indentation = "";
            }


        }


        System.out.println(ReturnStringBuilder);
        return ReturnStringBuilder;
    }

    /**
     * This method returns the current total number of accounts present in the
     * platform.
     *
     * @return the total number of accounts in the platform.
     */

    @Override
    public int getNumberOfAccounts() {
        // TODO Auto-generated method stub
        // FIND NUM FROM ACCOUNTSLIST
        int numAccounts = accountsList.size();
        System.out.println("Number of accounts: " + numAccounts);

        // FIND NUM FROM LIST OF HANDLES
        int numOfList = LIST.size();
        assert numOfList == numAccounts : "Numbers do not match, Accounts Broken";

        return numOfList;
    }

    /**
     * This method returns the current total number of original posts present in the platform.
     *
     * @return the total number of original posts in the platform.
     */


    @Override
    public int getTotalOriginalPosts() {
        // TODO Auto-generated method stub
        List<Integer> OriginalPosts = new ArrayList<>(); // List containing all handles

        for (Integer item : listOfPostID) {
            if (!listOfCommID.contains(item) && !listOfEndID.contains(item)) {
                OriginalPosts.add(item);
            }
        }

        int TotalOriginalPosts = OriginalPosts.size();


        System.out.println("Total Original Posts: " + TotalOriginalPosts);
        return TotalOriginalPosts;
    }

    /**
     * This method returns the current total number of endorsement posts present in
     * the platform.
     *
     * @return the total number of endorsement posts in the platform.
     */
    @Override
    public int getTotalEndorsmentPosts() {
        // TODO Auto-generated method stub
        List<Integer> EndorsementPosts = new ArrayList<>(); // List containing all handles

        for (Integer item : listOfPostID) {
            if (!listOfCommID.contains(item) && listOfEndID.contains(item)) {
                EndorsementPosts.add(item);
            }
        }

        int TotalEndorsementPosts = EndorsementPosts.size();

        System.out.println("Total Endorsement Posts: " + TotalEndorsementPosts);
        return TotalEndorsementPosts;
    }

    /**
     * This method returns the current total number of comments posts present in the
     * platform.
     *
     * @return the total number of comments posts in the platform.
     */

    @Override
    public int getTotalCommentPosts() {
        // TODO Auto-generated method stub
        List<Integer> CommentPosts = new ArrayList<>(); // List containing all handles

        for (Integer item : listOfPostID) {
            if (listOfCommID.contains(item) && !listOfEndID.contains(item)) {
                CommentPosts.add(item);
            }
        }

        int TotalCommentPosts = CommentPosts.size();

        System.out.println("Total Comment Posts: " + TotalCommentPosts);
        return TotalCommentPosts;
    }

    /**
     * This method identifies and returns the post with the most number of
     * endorsements.
     *
     * @return the ID of the most popular post.
     */

    @Override
    public int getMostEndorsedPost() {
        // TODO Auto-generated method stub
        Integer CheckMost = 0;
        Integer ReturnPostID = 0;

        for (Endorsement Endorse : EndorsementsList) {
            Endorse.getOriginalPostID();

            for (Post post : postsList) {
                post.getEndorsementCount();

                if (post.getEndorsementCount() > CheckMost) {
                    CheckMost = post.getEndorsementCount();
                }
            }

            for (Comment comment : commentsList) {
                comment.getEndorseCount();

                if (comment.getEndorseCount() > CheckMost) {
                    CheckMost = comment.getEndorseCount();
                }
            }
        }

        for (Post post : postsList) {
            post.getEndorsementCount();
            if (post.getEndorsementCount() == CheckMost) {
                ReturnPostID = post.getPostID();
            }

        }

        for (Comment comment : commentsList) {
            comment.getEndorseCount();
            if (comment.getEndorseCount() == CheckMost) {
                ReturnPostID = comment.getEndorseCount();
            }

        }

        System.out.println("Most endorsed Post: " + ReturnPostID);
        return ReturnPostID;
    }

    /**
     * This method identifies and returns the account with the most number of
     * endorsements
     *
     * @return the ID of the most popular account.
     */
    @Override
    public int getMostEndorsedAccount() {
        // TODO Auto-generated method stub
        Integer CheckMost = 0;
        Integer ReturnPostID = 0;

        for (Endorsement Endorse : EndorsementsList) {
            Endorse.getOriginalPostID();

            for (Account account : accountsList) {
                account.getEndorseCount();

                if (account.getEndorseCount() > CheckMost) {
                    CheckMost = account.getEndorseCount();
                }
            }
        }
        for (Account account : accountsList) {
            account.getUserID();
            if (account.getEndorseCount() == CheckMost) {
                ReturnPostID = account.getUserID();
            }

        }
        System.out.println("Most endorsed Account: " + ReturnPostID);
        return ReturnPostID;
    }

    /**
     * Method empties the platform of its contents and resets all
     * internal counters.
     */
    @Override
    public void erasePlatform() {
        // TODO Auto-generated method stub

        for (Account account : accountsList) {
            account.PostIdForAccount.clear();
        }
        LIST.clear();
        listOfEndID.clear();
        listOfPostID.clear();
        listOfEndID.clear();
        postsList.clear();
        EndorsementsList.clear();
        commentsList.clear();
        accountsList.clear();
        id = 0;
        Postid = 0;
    }

    /**
     * Method saves this SocialMediaPlatform's contents into a serialised file, with
     * the filename given in the argument.
     *
     * @param filename location of the file to be saved
     * @throws IOException if there is a problem experienced when trying to save the
     *                     store contents to the file
     */

    @Override
    public void savePlatform(String filename) throws IOException {
        // TODO Auto-generated method stub

        try (ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(filename))) {

            objOut.writeObject(LIST);
            objOut.writeObject(listOfCommID);
            objOut.writeObject(listOfEndID);
            objOut.writeObject(listOfPostID);
            objOut.writeObject(accountsList);
            objOut.writeObject(postsList);
            objOut.writeObject(EndorsementsList);
            objOut.writeObject(commentsList);
            objOut.writeInt(id);
            objOut.writeInt(Postid);
            objOut.close();
        } catch (java.io.IOException e) {
            throw new java.io.IOException("An error occurred while saving the data to " + filename, e);
        }
    }

    /**
     * Method should load and replace the platforms contents with the
     * serialised contents stored in the file given in the argument.
     *
     * @param filename location of the file to be loaded
     * @throws IOException            if there is a problem experienced when trying
     *                                to load the store contents from the file
     * @throws ClassNotFoundException if required class files cannot be found when
     *                                loading
     */

    @Override
    public void loadPlatform(String filename) throws IOException, ClassNotFoundException {
        // TODO Auto-generated method stub
        try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(filename))) {
            // Read the objects in the same order they were written

            List<String> LIST = (List<String>) objIn.readObject();
            List<Integer> listOfCommID = (List<Integer>) objIn.readObject();
            List<Integer> listOfEndID = (List<Integer>) objIn.readObject();
            List<Integer> listOfPostID = (List<Integer>) objIn.readObject();
            List<Account> accountsList = (List<Account>) objIn.readObject();

            List<Post> postsList = (List<Post>) objIn.readObject();

            List<Endorsement> EndorsementsList = (List<Endorsement>) objIn.readObject();

            List<Comment> commentsList = (List<Comment>) objIn.readObject();

            int id = objIn.readInt();
            int Postid = objIn.readInt();



            // Assign the loaded data to your variables
            this.LIST = LIST;
            this.listOfCommID = listOfCommID;
            this.listOfEndID = listOfEndID;
            this.listOfPostID = listOfPostID;
            this.accountsList = accountsList;
            this.postsList = postsList;
            this.EndorsementsList = EndorsementsList;
            this.commentsList = commentsList;
            this.id = id;
            this.Postid = Postid;




        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("An error occurred while loading the data from " + filename, e);
        }


    }


}
