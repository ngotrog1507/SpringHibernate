/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.viettel.erp.service;

import com.viettel.erp.bo.Person;
import com.viettel.erp.form.PersonForm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author HungLQ9
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

    private static final Logger logger = Logger.getLogger(PersonServiceImpl.class);
    private static final AtomicInteger counter = new AtomicInteger();

    private static List<Person> persons = new ArrayList<>();

    static {
        for (int i = 0; i < 50; i++) {
            persons.add(new Person(counter.incrementAndGet(), "User" + i, "Country" + i));
        }
    }

    @Override
    public void addPerson(Person p) {
        p.setId(counter.incrementAndGet());
        persons.add(p);
        logger.info("Person saved successfully, Person Details=" + p);
    }

    @Override
    public void updatePerson(Person p) {
        int index = persons.indexOf(p);
        persons.set(index, p);
        logger.info("Person updated successfully, Person Details=" + p);
    }

    @Override
    public List<Person> listPersons(PersonForm per) {
        List<Person> ls = persons;
        List<Person> lsRet = persons;
        if (!persons.isEmpty()) {
//            if (per != null && per.getName() != null && !per.getName().isEmpty()) {
//                lsRet = ls.stream().filter(p -> p.getName().toLowerCase().contains(per.getName().toLowerCase())).collect(Collectors.toList());
//                ls = lsRet;
//            }
//            if (per != null && per.getCountry() != null && !per.getCountry().isEmpty()) {
//                lsRet = ls.stream().filter(p -> p.getCountry().toLowerCase().contentEquals(per.getCountry().toLowerCase())).collect(Collectors.toList());
//            }

        }
        return lsRet;
    }

    @Override
    public Person getPersonById(int id) {
        for (Person p : persons) {
            if (p.getId() == id) {
                logger.info("Person loaded successfully, Person details=" + p);
                return p;
            }
        }
        return null;
    }

    @Override
    public void removePerson(int id) {
        for (Iterator<Person> iterator = persons.iterator(); iterator.hasNext();) {
            Person p = iterator.next();
            if (p.getId() == id) {
                iterator.remove();
                logger.info("Person deleted successfully, person details=" + p);
            }
        }

    }

    public boolean isUserExist(Person p) {
        return findByName(p.getName()) != null;
    }

    public Person findByName(String name) {
        for (Person p : persons) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
}
