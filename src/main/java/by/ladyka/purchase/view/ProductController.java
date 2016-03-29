package by.ladyka.purchase.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    private static final LocalDateTime localDateTime = LocalDateTime.now();

    @RequestMapping(
            value = {"{id}"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public ResponseEntity getBoard(@PathVariable("id") int id) {
        return new ResponseEntity(productService.getProduct(id));
    }

}
