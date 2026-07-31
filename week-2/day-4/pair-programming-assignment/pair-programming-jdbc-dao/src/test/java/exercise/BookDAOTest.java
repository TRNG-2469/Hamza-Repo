package exercise;

import utils.ConnectionFactory;
import org.junit.jupiter.api.*;
import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

class BookDAOTest {

    private final BookDAO dao = new BookDAOImpl(); // -> ConnectionFactory -> system env

    @AfterEach
    void tearDown() throws SQLException {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             Statement st = conn.createStatement()) {
            st.execute("DROP TABLE IF EXISTS books");
        }
    }

    @BeforeEach
    void setUp() throws SQLException {
        try (Connection conn = ConnectionFactory.getInstance().getConnection();
             Statement st = conn.createStatement()) {
            st.execute("""
                CREATE TABLE books (
                    book_id INTEGER PRIMARY KEY,
                    title   VARCHAR(255) NOT NULL,
                    author  VARCHAR(255) NOT NULL
                )
                """);
        }
    }



    @Test
    void save_persistsBook() {
        dao.save(new Book(1, "Clean Code", "Robert Martin"));
        Book found = dao.getById(1);
        assertNotNull(found);
        assertEquals("Clean Code", found.getTitle());
        assertEquals("Robert Martin", found.getAuthor());
    }

    @Test
    void getById_returnsPersistedBook() {
        dao.save(new Book(2, "Effective Java", "Joshua Bloch"));
        Book found = dao.getById(2);
        assertNotNull(found);
        assertEquals(2, found.getId());
        assertEquals("Effective Java", found.getTitle());
    }

    @Test
    void getById_returnsNullWhenMissing() {
        assertNull(dao.getById(9999));
    }

    @Test
    void delete_removesExistingBook() {
        dao.save(new Book(4, "The Pragmatic Programmer", "Andy Hunt"));
        dao.delete(4);
        assertNull(dao.getById(4));
    }


}