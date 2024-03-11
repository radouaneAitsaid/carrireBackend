package  ma.zs.carriere.dao.criteria.core.avancement;


import ma.zs.carriere.dao.criteria.core.commun.EmployeCriteria;

import ma.zs.carriere.zynerator.criteria.BaseCriteria;
import java.util.List;

public class AvancementCriteria extends  BaseCriteria  {

    private String ref;
    private String refLike;
    private String salaireAjoute;
    private String salaireAjouteMin;
    private String salaireAjouteMax;

    private EmployeCriteria employe ;
    private List<EmployeCriteria> employes ;
    private EchelonCriteria echelon ;
    private List<EchelonCriteria> echelons ;


    public AvancementCriteria(){}

    public String getRef(){
        return this.ref;
    }
    public void setRef(String ref){
        this.ref = ref;
    }
    public String getRefLike(){
        return this.refLike;
    }
    public void setRefLike(String refLike){
        this.refLike = refLike;
    }

    public String getSalaireAjoute(){
        return this.salaireAjoute;
    }
    public void setSalaireAjoute(String salaireAjoute){
        this.salaireAjoute = salaireAjoute;
    }   
    public String getSalaireAjouteMin(){
        return this.salaireAjouteMin;
    }
    public void setSalaireAjouteMin(String salaireAjouteMin){
        this.salaireAjouteMin = salaireAjouteMin;
    }
    public String getSalaireAjouteMax(){
        return this.salaireAjouteMax;
    }
    public void setSalaireAjouteMax(String salaireAjouteMax){
        this.salaireAjouteMax = salaireAjouteMax;
    }
      

    public EmployeCriteria getEmploye(){
        return this.employe;
    }

    public void setEmploye(EmployeCriteria employe){
        this.employe = employe;
    }
    public List<EmployeCriteria> getEmployes(){
        return this.employes;
    }

    public void setEmployes(List<EmployeCriteria> employes){
        this.employes = employes;
    }
    public EchelonCriteria getEchelon(){
        return this.echelon;
    }

    public void setEchelon(EchelonCriteria echelon){
        this.echelon = echelon;
    }
    public List<EchelonCriteria> getEchelons(){
        return this.echelons;
    }

    public void setEchelons(List<EchelonCriteria> echelons){
        this.echelons = echelons;
    }
}
