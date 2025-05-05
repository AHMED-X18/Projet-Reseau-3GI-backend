package com._GI.Network.project.Controller;

import com._GI.Network.project.Models.API;
import com._GI.Network.project.Service.APIService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class API_Controller {

    @Autowired
    private APIService APIService;

    @GetMapping
    public ResponseEntity<List<API>> getall(){
        List<API> api= APIService.findAll();
        return new ResponseEntity<>(api, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<API> getByName(@PathVariable String nom){
        API api = APIService.findByName(nom);
        return api !=null ? new ResponseEntity<>(api, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
