package app.searchlistingapp.com.data;

import android.content.Intent;
import android.net.Uri;
import android.view.View;

import java.io.Serializable;
import java.util.List;

/**
 * Created by debu on 5/11/17.
 */

public class Hits implements Serializable{
    private String comment_text;

    private String story_text;

    private List<String> _tags;

    private String url;

    private String story_title;

    private String author;

    private int num_comments;

    private String story_id;

    private String title;

    private String story_url;

    private String created_at;

    private String points;

    private String created_at_i;

    private String parent_id;

    public String getComment_text ()
    {
        return comment_text;
    }

    public void setComment_text (String comment_text)
    {
        this.comment_text = comment_text;
    }

    public String getStory_text ()
    {
        return story_text;
    }

    public void setStory_text (String story_text)
    {
        this.story_text = story_text;
    }

    public List<String> get_tags ()
    {
        return _tags;
    }

    public void set_tags (List<String> _tags)
    {
        this._tags = _tags;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getStory_title ()
    {
        return story_title;
    }

    public void setStory_title (String story_title)
    {
        this.story_title = story_title;
    }

    public String getAuthor ()
    {
        return author;
    }

    public void setAuthor (String author)
    {
        this.author = author;
    }

    public int getNum_comments ()
    {
        return num_comments;
    }

    public void setNum_comments (int num_comments)
    {
        this.num_comments = num_comments;
    }

    public String getStory_id ()
    {
        return story_id;
    }

    public void setStory_id (String story_id)
    {
        this.story_id = story_id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getStory_url ()
    {
        return story_url;
    }

    public void setStory_url (String story_url)
    {
        this.story_url = story_url;
    }

    public String getCreated_at ()
    {
        return created_at;
    }

    public void setCreated_at (String created_at)
    {
        this.created_at = created_at;
    }

    public String getPoints ()
    {
        return points;
    }

    public void setPoints (String points)
    {
        this.points = points;
    }

    public String getCreated_at_i ()
    {
        return created_at_i;
    }

    public void setCreated_at_i (String created_at_i)
    {
        this.created_at_i = created_at_i;
    }

    public String getParent_id ()
    {
        return parent_id;
    }

    public void setParent_id (String parent_id)
    {
        this.parent_id = parent_id;
    }

    public void showInBrowser(View v){
        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(url.length()>0 ? url : story_url));
        v.getContext().startActivity(intent);
    }

}
