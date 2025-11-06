package com.ramin.restaurantapp.ui.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0002J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0015H\u0016J\b\u0010$\u001a\u00020\u0015H\u0016J\u001a\u0010%\u001a\u00020\u00152\u0006\u0010&\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010\'\u001a\u00020\u0015H\u0002J\b\u0010(\u001a\u00020\u0015H\u0002J\b\u0010)\u001a\u00020\u0015H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006*"}, d2 = {"Lcom/ramin/restaurantapp/ui/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/ramin/restaurantapp/databinding/FragmentHomeBinding;", "binding", "getBinding", "()Lcom/ramin/restaurantapp/databinding/FragmentHomeBinding;", "categoryAdapter", "Lcom/ramin/restaurantapp/ui/common/CategoryAdapter;", "categoryChipAdapter", "Lcom/ramin/restaurantapp/ui/common/CategoryChipAdapter;", "searchAdapter", "Lcom/ramin/restaurantapp/ui/common/FoodAdapter;", "viewModel", "Lcom/ramin/restaurantapp/viewmodel/RestaurantViewModel;", "getViewModel", "()Lcom/ramin/restaurantapp/viewmodel/RestaurantViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "handleCategorySelection", "", "category", "Lcom/ramin/restaurantapp/model/CategorySummary;", "hideKeyboard", "observeCategories", "observeSearchResults", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onResume", "onViewCreated", "view", "setupCategoryGrid", "setupQuickCategories", "setupSearchSection", "app_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.ramin.restaurantapp.databinding.FragmentHomeBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.ramin.restaurantapp.ui.common.CategoryAdapter categoryAdapter;
    private com.ramin.restaurantapp.ui.common.CategoryChipAdapter categoryChipAdapter;
    private com.ramin.restaurantapp.ui.common.FoodAdapter searchAdapter;
    
    public HomeFragment() {
        super();
    }
    
    private final com.ramin.restaurantapp.databinding.FragmentHomeBinding getBinding() {
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
    
    private final void setupCategoryGrid() {
    }
    
    private final void setupQuickCategories() {
    }
    
    private final void setupSearchSection() {
    }
    
    private final void observeCategories() {
    }
    
    private final void observeSearchResults() {
    }
    
    private final void handleCategorySelection(com.ramin.restaurantapp.model.CategorySummary category) {
    }
    
    private final void hideKeyboard() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}