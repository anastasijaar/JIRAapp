package rs.raf.projekat1.anastasija_radonjic_rn6819.models;

public class Bug {

    private String id;
    private String priority;
    private int estimation;
    private String title;
    private String description;

    public Bug(String priority, int estimation, String title, String description) {
        this.priority = priority;
        this.estimation = estimation;
        this.title = title;
        this.description = description;
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
}
