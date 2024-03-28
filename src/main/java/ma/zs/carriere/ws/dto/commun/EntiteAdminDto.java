package ma.zs.carriere.ws.dto.commun;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.zs.carriere.bean.core.commun.Employe;
import ma.zs.carriere.zynerator.audit.Log;
import ma.zs.carriere.zynerator.dto.AuditBaseDto;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class EntiteAdminDto extends AuditBaseDto {

    private String ref  ;
    private String departement  ;
    private String chefDepart  ;
    private String titrePoste  ;




    public EntiteAdminDto(){
        super();
    }



    @Log
    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }

    @Log
    public String getDepartement(){
        return this.departement;
    }
    public void setDepartement(String departement){
        this.departement = departement;
    }

    @Log
    public Employe getChefDepart() {
        return chefDepart;
    }

    public void setChefDepart(String chefDepart) {
        this.chefDepart = chefDepart;
    }

    @Log
    public String getTitrePoste() {
        return titrePoste;
    }

    public void setTitrePoste(String titrePoste) {
        this.titrePoste = titrePoste;
    }
}
