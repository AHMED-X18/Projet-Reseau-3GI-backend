package Controller;

import Models.Access;
import Models.Id_access;
import Service.Access_service;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Access_Controller {

    @Autowired
    private Access_service AccessService;

    @GetMapping
    public ResponseEntity<List<Access>> getall(){
        List<Access> Accesss= AccessService.findAll();
        return new ResponseEntity<>(Accesss, HttpStatus.OK);
    }
    @GetMapping("/{id")
    public ResponseEntity<Access> getByID(@PathVariable Id_access id){
        Access Access = AccessService.findById(id);
        return Access !=null ? new ResponseEntity<>(Access, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Access> createAccess (@RequestBody Access Access){
        Access createdAccess = AccessService.createAccess(Access);
        return new ResponseEntity<>(createdAccess, HttpStatus.CREATED);
    }

}
