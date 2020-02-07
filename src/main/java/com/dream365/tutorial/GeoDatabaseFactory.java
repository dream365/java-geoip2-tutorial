package com.dream365.tutorial;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

public class GeoDatabaseFactory {
    private static final String DB_NAME = "GeoLite2-City.mmdb";

    public static DatabaseReader getGeoDB() throws IOException {
        File database = new File(GeoDatabaseFactory.class.getClassLoader().getResource(DB_NAME).getFile());
        return new DatabaseReader.Builder(database).build();
    }
}
