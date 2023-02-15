package diet;

import java.util.HashMap;
//import java.util.TreeMap;
import java.util.Map;

public class Recipe implements NutritionalElement {

	private String name;
	private Food food;
	private Map<NutritionalElement, Double> ingredients = new HashMap<>();

	public Recipe(String name) {
		this.name = name;
		this.food = food;
	}


	public Recipe addIngredient(String material, double quantity) {
		NutritionalElement rawMaterial = this.food.getRawMaterial(material);
		if (!this.ingredients.containsKey(rawMaterial)) {
			this.ingredients.put((rawMaterial), quantity);
		} else {
			this.ingredients.put((rawMaterial), (Double) this.ingredients.get(rawMaterial) + quantity);
		}

		return this;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public double getCalories() {

		double totalRecipeCalories = 0;
		Map<String, NutritionalElement> rawMaterialMap = food.rawMaterialMap;
		for (NutritionalElement name : ingredients.keySet()) {
			NutritionalElement nutritionalElement = rawMaterialMap.get(name);
			double elementTotalColor = nutritionalElement.getCalories();
			double percentage = ingredients.get(name);
			double color = (elementTotalColor * percentage) / 100;
			totalRecipeCalories += color;
		}
		return totalRecipeCalories;
	}

	@Override
	public double getProteins() {
		double totalRecipeProteins=0;
		return totalRecipeProteins;
	}

	@Override
	public double getCarbs() {
		double totalRecipeCarbs = 0;
		return totalRecipeCarbs;
	}

	@Override
	public double getFat() {
		double totalRecipeFat = 0;
		return totalRecipeFat;
	}


	@Override
	public boolean per100g() {
		return true;
	}
}
