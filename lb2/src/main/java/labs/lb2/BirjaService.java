package labs.lb2;

import labs.lb2.ClassBirja;

import java.util.List;

public interface BirjaService {

    void create(ClassBirja birjaCompany);
    List<ClassBirja> readAll();
    ClassBirja read(int id);
    boolean update(ClassBirja birjaCompany, int id);
    boolean delete(int id);
}
