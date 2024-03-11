package ma.zs.carriere.dao.facade.core.avancement;

import org.springframework.data.jpa.repository.Query;
import ma.zs.carriere.zynerator.repository.AbstractRepository;
import ma.zs.carriere.bean.core.avancement.Echelon;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EchelonDao extends AbstractRepository<Echelon,Long>  {

    List<Echelon> findByEchelleId(Long id);
    int deleteByEchelleId(Long id);
    long countByEchelleId(Long id);

    @Query("SELECT NEW Echelon(item.id,item.libelle) FROM Echelon item")
    List<Echelon> findAllOptimized();

}
