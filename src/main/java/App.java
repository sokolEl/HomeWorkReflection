import obj.Human;
import obj.Person;
import service.Service;
import java.time.LocalDate;



public class App {

    public static void main(String[] args) throws IllegalAccessException {

        Person person=new Person("Elina","Sokol","singing in the shower", LocalDate.now());
        Human human=new Human("Elina",null,"singing in the shower", null);

        Service call=new Service();

        System.out.println(call.convertToJson(person));
        System.out.println(call.convertToJson(human));

    }

}
