package ru.netology.testing.geoservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class GeoServiceTest {

    public static final String NEW_YORK_IP = "96.44.183.149";
    GeoService service = new GeoServiceImpl();

    @Test
    public void byIpTest() {
        Location location = service.byIp(NEW_YORK_IP);
        Country res = location.getCountry();
        Country expected = Country.USA;
        Assertions.assertEquals(expected, res);
    }
}
