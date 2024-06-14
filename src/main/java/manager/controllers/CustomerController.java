package manager.controllers;

import manager.models.Customer;
import manager.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public ModelAndView getList() {
        ModelAndView list = new ModelAndView("home");
        list.addObject("customers", customerService.findAll());
        return list;
    }

    @GetMapping("/create")
    public ModelAndView getCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Customer customer) {
        customerService.addCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/edit/{id}")
    public String getEdit(@PathVariable int id, ModelMap modelMap) {
        Customer customer = customerService.findById(id);
        if (customer == null) {
            modelMap.addAttribute("message", "Customer not found");
            return "error";
        } else {
            modelMap.addAttribute("customer", customer);
            return "edit";
        }
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, @ModelAttribute Customer customer) {
        customerService.updateCustomer(id, customer);
        return "redirect:/customer/list";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }
}
