package it.marcomolinari.model.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.marcomolinari.model.User;
import it.marcomolinari.model.service.UserService;

@RestController
@RequestMapping("/usercontroller")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/findall")
	public List<User> findAll(){
		return userService.findAllUser();
		}
	@GetMapping("/findbyid")
	public Optional<User> findById(@RequestParam Long id){
		return userService.findUserById(id);
	}
	@PostMapping("/saveuser")
	public void saveUser(@RequestBody User user) {

		userService.saveUser(user);
	}
	
	// Paginazione
    @GetMapping(value = "/mygetalluserspage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<User>> myGetAllUsersPage(Pageable pageable) {
        Page<User> findAll = userService.myFindAllUsersPageable(pageable);
        if (findAll.hasContent()) {
            return new ResponseEntity<>(findAll, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping(value = "/mygetalluserspagesize", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> myGetAllUsersPageSize(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "3") int size) {
        Page<User> users = userService.myFindAllUsersPageSize(page, size);
        Map<String, Object> myResponse = new HashMap<>();
        myResponse.put("users", users);
        return myResponse;
    }
    @GetMapping(value = "/mygetalluserspagesizesort", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> myGetAllUserPageSizeSort(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size, @RequestParam(defaultValue = "id") String sort) {
      List<User> list = userService.myFindAllUsersPageSizeSort(page, size, sort);
      return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK); 
    }
    @GetMapping(value = "/mygetalluserssortbyname", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> myGetAllusersSortByName() {
        return userService.myFindAllUsersSorted();
    }
}
