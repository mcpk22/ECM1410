package src.socialmedia;

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
public class Post implements Serializable{

    public String UserHandle;
    public Integer PostID;
    public String PostMessage;

    public Integer OriginalPostID;

    public Integer CommentCount;
    public Integer EndorsementCount;
    public Post(String UserHandle, Integer PostID, String PostMessage, Integer OriginalPostID, Integer EndorsementCount, Integer CommentCount){
        this.UserHandle = UserHandle;
        this.PostID = PostID;
        this.PostMessage = PostMessage;
        this.OriginalPostID = OriginalPostID;
        this.EndorsementCount = EndorsementCount;
        this.CommentCount = CommentCount;
    }


    public String getUserHandle() {
        return UserHandle;
    }

    public Integer getPostID() {
        return PostID;
    }

    public String getPostMessage() {
        return PostMessage;
    }

    public Integer getOriginalPostID(){return OriginalPostID;}

    public void StartCount(){
        CommentCount = 0;
        EndorsementCount = 0;
    }
    public Integer getCommentCount(){return CommentCount;}
    public Integer getEndorsementCount(){return EndorsementCount;}
    public Integer IncreaseEndorsementCount(){
        EndorsementCount = EndorsementCount + 1;
        return EndorsementCount;

    }

    public Integer ChangeEndorsementCount(Integer a){EndorsementCount = a;
    return EndorsementCount;}


    public Integer IncreaseCommentCount(){
        CommentCount = CommentCount + 1;
        return CommentCount;}


}
