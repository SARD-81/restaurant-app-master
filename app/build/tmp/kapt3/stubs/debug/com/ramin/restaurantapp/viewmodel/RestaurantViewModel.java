package com.ramin.restaurantapp.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001+B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00130\bJ\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\b2\u0006\u0010\u0019\u001a\u00020\nJ$\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\b2\u0006\u0010\u001b\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u0011J\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\bJ\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\nJ\u000e\u0010 \u001a\u00020\u001f2\u0006\u0010\u0019\u001a\u00020\nJ\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\bJ\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\bJ\u0006\u0010#\u001a\u00020\u0011J\u001a\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00130\b2\u0006\u0010\u001b\u001a\u00020\u0011J\u000e\u0010&\u001a\u00020\'2\u0006\u0010\u0019\u001a\u00020\nJ\u000e\u0010(\u001a\u00020\'2\u0006\u0010\u0019\u001a\u00020\nJ\u000e\u0010)\u001a\u00020\'2\u0006\u0010*\u001a\u00020\u0011R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\f\u00a8\u0006,"}, d2 = {"Lcom/ramin/restaurantapp/viewmodel/RestaurantViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/ramin/restaurantapp/data/RestaurantRepository;", "preferences", "Lcom/ramin/restaurantapp/data/RestaurantPreferences;", "(Lcom/ramin/restaurantapp/data/RestaurantRepository;Lcom/ramin/restaurantapp/data/RestaurantPreferences;)V", "likedIdsLiveData", "Landroidx/lifecycle/LiveData;", "", "", "getLikedIdsLiveData", "()Landroidx/lifecycle/LiveData;", "savedIdsLiveData", "getSavedIdsLiveData", "searchQuery", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "searchResultsLiveData", "", "Lcom/ramin/restaurantapp/model/FoodItem;", "getSearchResultsLiveData", "categoriesLiveData", "Lcom/ramin/restaurantapp/model/CategorySummary;", "foodDetailLiveData", "id", "foodsLiveData", "category", "subcategory", "fullMenuLiveData", "isLiked", "", "isSaved", "likedFoodsLiveData", "savedFoodsLiveData", "searchQueryValue", "subcategoriesLiveData", "Lcom/ramin/restaurantapp/model/SubcategorySummary;", "toggleLiked", "", "toggleSaved", "updateSearchQuery", "query", "Factory", "app_debug"})
public final class RestaurantViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.ramin.restaurantapp.data.RestaurantRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ramin.restaurantapp.data.RestaurantPreferences preferences = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.Set<java.lang.Integer>> likedIdsLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.Set<java.lang.Integer>> savedIdsLiveData = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.ramin.restaurantapp.model.FoodItem>> searchResultsLiveData = null;
    
    public RestaurantViewModel(@org.jetbrains.annotations.NotNull()
    com.ramin.restaurantapp.data.RestaurantRepository repository, @org.jetbrains.annotations.NotNull()
    com.ramin.restaurantapp.data.RestaurantPreferences preferences) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ramin.restaurantapp.model.CategorySummary>> categoriesLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ramin.restaurantapp.model.SubcategorySummary>> subcategoriesLiveData(@org.jetbrains.annotations.NotNull()
    java.lang.String category) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ramin.restaurantapp.model.FoodItem>> foodsLiveData(@org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.Nullable()
    java.lang.String subcategory) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.ramin.restaurantapp.model.FoodItem> foodDetailLiveData(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ramin.restaurantapp.model.FoodItem>> fullMenuLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.Set<java.lang.Integer>> getLikedIdsLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.Set<java.lang.Integer>> getSavedIdsLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ramin.restaurantapp.model.FoodItem>> likedFoodsLiveData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ramin.restaurantapp.model.FoodItem>> savedFoodsLiveData() {
        return null;
    }
    
    public final void toggleLiked(int id) {
    }
    
    public final void toggleSaved(int id) {
    }
    
    public final boolean isLiked(int id) {
        return false;
    }
    
    public final boolean isSaved(int id) {
        return false;
    }
    
    public final void updateSearchQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String searchQueryValue() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ramin.restaurantapp.model.FoodItem>> getSearchResultsLiveData() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016\u00a2\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/ramin/restaurantapp/viewmodel/RestaurantViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "repository", "Lcom/ramin/restaurantapp/data/RestaurantRepository;", "preferences", "Lcom/ramin/restaurantapp/data/RestaurantPreferences;", "(Lcom/ramin/restaurantapp/data/RestaurantRepository;Lcom/ramin/restaurantapp/data/RestaurantPreferences;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
    public static final class Factory implements androidx.lifecycle.ViewModelProvider.Factory {
        @org.jetbrains.annotations.NotNull()
        private final com.ramin.restaurantapp.data.RestaurantRepository repository = null;
        @org.jetbrains.annotations.NotNull()
        private final com.ramin.restaurantapp.data.RestaurantPreferences preferences = null;
        
        public Factory(@org.jetbrains.annotations.NotNull()
        com.ramin.restaurantapp.data.RestaurantRepository repository, @org.jetbrains.annotations.NotNull()
        com.ramin.restaurantapp.data.RestaurantPreferences preferences) {
            super();
        }
        
        @java.lang.Override()
        @kotlin.Suppress(names = {"UNCHECKED_CAST"})
        @org.jetbrains.annotations.NotNull()
        public <T extends androidx.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
        java.lang.Class<T> modelClass) {
            return null;
        }
    }
}