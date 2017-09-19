package org.javaavancado.data;

import org.javaavancado.model.Interessados;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.List;
import java.util.TimeZone;

@Stateless
public class InteressadosRepository {

    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    public void save(Interessados entity) {
        if (entity != null && entity.getNome() != null && entity.getNome().trim().length() > 2 && entity.getEmail() != null && entity.getEmail().trim().length() > 2) {
            TimeZone.setDefault(TimeZone.getTimeZone("UTC-3"));
            entity.setDataCadastro(new Timestamp(System.currentTimeMillis()));
            em.persist(entity);
        }
    }
    public List<Interessados> getAll(){
        return em.createQuery("Select i from Interessados i", Interessados.class).getResultList();
    }
}
