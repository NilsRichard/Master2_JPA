package dao;

import dao.generic.AbstractJpaDao;
import domain.ColumnKB;

public class ColumnKBDao extends AbstractJpaDao<Long, ColumnKB> {

	public ColumnKBDao() {
		super(ColumnKB.class);
	}

}
