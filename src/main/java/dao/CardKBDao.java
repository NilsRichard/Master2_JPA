package dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import dao.generic.AbstractJpaDao;
import domain.CardKB;

public class CardKBDao extends AbstractJpaDao<Long, CardKB> {

	public CardKBDao() {
		super(CardKB.class);
	}
	
	private List<CardKB> findLike(String attribute, String value){
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<CardKB> cq = cb.createQuery(CardKB.class);

		Root<CardKB> card = cq.from(CardKB.class);
		Predicate predicate = cb.like(card.get(attribute), "%"+value+"%");
		cq.where(predicate);

		TypedQuery<CardKB> query = entityManager.createQuery(cq);
		return query.getResultList();
	}
	
	public List<CardKB> findLabelLike(String value) {
		return findLike("label", value);
	}

	public List<CardKB> findUrlLike(String value) {
		return findLike("url", value);
	}

	public List<CardKB> findLocationLike(String value) {
		return findLike("location", value);
	}
	
	public void populate() {
		if (findAll().isEmpty()) {
			save(new CardKB("card1","description",45,"internet.fr","France"));
			save(new CardKB("card2","good description",15,"web.fr","France"));
		}
	}

}
