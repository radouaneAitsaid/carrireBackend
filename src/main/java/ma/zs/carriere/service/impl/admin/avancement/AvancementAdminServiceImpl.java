package ma.zs.carriere.service.impl.admin.avancement;


import ma.zs.carriere.bean.core.avancement.Avancement;
import ma.zs.carriere.dao.criteria.core.avancement.AvancementCriteria;
import ma.zs.carriere.dao.facade.core.avancement.AvancementDao;
import ma.zs.carriere.dao.specification.core.avancement.AvancementSpecification;
import ma.zs.carriere.service.facade.admin.avancement.AvancementAdminService;
import ma.zs.carriere.zynerator.service.AbstractServiceImpl;
import ma.zs.carriere.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.carriere.service.facade.admin.avancement.EchelonAdminService ;
import ma.zs.carriere.bean.core.avancement.Echelon ;
import ma.zs.carriere.service.facade.admin.commun.EmployeAdminService ;
import ma.zs.carriere.bean.core.commun.Employe ;

import java.util.List;
@Service
public class AvancementAdminServiceImpl extends AbstractServiceImpl<Avancement, AvancementCriteria, AvancementDao> implements AvancementAdminService {






    public Avancement findByReferenceEntity(Avancement t){
        return  dao.findByRef(t.getRef());
    }
    public void findOrSaveAssociatedObject(Avancement t){
        if( t != null) {
            t.setEmploye(employeService.findOrSave(t.getEmploye()));
            t.setEchelon(echelonService.findOrSave(t.getEchelon()));
        }
    }

    public List<Avancement> findByEmployeId(Long id){
        return dao.findByEmployeId(id);
    }
    public int deleteByEmployeId(Long id){
        return dao.deleteByEmployeId(id);
    }
    public long countByEmployeRef(String ref){
        return dao.countByEmployeRef(ref);
    }
    public List<Avancement> findByEchelonId(Long id){
        return dao.findByEchelonId(id);
    }
    public int deleteByEchelonId(Long id){
        return dao.deleteByEchelonId(id);
    }
    public long countByEchelonId(Long id){
        return dao.countByEchelonId(id);
    }

    public List<Avancement> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Avancement.class, AvancementSpecification.class);
    }


    @Autowired
    private EchelonAdminService echelonService ;
    @Autowired
    private EmployeAdminService employeService ;

    public AvancementAdminServiceImpl(AvancementDao dao) {
        super(dao);
    }

}
