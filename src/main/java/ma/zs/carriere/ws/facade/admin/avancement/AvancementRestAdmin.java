package  ma.zs.carriere.ws.facade.admin.avancement;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.carriere.bean.core.avancement.Avancement;
import ma.zs.carriere.dao.criteria.core.avancement.AvancementCriteria;
import ma.zs.carriere.service.facade.admin.avancement.AvancementAdminService;
import ma.zs.carriere.ws.converter.avancement.AvancementConverter;
import ma.zs.carriere.ws.dto.avancement.AvancementDto;
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
@RequestMapping("/api/admin/avancement/")
public class AvancementRestAdmin  extends AbstractController<Avancement, AvancementDto, AvancementCriteria, AvancementAdminService, AvancementConverter> {



    @Operation(summary = "upload one avancement")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple avancements")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all avancements")
    @GetMapping("")
    public ResponseEntity<List<AvancementDto>> findAll() throws Exception {
        return super.findAll();
    }

    @Operation(summary = "Finds an optimized list of all avancements")
    @GetMapping("optimized")
    public ResponseEntity<List<AvancementDto>> findAllOptimized() throws Exception {
        return super.findAllOptimized();
    }

    @Operation(summary = "Finds a avancement by ref")
    @GetMapping("ref/{ref}")
    public ResponseEntity<AvancementDto> findByRef(@PathVariable String ref) {
        return super.findByReferenceEntity(new Avancement(ref));
    }

    @Operation(summary = "Saves the specified  avancement")
    @PostMapping("")
    public ResponseEntity<AvancementDto> save(@RequestBody AvancementDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  avancement")
    @PutMapping("")
    public ResponseEntity<AvancementDto> update(@RequestBody AvancementDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of avancement")
    @PostMapping("multiple")
    public ResponseEntity<List<AvancementDto>> delete(@RequestBody List<AvancementDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified avancement")
    @DeleteMapping("")
    public ResponseEntity<AvancementDto> delete(@RequestBody AvancementDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified avancement")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple avancements by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by employe id")
    @GetMapping("employe/id/{id}")
    public List<AvancementDto> findByEmployeId(@PathVariable Long id){
        return findDtos(service.findByEmployeId(id));
    }
    @Operation(summary = "delete by employe id")
    @DeleteMapping("employe/id/{id}")
    public int deleteByEmployeId(@PathVariable Long id){
        return service.deleteByEmployeId(id);
    }
    @Operation(summary = "find by echelon id")
    @GetMapping("echelon/id/{id}")
    public List<AvancementDto> findByEchelonId(@PathVariable Long id){
        return findDtos(service.findByEchelonId(id));
    }
    @Operation(summary = "delete by echelon id")
    @DeleteMapping("echelon/id/{id}")
    public int deleteByEchelonId(@PathVariable Long id){
        return service.deleteByEchelonId(id);
    }

    @Operation(summary = "Finds a avancement and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<AvancementDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds avancements by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<AvancementDto>> findByCriteria(@RequestBody AvancementCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated avancements by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody AvancementCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports avancements by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody AvancementCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets avancement data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody AvancementCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public AvancementRestAdmin (AvancementAdminService service, AvancementConverter converter) {
        super(service, converter);
    }




}
