package by.ladyka.purchase.view;

import by.ladyka.purchase.repository.Product;
import by.ladyka.purchase.servicies.SpaceService;
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
@RequestMapping("space")
public class SpaceController {

    @Autowired
    SpaceService spaceService;

    Logger logger = LoggerFactory.getLogger(getClass());
    private static final LocalDateTime localDateTime = LocalDateTime.now();

    @RequestMapping(
            value = {"{id}"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public ResponseEntity get(Principal principal, @PathVariable("id") int id) {
        try {
            return new ResponseEntity(spaceService.get(principal.getName(), id));
        } catch (Exception ex) {
            return new ResponseEntity(false, ex.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public
    @ResponseBody
    ResponseEntity create(Principal principal, String name) {
        try {
            return new ResponseEntity(spaceService.create(principal.getName(), name));
        } catch (Exception ex) {
            return new ResponseEntity(false, ex.getMessage());
        }

    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    ResponseEntity read(Principal principal, String query) {
        try {
            return new ResponseEntity(spaceService.get(principal.getName(), query));
        } catch (Exception ex) {
            return new ResponseEntity(false, ex.getMessage());
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity update(Principal principal, int id, String name, HttpServletRequest httpServletRequest) {
        Product product = null;
        String method = httpServletRequest.getParameter("_method");
        switch (method) {
            case "PUT":
                return create(principal, name);
            case "DELETE":
                return delete(principal, id);
            default:
                try {
                    return new ResponseEntity(spaceService.edit(principal.getName(), id, name));
                } catch (Exception ex) {
                    return new ResponseEntity(false, ex.getMessage());
                }
        }
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public
    @ResponseBody
    ResponseEntity delete(Principal principal, int id) {
        try {
            boolean result = spaceService.delete(principal.getName(), id);
            return new ResponseEntity(result, result);
        } catch (Exception ex) {
            return new ResponseEntity(false, ex.getMessage());
        }
    }
}
