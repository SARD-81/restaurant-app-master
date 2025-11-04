package com.ramin.restaurantapp.ui.detail;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0012B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\f\u001a\u00020\bH\u0016J\u001c\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0014\u0010\u0011\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u0000H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/ramin/restaurantapp/ui/detail/MediaPagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ramin/restaurantapp/ui/detail/MediaPagerAdapter$MediaViewHolder;", "mediaItems", "", "Lcom/ramin/restaurantapp/model/FoodMedia;", "(Ljava/util/List;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewRecycled", "MediaViewHolder", "app_debug"})
public final class MediaPagerAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.ramin.restaurantapp.ui.detail.MediaPagerAdapter.MediaViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.ramin.restaurantapp.model.FoodMedia> mediaItems = null;
    
    public MediaPagerAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.ramin.restaurantapp.model.FoodMedia> mediaItems) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.ramin.restaurantapp.ui.detail.MediaPagerAdapter.MediaViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.ramin.restaurantapp.ui.detail.MediaPagerAdapter.MediaViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public void onViewRecycled(@org.jetbrains.annotations.NotNull()
    com.ramin.restaurantapp.ui.detail.MediaPagerAdapter.MediaViewHolder holder) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/ramin/restaurantapp/ui/detail/MediaPagerAdapter$MediaViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/ramin/restaurantapp/databinding/ItemMediaPageBinding;", "(Lcom/ramin/restaurantapp/ui/detail/MediaPagerAdapter;Lcom/ramin/restaurantapp/databinding/ItemMediaPageBinding;)V", "bind", "", "media", "Lcom/ramin/restaurantapp/model/FoodMedia;", "cleanup", "showImage", "url", "", "showVideo", "app_debug"})
    public final class MediaViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.ramin.restaurantapp.databinding.ItemMediaPageBinding binding = null;
        
        public MediaViewHolder(@org.jetbrains.annotations.NotNull()
        com.ramin.restaurantapp.databinding.ItemMediaPageBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.ramin.restaurantapp.model.FoodMedia media) {
        }
        
        private final void showImage(java.lang.String url) {
        }
        
        private final void showVideo(java.lang.String url) {
        }
        
        public final void cleanup() {
        }
    }
}