import com.ineutm.backend.evaluaciones.EvaluacionesApplication;
import com.ineutm.backend.evaluaciones.expose.dao.AccountDao;
import com.ineutm.backend.evaluaciones.expose.dao.TransactionDao;
import com.ineutm.backend.evaluaciones.expose.dao.UserDao;
import com.ineutm.backend.evaluaciones.expose.dto.UserDto;
import com.ineutm.backend.evaluaciones.expose.service.ClientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = EvaluacionesApplication.class)
public class ClientServiceTest {
    @Autowired
    private ClientService clientService;
    @Mock
    private UserDao userDao;
    @Mock
    private AccountDao accountDao;
    @Mock
    private TransactionDao transactionDao;

    @Test
    void getUserByNumberDocument_PremiumUser_ReturnsUserDtoWithTransactions() {
        ResponseEntity<UserDto> response = clientService.getUserByNumberDocument("43843823");

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        UserDto userDto = response.getBody();
        assertNotNull(userDto);
        assertEquals(2, userDto.getAccounts().size());
        assertEquals(3, userDto.getAccounts().get(0).getTransactions().size());
    }

    @Test
    void getUserByNumberDocument_RegularUser_ReturnsUserDtoWithoutTransactions() {
        ResponseEntity<UserDto> response = clientService.getUserByNumberDocument("40012342");

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        UserDto userDto = response.getBody();
        assertNotNull(userDto);
        assertEquals(1, userDto.getAccounts().size());
        assertEquals(userDto.getAccounts().get(0).getTransactions(), null);
    }
}
