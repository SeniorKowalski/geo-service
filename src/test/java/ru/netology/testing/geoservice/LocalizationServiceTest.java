package ru.netology.testing.geoservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceTest {

    LocalizationService service = new LocalizationServiceImpl();

    @Test
    public void localeTest(){
        String res = service.locale(Country.RUSSIA);
        String expected = "Добро пожаловать";
        Assertions.assertEquals(expected,res);
    }

}
