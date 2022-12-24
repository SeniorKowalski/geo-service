package ru.netology.testing.geoservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSenderImpl;
import java.util.Map;

public class MessageSenderMockTest {

    final String MOSCOW_IP = "172.0.32.11";
    final String NEW_YORK_IP = "96.44.183.149";
    MessageSenderImpl messageSender;
    GeoService geoService = Mockito.mock(GeoService.class);
    LocalizationService localizationService = Mockito.mock(LocalizationService.class);

    @BeforeEach
    public void beforeEach() {
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }

    @Test
    public void sendRuTest() {
        Mockito.when(geoService.byIp(Mockito.eq(MOSCOW_IP))).thenReturn(new Location("Moskow", Country.RUSSIA, null, 0));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        String res = messageSender.send(Map.of(MessageSenderImpl.IP_ADDRESS_HEADER, MOSCOW_IP));
        String message = "Добро пожаловать";
        Assertions.assertEquals(message, res);
    }

    @Test
    public void sendEnTest() {
        Mockito.when(geoService.byIp(Mockito.eq(NEW_YORK_IP))).thenReturn(new Location("New York", Country.USA, null, 0));
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        String res = messageSender.send(Map.of(MessageSenderImpl.IP_ADDRESS_HEADER, NEW_YORK_IP));
        String message = "Welcome";
        Assertions.assertEquals(message, res);
    }
}
