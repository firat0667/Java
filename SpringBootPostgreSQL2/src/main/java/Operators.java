import java.util.List;

public class Operators<T> {
    public interface  Operations<T>{
         void save (T t);
         void Update (T t);
         void delete (T t);

         List<T> list(T t);
         List<T> search(String columnName,String value,T t);
         T find(Long id,T t);
         List<T> advancedList(T t);

    }
}
