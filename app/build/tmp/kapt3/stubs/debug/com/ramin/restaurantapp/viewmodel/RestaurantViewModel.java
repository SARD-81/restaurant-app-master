package com.ramin.restaurantapp.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\n0\tJ\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0011\u001a\u00020\u0012J$\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007J\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\tJ\u0006\u0010\u0017\u001a\u00020\u0007J\u001a\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\n0\t2\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001e"}, d2 = {"Lcom/ramin/restaurantapp/viewmodel/RestaurantViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/ramin/restaurantapp/data/RestaurantRepository;", "(Lcom/ramin/restaurantapp/data/RestaurantRepository;)V", "searchQuery", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "searchResultsLiveData", "Landroidx/lifecycle/LiveData;", "", "Lcom/ramin/restaurantapp/model/FoodItem;", "getSearchResultsLiveData", "()Landroidx/lifecycle/LiveData;", "categoriesLiveData", "Lcom/ramin/restaurantapp/model/CategorySummary;", "foodDetailLiveData", "id", "", "foodsLiveData", "category", "subcategory", "fullMenuLiveData", "searchQueryValue", "subcategoriesLiveData", "Lcom/ramin/restaurantapp/model/SubcategorySummary;", "updateSearchQuery", "", "query", "Factory", "app_debug"})
public final class RestaurantViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.ramin.restaurantapp.data.RestaurantRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> searchQuery = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.ramin.restaurantapp.model.FoodItem>> searchResultsLiveData = null;
    
    public RestaurantViewModel(@org.jetbrains.annotations.NotNull()
    com.ramin.restaurantapp.data.RestaurantRepository repository) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0002H\u0006\"\b\b\u0000\u0010\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/ramin/restaurantapp/viewmodel/RestaurantViewModel$Factory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "repository", "Lcom/ramin/restaurantapp/data/RestaurantRepository;", "(Lcom/ramin/restaurantapp/data/RestaurantRepository;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "app_debug"})
    public static final class Factory implements androidx.lifecycle.ViewModelProvider.Factory {
        @org.jetbrains.annotations.NotNull()
        private final com.ramin.restaurantapp.data.RestaurantRepository repository = null;
        
        public Factory(@org.jetbrains.annotations.NotNull()
        com.ramin.restaurantapp.data.RestaurantRepository repository) {
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