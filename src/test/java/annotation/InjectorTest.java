package annotation;

import data.Data;
import org.junit.jupiter.api.Test;
import repo.ComparatorFactory;
import repo.Repository;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class InjectorTest {

    @Test
    void inject() throws IOException, ClassNotFoundException {
        try{
            Repository repository = new Repository();
            Injector.inject(repository);

            Field[] fields = Repository.class.getDeclaredFields();
            for(Field field : fields){
                if(field.getName().equals("sorter")){
                    field.setAccessible(true);
                    assertNotNull(field.get(repository));
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    void injectIntoList() throws IOException, ClassNotFoundException {
        try{
            Data data = new Data();
            Injector.inject(data);

            Field[] fields = Data.class.getDeclaredFields();
            for(Field field : fields){
                if(field.getName().equals("validators")){
                    field.setAccessible(true);
                    assertNotNull(field.get(data));
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}