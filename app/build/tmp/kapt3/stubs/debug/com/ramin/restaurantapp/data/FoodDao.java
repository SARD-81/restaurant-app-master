package com.ramin.restaurantapp.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0014\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\'J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\t\u001a\u00020\nH\'J\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\f\u001a\u00020\rH\'J$\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\'J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\'J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\u0005H\'J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00060\u00052\u0006\u0010\f\u001a\u00020\rH\'J\u0016\u0010\u0013\u001a\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\'J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\u0016\u001a\u00020\rH\'\u00a8\u0006\u0017"}, d2 = {"Lcom/ramin/restaurantapp/data/FoodDao;", "", "clear", "", "getAllFoods", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/ramin/restaurantapp/data/FoodEntity;", "getFoodById", "id", "", "getFoodsForCategory", "category", "", "getFoodsForSubcategory", "subcategory", "getFullMenu", "getLevelOneCategories", "getSubcategoriesFor", "insertAll", "items", "searchFoods", "query", "app_debug"})
@androidx.room.Dao()
public abstract interface FoodDao {
    
    @androidx.room.Query(value = "SELECT * FROM food ORDER BY name")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.ramin.restaurantapp.data.FoodEntity>> getAllFoods();
    
    @androidx.room.Query(value = "SELECT DISTINCT category_1 FROM food ORDER BY category_1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<java.lang.String>> getLevelOneCategories();
    
    @androidx.room.Query(value = "SELECT DISTINCT category_2 FROM food WHERE category_1 = :category AND category_2 IS NOT NULL AND category_2 != \'\' ORDER BY category_2")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<java.lang.String>> getSubcategoriesFor(@org.jetbrains.annotations.NotNull()
    java.lang.String category);
    
    @androidx.room.Query(value = "SELECT * FROM food WHERE category_1 = :category AND (category_2 IS NULL OR category_2 = \'\') ORDER BY name")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.ramin.restaurantapp.data.FoodEntity>> getFoodsForCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category);
    
    @androidx.room.Query(value = "SELECT * FROM food WHERE category_1 = :category AND category_2 = :subcategory ORDER BY name")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.ramin.restaurantapp.data.FoodEntity>> getFoodsForSubcategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    java.lang.String subcategory);
    
    @androidx.room.Query(value = "SELECT * FROM food WHERE id = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.ramin.restaurantapp.data.FoodEntity> getFoodById(int id);
    
    @androidx.room.Query(value = "SELECT * FROM food ORDER BY category_1, name")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.ramin.restaurantapp.data.FoodEntity>> getFullMenu();
    
    @androidx.room.Query(value = "SELECT * FROM food WHERE name LIKE \'%\' || :query || \'%\' OR description LIKE \'%\' || :query || \'%\' OR category_1 LIKE \'%\' || :query || \'%\' OR category_2 LIKE \'%\' || :query || \'%\' ORDER BY name")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.ramin.restaurantapp.data.FoodEntity>> searchFoods(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ramin.restaurantapp.data.FoodEntity> items);
    
    @androidx.room.Query(value = "DELETE FROM food")
    public abstract void clear();
}