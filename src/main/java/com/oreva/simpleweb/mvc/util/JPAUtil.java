package com.oreva.simpleweb.mvc.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created with IntelliJ IDEA.
 * User: Olga
 * Date: 11/19/15
 * Time: 4:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class JPAUtil {
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactory() {
        if (null == entityManagerFactory) {
            entityManagerFactory = Persistence.createEntityManagerFactory("simpleweb");
        }
        return entityManagerFactory;
    }

    public static void closeEntityManagerFactory() {
        if (null != entityManagerFactory) {
            entityManagerFactory.close();
            entityManagerFactory = null;
        }
    }
}
