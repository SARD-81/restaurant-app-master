package com.ramin.restaurantapp.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00060\u000bJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u0006\u0010\u000f\u001a\u00020\u0010J$\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00060\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J\u001a\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00060\u000b2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/ramin/restaurantapp/data/RestaurantRepository;", "", "foodDao", "Lcom/ramin/restaurantapp/data/FoodDao;", "(Lcom/ramin/restaurantapp/data/FoodDao;)V", "buildMedia", "", "Lcom/ramin/restaurantapp/model/FoodMedia;", "entity", "Lcom/ramin/restaurantapp/data/FoodEntity;", "observeCategories", "Lkotlinx/coroutines/flow/Flow;", "Lcom/ramin/restaurantapp/model/CategorySummary;", "observeFoodDetail", "Lcom/ramin/restaurantapp/model/FoodItem;", "id", "", "observeFoods", "category", "", "subcategory", "observeSubcategories", "Lcom/ramin/restaurantapp/model/SubcategorySummary;", "app_debug"})
public final class RestaurantRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.ramin.restaurantapp.data.FoodDao foodDao = null;
    
    public RestaurantRepository(@org.jetbrains.annotations.NotNull()
    com.ramin.restaurantapp.data.FoodDao foodDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ramin.restaurantapp.model.CategorySummary>> observeCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ramin.restaurantapp.model.SubcategorySummary>> observeSubcategories(@org.jetbrains.annotations.NotNull()
    java.lang.String category) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ramin.restaurantapp.model.FoodItem>> observeFoods(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.Nullable()
    java.lang.String subcategory) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.ramin.restaurantapp.model.FoodItem> observeFoodDetail(int id) {
        return null;
    }
    
    private final java.util.List<com.ramin.restaurantapp.model.FoodMedia> buildMedia(com.ramin.restaurantapp.data.FoodEntity entity) {
        return null;
    }
}