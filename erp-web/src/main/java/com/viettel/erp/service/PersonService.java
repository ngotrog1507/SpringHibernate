/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.service;

import com.viettel.erp.bo.Person;
import com.viettel.erp.form.PersonForm;
import java.util.List;

/**
 *
 * @author HungLQ9
 */
public interface PersonService {

    public void addPerson(Person p);

    public void updatePerson(Person p);

    public List<Person> listPersons(PersonForm p);

    public Person getPersonById(int id);

    public void removePerson(int id);

    public boolean isUserExist(Person p);
}
