package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
@Entity
public class CardKB implements Serializable {

    private static final long serialVersionUID = -7963053538051720399L;

    private Long id;

    private String label;

    private String description;

    private Calendar dueDate;

    private UserKB assignedUser;

    private int estimatedTimeMinutes;

    private List<TagKB> tags = new ArrayList<>();

    private String url;

    private String location;

    private ColumnKB column;

    @Override
    public String toString() {
        return "Card [id=" + id + ", label=" + label + ", description=" + description + ", dueDate=" + dueDate
                + ", assignedUser=" + assignedUser + ", estimatedTimeMinutes=" + estimatedTimeMinutes + ", tags=" + tags
                + ", url=" + url + ", location=" + location + ", column=" + column + "]";
    }


    public CardKB() {
        super();
    }

    public CardKB(String label, String description, int estimatedTimeMinutes, String url, String location) {
        super();
        this.label = label;
        this.description = description;
        this.estimatedTimeMinutes = estimatedTimeMinutes;
        this.url = url;
        this.location = location;
    }

    public void addTag(TagKB tag) {
        this.tags.add(tag);
    }

    @OneToOne
    public UserKB getAssignedUser() {
        return assignedUser;
    }

    @ManyToOne
    public ColumnKB getColumn() {
        return column;
    }

    public String getDescription() {
        return description;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public int getEstimatedTimeMinutes() {
        return estimatedTimeMinutes;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getLocation() {
        return location;
    }

    @XmlElementWrapper(name = "tags")
    @ManyToMany(mappedBy = "cards", cascade = CascadeType.PERSIST)
    public List<TagKB> getTags() {
        return tags;
    }

    public String getUrl() {
        return url;
    }

    public void setAssignedUser(UserKB assignedUser) {
        this.assignedUser = assignedUser;
    }

    public void setColumn(ColumnKB column) {
        this.column = column;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

    public void setEstimatedTimeMinutes(int estimatedTimeMinutes) {
        this.estimatedTimeMinutes = estimatedTimeMinutes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTags(List<TagKB> tags) {
        this.tags = tags;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
