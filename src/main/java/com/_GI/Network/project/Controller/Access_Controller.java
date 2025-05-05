package com._GI.Network.project.Controller;

import com._GI.Network.project.Models.Access;
import com._GI.Network.project.Models.Id_access;
import com._GI.Network.project.Service.AccessService;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/access")
public class Access_Controller {

    @Autowired
    private AccessService AccessService;

    @GetMapping
    public ResponseEntity<List<Access>> getHistory(){
        List<Access> Access= AccessService.findAll();
        return new ResponseEntity<>(Access, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getByID(@PathVariable Id_access id){
        @NotNull Optional<Access> Access = AccessService.findById(id);
        return Access.isPresent() ? new ResponseEntity<>(Access, HttpStatus.OK): new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Access> createAccess (@RequestBody Access Access){
        Access createdAccess = AccessService.createAccess(Access);
        return new ResponseEntity<>(createdAccess, HttpStatus.CREATED);
    }

}
