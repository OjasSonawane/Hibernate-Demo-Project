package com.internship;

import com.internship.entities.Certificates;
import com.internship.entities.Student;
import com.internship.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        //Student create
        //save : hibernate

        Student student = new Student();

        student.setName("Ojas");
        student.setEmail("ojas@gmail.com");
        student.setCollege("GHRCEM PUNE");
        student.setBranch("Computer Science");
        student.setYear("TY");
        student.setPhoneNumber("1234567890");
        student.setAbout("A passionate learner and developer.");

        Certificates certificates = new Certificates();
        certificates.setTitle("Java Developer");
        certificates.setAbout("Java Developer Certificate");
        certificates.setLink("https://example.com/certificate/java-developer");
        certificates.setStudent(student);

        Certificates certificates1 = new Certificates();
        certificates1.setTitle("Pthon Developer");
        certificates1.setAbout("Python Developer Certificate");
        certificates1.setLink("https://example.com/certificate/python-developer");
        certificates1.setStudent(student);

        // Add certificates to the student's list
        List<Certificates> certList = new ArrayList<>();
        certList.add(certificates);
        certList.add(certificates1);
        student.setCertificates(certList);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        System.out.println(sessionFactory);

        Session session = sessionFactory.openSession();

        Transaction transaction = null;

        try {

            transaction = session.beginTransaction();

            session.persist(student);
            // No need to persist certificates separately; CascadeType.ALL will handle it

            transaction.commit();

            System.out.println("Student saved successfully ");

        } catch (Exception e) {
            if (transaction !=null){
                transaction.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}
