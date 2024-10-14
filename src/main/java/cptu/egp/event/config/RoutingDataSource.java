package cptu.egp.event.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class RoutingDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    @Override
    protected Object determineCurrentLookupKey() {
        // Retrieve the key from the DataSourceContextHolder
        //return contextHolder.get();
        String dataSourceKey = DataSourceContextHolder.getDataSourceKey();
        return dataSourceKey;

        // return contextHolder.get(); // Will return "PRIMARY", "SECONDARY", "TERTIARY", etc.
    }

    public static void setDataSource(String dataSource) {
        contextHolder.set(dataSource);  // Set the appropriate data source dynamically
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }
}

