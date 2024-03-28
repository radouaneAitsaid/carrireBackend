package ma.zs.carriere.dao.facade.core.commun;

import ma.zs.carriere.bean.core.commun.EntiteAdmin;
import ma.zs.carriere.zynerator.repository.AbstractRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EntiteAdminDao extends AbstractRepository<EntiteAdmin,Long>  {
    EntiteAdmin findByRef(String ref);
    int deleteByRef(String ref);
    List<EntiteAdmin> findByDepartement(String departement);
    int deleteByDepartement(String departement);

    List<EntiteAdmin> findByTitrePoste(String titrePoste);
    int deleteByTitrePoste(String titrePoste);


    @Query("SELECT NEW Employe(item.id,item.ref) FROM Employe item")
    List<EntiteAdmin> findAllOptimized();

}
