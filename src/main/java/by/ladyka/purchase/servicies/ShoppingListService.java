package by.ladyka.purchase.servicies;

import by.ladyka.purchase.dao.ShoppingListDAO;
import by.ladyka.purchase.repository.ShoppingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static by.ladyka.purchase.dao.ShoppingListDAO.STATUS_BOUGHT;
import static by.ladyka.purchase.dao.ShoppingListDAO.STATUS_CREATE;

@Service
public class ShoppingListService {

    @Autowired
    ShoppingListDAO shoppingListDAO;


    public ShoppingList get(int id) {
        return shoppingListDAO.get(id);
    }

    public ShoppingList create(String principalName, String name, int spaceId) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList = updateEntity(shoppingList,name,spaceId,STATUS_CREATE);
        shoppingList = shoppingListDAO.saveOrUpdate(shoppingList);
        return shoppingList;
    }

    public boolean delete(int id) {
        shoppingListDAO.delete(id);
        return true;
    }

    public ShoppingList rename(String principalName, int id , String name) {
        ShoppingList shoppingList = shoppingListDAO.get(id);
        shoppingList.setName(name);
        shoppingList = shoppingListDAO.saveOrUpdate(shoppingList);
        return shoppingList;
    }

    public ShoppingList bought(String principalName, int id) {
        ShoppingList shoppingList = shoppingListDAO.get(id);
        shoppingList.setBuyTime(Timestamp.valueOf(LocalDateTime.now()));
        shoppingList.setStatus(STATUS_BOUGHT);
        shoppingList = shoppingListDAO.saveOrUpdate(shoppingList);
        return shoppingList;
    }

    public List<ShoppingList> get(String query) {
        return shoppingListDAO.get(query);
    }

    private ShoppingList updateEntity(ShoppingList shoppingList, String name, int spaceId, int status) {
        shoppingList.setName(name);
        shoppingList.setSpaceId(spaceId);
        shoppingList.setStatus(status);
        return shoppingList;
    }
}
