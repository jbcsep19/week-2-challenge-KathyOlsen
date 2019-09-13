import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //Create 25 burritos each containing one random selection from a random number of 5 to 9 specific categories
        //(1 from each of the five main categories of rice, meat, beans, salsa, and veggies and 0-4 of the extras
        //(cheese, guacamole, queso, and sour cream).  If "all" of a type is picked, then each actual item of that
        //type will be listed separately in the list of that burrito's ingredients.

        Random r = new Random();
        //creating array lists for each type of ingredient
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
        beans.add("all");

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

        //creating arrays for the burritos and pricing info
        ArrayList<String> [] burritos = new ArrayList[25];
        int[] burritoIngredientsForPricing = new int[25];

        //selections for each burrito
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
            int numberIngredientsForPricing = 0;

            ArrayList<String> selections = new ArrayList<>();
            if(randomRice == rice.size() - 1) {
                for (int j = 0; j < (randomRice - 1); j++) {
                    selections.add(rice.get(j) + " rice");
                    numberIngredientsForPricing += 1;
                }
            }else if(randomRice == rice.size() - 2){
                selections.add(rice.get(randomRice)+ " rice");
            }else{
                selections.add(rice.get(randomRice)+ " rice");
                numberIngredientsForPricing += 1;
            }
            if(randomMeat == meat.size() - 1) {
                for (int j = 0; j < (randomMeat - 1); j++) {
                    selections.add(meat.get(j) + " meat");
                    numberIngredientsForPricing += 1;
                }
            }else if(randomMeat == meat.size() - 2){
                selections.add(meat.get(randomMeat) + " meat");
            } else{
                selections.add(meat.get(randomMeat)+ " meat");
                numberIngredientsForPricing += 1;
            }
            if(randomBeans == beans.size() - 1) {
                for (int j = 0; j < (randomBeans - 1); j++) {
                    selections.add(beans.get(j) + " beans");
                    numberIngredientsForPricing += 1;
                }
            }else if(randomBeans == beans.size() - 2){
                selections.add(beans.get(randomBeans) + " beans");
            }else{
                selections.add(beans.get(randomBeans) + " beans");
                numberIngredientsForPricing += 1;
            }
            if(randomSalsa == salsa.size() - 1) {
                for (int j = 0; j < (randomSalsa - 1); j++) {
                    selections.add(salsa.get(j) + " salsa");
                    numberIngredientsForPricing += 1;
                }
            }else if(randomSalsa == salsa.size() - 2){
                selections.add(salsa.get(randomSalsa) + " salsa");
            }else{
                selections.add(salsa.get(randomSalsa) + " salsa");
                numberIngredientsForPricing += 1;
            }
            if(randomVeggies == veggies.size() - 1) {
                for (int j = 0; j < (randomVeggies - 1); j++) {
                    selections.add(veggies.get(j));
                    numberIngredientsForPricing += 1;
                }
            } else if (randomVeggies == veggies.size() - 2) {
                selections.add(veggies.get(randomVeggies));
            }else{
                selections.add(veggies.get(randomVeggies));
                numberIngredientsForPricing += 1;
            }
            if(randomNumberIngredients - 5 >= 1){
                selections.add(extras.get(randomExtras1));
                numberIngredientsForPricing += 1;
            }if(randomNumberIngredients - 5 >= 2){
                selections.add(extras.get(randomExtras2));
                numberIngredientsForPricing += 1;
            }if(randomNumberIngredients - 5 >= 3){
                selections.add(extras.get(randomExtras3));
                numberIngredientsForPricing += 1;
            }if(randomNumberIngredients - 5 >= 4){
                selections.add(extras.get(randomExtras4));
                numberIngredientsForPricing += 1;
            }

            //saving selections and pricing info for each burrito
            burritos[i] = selections;
            burritoIngredientsForPricing[i] = numberIngredientsForPricing;
        }

        //Calculate and display a price for each burrito. Pricing is $3.00 for the tortilla plus $0.50 for each
        //actual ingredient.  There will be no change in price for not getting any of an item (e.g., no meat).
        //Also display the total price for all 25 burritos.
        double[] prices = new double[25];
        double totalPrice = 0;
        for(int i = 0; i < 25; i++){
            prices[i] = 3.00 + 0.50 * burritoIngredientsForPricing[i];
            totalPrice += prices[i];
        }
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        nf.setMinimumFractionDigits(2);

        //Print out the list of burritos with prices and total.
        System.out.println("\nOur new robot, Bob, has randomly selected and assembled these burritos for your enjoyment:\n");
        for(int i = 0; i < 25; i++){
            System.out.print("Burrito " + (i+1) + ": " + burritos[i] + "\t$" + nf.format(prices[i]) + "\n");

        }
        System.out.println("\nYour total catering bill is:  $" + nf.format(totalPrice));
        System.out.println("\nWe hope you enjoyed Bob's selections. Thank you for being a valued customer!");
    }
}
