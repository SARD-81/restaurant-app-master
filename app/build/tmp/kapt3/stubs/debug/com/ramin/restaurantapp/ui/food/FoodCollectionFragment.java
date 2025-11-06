package com.ramin.restaurantapp.ui.food;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 *2\u00020\u0001:\u0002)*B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010 \u001a\u00020\u0013H\u0016J\b\u0010!\u001a\u00020\u0013H\u0016J\u001a\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0016\u0010$\u001a\u00020\u00132\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00150&H\u0002J\b\u0010\'\u001a\u00020\u0013H\u0002J\b\u0010(\u001a\u00020\u0013H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006+"}, d2 = {"Lcom/ramin/restaurantapp/ui/food/FoodCollectionFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/ramin/restaurantapp/databinding/FragmentFoodCollectionBinding;", "adapter", "Lcom/ramin/restaurantapp/ui/common/FoodAdapter;", "binding", "getBinding", "()Lcom/ramin/restaurantapp/databinding/FragmentFoodCollectionBinding;", "collectionType", "Lcom/ramin/restaurantapp/ui/food/FoodCollectionType;", "viewModel", "Lcom/ramin/restaurantapp/viewmodel/RestaurantViewModel;", "getViewModel", "()Lcom/ramin/restaurantapp/viewmodel/RestaurantViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "navigateToDetail", "", "item", "Lcom/ramin/restaurantapp/model/FoodItem;", "observeCollection", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onResume", "onViewCreated", "view", "renderCollection", "items", "", "setupHero", "setupRecycler", "CollectionUiConfig", "Companion", "app_debug"})
public final class FoodCollectionFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private com.ramin.restaurantapp.databinding.FragmentFoodCollectionBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.ramin.restaurantapp.ui.food.FoodCollectionType collectionType;
    private com.ramin.restaurantapp.ui.common.FoodAdapter adapter;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ARG_COLLECTION_TYPE = "collectionType";
    @org.jetbrains.annotations.NotNull()
    public static final com.ramin.restaurantapp.ui.food.FoodCollectionFragment.Companion Companion = null;
    
    public FoodCollectionFragment() {
        super();
    }
    
    private final com.ramin.restaurantapp.databinding.FragmentFoodCollectionBinding getBinding() {
        return null;
    }
    
    private final com.ramin.restaurantapp.viewmodel.RestaurantViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    
    private final void setupHero() {
    }
    
    private final void setupRecycler() {
    }
    
    private final void observeCollection() {
    }
    
    private final void renderCollection(java.util.List<com.ramin.restaurantapp.model.FoodItem> items) {
    }
    
    private final void navigateToDetail(com.ramin.restaurantapp.model.FoodItem item) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0082\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0007H\u00c6\u0003J\t\u0010 \u001a\u00020\u0007H\u00c6\u0003J\t\u0010!\u001a\u00020\u0007H\u00c6\u0003J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u00c6\u0003Je\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fH\u00c6\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\'\u001a\u00020\u0007H\u00d6\u0001J\t\u0010(\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017\u00a8\u0006)"}, d2 = {"Lcom/ramin/restaurantapp/ui/food/FoodCollectionFragment$CollectionUiConfig;", "", "title", "", "subtitle", "emptyText", "iconRes", "", "backgroundRes", "emptyIconRes", "emptyIconTint", "badgeBuilder", "Lkotlin/Function1;", "Lcom/ramin/restaurantapp/model/FoodItem;", "Lcom/ramin/restaurantapp/ui/common/FoodAdapter$FoodBadge;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIILkotlin/jvm/functions/Function1;)V", "getBackgroundRes", "()I", "getBadgeBuilder", "()Lkotlin/jvm/functions/Function1;", "getEmptyIconRes", "getEmptyIconTint", "getEmptyText", "()Ljava/lang/String;", "getIconRes", "getSubtitle", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    static final class CollectionUiConfig {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String title = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String subtitle = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String emptyText = null;
        private final int iconRes = 0;
        private final int backgroundRes = 0;
        private final int emptyIconRes = 0;
        private final int emptyIconTint = 0;
        @org.jetbrains.annotations.NotNull()
        private final kotlin.jvm.functions.Function1<com.ramin.restaurantapp.model.FoodItem, com.ramin.restaurantapp.ui.common.FoodAdapter.FoodBadge> badgeBuilder = null;
        
        public CollectionUiConfig(@org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String subtitle, @org.jetbrains.annotations.NotNull()
        java.lang.String emptyText, int iconRes, int backgroundRes, int emptyIconRes, int emptyIconTint, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.ramin.restaurantapp.model.FoodItem, com.ramin.restaurantapp.ui.common.FoodAdapter.FoodBadge> badgeBuilder) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getSubtitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEmptyText() {
            return null;
        }
        
        public final int getIconRes() {
            return 0;
        }
        
        public final int getBackgroundRes() {
            return 0;
        }
        
        public final int getEmptyIconRes() {
            return 0;
        }
        
        public final int getEmptyIconTint() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.jvm.functions.Function1<com.ramin.restaurantapp.model.FoodItem, com.ramin.restaurantapp.ui.common.FoodAdapter.FoodBadge> getBadgeBuilder() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component3() {
            return null;
        }
        
        public final int component4() {
            return 0;
        }
        
        public final int component5() {
            return 0;
        }
        
        public final int component6() {
            return 0;
        }
        
        public final int component7() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final kotlin.jvm.functions.Function1<com.ramin.restaurantapp.model.FoodItem, com.ramin.restaurantapp.ui.common.FoodAdapter.FoodBadge> component8() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.ramin.restaurantapp.ui.food.FoodCollectionFragment.CollectionUiConfig copy(@org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String subtitle, @org.jetbrains.annotations.NotNull()
        java.lang.String emptyText, int iconRes, int backgroundRes, int emptyIconRes, int emptyIconTint, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.ramin.restaurantapp.model.FoodItem, com.ramin.restaurantapp.ui.common.FoodAdapter.FoodBadge> badgeBuilder) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/ramin/restaurantapp/ui/food/FoodCollectionFragment$Companion;", "", "()V", "ARG_COLLECTION_TYPE", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}