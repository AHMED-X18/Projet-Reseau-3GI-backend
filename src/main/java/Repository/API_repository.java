package Repository;

import Models.API;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface API_repository extends JpaRepository<API, String> {
    List<API> FindByName(String nom);
    List<API> FindByDate(Date date);
    List<API> FindByTime(Time time);

    API findByName(String nom);

    boolean existsByNom(String nom);
}
