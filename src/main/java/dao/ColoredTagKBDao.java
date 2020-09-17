package dao;

import dao.generic.AbstractJpaDao;
import domain.ColoredTagKB;

public class ColoredTagKBDao extends AbstractJpaDao<Long, ColoredTagKB> {

	public ColoredTagKBDao() {
		super(ColoredTagKB.class);
	}

}
