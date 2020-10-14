package dao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import dao.generic.AbstractJpaDao;
import domain.BoardKB;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
public class BoardKBDao extends AbstractJpaDao<Long, BoardKB> {

    public BoardKBDao() {
        super(BoardKB.class);
    }

    public BoardKB findByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BoardKB> cq = cb.createQuery(BoardKB.class);

        Root<BoardKB> board = cq.from(BoardKB.class);
        Predicate boardNamePredicate = cb.equal(board.get("name"), name);
        cq.where(boardNamePredicate);

        TypedQuery<BoardKB> query = entityManager.createQuery(cq);
        return query.getSingleResult();
    }

    public void populate() {
        if (findAll().isEmpty()) {
            save(new BoardKB("First_Board"));
            save(new BoardKB("Second_Board"));
        }
    }

}
