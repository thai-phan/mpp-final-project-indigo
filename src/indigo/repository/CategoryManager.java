package indigo.repository;

public class CategoryManager {
    private final CategoryRepository categoryRepository = new CategoryRepository();

    public String addCategory(Category category) {
        try {
            categoryRepository.addCategory(category);
            return "Category added successfully";
        } catch (Exception e) {
            return "Error adding category";
        }
    }
}