package  ma.zs.carriere.ws.facade.admin.avancement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.carriere.bean.core.avancement.Echelon;
import ma.zs.carriere.dao.criteria.core.avancement.EchelonCriteria;
import ma.zs.carriere.service.facade.admin.avancement.EchelonAdminService;
import ma.zs.carriere.ws.converter.avancement.EchelonConverter;
import ma.zs.carriere.ws.dto.avancement.EchelonDto;
import ma.zs.carriere.zynerator.controller.AbstractController;
import ma.zs.carriere.zynerator.dto.AuditEntityDto;
import ma.zs.carriere.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.carriere.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.carriere.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/echelon/")
public class EchelonRestAdmin  extends AbstractController<Echelon, EchelonDto, EchelonCriteria, EchelonAdminService, EchelonConverter> {



    @Operation(summary = "upload one echelon")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple echelons")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all echelons")
    @GetMapping("")
    public ResponseEntity<List<EchelonDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all echelons")
    @GetMapping("optimized")
    public ResponseEntity<List<EchelonDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a echelon by libelle")
    @GetMapping("libelle/{libelle}")
    public ResponseEntity<EchelonDto> findByLibelle(@PathVariable String libelle) {
        return super.findByReferenceEntity(new Echelon(libelle));
    }

    @Operation(summary = "Saves the specified  echelon")
    @PostMapping("")
    public ResponseEntity<EchelonDto> save(@RequestBody EchelonDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  echelon")
    @PutMapping("")
    public ResponseEntity<EchelonDto> update(@RequestBody EchelonDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of echelon")
    @PostMapping("multiple")
    public ResponseEntity<List<EchelonDto>> delete(@RequestBody List<EchelonDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified echelon")
    @DeleteMapping("")
    public ResponseEntity<EchelonDto> delete(@RequestBody EchelonDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified echelon")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple echelons by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by echelle id")
    @GetMapping("echelle/id/{id}")
    public List<EchelonDto> findByEchelleId(@PathVariable Long id){
        return findDtos(service.findByEchelleId(id));
    }
    @Operation(summary = "delete by echelle id")
    @DeleteMapping("echelle/id/{id}")
    public int deleteByEchelleId(@PathVariable Long id){
        return service.deleteByEchelleId(id);
    }

    @Operation(summary = "Finds a echelon and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<EchelonDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds echelons by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<EchelonDto>> findByCriteria(@RequestBody EchelonCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated echelons by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody EchelonCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports echelons by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody EchelonCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets echelon data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody EchelonCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public EchelonRestAdmin (EchelonAdminService service, EchelonConverter converter) {
        super(service, converter);
    }




}
