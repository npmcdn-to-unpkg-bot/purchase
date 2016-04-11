package by.ladyka.purchase.view;

import by.ladyka.purchase.servicies.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.time.LocalDateTime;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    Logger logger = LoggerFactory.getLogger(getClass());
    private static final LocalDateTime localDateTime = LocalDateTime.now();

    @RequestMapping(
            value = {"{id}"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public ResponseEntity read(Principal principal, @PathVariable("id") int id) {
        return new ResponseEntity(productService.getProduct(id));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public
    @ResponseBody
    ResponseEntity create(Principal principal, String name, String description, String image1, String image2, String image3) {
        return new ResponseEntity(productService.create(principal.getName(),name,description,image1,image2,image3)) ;
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity read(Principal principal, String query) {
        return new ResponseEntity(productService.get(query));
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity update(Principal principal, int id, String name, String description, String image1, String image2, String image3, HttpServletRequest httpServletRequest) {
        String method = httpServletRequest.getParameter("_method");
        switch (method) {
            case "PUT":
                return create(principal,name,description,image1,image2,image3);
            case "DELETE":
                return delete(principal, id);
            default:
                return new ResponseEntity(productService.edit(principal.getName(),id,name,description,image1,image2,image3));
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public
    @ResponseBody
    ResponseEntity delete(Principal principal, int id) {
        boolean result = productService.delete(id);
        return new ResponseEntity(result,result);
    }

    @RequestMapping(value = {"delete"}, method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity deleteNew(Principal principal, int id) {
        boolean result = productService.delete(id);
        return new ResponseEntity(result,result);
    }
}
