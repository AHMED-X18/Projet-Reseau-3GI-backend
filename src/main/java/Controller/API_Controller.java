package Controller;

import Models.API;
import Service.API_service;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class API_Controller {

    @Autowired
    private API_service APIService;

    @GetMapping
    public ResponseEntity<List<API>> getall(){
        List<API> api= APIService.findAll();
        return new ResponseEntity<>(api, HttpStatus.OK);
    }
    @GetMapping("/{id")
    public ResponseEntity<API> getByName(@PathVariable String nom){
        API api = APIService.findByName(nom);
        return api !=null ? new ResponseEntity<>(api, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<API> createAPI (@RequestBody API api){
        API createdAPI = APIService.createAPI(api);
        return new ResponseEntity<>(createdAPI, HttpStatus.CREATED);
    }

    @PutMapping("/{id")
    public ResponseEntity<API> updateAPI (@PathVariable String id, @RequestBody API api){
        API updatedAPI = APIService.updateAPI(id, api);
        return updatedAPI != null ? new ResponseEntity<>(updatedAPI, HttpStatus.OK) :new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAPI(@PathVariable String id) {
        if (!APIService.existById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
