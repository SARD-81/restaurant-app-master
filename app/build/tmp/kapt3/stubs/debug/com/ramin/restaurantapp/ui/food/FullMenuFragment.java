package com.ramin.restaurantapp.ui.food;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\tH\u0002J\b\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001b\u001a\u00020\u0016H\u0002J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0016H\u0016J\u001a\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010\'\u001a\u00020\u0016H\u0002J\u0016\u0010(\u001a\u00020\u00162\f\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\bH\u0002J\b\u0010+\u001a\u00020\u0016H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006,"}, d2 = {"Lcom/ramin/restaurantapp/ui/food/FullMenuFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/ramin/restaurantapp/databinding/FragmentFullMenuBinding;", "adapter", "Lcom/ramin/restaurantapp/ui/common/FoodAdapter;", "allFoods", "", "Lcom/ramin/restaurantapp/model/FoodItem;", "binding", "getBinding", "()Lcom/ramin/restaurantapp/databinding/FragmentFullMenuBinding;", "selectedCategory", "", "viewModel", "Lcom/ramin/restaurantapp/viewmodel/RestaurantViewModel;", "getViewModel", "()Lcom/ramin/restaurantapp/viewmodel/RestaurantViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "applyFilter", "", "badgeForFood", "Lcom/ramin/restaurantapp/ui/common/FoodAdapter$FoodBadge;", "item", "observeCategories", "observeFullMenu", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "refreshVisibleBadges", "renderCategoryChips", "categories", "Lcom/ramin/restaurantapp/model/CategorySummary;", "setupRecycler", "app_debug"})
public final class FullMenuFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.ramin.restaurantapp.databinding.FragmentFullMenuBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.ramin.restaurantapp.ui.common.FoodAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.ramin.restaurantapp.model.FoodItem> allFoods;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String selectedCategory;
    
    public FullMenuFragment() {
        super();
    }
    
    private final com.ramin.restaurantapp.databinding.FragmentFullMenuBinding getBinding() {
        return null;
    }
    
    private final com.ramin.restaurantapp.viewmodel.RestaurantViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupRecycler() {
    }
    
    private final void observeCategories() {
    }
    
    private final void observeFullMenu() {
    }
    
    private final void renderCategoryChips(java.util.List<com.ramin.restaurantapp.model.CategorySummary> categories) {
    }
    
    private final void applyFilter() {
    }
    
    private final com.ramin.restaurantapp.ui.common.FoodAdapter.FoodBadge badgeForFood(com.ramin.restaurantapp.model.FoodItem item) {
        return null;
    }
    
    private final void refreshVisibleBadges() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}