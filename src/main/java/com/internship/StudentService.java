package com.internship;

import com.internship.entities.Student;
import com.internship.util.HibernateUtil;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentService {

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    //save

    public void saveStudent(Student student) {

        try (Session session = sessionFactory.openSession()) {

            Transaction beginTransaction = session.beginTransaction();

            session.persist(student);
            beginTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Student getByID(long studentId) {

        try (Session session = sessionFactory.openSession()) {

            Student student = session.get(Student.class, studentId);
            return student;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    //update
    public Student updateStudent(long studentId, Student student) {

        try (Session session = sessionFactory.openSession()) {

            Transaction transaction = session.beginTransaction();

            Student oldStudent = session.get(Student.class, studentId);
            if (oldStudent != null) {
                oldStudent.setName(student.getName());
                oldStudent.setEmail(student.getEmail());
                oldStudent.setCollege(student.getCollege());
                oldStudent.setBranch(student.getBranch());
                oldStudent.setYear(student.getYear());
                oldStudent.setPhoneNumber(student.getPhoneNumber());
                oldStudent.setAbout(student.getAbout());

                oldStudent = session.merge(oldStudent);
            }

            transaction.commit();
            return oldStudent;
        }
    }

    //delete student

    public void deleteStudent(long studentId) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                session.remove(student);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //HQL (Hibernate Query Language)
    public List<Student> getAllStudent(){

        try (Session session = sessionFactory.openSession()) {
            String getHQL = "FROM Student";
            Query<Student> query = session.createQuery(getHQL, Student.class);
            return query.list();
        }
    }

    //get STudent by name

    public Student getStudentByNameHQL(String name) {
        try (Session session = sessionFactory.openSession()) {
            String getByNameHQL = "FROM Student WHERE student_name = :studentName";
            Query<Student> query = session.createQuery(getByNameHQL, Student.class);
            query.setParameter("studentName", name);
            return query.uniqueResult();
        }
    }

    // criteria api;

    public List<Student> getStudentsByCriteriaCollege(String college ) {
        try (Session session = sessionFactory.openSession()) {

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Student> query = criteriaBuilder.createQuery(Student.class);

            Root<Student> root = query.from(Student.class);
            query.select(root).where(criteriaBuilder.equal(root.get("college"), college));

            Query<Student> q = session.createQuery(query);
            return q.getResultList();
        }
    }

    public List<Student> getStudentWithPagination(int pageNumber, int pageSize) {
        try (Session session = sessionFactory.openSession()) {

            String hql = "FROM Student";

            Query<Student> query = session.createQuery(hql, Student.class);

            query.setFirstResult((pageNumber - 1) * pageSize);

            query.setMaxResults(pageSize);

            return query.list();
        }
    }

}