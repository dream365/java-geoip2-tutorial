import com.dream365.tutorial.GeoDatabaseFactory;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;

import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;

public class GeoDatabaseTest {
    @Test
    public void givenIP_whenFetchingCity_thenReturnsCityData() throws IOException, GeoIp2Exception {
        String ip = "183.99.77.133";
        DatabaseReader dbReader = GeoDatabaseFactory.getGeoDB();

        InetAddress ipAddress = InetAddress.getByName(ip);
        CityResponse cityResponse = dbReader.city(ipAddress);

        String countryName = cityResponse.getCountry().getName();
        String cityName = cityResponse.getCity().getName();
        String postal = cityResponse.getPostal().getCode();
        String state = cityResponse.getLeastSpecificSubdivision().getName();
        Double latitude = cityResponse.getLocation().getLatitude();
        Double longitude = cityResponse.getLocation().getLongitude();

        System.out.println("Country Name : " + countryName + "\nCity Name : " + cityName + "\nPostal : " + postal + "\nState : " + state + "\nLatitude : " + latitude + "\nLongitude : " + longitude);
    }
}
