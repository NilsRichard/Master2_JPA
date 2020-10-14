package dao;

import dao.generic.AbstractJpaDao;
import domain.ColoredTagKB;

/**
 * @author Nils Richard
 * @author Dorian Bouillet
 */
public class ColoredTagKBDao extends AbstractJpaDao<Long, ColoredTagKB> {

    public ColoredTagKBDao() {
        super(ColoredTagKB.class);
    }

}
