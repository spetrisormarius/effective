import BuilderPattern.Calzone;
import BuilderPattern.NyPizza;
import telescope.NutritionFacts;
import static BuilderPattern.NyPizza.Size.SMALL;
import static BuilderPattern.Pizza.Topping.HAM;
import static BuilderPattern.Pizza.Topping.ONION;
import static BuilderPattern.Pizza.Topping.SAUSAGE;

//Item 2: Consider a builder when faced with many constructor
//        parameters

public class Main {
    public static void main(String[] args) {


        NutritionFacts cocaColaDiet =
                new NutritionFacts(240, 8, 100, 0, 35, 27);


        JavaBeansPattern.NutritionFacts cocaCola = new JavaBeansPattern.NutritionFacts();

        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);


        BuilderPattern.NutritionFacts cocaCola250 = new BuilderPattern.NutritionFacts.Builder(240, 8)
                .calories(100).sodium(35).carbohydrate(27).build();


        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();


    }
}
