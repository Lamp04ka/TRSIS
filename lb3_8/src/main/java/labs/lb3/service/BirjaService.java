package labs.lb3.service;

import labs.lb3.model.classBirja;

import java.util.List;

public interface BirjaService {

    void create(classBirja birjaCompany);
    List<classBirja> readAll();
    classBirja read(int id);
    boolean update(classBirja birjaCompany, int id);
    boolean delete(int id);
}
