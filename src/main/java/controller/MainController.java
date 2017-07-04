package controller;


 import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.UserService;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping(value={"/list","/"}, method=RequestMethod.GET)
    public ModelAndView userListPage(@RequestParam(required = false) Integer page) {
        ModelAndView modelAndView = new ModelAndView("list");
        List<User> userList = userService.findAll();
        PagedListHolder<User> pagedListHolder = new PagedListHolder<>(userList);
        pagedListHolder.setPageSize(10);
        int numberOfPages = pagedListHolder.getPageCount();
        modelAndView.addObject("maxPages",numberOfPages );
        if(page==null || page < 1 || page > pagedListHolder.getPageCount()){
            page=1;
        }
        modelAndView.addObject("page", page);
        if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
            pagedListHolder.setPage(0);
             userList = pagedListHolder.getPageList();
            modelAndView.addObject("userList", userList);
        }
        else if(page <= pagedListHolder.getPageCount()) {
            pagedListHolder.setPage(page-1);
            userList = pagedListHolder.getPageList();
            modelAndView.addObject("userList", userList);
        }
        return modelAndView;
    }



    @RequestMapping(value="/search", method=RequestMethod.GET)
    public ModelAndView userSearchPage(@RequestParam(value = "searchstring", required = false) String s) {
        ModelAndView modelAndView = new ModelAndView("list");
        List<User> userList = userService.search(s);
        modelAndView.addObject("userList", userList);
        return modelAndView;
    }

    @RequestMapping(value="/create", method=RequestMethod.GET)
    public ModelAndView newUserPage() {
        return new ModelAndView("form", "user", new User());
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute User user, final RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView();
        String message = "New user " + user.getName() + " was successfully created.";
        userService.create(user);
        modelAndView.setViewName("redirect:/list");
        redirectAttributes.addFlashAttribute("message", message);
        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editUserPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        User user = userService.findById(id);
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute User user, @PathVariable Integer id, final RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        userService.update(user);
        String message = "User " + user.getName() + " was successfully updated.";
        redirectAttributes.addFlashAttribute("message", message);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public ModelAndView deleteShop(@PathVariable Integer id, final RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        User user = userService.delete(id);
        String message = "User " + user.getName() + " was successfully deleted.";
        redirectAttributes.addFlashAttribute("message", message);
        return modelAndView;
    }



}
