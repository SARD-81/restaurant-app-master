package com.ramin.restaurantapp.ui.detail;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0015H\u0016J\u001a\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tH\u0002J\b\u0010&\u001a\u00020\u0015H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\'"}, d2 = {"Lcom/ramin/restaurantapp/ui/detail/FoodDetailFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/ramin/restaurantapp/databinding/FragmentFoodDetailBinding;", "binding", "getBinding", "()Lcom/ramin/restaurantapp/databinding/FragmentFoodDetailBinding;", "currentFood", "Lcom/ramin/restaurantapp/model/FoodItem;", "mediaAdapter", "Lcom/ramin/restaurantapp/ui/detail/MediaPagerAdapter;", "tabMediator", "Lcom/google/android/material/tabs/TabLayoutMediator;", "viewModel", "Lcom/ramin/restaurantapp/viewmodel/RestaurantViewModel;", "getViewModel", "()Lcom/ramin/restaurantapp/viewmodel/RestaurantViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "bindFood", "", "foodItem", "observeFood", "foodId", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "shareFood", "updateActionButtons", "app_debug"})
public final class FoodDetailFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.ramin.restaurantapp.databinding.FragmentFoodDetailBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private com.ramin.restaurantapp.ui.detail.MediaPagerAdapter mediaAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.google.android.material.tabs.TabLayoutMediator tabMediator;
    @org.jetbrains.annotations.Nullable()
    private com.ramin.restaurantapp.model.FoodItem currentFood;
    
    public FoodDetailFragment() {
        super();
    }
    
    private final com.ramin.restaurantapp.databinding.FragmentFoodDetailBinding getBinding() {
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
    
    private final void observeFood(int foodId) {
    }
    
    private final void bindFood(com.ramin.restaurantapp.model.FoodItem foodItem) {
    }
    
    private final void updateActionButtons() {
    }
    
    private final void shareFood(com.ramin.restaurantapp.model.FoodItem foodItem) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}