package com.ramin.restaurantapp.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\bJ\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\bJ,\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\b2\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/ramin/restaurantapp/data/RestaurantPreferences;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_likedIds", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "_savedIds", "likedIds", "Lkotlinx/coroutines/flow/StateFlow;", "getLikedIds", "()Lkotlinx/coroutines/flow/StateFlow;", "savedIds", "getSavedIds", "sharedPreferences", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "isLiked", "", "id", "isSaved", "loadIds", "key", "", "persistIds", "", "ids", "toggleLiked", "toggleSaved", "updateCollection", "flow", "Companion", "app_debug"})
public final class RestaurantPreferences {
    private final android.content.SharedPreferences sharedPreferences = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Set<java.lang.Integer>> _likedIds = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Set<java.lang.Integer>> _savedIds = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.Set<java.lang.Integer>> likedIds = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.Set<java.lang.Integer>> savedIds = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String PREFS_NAME = "restaurant_user_state";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_LIKED_IDS = "liked_food_ids";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_SAVED_IDS = "saved_food_ids";
    @org.jetbrains.annotations.NotNull()
    public static final com.ramin.restaurantapp.data.RestaurantPreferences.Companion Companion = null;
    
    public RestaurantPreferences(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.Set<java.lang.Integer>> getLikedIds() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.Set<java.lang.Integer>> getSavedIds() {
        return null;
    }
    
    public final boolean isLiked(int id) {
        return false;
    }
    
    public final boolean isSaved(int id) {
        return false;
    }
    
    public final void toggleLiked(int id) {
    }
    
    public final void toggleSaved(int id) {
    }
    
    private final void updateCollection(int id, kotlinx.coroutines.flow.MutableStateFlow<java.util.Set<java.lang.Integer>> flow, java.lang.String key) {
    }
    
    private final java.util.Set<java.lang.Integer> loadIds(java.lang.String key) {
        return null;
    }
    
    private final void persistIds(java.lang.String key, java.util.Set<java.lang.Integer> ids) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/ramin/restaurantapp/data/RestaurantPreferences$Companion;", "", "()V", "KEY_LIKED_IDS", "", "KEY_SAVED_IDS", "PREFS_NAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}