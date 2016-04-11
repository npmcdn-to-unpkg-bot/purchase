package by.ladyka.purchase.servicies;

import by.ladyka.purchase.dao.SpaceDAO;
import by.ladyka.purchase.repository.Space;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpaceService{

    @Autowired
    SpaceDAO spaceDAO;

    public Space get(String emailUser, int id) {
        return spaceDAO.get(id);
    }

    public Space create(String emailUser, String name) {
        Space space = new Space();
        updateSpace(name, space);
        return space;
    }

    public boolean delete(String emailUser, int id) {
        return spaceDAO.delete(id);
    }

    public Space edit(String emailUser, int id, String name) {
        Space space = new Space().setId(id);
        updateSpace(name, space);
        return space;
    }

    public List<Space> get(String emailUser, String query) {
        return spaceDAO.get(query);
    }


    private void updateSpace(String name, Space space) {
        space.setName(name);
        spaceDAO.saveOrUpdate(space);
    }
}
