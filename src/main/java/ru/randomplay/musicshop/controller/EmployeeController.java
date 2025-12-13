package ru.randomplay.musicshop.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.randomplay.musicshop.dto.create.CategoryCreateRequest;
import ru.randomplay.musicshop.dto.update.CategoryUpdateRequest;
import ru.randomplay.musicshop.entity.Employee;
import ru.randomplay.musicshop.entity.User;
import ru.randomplay.musicshop.service.CategoryService;
import ru.randomplay.musicshop.service.EmployeeService;
import ru.randomplay.musicshop.service.OrderService;
import ru.randomplay.musicshop.service.ProductService;

@Controller
@RequestMapping("/employee")
@PreAuthorize("hasRole('EMPLOYEE')")
@RequiredArgsConstructor
public class EmployeeController {
    private final OrderService orderService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final EmployeeService employeeService;

    @GetMapping("/dashboard")
    public String productsPage(Model model,
                               @RequestParam(required = false) String table) {
        if (table == null) {
            model.addAttribute("orders", orderService.getAllWithoutConfirm());
            return "employee/orders";
        }
        switch (table) {
            case "products":
                model.addAttribute("products", productService.getAll());
                return "employee/products";
            case "categories":
                model.addAttribute("categories", categoryService.getAll());
                return "employee/categories";
            default:
                model.addAttribute("orders", orderService.getAllWithoutConfirm());
                return "employee/orders";
        }
    }

    @GetMapping("/order/{id}")
    public String orderPage(Model model,
                            @PathVariable Long id) {
        model.addAttribute("order", orderService.get(id));
        return "employee/checkOrder";
    }

    @GetMapping("/add/category")
    public String addCategoryPage() {
        return "employee/newCategory";
    }

    @GetMapping("/update/category/{id}")
    public String updateCategoryPage(Model model,
                                     @PathVariable Long id) {
        model.addAttribute("category", categoryService.get(id));
        return "employee/updateCategory";
    }

    @PostMapping("/confirm-order/{id}")
    public String confirmOrder(@PathVariable Long id,
                               @AuthenticationPrincipal User user) {
        Employee employee = employeeService.getByEmail(user.getEmail());
        orderService.confirm(employee, id);
        return "redirect:/employee/dashboard?table=orders";
    }

    @PostMapping("/reject-order/{id}")
    public String rejectOrder(@PathVariable Long id,
                              @AuthenticationPrincipal User user) {
        Employee employee = employeeService.getByEmail(user.getEmail());
        orderService.reject(employee, id);
        return "redirect:/employee/dashboard?table=orders";
    }

    @PostMapping("/add/category")
    public String addCategory(@Valid @ModelAttribute CategoryCreateRequest categoryCreateRequest) {
        categoryService.save(categoryCreateRequest);
        return "redirect:/employee/dashboard?table=categories";
    }

    @PostMapping("/update/category/{id}")
    public String updateCategory(@PathVariable Long id,
                                 @Valid @ModelAttribute CategoryUpdateRequest categoryUpdateRequest) {
        categoryService.update(id, categoryUpdateRequest);
        return "redirect:/employee/dashboard?table=categories";
    }

    @PostMapping("/delete/category/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return "redirect:/employee/dashboard?table=categories";
    }
}
