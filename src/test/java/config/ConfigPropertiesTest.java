package config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static config.ConfigProperties.properties;

class ConfigPropertiesTest {

    @Test
    void configTest() {
        ConfigProperties configProperties = properties();

        Assertions.assertThat(configProperties.Port()).isEqualTo("27017");
    }

}