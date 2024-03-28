package ma.zs.carriere.ws.converter.commun;

import ma.zs.carriere.bean.core.commun.EntiteAdmin;
import ma.zs.carriere.ws.dto.commun.EntiteAdminDto;
import ma.zs.carriere.zynerator.converter.AbstractConverter;
import ma.zs.carriere.zynerator.util.StringUtil;
import org.springframework.stereotype.Component;

@Component
public class EntiteAdminConverter extends AbstractConverter<EntiteAdmin, EntiteAdminDto> {


    public EntiteAdminConverter() {
        super(EntiteAdmin.class, EntiteAdminDto.class);
    }

    @Override
    public EntiteAdmin toItem(EntiteAdminDto dto) {
        if (dto == null) {
            return null;
        } else {
        EntiteAdmin item = new EntiteAdmin();
            if(StringUtil.isNotEmpty(dto.getId()))
                item.setId(dto.getId());
            if(StringUtil.isNotEmpty(dto.getRef()))
                item.setRef(dto.getRef());
            if(StringUtil.isNotEmpty(dto.getDepartement()))
                item.setDepartement(dto.getDepartement());
            if(StringUtil.isNotEmpty(dto.getChefDepart()))
                item.setChefDepart(dto.getChefDepart());
            if(StringUtil.isNotEmpty(dto.getTitrePoste()))
                item.setTitrePoste(dto.getTitrePoste());




        return item;
        }
    }

    @Override
    public EntiteAdminDto toDto(EntiteAdmin item) {
        if (item == null) {
            return null;
        } else {
            EntiteAdminDto dto = new EntiteAdminDto();
            if(StringUtil.isNotEmpty(item.getId()))
                dto.setId(item.getId());
            if(StringUtil.isNotEmpty(item.getRef()))
                dto.setRef(item.getRef());
            if(StringUtil.isNotEmpty(item.getDepartement()))
                dto.setDepartement(item.getDepartement());
            if(StringUtil.isNotEmpty(item.getChefDepart()))
                dto.setChefDepart(item.getChefDepart());
            if(StringUtil.isNotEmpty(item.getTitrePoste()))
                dto.setTitrePoste(item.getTitrePoste());


        return dto;
        }
    }




    public void initObject(boolean value) {
    }


}
