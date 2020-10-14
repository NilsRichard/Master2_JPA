package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class TagKB implements Serializable {

    private static final long serialVersionUID = -5312824533997938950L;

    private Long id;

    private String label;

    private List<CardKB> cards = new ArrayList<>();

    public void addCards(CardKB card) {
        this.cards.add(card);
    }

    @ManyToMany
    public List<CardKB> getCards() {
        return cards;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void setCards(List<CardKB> cards) {
        this.cards = cards;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
