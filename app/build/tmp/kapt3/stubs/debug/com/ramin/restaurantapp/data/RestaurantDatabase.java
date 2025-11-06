package com.ramin.restaurantapp.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/ramin/restaurantapp/data/RestaurantDatabase;", "Landroidx/room/RoomDatabase;", "()V", "foodDao", "Lcom/ramin/restaurantapp/data/FoodDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.ramin.restaurantapp.data.FoodEntity.class}, version = 5, exportSchema = false)
public abstract class RestaurantDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile()
    @org.jetbrains.annotations.Nullable()
    private static volatile com.ramin.restaurantapp.data.RestaurantDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.ramin.restaurantapp.data.RestaurantDatabase.Companion Companion = null;
    
    public RestaurantDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.ramin.restaurantapp.data.FoodDao foodDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0082@\u00a2\u0006\u0002\u0010\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/ramin/restaurantapp/data/RestaurantDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/ramin/restaurantapp/data/RestaurantDatabase;", "getDatabase", "context", "Landroid/content/Context;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "seedDatabase", "", "foodDao", "Lcom/ramin/restaurantapp/data/FoodDao;", "(Lcom/ramin/restaurantapp/data/FoodDao;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.ramin.restaurantapp.data.RestaurantDatabase getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        kotlinx.coroutines.CoroutineScope scope) {
            return null;
        }
        
        private final java.lang.Object seedDatabase(com.ramin.restaurantapp.data.FoodDao foodDao, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
            return null;
        }
    }
}