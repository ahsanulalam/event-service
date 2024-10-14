package cptu.egp.event.service;

import cptu.egp.event.config.DataSourceContextHolder;
import cptu.egp.event.config.RoutingDataSource;
import cptu.egp.event.model.Alumni;
import cptu.egp.event.repository.AlumniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonService {

    private final AlumniRepository repository;

    @Autowired
    public CommonService(AlumniRepository repository) {
        this.repository = repository;
    }

    public void saveToDatabase(Alumni entity, String db) {
        try {
            RoutingDataSource.setDataSource(db.toUpperCase());  // Set the data source dynamically
            repository.save(entity);
        } finally {
            RoutingDataSource.clearDataSource();
        }
    }

    public List<Alumni> getAllFromDatabase(String db) {
        try {
            //RoutingDataSource.setDataSource(db) Switch to the appropriate database
            if(db.equals("1"))
                DataSourceContextHolder.setDataSourceKey("PRIMARY");
            else
                DataSourceContextHolder.setDataSourceKey("SECONDARY");
            return repository.findAll();
        } finally {
            //RoutingDataSource.clearDataSource();
            DataSourceContextHolder.clearDataSourceKey();
        }
    }
}
