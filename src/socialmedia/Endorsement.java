package src.src.socialmedia;

import java.io.Serializable;

public class Endorsement implements Serializable {

    public String UserHandle;
    public Integer PostID;
    public String PostComment;

    public Integer OriginalPostID;
    public Endorsement(String UserHandle, String PostComment, Integer OriginalPostID, Integer PostID){
        this.UserHandle = UserHandle;
        this.PostID = PostID;
        this.PostComment = PostComment;
        this.OriginalPostID = OriginalPostID;
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








}
