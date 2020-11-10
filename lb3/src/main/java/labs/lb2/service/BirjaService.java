package labs.lb2.service;

import labs.lb2.model.classBirja;

import java.util.List;

public interface BirjaService {

    void create(classBirja birjaCompany);
    List<classBirja> readAll();
    classBirja read(int id);
    boolean update(classBirja birjaCompany, int id);
    boolean delete(int id);
}
