package src.socialmedia;

import src.src.socialmedia.Endorsement;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.util.*;

/**
 * Account is a class used to store data for each Account used in the Social Media,
 * and allows for the backend to interact with each user
 *
 * @author Jayant Chawla, Pui Kin Chan
 * @version 1.0
 */

public class Account implements Serializable{
    public String UserHandle;
    public Integer UserID;
    public String UserDescription;

    public Integer PostCount;

    public Integer EndorseCount;

    public Integer CommentCount;

    public List<Integer> PostIdForAccount = new ArrayList<>(); // List containing all Post IDs for user

    public Account(Integer UserID, String UserHandle, String UserDescription, Integer EndorseCount, Integer CommentCount) {
        this.UserHandle = UserHandle;
        this.UserID = UserID;
        this.UserDescription = UserDescription;
        this.EndorseCount = EndorseCount;
        this.CommentCount = CommentCount;
    }

    public Integer getUserID() {
        return UserID;
    }
    public String getUserHandle() {
        return UserHandle;
    }

    public String getUserDescription(){
        return UserDescription;

    }

    public String changeUserHandle(String UserHandle){
        this.UserHandle = UserHandle;
        return UserHandle;
    }

    public String getNewHandle(){
        return UserHandle;
    }

    public String changeUserDescription(String UserDescription){
        this.UserDescription = UserDescription;
        return UserDescription;
    }

    public String getNewDescription(){
        return UserDescription;
    }

    public void StartCount(){
        EndorseCount = 0;
        PostCount = 0;
        CommentCount = 0;
    }

    public Integer getPostCount(){ return PostCount;}

    public Integer getEndorseCount(){ return EndorseCount;}

    public Integer getCommentCount(){ return CommentCount;}

    public Integer IncreasePostCount(){
        PostCount = PostCount + 1;
        return PostCount;
    }

    public Integer IncreaseEndorseCount(){
        EndorseCount = EndorseCount + 1;
        return EndorseCount;
    }

    public Integer IncreaseCommentCount() {
        CommentCount = CommentCount + 1;
        return CommentCount;
    }

    public Integer DecreasePostCount(){PostCount = PostCount - 1;
        return PostCount;}

    public Integer DecreaseEndorseCount(Integer a){
        EndorseCount = EndorseCount - a;
        return EndorseCount;
    }

    public Integer DecreaseCommentCount(Integer b) {
        CommentCount = CommentCount - b;
        return CommentCount;
    }


    public void AddToList(Integer PostId){
        PostIdForAccount.add(PostId);
    }

    public void setPostList(List<Integer> PostIdForAccount){
        this.PostIdForAccount = PostIdForAccount;
    }

    public List<Integer> getPostIdForAccount(){
        //System.out.println(PostIdForAccount);
        return PostIdForAccount;
    }


}
