package  ma.zs.carriere.dao.specification.core.avancement;

import ma.zs.carriere.dao.criteria.core.avancement.AvancementCriteria;
import ma.zs.carriere.bean.core.avancement.Avancement;
import ma.zs.carriere.zynerator.specification.AbstractSpecification;


public class AvancementSpecification extends  AbstractSpecification<AvancementCriteria, Avancement>  {

    @Override
    public void constructPredicates() {
        addPredicateId("id", criteria);
        addPredicate("ref", criteria.getRef(),criteria.getRefLike());
        addPredicateBigDecimal("salaireAjoute", criteria.getSalaireAjoute(), criteria.getSalaireAjouteMin(), criteria.getSalaireAjouteMax());
        addPredicateFk("employe","id", criteria.getEmploye()==null?null:criteria.getEmploye().getId());
        addPredicateFk("employe","id", criteria.getEmployes());
        addPredicateFk("employe","ref", criteria.getEmploye()==null?null:criteria.getEmploye().getRef());
        addPredicateFk("echelon","id", criteria.getEchelon()==null?null:criteria.getEchelon().getId());
        addPredicateFk("echelon","id", criteria.getEchelons());
    }

    public AvancementSpecification(AvancementCriteria criteria) {
        super(criteria);
    }

    public AvancementSpecification(AvancementCriteria criteria, boolean distinct) {
        super(criteria, distinct);
    }

}
