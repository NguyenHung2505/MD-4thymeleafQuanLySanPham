package controller;

import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.IProductService;
import service.ProductService;

import java.util.List;

    @Controller
    @RequestMapping("/product")
    public class ProductController {
        private final IProductService iProductService = new ProductService();
        @GetMapping("")
        public String index(Model model) {
            List<Product> productList = iProductService.findAll();
            model.addAttribute("products", productList);
            return "/index";
        }
        @GetMapping("/create")
        public String create(Model model) {
            model.addAttribute("products", new Product());
            return "/create";
        }
        @PostMapping("/save")
//        thong bao them thanh cong
        public String save(Product product, RedirectAttributes redirectAttributes) {
            product.setId((int) (Math.random() * 10000));
            iProductService.save(product);
            redirectAttributes.addFlashAttribute("success", "Them thanh cong");
            return "redirect:/product";
        }

        @GetMapping("/{id}/edit")
        public String edit(@PathVariable int id, Model model) {
            model.addAttribute("product", iProductService.findById(id));
            return "/edit";
        }
        @PostMapping("/update")
        public String update(Product product) {
            iProductService.update(product.getId(), product);
            return "redirect:/product";
        }
        @GetMapping("/{id}/delete")
        public String delete(@PathVariable int id, Model model ) {
            model.addAttribute("product", iProductService.findById(id));
            return "/delete";
        }
        @PostMapping("/delete")
        public String delete(Product product, RedirectAttributes redirect ) {
            iProductService.remove(product.getId());
            redirect.addFlashAttribute("success", "xoa thanh cong");
            return "redirect:/product";
        }
        @GetMapping("/{id}/view")
        public String view(@PathVariable int id, Model model) {
            model.addAttribute("product", iProductService.findById(id));
            return "/view";
        }

        @GetMapping("/seach")
        public String find(@RequestParam String name, Model model) {
            model.addAttribute("find", iProductService.findByName(name));
            return "/seach";
        }
    }
