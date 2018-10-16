import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import obj.Human;
import org.junit.Test;
import service.Service;
import java.time.LocalDate;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

public class test {


    @Test
    public void  testToJson() throws IllegalAccessException {
        //Given
        Human human=new Human("Elina","Sokol","singing in the shower", LocalDate.now());

        Gson actual = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();

        String actualJson=actual.toJson(human);

        //When
        Service test=new Service();

        String expectedJson=test.convertToJson(human);

        //Then
        assertThatJson(actualJson).isEqualTo(expectedJson);

    }

    @Test
    public void  testIsEmptyValue() throws IllegalAccessException {
        //Given
        Human human=new Human("Elina",null,"singing in the shower", LocalDate.now());
        Gson actual = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create();
        String actualJson=actual.toJson(human);

        //When
        Service test=new Service();
        String expectedJson=test.convertToJson(human);

        //Then
        assertThatJson(actualJson).isEqualTo(expectedJson);

    }
}
