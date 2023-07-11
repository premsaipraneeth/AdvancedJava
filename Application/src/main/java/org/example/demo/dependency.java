package org.example.demo;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api")
public class dependency {

    private service exampleService;

    @Autowired
    public dependency(service exampleService) {
        this.exampleService = exampleService;
    }

    @GetMapping("/data")
    public List<String> getAllData() {
        return exampleService.getAllData();
    }

    @GetMapping("/data/{id}")
    public String getDataById(@PathVariable int id) {
        return exampleService.getDataById(id);
    }

    @PostMapping("/add")
    public void addData(@RequestBody String data) {
        exampleService.addData(data);
    }

    @PutMapping("/data/{id}")
    public void updateData(@PathVariable int id, @RequestBody String data) {
        exampleService.updateData(id, data);
    }

    @DeleteMapping("/data/{id}")
    public void deleteData(@PathVariable int id) {
        exampleService.deleteData(id);
    }
}
