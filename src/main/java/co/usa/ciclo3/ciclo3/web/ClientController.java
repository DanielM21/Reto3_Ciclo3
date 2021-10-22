package co.usa.ciclo3.ciclo3.web;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins= "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ClientController {
    @Autowired
    private ClientService services;
    @GetMapping("/all")
    public List<Client> getClient(){
        return services.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id")int idClient) {return services.getClient(idClient);}

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client){
        return services.save(client);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client){return services.update(client);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clientId){return services.deleteClient(clientId);}

}
