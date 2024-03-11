package ma.zs.carriere.service.impl.admin.avancement;


import ma.zs.carriere.bean.core.avancement.Echelon;
import ma.zs.carriere.dao.criteria.core.avancement.EchelonCriteria;
import ma.zs.carriere.dao.facade.core.avancement.EchelonDao;
import ma.zs.carriere.dao.specification.core.avancement.EchelonSpecification;
import ma.zs.carriere.service.facade.admin.avancement.EchelonAdminService;
import ma.zs.carriere.zynerator.service.AbstractServiceImpl;
import ma.zs.carriere.zynerator.util.ListUtil;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;





import org.springframework.beans.factory.annotation.Autowired;

import ma.zs.carriere.service.facade.admin.avancement.EchelleAdminService ;
import ma.zs.carriere.bean.core.avancement.Echelle ;

import java.util.List;
@Service
public class EchelonAdminServiceImpl extends AbstractServiceImpl<Echelon, EchelonCriteria, EchelonDao> implements EchelonAdminService {






    public void findOrSaveAssociatedObject(Echelon t){
        if( t != null) {
            t.setEchelle(echelleService.findOrSave(t.getEchelle()));
        }
    }

    public List<Echelon> findByEchelleId(Long id){
        return dao.findByEchelleId(id);
    }
    public int deleteByEchelleId(Long id){
        return dao.deleteByEchelleId(id);
    }
    public long countByEchelleId(Long id){
        return dao.countByEchelleId(id);
    }

    public List<Echelon> findAllOptimized() {
        return dao.findAllOptimized();
    }





    public void configure() {
        super.configure(Echelon.class, EchelonSpecification.class);
    }


    @Autowired
    private EchelleAdminService echelleService ;

    public EchelonAdminServiceImpl(EchelonDao dao) {
        super(dao);
    }

}
