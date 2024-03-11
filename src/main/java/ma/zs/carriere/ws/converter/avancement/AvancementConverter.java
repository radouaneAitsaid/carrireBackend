package  ma.zs.carriere.ws.converter.avancement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.zs.carriere.ws.converter.avancement.EchelonConverter;
import ma.zs.carriere.ws.converter.commun.EmployeConverter;



import ma.zs.carriere.zynerator.util.StringUtil;
import ma.zs.carriere.zynerator.converter.AbstractConverter;
import ma.zs.carriere.zynerator.util.DateUtil;
import ma.zs.carriere.bean.core.avancement.Avancement;
import ma.zs.carriere.ws.dto.avancement.AvancementDto;

@Component
public class AvancementConverter extends AbstractConverter<Avancement, AvancementDto> {

    @Autowired
    private EchelonConverter echelonConverter ;
    @Autowired
    private EmployeConverter employeConverter ;
    private boolean employe;
    private boolean echelon;

    public  AvancementConverter() {
        super(Avancement.class, AvancementDto.class);
        init(true);
    }

    @Override
    public Avancement toItem(AvancementDto dto) {
        if (dto == null) {
            return null;
        } else {
        Avancement item = new Avancement();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getSalaireAjoute()))
                item.setSalaireAjoute(dto.getSalaireAjoute());
            if(this.employe && dto.getEmploye()!=null &&  dto.getEmploye().getId() != null)
                item.setEmploye(employeConverter.toItem(dto.getEmploye())) ;

            if(this.echelon && dto.getEchelon()!=null &&  dto.getEchelon().getId() != null)
                item.setEchelon(echelonConverter.toItem(dto.getEchelon())) ;




        return item;
        }
    }

    @Override
    public AvancementDto toDto(Avancement item) {
        if (item == null) {
            return null;
        } else {
            AvancementDto dto = new AvancementDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getSalaireAjoute()))
                dto.setSalaireAjoute(item.getSalaireAjoute());
            if(this.employe && item.getEmploye()!=null) {
                dto.setEmploye(employeConverter.toDto(item.getEmploye())) ;

            }
            if(this.echelon && item.getEchelon()!=null) {
                dto.setEchelon(echelonConverter.toDto(item.getEchelon())) ;

            }


        return dto;
        }
    }

    public void copy(AvancementDto dto, Avancement t) {
    super.copy(dto, t);
    if (dto.getEmploye() != null)
        employeConverter.copy(dto.getEmploye(), t.getEmploye());
    if (dto.getEchelon() != null)
        echelonConverter.copy(dto.getEchelon(), t.getEchelon());
    }



    public void initObject(boolean value) {
        this.employe = value;
        this.echelon = value;
    }


    public EchelonConverter getEchelonConverter(){
        return this.echelonConverter;
    }
    public void setEchelonConverter(EchelonConverter echelonConverter ){
        this.echelonConverter = echelonConverter;
    }
    public EmployeConverter getEmployeConverter(){
        return this.employeConverter;
    }
    public void setEmployeConverter(EmployeConverter employeConverter ){
        this.employeConverter = employeConverter;
    }
    public boolean  isEmploye(){
        return this.employe;
    }
    public void  setEmploye(boolean employe){
        this.employe = employe;
    }
    public boolean  isEchelon(){
        return this.echelon;
    }
    public void  setEchelon(boolean echelon){
        this.echelon = echelon;
    }
}
