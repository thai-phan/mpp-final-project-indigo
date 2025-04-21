package indigo.screen;

public class AdminView {
    private final CategoryManager categoryManager = new CategoryManager();

    public void chooseAdd(String name, String description) {
        Category category = new Category(name, description);
        String result = categoryManager.addCategory(category);
        System.out.println(result);
    }
}