package Repository.Parent;

import Models.Access;
import Models.Id_access;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface Access_Repository extends JpaRepository<Access, Id_access>  {

    Access findByDate(Date date);
}
