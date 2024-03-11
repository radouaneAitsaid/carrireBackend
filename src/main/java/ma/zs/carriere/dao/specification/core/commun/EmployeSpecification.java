package  ma.zs.carriere.dao.specification.core.commun;

import ma.zs.carriere.dao.criteria.core.commun.EmployeCriteria;
import ma.zs.carriere.bean.core.commun.Employe;
import ma.zs.carriere.zynerator.specification.AbstractSpecification;


public class EmployeSpecification extends  AbstractSpecification<EmployeCriteria, Employe>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicate("username", criteria.getUsername(),criteria.getUsernameLike());
        addPredicate("nom", criteria.getNom(),criteria.getNomLike());
        addPredicate("password", criteria.getPassword(),criteria.getPasswordLike());
        addPredicateBigDecimal("salaire", criteria.getSalaire(), criteria.getSalaireMin(), criteria.getSalaireMax());
    }

    public EmployeSpecification(EmployeCriteria criteria) {
        super(criteria);
    }

    public EmployeSpecification(EmployeCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
