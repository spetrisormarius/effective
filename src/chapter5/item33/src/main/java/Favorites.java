import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Typesafe heterogeneous container pattern - API
public class Favorites {

    private Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), instance);
    }

    // Achieving runtime type safety with a dynamic cast
    public <T> void putFavoriteSafe(Class<T> type, T instance) {
        favorites.put(type, type.cast(instance));
    }


    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    // Typesafe heterogeneous container pattern - client
    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);

        String favoriteString = f.getFavorite(String.class);

        int favoriteInteger = f.getFavorite(Integer.class);

        Class<?> favoriteClass = f.getFavorite(Class.class);

        System.out.printf("%s %x %s%n", favoriteString,
                favoriteInteger, favoriteClass.getName());

        Class<?> classy = Favorites.class;

        //Collections.checkedList()

    }

//    public <T extends Annotation>
//    T getAnnotation(Class<T> annotationType);


    // Use of asSubclass to safely cast to a bounded type token
//    static Integer getAnnotation(String element,
//                                    String annotationTypeName) {
//        Class<?> annotationType = null; // Unbounded type token
//        try {
//            annotationType = Class.forName(annotationTypeName);
//        } catch (Exception ex) {
//            throw new IllegalArgumentException(ex);
//        }
//        return element.getAnnotation(
//                annotationType.asSubclass(Annotation.class));
//    }

}
