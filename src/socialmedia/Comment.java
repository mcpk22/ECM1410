package src.socialmedia;

import java.io.Serializable;

/** Account is a class used to store data for each Account used in the Social Media,
* and allows for the backend to interact with each user
*
* @author Jayant Chawla, Pui Kin Chan
* @version 1.0
*/
public class Comment implements Serializable {

    public String UserHandle;
    public Integer PostID;
    public String PostComment;

    public Integer OriginalPostID;
    public Integer CommentCount;

    public Integer EndorseCount;
    public Comment(String UserHandle, String PostComment, Integer OriginalPostID, Integer PostID, Integer CommentCount, Integer EndorseCount){
        this.UserHandle = UserHandle;
        this.PostID = PostID;
        this.PostComment = PostComment;
        this.OriginalPostID = OriginalPostID;
        this.CommentCount = CommentCount;
        this.EndorseCount = EndorseCount;
    }


    public String getUserHandle() {
        return UserHandle;
    }

    public Integer getPostID() {
        return PostID;
    }

    public String getPostComment() {
        return PostComment;
    }

    public Integer getOriginalPostID(){return OriginalPostID;}

    public void StartCount(){
        CommentCount = 0;
        EndorseCount = 0;
    }
    public Integer getCommentCount(){
        return CommentCount;
    }
    public Integer IncreaseCommentCount(){
        CommentCount = CommentCount + 1;
        return CommentCount;
    }

    public Integer ChangeOriginalID(Integer a){
        OriginalPostID = -1;
        OriginalPostID = a;
        return OriginalPostID;
    }

    public Integer getEndorseCount(){return EndorseCount;}

    public Integer IncreaseEndorseCount(){EndorseCount = EndorseCount + 1;
    return EndorseCount;}

}