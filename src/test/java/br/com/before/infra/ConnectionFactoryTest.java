package br.com.before.infra;

import br.com.before.infra.ConnectionFactory;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class ConnectionFactoryTest {

    Connection connection;

    @Test
    public void TesteDeConexao() {
        this.connection = new ConnectionFactory().getConnection();
    }
}
