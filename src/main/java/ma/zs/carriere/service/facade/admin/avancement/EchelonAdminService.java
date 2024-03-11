package ma.zs.carriere.service.facade.admin.avancement;

import java.util.List;
import ma.zs.carriere.bean.core.avancement.Echelon;
import ma.zs.carriere.dao.criteria.core.avancement.EchelonCriteria;
import ma.zs.carriere.zynerator.service.IService;



public interface EchelonAdminService extends  IService<Echelon,EchelonCriteria>  {

    List<Echelon> findByEchelleId(Long id);
    int deleteByEchelleId(Long id);
    long countByEchelleId(Long id);




}
