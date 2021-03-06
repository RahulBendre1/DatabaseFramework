package com.iamtek.hibernate.entitymapping2;

import com.iamtek.hibernate.entitymapping2.dto.UserDetails5;
import com.iamtek.hibernate.entitymapping2.dto.Vehicle5;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyMapping {

    public static void main(String[] args) {

        UserDetails5 user = new UserDetails5();
        user.setUserName("First User");

        Vehicle5 vehicle1 = new Vehicle5();
        vehicle1.setVehicleName("Car");

        Vehicle5 vehicle2 = new Vehicle5();
        vehicle2.setVehicleName("Jeep");

        //Bidirectional mapping
        user.getVehicleList().add(vehicle1);
        user.getVehicleList().add(vehicle2);
        vehicle1.getUserList().add(user);
        vehicle2.getUserList().add(user);

        SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(UserDetails5.class).addAnnotatedClass(Vehicle5.class).buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.save(vehicle1);
        session.save(vehicle2);
        session.getTransaction().commit();
        session.close();

    }

}
