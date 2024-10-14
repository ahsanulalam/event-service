package cptu.egp.event.controller;

import cptu.egp.event.model.Alumni;
import cptu.egp.event.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/common")
public class CommonController {

    private final CommonService commonEntityService;

    @Autowired
    public CommonController(CommonService commonEntityService) {
        this.commonEntityService = commonEntityService;
    }

    @PostMapping("/save/{db}")
    public ResponseEntity<?> saveToDatabase(@RequestBody Alumni entity, @PathVariable String db) {
        commonEntityService.saveToDatabase(entity, db);  // Pass the database name ("PRIMARY", "SECONDARY", "TERTIARY", etc.)
        return ResponseEntity.ok("Saved to " + db + " database");
    }

    @GetMapping("/all/{db}")
    public List<Alumni> getAllFromDatabase(@PathVariable String db) {
        return commonEntityService.getAllFromDatabase(db);  // Retrieve from the selected database
    }
}
