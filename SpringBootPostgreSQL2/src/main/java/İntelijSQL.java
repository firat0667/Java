import entity.DeveloperEntity;
import javafx.animation.ScaleTransition;
import org.hibernate.cache.spi.support.EntityTransactionalAccess;
import org.hibernate.internal.build.AllowSysOut;

import javax.persistence.*;
import javax.swing.text.html.parser.Entity;

public class İntelijSQL {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("default");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction transaction=entityManager.getTransaction();

        try {
            transaction.begin();
            DeveloperEntity ahmet = new DeveloperEntity();
            ahmet.setId(1);
            ahmet.setName("Ahmet");
            ahmet.setSurname("Kulaksız");
            ahmet.setDepartment("Software Developer");
            ahmet.setUniversity("Konya Selçuk");
            ahmet.setPlanguage("Javascript");
            entityManager.persist(ahmet);




            /*
            TypedQuery<DeveloperEntity> developerEntityTypedQuery=entityManager.createNamedQuery("DeveloperEntity",DeveloperEntity.class);
            developerEntityTypedQuery.setParameter(1,"java");
            for(DeveloperEntity developerEntity:developerEntityTypedQuery.getResultList()){
                System.out.println(developerEntity);


             */


            transaction.commit();




        }finally {
            if(transaction.isActive())
            {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();

        }

        }
    }

