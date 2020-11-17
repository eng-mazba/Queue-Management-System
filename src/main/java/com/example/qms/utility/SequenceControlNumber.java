package com.example.qms.utility;

import org.hibernate.MappingException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.slf4j.LoggerFactory;

import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SequenceControlNumber extends SequenceStyleGenerator {
    private static final Logger log =
            (Logger) LoggerFactory.getLogger(SequenceGenerator.class);



    public Serializable generate(SessionImplementor session, Object obj) {
        Connection connection = session.connection();

        try {
            PreparedStatement st = connection.prepareStatement
                    ("SELECT NEXT VALUE FOR token_generator as nextval");
            ResultSet rs = st.executeQuery();
            rs.next();
            int currentVall = rs.getInt("token_no");
            String result = "00"+currentVall;
//            if(currentVall <255){
//                result = currentVall +1;
//            }
            if ( log.isLoggable(Level.SEVERE) ) {
                log.severe("Sequence identifier generated: " + result);
            }
            rs.close();
            return result;
        }

        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void configure(Type type, Properties params,
                          ServiceRegistry serviceRegistry) throws MappingException {

    }
}
