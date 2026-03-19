import org.junit.jupiter.api.Test;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ImmobilieTest {

    @Test
    void immobilieIstAbstraktUndDaherNichtDirektInstanziierbar() {
        assertTrue(Modifier.isAbstract(Immobilie.class.getModifiers()));
    }
}

