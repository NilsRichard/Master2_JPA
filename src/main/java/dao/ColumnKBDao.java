package dao;

import dao.generic.AbstractJpaDao;
import domain.ColumnKB;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
public class ColumnKBDao extends AbstractJpaDao<Long, ColumnKB> {

    public ColumnKBDao() {
        super(ColumnKB.class);
    }

}
