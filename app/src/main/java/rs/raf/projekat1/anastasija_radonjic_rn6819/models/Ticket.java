package rs.raf.projekat1.anastasija_radonjic_rn6819.models;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageView;

import java.util.UUID;

public class Ticket {

    private String id;
    private String type;
    private String priority;
    private int estimation;
    private String title;
    private String description;
    private Drawable image;

    public Ticket(String title, int estimation, String description) {
        this.id = UUID.randomUUID().toString();
        this.estimation = estimation;
        this.title = title;
        this.description = description;
    }

    public Ticket(String type, String priority, int estimation, String title, String description) {
        this.type = type;
        this.priority = priority;
        this.estimation = estimation;
        this.title = title;
        this.description = description;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getEstimation() {
        return estimation;
    }

    public void setEstimation(int estimation) {
        this.estimation = estimation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
