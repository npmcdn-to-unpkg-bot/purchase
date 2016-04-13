package by.ladyka.purchase.view;

import by.ladyka.purchase.servicies.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ShoppingListController {

    @Autowired
    ShoppingListService shoppingListService;

}
