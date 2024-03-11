package ma.zs.carriere.dao.facade.core.avancement;

import org.springframework.data.jpa.repository.Query;
import ma.zs.carriere.zynerator.repository.AbstractRepository;
import ma.zs.carriere.bean.core.avancement.Echelle;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EchelleDao extends AbstractRepository<Echelle,Long>  {


    @Query("SELECT NEW Echelle(item.id,item.libelle) FROM Echelle item")
    List<Echelle> findAllOptimized();

}
