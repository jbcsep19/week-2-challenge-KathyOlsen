import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Create 25 burritos each containing one random selection from a random number of 5 to 9 specific categories.
        Random r = new Random();
        ArrayList<String> rice = new ArrayList<>();
        rice.add("white");
        rice.add("brown");
        rice.add("no");
        rice.add("all");

        ArrayList<String> meat = new ArrayList<>();
        meat.add("chicken");
        meat.add("steak");
        meat.add("carnitas");
        meat.add("chorizo");
        meat.add("sofritas");
        meat.add("veggie not");
        meat.add("no");
        meat.add("all");

        ArrayList<String> beans = new ArrayList<>();
        beans.add("pinto");
        beans.add("black");
        beans.add("no");

        ArrayList<String> salsa = new ArrayList<>();
        salsa.add("mild");
        salsa.add("medium");
        salsa.add("hot");
        salsa.add("no");
        salsa.add("all");

        ArrayList<String> veggies = new ArrayList<>();
        veggies.add("lettuce");
        veggies.add("fajita veggies");
        veggies.add("no veggies");
        veggies.add("all veggies");

        ArrayList<String> extras = new ArrayList<>();
        extras.add("cheese");
        extras.add("guac");
        extras.add("queso");
        extras.add("sour cream");

        ArrayList<String> [] burritos = new ArrayList[25];

        for(int i = 0; i < 25; i++){
            int randomRice = r.nextInt(rice.size());
            int randomMeat = r.nextInt(meat.size());
            int randomBeans = r.nextInt(beans.size());
            int randomSalsa = r.nextInt(salsa.size());
            int randomVeggies = r.nextInt(veggies.size());
            int randomExtras1 = r.nextInt(extras.size());
            int randomExtras2 = r.nextInt(extras.size());
            while (randomExtras2 == randomExtras1){
                randomExtras2 = r.nextInt(extras.size());
            }
            int randomExtras3 = r.nextInt(extras.size());
            while ((randomExtras3 == randomExtras1) | (randomExtras3 == randomExtras2)){
                randomExtras3 = r.nextInt(extras.size());
            }
            int randomExtras4 = r.nextInt(extras.size());
            while ((randomExtras4 == randomExtras1) | (randomExtras4 == randomExtras2) | (randomExtras4 == randomExtras3)){
                randomExtras4 = r.nextInt(extras.size());
            }
            int randomNumberIngredients = 5 + r.nextInt(4);

            ArrayList<String> selections = new ArrayList<>();
            selections.add(rice.get(randomRice) + " rice");
            selections.add(meat.get(randomMeat) + " meat");
            selections.add(beans.get(randomBeans) + " beans");
            selections.add(salsa.get(randomSalsa) + " salsa");
            selections.add(veggies.get(randomVeggies));
            if(randomNumberIngredients - 5 >= 1){
                selections.add(extras.get(randomExtras1));
            }if(randomNumberIngredients - 5 >= 2){
                selections.add(extras.get(randomExtras2));
            }if(randomNumberIngredients - 5 >= 3){
                selections.add(extras.get(randomExtras3));
            }if(randomNumberIngredients - 5 >= 4){
                selections.add(extras.get(randomExtras4));
            }

            burritos[i] = selections;
        }
        //Print out the list of burritos.
        for(int i = 0; i < 25; i++){
            System.out.print("Burrito " + (i+1) + ": " + burritos[i] + "\n");
        }
        //Calculate and display a price for each burrito. Pricing is $3.00 plus $0.50 for each additional ingredient.
        //It will be assumed that "all" of any item means a smaller share of each type of that item so that the total
        //quantity of that item is the same.  Thus the $0.50 add-on only applies to the extra ingredients.
        //Likewise, there will be no reduction in price for not getting any of an item (e.g., no meat).
    }
}
